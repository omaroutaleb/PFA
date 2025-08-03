package com.example.pfa.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileNam;
    private String docType;
    private LocalDateTime createdAt = LocalDateTime.now();

    // Getters and setters
}
