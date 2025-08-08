package com.example.SmartDoc.application.controller;

import com.example.SmartDoc.adapter.DocumentMapper;
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

    public void setDocumentService(DocumentService documentService,DocumentMapper documentMapper) {
        this.documentService = documentService;
        this.documentMapper = documentMapper;
    }

    @PostMapping("save")
    public Document save(@RequestBody DocumentDTO documentDTO) {
        Document doc = documentMapper.fromDTO(documentDTO);
        return documentService.save(doc);
    }




}
