package com.example.SmartDoc.service;

import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.content.Media;
import org.springframework.core.io.Resource;
import org.springframework.util.MimeType;

import java.util.List;
import java.util.List;

@Service
public class AIService {

    private final OpenAiChatModel openAiChatModel;

    public AIService(OpenAiChatModel openAiChatModel) {
        this.openAiChatModel = openAiChatModel;
    }



    public ChatResponse extractFieldsFromPdf(Resource pdfFile) {
        var userMessage = UserMessage.builder()
                .text("""
                  Summarize this PDF. 
                  - What is it about?
                  - Key fields, dates, amounts
                  - Any tables or entities worth extracting
                  """)
                .media(List.of(new Media(new MimeType("application", "pdf"), pdfFile)))
                .build();

        var response = this.openAiChatModel.call(
                new Prompt(List.of(userMessage),
                        OpenAiChatOptions.builder()
                                .model("gpt-4o")
                                .build())
        );

        System.out.println(response);
        return response;
    }


//
//    public ChatResponse extractFields(Resource file) {
//
//
//        var userMessage = UserMessage.builder()
//                .text("Explain what do you see on this picture?")
//                .media(List.of(new org.springframework.ai.content.Media(MimeTypeUtils.IMAGE_PNG, (Resource) file)))
//                .build();
//        var response = this.openAiChatModel
//                .call(new Prompt(List.of(userMessage), OpenAiChatOptions.builder().model("gpt-4o").build()));
//
//        System.out.println(response);
//        return response;


    }


