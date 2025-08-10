package com.example.SmartDoc.application.controller;

import com.example.SmartDoc.service.FileStorageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {

    private FileStorageService fileStorageService;

    public UploadController(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @PostMapping("/upload")
    public MultipartFile fileStorageService(MultipartFile file) {

        return fileStorageService(file);
    }

}
