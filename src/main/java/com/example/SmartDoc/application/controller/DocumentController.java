package com.example.SmartDoc.application.controller;

import com.example.SmartDoc.adapter.DocumentMapper;
import com.example.SmartDoc.adapter.DocumentRepository;
import com.example.SmartDoc.application.DTO.DocumentDTO;
import com.example.SmartDoc.model.Document;
import com.example.SmartDoc.service.DocumentService;
import jakarta.persistence.PostUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@RestController

public class DocumentController {

    private DocumentService documentService;

    private DocumentMapper documentMapper;

    private List<DocumentDTO> documentDTOS = new ArrayList<>() ;

    @Autowired
    public void setDocumentService(DocumentService documentService,DocumentMapper documentMapper) {
        this.documentService = documentService;
        this.documentMapper = documentMapper;
    }


    @GetMapping("/documents/{id}")
    public DocumentDTO get(@PathVariable UUID id) {
        Document doc = documentService.findById(id);
        return documentMapper.toDTO(doc);
    }


    @GetMapping("/documents")
    public void getAll() {
        List<Document> docs = documentService.findAll();
        for (Document doc : docs) {
            documentDTOS.add(documentMapper.toDTO(doc));
            System.out.println(docs) ;
        }

    }
//    @GetMapping("/documents")
//    public List<DocumentDTO> getAll() {
//        List<Document> docs = documentService.findAll();
//        for (Document doc : docs) {
//            documentDTOS.add(documentMapper.toDTO(doc));
//        }
//        return documentDTOS;
//    }




    @PutMapping("/documents/{id}")
    public DocumentDTO update(@PathVariable UUID id, @RequestBody DocumentDTO documentDTO) {
        Document doc = documentMapper.fromDTO(documentDTO);
        return documentMapper.toDTO(documentService.updateFields(id,doc));
    }

}
