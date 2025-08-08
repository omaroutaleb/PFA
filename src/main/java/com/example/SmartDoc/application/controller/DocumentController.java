package com.example.SmartDoc.application.controller;

import com.example.SmartDoc.adapter.DocumentMapper;
import com.example.SmartDoc.adapter.DocumentRepository;
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

    private DocumentMapper documentMapper;

    private DocumentRepository documentRepository;

    @Autowired
    public void setDocumentService(DocumentService documentService,DocumentMapper documentMapper) {
        this.documentService = documentService;
        this.documentMapper = documentMapper;
    }







}
