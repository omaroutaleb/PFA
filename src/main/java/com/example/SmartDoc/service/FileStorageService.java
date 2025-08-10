package com.example.SmartDoc.service;

import com.example.SmartDoc.model.Document;
import org.apache.tomcat.util.http.fileupload.impl.SizeException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;


@Service
public class FileStorageService {

    public File save(MultipartFile file ) {

        try {
            if(file.isEmpty() || file.getSize() > 10 ) {
                
            }
        }catch (Exception e ){
            System.out.println( e.getMessage() );;
        }

    }

}
