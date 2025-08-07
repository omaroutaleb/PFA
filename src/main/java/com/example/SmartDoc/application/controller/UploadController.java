package com.example.SmartDoc.application.controller;

import com.example.SmartDoc.service.FileStorageService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
    public class UploadController {

    @GetMapping (value = "/ulpoad",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})

    public ResponseEntity<String> upload(MultipartFile file) {

        String fileName = file.getOriginalFilename();
        FileStorageService f = new FileStorageService();
        try {
            file.transferTo(new File(f.store(file)));
        }
        catch(IOException e) {
            System.out.println(e);
        }
        return ResponseEntity.ok("file uploaded successfuly");
    }


}
