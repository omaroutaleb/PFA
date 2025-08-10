package com.example.SmartDoc.application.controller;

import com.example.SmartDoc.adapter.StorageException;
import com.example.SmartDoc.service.FileStorageService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {

    private FileStorageService fileStorageService;

    public UploadController(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @PostMapping("/upload,consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}")
    public void fileStorage(MultipartFile file) throws StorageException {

        fileStorageService.store(file);
    }

}
