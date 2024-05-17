package com.example.OliviaFlowers.secvices;

import com.example.OliviaFlowers.models.Bouquet;
import com.example.OliviaFlowers.models.Postcard;
import com.example.OliviaFlowers.repositories.PostcardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PostcardService {
    @Autowired
    private final PostcardRepository postcardRepository;

    public PostcardService(PostcardRepository postcardRepository) {
        this.postcardRepository = postcardRepository;
    }
    public List<Postcard> listAllPostcards(){
        return postcardRepository.findAll();
    }
}
