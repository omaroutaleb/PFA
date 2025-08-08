package com.example.SmartDoc.application.controller;

import com.example.SmartDoc.application.DTO.DocumentDTO;
import com.example.SmartDoc.model.Document;
import com.example.SmartDoc.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumentController {

    private DocumentService documentService;


    public void setDocumentService(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping("save")
    public DocumentDTO save(@RequestBody DocumentDTO document) {
        return documentService.save(document);
    }


}
