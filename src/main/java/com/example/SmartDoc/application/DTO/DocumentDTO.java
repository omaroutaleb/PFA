package com.example.SmartDoc.application.DTO;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class DocumentDTO {


    private UUID id;

    private String fileName;
    private String docType;
    private LocalDateTime createdAt;
    private String status;
    private String extractedDataJson;
}
