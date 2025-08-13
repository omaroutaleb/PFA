package com.example.SmartDoc.service;

import com.example.SmartDoc.adapter.DocumentRepository;
import com.example.SmartDoc.model.Document;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.UUID;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }



    public Document updateFields(@RequestBody UUID id, Document entity) {
        Document existing = findById(id);
        existing.setFileName(entity.getFileName());
        existing.setDocType(entity.getDocType());
        existing.setExtractedDataJson(entity.getExtractedDataJson());
        existing.setStatus(entity.getStatus());
        return documentRepository.save(existing);
    }

    public Document save(Document entity) {
        return documentRepository.save(entity);

    }

    public List<Document> findAll() {
        return documentRepository.findAll();
    }

    public Document findById(UUID id) {
        return documentRepository.findById(id).orElseThrow(() -> new RuntimeException("Document not found: " + id));
    }
}
