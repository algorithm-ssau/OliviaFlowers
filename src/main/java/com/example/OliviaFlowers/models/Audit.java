package com.example.OliviaFlowers.models;//package com.example.OliviaFlowers.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String table;
    @Column
    private Long idTuple;
    @Column
    private String action;
    @Column
    private Time actionTime;
    @Column
    private String changedColumn;
    @Column
    private String oldValue;
    @Column
    private String newValue;
}
