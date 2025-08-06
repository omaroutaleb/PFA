package com.example.SmartDoc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
@Entity
public class Document {

    @Id
    private String id;

    private String fileName;
    private String docType;
    private LocalDateTime createdAt;
    private String status;
    private String extractedDataJson;
}
