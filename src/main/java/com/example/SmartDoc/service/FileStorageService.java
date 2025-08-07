package com.example.SmartDoc.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileStorageService {

    public String store(MultipartFile file) {

        try {
            file.transferTo(new File("C:\\Users\\oouta\\STOREDFILEs"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "success";
    }
}
