package com.example.SmartDoc.service;

import com.example.SmartDoc.model.Document;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;
import org.springframework.ai.content.Media;

import java.time.LocalDate;
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

        var userMessage = UserMessage.builder()
                .text("""
                  You are an IDP assistant.
                  - If input is a PDF, read all pages.
                  - If input is an image, do OCR first.
                  Return a concise JSON with detected doc type and key fields (dates, totals, names, ids, addresses).
                  """)
                .media(List.of(new Media(type, file)))
                .build();

        String response = String.valueOf(this.openAiChatModel.call(
                new Prompt(List.of(userMessage),
                        OpenAiChatOptions.builder()
                                .model("gpt-4o")
                                .build())
        ));

        System.out.println(response);
        String filename = file.getFilename();
        LocalDateTime date = LocalDateTime.now();
        Document doc = new Document(filename,null,date,"loading",response);
        return doc;
    }

    private MimeType detectMimeType(Resource file) {
        String name = file.getFilename() == null ? "" : file.getFilename().toLowerCase();

        if (name.endsWith(".pdf"))   return new MimeType("application", "pdf");
        if (name.endsWith(".docx")) return new MimeType("application, vnd.openxmlformats-officedocument.wordprocessingml.document");// no MimeTypeUtils constant for PDF
        if (name.endsWith(".doc"))   return new MimeType("application", "msword");
        if (name.endsWith(".png"))   return MimeTypeUtils.IMAGE_PNG;
        if (name.endsWith(".jpg") || name.endsWith(".jpeg")) return MimeTypeUtils.IMAGE_JPEG;

        throw new IllegalArgumentException("Unsupported file type: " + name);
    }

}


