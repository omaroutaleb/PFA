package com.example.SmartDoc.service;

import com.example.SmartDoc.adapter.DocumentRepository;
import com.example.SmartDoc.model.Document;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;


    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Transactional
    public Document save(Document entity) {
        Document doc = Document.builder()
                .docType(entity.getDocType())
                .extractedDataJson(entity.getExtractedDataJson())
                .status(entity.getStatus())
                .createdAt(LocalDateTime.now())
                .fileName(entity.getFileName()).build();
        return documentRepository.save(doc);
    }
    public List<Document> findAll() {
        return documentRepository.findAll();
    }
    public Document findById(UUID id) {
        Document doc = documentRepository.findById(id).orElse(null);
        return doc;
    }

}
