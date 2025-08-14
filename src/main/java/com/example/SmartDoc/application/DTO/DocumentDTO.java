package com.example.SmartDoc.application.DTO;

import java.time.LocalDateTime;
import java.util.UUID;

public class DocumentDTO {
    private UUID id;
    private String fileName;
    private String docType;
    private LocalDateTime createdAt;
    private String status;
    private String extractedDataJson;

    public DocumentDTO() {}
    // getters + setters for all fields..


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExtractedDataJson() {
        return extractedDataJson;
    }

    public void setExtractedDataJson(String extractedDataJson) {
        this.extractedDataJson = extractedDataJson;
    }
}
