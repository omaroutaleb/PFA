package com.example.SmartDoc.application.controller;

import com.example.SmartDoc.adapter.DocumentMapper;
import com.example.SmartDoc.adapter.StorageException;
import com.example.SmartDoc.application.DTO.DocumentDTO;
import com.example.SmartDoc.model.Document;
import com.example.SmartDoc.service.AIService;
import com.example.SmartDoc.service.DocumentService;
import com.example.SmartDoc.service.FileStorageService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@CrossOrigin(origins = "http://localhost:8081/")
@RequestMapping("/docs")
@RestController
public class UploadController {

    private FileStorageService fileStorageService;

    private AIService aiService;

    private DocumentService documentService;
    private DocumentMapper docmapper;

    public UploadController(FileStorageService fileStorageService, AIService aiService, DocumentService documentService, DocumentMapper docmapper) {
        this.fileStorageService = fileStorageService;
        this.aiService = aiService;
        this.documentService = documentService;
        this.docmapper = docmapper;
    }

@PostMapping(
        value = "/upload",
        consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
)
public DocumentDTO fileStorage(@RequestPart("file") MultipartFile file) throws StorageException {
    if (file == null || file.isEmpty()) {
        throw new org.springframework.web.server.ResponseStatusException(
                org.springframework.http.HttpStatus.BAD_REQUEST, "file is required");
    }

    fileStorageService.store(file);

    // Assuming your AI service returns a Document entity (as in your snippet)
    Document doc = aiService.extractFields(file.getResource());

    // Persist and return DTO
    doc = documentService.save(doc);
    return docmapper.toDTO(doc);
}


}
