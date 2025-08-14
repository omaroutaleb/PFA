package com.example.SmartDoc.service;

import com.example.SmartDoc.model.Document;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.content.Media;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AIService {

    private final OpenAiChatModel openAiChatModel;

    public AIService(OpenAiChatModel openAiChatModel) {
        this.openAiChatModel = openAiChatModel;
    }

    public Document extractFields(Resource file) {
        MimeType type = detectMimeType(file);

        UserMessage userMessage = UserMessage.builder()
                .text("""
                        You are an Intelligent Document Processing (IDP) assistant. Extract key information from uploaded documents and return results as JSON only.
                                                PROCESS:
                                                1. PDF: Read all pages
                                                2. Image: Perform OCR first
                                                3. Extract: Document type, dates, amounts, names, IDs, addresses, and other key fields
                                                4. Output: Clean JSON with "doctype" field and extracted data
          
                                                Return only the JSON response, no explanations.""")
                .media(List.of(new Media(type, file)))
                .build();

        OpenAiChatOptions options = OpenAiChatOptions.builder()
                .model("gpt-4o")
                .build();
        ChatResponse resp = this.openAiChatModel.call(new Prompt(List.of(userMessage), options));


        String json;
        json = resp.getResult().getOutput().getText();
        json = stripCodeFences(json);

           System.out.println(json);

        String filename = file.getFilename();
        LocalDateTime date = LocalDateTime.now();
        String doctype = docTypeFrom(json);
        System.out.println("doctype: " + doctype);
        return new Document(filename, doctype, date, "extracted", json);
    }

    private MimeType detectMimeType(Resource file) {
        String name = file.getFilename() == null ? "" : file.getFilename().toLowerCase();

        if (name.endsWith(".pdf"))   return new MimeType("application", "pdf");
        if (name.endsWith(".docx"))  return new MimeType("application", "vnd.openxmlformats-officedocument.wordprocessingml.document");
        if (name.endsWith(".doc"))   return new MimeType("application", "msword");
        if (name.endsWith(".png"))   return MimeTypeUtils.IMAGE_PNG;
        if (name.endsWith(".jpg") || name.endsWith(".jpeg")) return MimeTypeUtils.IMAGE_JPEG;

        throw new IllegalArgumentException("Unsupported file type: " + name);
    }

    private static String docTypeFrom(String json) {
        try {
            com.fasterxml.jackson.databind.ObjectMapper om = new com.fasterxml.jackson.databind.ObjectMapper();
            com.fasterxml.jackson.databind.JsonNode r = om.readTree(json);
            com.fasterxml.jackson.databind.JsonNode n = r.at("/doctype");
            if (!n.isTextual()) n = r.at("/key_fields/doctype");
            return n.isTextual() ? n.asText() : null;
        } catch (Exception e) {
            return null;
        }
    }


    private static String stripCodeFences(String s) {
        if (s == null) return null;
        return s.replaceAll("(?s)```json\\s*|```", "").trim();
    }
}
