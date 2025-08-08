package com.example.SmartDoc.application.DTO;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DocumentUploadDTO {

    private List<DocumentFiledDTO> fields = new ArrayList<>();
}
