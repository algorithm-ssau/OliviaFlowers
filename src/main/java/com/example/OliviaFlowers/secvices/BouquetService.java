package com.example.OliviaFlowers.secvices;

import com.example.OliviaFlowers.models.Bouquet;
import com.example.OliviaFlowers.models.Image;
import com.example.OliviaFlowers.repositories.BouquetRepository;
import com.example.OliviaFlowers.repositories.ImageRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BouquetService {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private final BouquetRepository bouquetRepository;
    private final ImageRepository imageRepository;



    public BouquetService(BouquetRepository bouquetRepository, ImageRepository imageRepository, ImageRepository imageRepository1) {
        this.bouquetRepository = bouquetRepository;
        this.imageRepository = imageRepository;
    }

    public List<Bouquet> listAllBouquetsByName(String name){
        if (name != null) return bouquetRepository.findByName(name);
        return bouquetRepository.findAll();
    }
    public List<Bouquet> listAllBouquets(){
        return bouquetRepository.findAll();
    }




    //если что то не работает в методе можно try, catch использовать и ошибки будут выводиться в консоль
    public void saveBouquet(Bouquet bouquet, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
        try {
            // Сохраняем букет и получаем его ID
            Bouquet savedBouquet = bouquetRepository.save(bouquet);

            // Создаем список для хранения всех изображений
            List<Image> images = new ArrayList<>();

            if (file1.getSize() != 0) {
                Image image1 = toImageEntity(file1);
                image1.setPreviewImage(true);
                // Устанавливаем ссылку на сохраненный букет
                image1.setBouquet(savedBouquet);
                images.add(image1); // Добавляем изображение в список
            }
            if (file2.getSize() != 0) {
                Image image2 = toImageEntity(file2);
                // Устанавливаем ссылку на сохраненный букет
                image2.setBouquet(savedBouquet);
                images.add(image2); // Добавляем изображение в список
            }
            if (file3.getSize() != 0) {
                Image image3 = toImageEntity(file3);
                // Устанавливаем ссылку на сохраненный букет
                image3.setBouquet(savedBouquet);
                images.add(image3); // Добавляем изображение в список
            }

            // Сохраняем все изображения
            imageRepository.saveAll(images);

            // Устанавливаем изображения букету
            savedBouquet.setImages(images);

            // Устанавливаем ID первого изображения в качестве предварительного изображения букета
            if (!images.isEmpty()) {
                savedBouquet.setPreviewImageID(images.get(0).getId());
                bouquetRepository.save(savedBouquet);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }


    @Transactional
    public void deleteBouquet(Long id){
        try {
            deleteImagesByBouquetId(id); // Удалить все изображения, связанные с букетом
            bouquetRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public void deleteImagesByBouquetId(Long bouquetId) {
        try {
            imageRepository.deleteByBouquetId(bouquetId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Bouquet getBouquetByID(Long id){
        return bouquetRepository.findById(id).orElse(null);
    }

    public List<Bouquet> listAuthorBouquets() {
        return bouquetRepository.findByType("Авторский");
    }

    public List<Bouquet> listBoxBouquets(){
        return bouquetRepository.findByType("В коробке");
    }

    public List<Bouquet> listWeddingBouquets(){
        return bouquetRepository.findByType("Cвадебный");
    }


    public List<Bouquet> filterBouquets(Integer sort, Long minPrice, Long maxPrice, List<String> searchableu, List<Bouquet> a) {
        List<Bouquet> bouquets = a;
        if (searchableu.size() == 0){
            bouquets = bouquets.stream()
                    .filter(b -> b.getPrice() >= minPrice && b.getPrice() <= maxPrice)
                    .collect(Collectors.toList());
        }
        else{
            String[] searchables = searchableu.toArray(new String[0]);
            fillALLFlowers(bouquets);
            bouquets = bouquets.stream()
                    .filter(((Predicate<Bouquet>) b -> b.getPrice() >= minPrice && b.getPrice() <= maxPrice).and(b ->  Arrays.stream(b.flowers).anyMatch(element -> Arrays.stream(searchables).anyMatch(array2Element -> element.equals(array2Element)))))
                    .collect(Collectors.toList());
        }
        if (sort != null) {
            if(sort == 0)
            {
                return bouquets;
            }
            if (sort == 1) {
                bouquets.sort(Comparator.comparingLong(Bouquet::getPrice));
            } else if (sort == 2) {
                bouquets.sort(Comparator.comparingLong(Bouquet::getPrice).reversed());
            }
        }
        return bouquets;
    }

    public List<Bouquet> filterByFlower(Integer sort, List<Bouquet> a, String[] searchables){
        List<Bouquet> result = a;
        fillALLFlowers(result);

        result = result.stream()
                .filter(b ->  Arrays.stream(b.flowers).anyMatch(element -> Arrays.stream(searchables).anyMatch(array2Element -> element.equals(array2Element))))
                .collect(Collectors.toList());

        if (sort != null) {
            if(sort == 0)
            {
                return result;
            }
            if (sort == 1) {
                result.sort(Comparator.comparingLong(Bouquet::getPrice));
            } else if (sort == 2) {
                result.sort(Comparator.comparingLong(Bouquet::getPrice).reversed());
            }
        }
        return result;

    }

    public void fillFlowers(Bouquet bouquet){
        String description = bouquet.getComposition();
        String[] parts = description.split("\\R");
        for (int i = 0; i < parts.length; i++){
            String[] tempflow = parts[i].split("-", 2);
            parts[i] = tempflow[0].trim();
        }
        bouquet.flowers = parts;
    }

    public void fillALLFlowers(List<Bouquet> a){
        for(Bouquet bouquet : a){
            fillFlowers(bouquet);
        }
    }
}
