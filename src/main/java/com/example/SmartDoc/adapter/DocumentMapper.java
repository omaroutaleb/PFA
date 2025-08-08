package com.example.SmartDoc.adapter;


import com.example.SmartDoc.application.DTO.DocumentDTO;
import com.example.SmartDoc.model.Document;
import com.example.SmartDoc.service.DocumentService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DocumentMapper  {

    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();}

    public DocumentDTO toDTO(Document document){
          return modelMapper().map(document,DocumentDTO.class);
    }

    public Document fromDTO(DocumentDTO documentDTO){
        return modelMapper().map(documentDTO,Document.class);
    }




}
