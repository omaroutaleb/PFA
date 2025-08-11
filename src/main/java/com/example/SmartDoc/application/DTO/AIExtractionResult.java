package com.example.SmartDoc.application.DTO;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class AIExtractionResult {

    private String docType;
    private List<DocumentFiledDTO> fields ;


}
