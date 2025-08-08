package com.example.SmartDoc.service;

import com.example.SmartDoc.adapter.DocumentRepository;
import com.example.SmartDoc.application.DTO.DocumentDTO;
import com.example.SmartDoc.model.Document;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Transactional
    public Document save(DocumentDTO entity) {
        Document doc = new Document();
        doc.setDocType(entity.getDocType());
        doc.setCreatedAt(LocalDateTime.now());
        doc.setExtractedDataJson(entity.getExtractedDataJson());
        doc.setFileName(entity.getFileName());
        return documentRepository.save(doc);
    }

    public List<Document> findAll() {
        return documentRepository.findAll();
    }

    public Document getByid(String id) {
        return documentRepository.findById(id).orElseThrow(() -> new RuntimeException("Document not found: " + id));
    }



}
