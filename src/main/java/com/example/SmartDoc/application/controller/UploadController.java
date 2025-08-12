package com.example.SmartDoc.application.controller;

import com.example.SmartDoc.adapter.StorageException;
import com.example.SmartDoc.model.Document;
import com.example.SmartDoc.service.AIService;
import com.example.SmartDoc.service.DocumentService;
import com.example.SmartDoc.service.FileStorageService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/documents")
@RestController
public class UploadController {

    private FileStorageService fileStorageService;

    private AIService aiService;

    private DocumentService documentService;

    public UploadController(FileStorageService fileStorageService, AIService aiService, DocumentService documentService) {
        this.fileStorageService = fileStorageService;
        this.aiService = aiService;
        this.documentService = documentService;
    }

    @PostMapping("/upload")
    public void fileStorage(MultipartFile file) throws StorageException {

        fileStorageService.store(file);
        Document doc = aiService.extractFields(file.getResource());
        documentService.save(doc);
    }

}
