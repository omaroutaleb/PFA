package com.example.SmartDoc.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String fileName;
    private String docType;
    private LocalDateTime createdAt;
    private String status;
    @Column(name = "extracted_data_json",columnDefinition = "TEXT")
    private String extractedDataJson;

//    protected Document() {}

    public Document(String fileName, String docType, LocalDateTime createdAt,String status, String extractedDataJson) {
        this.fileName = fileName;
        this.docType = docType;
        this.createdAt = createdAt;
        this.extractedDataJson = extractedDataJson;
        this.status = status;
    }

//    public UUID getId() {
//        return id;
//    }
//
//    public void setId(UUID id) {
//        this.id = id;
//    }
//
//    public String getFileName() {
//        return fileName;
//    }
//
//    public void setFileName(String fileName) {
//        this.fileName = fileName;
//    }
//
//    public String getDocType() {
//        return docType;
//    }
//
//    public void setDocType(String docType) {
//        this.docType = docType;
//    }
//
//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public String getExtractedDataJson() {
//        return extractedDataJson;
//    }
//
//    public void setExtractedDataJson(String extractedDataJson) {
//        this.extractedDataJson = extractedDataJson;
//    }
}
