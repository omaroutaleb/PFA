package com.example.SmartDoc.application.controller;

import com.example.SmartDoc.adapter.StorageException;
import com.example.SmartDoc.service.AIService;
import com.example.SmartDoc.service.FileStorageService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/documents")
@RestController
public class UploadController {

    private FileStorageService fileStorageService;

    private AIService aiService;

    public UploadController(FileStorageService fileStorageService, AIService aiService) {
        this.fileStorageService = fileStorageService;
        this.aiService = aiService;
    }

    @PostMapping("/upload")
    public void fileStorage(MultipartFile file) throws StorageException {

        fileStorageService.store(file);
        aiService.extractFieldsFromPdf(file.getResource());
    }

}
