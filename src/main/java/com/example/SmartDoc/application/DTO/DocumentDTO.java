package com.example.SmartDoc.application.DTO;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class DocumentDTO {


    private String id;

    private String fileName;
    private String docType;
    private LocalDateTime createdAt;
    private String status;
    private String extractedDataJson;
}
