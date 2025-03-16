package com.tao.trigger.http;

import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.Map;

@RestController
@RequestMapping("/ai")
public class OllamaController {

    private final OllamaChatModel chatModel;

    @Autowired
    public OllamaController(OllamaChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @GetMapping("/ollama/generate")
    public ChatResponse generate(@RequestParam(value = "message", defaultValue = "介绍一下自己") String message,
                                 @RequestParam(value = "model", defaultValue = "qwen2:7b") String model) {
        Prompt prompt = new Prompt(message, OllamaOptions.builder().model(model).build());
        return this.chatModel.call(prompt);
    }

    @GetMapping("/ollama/generateStream")
    public Flux<ChatResponse> generateStream(@RequestParam(value = "message", defaultValue = "介绍一下自己") String message,
                                             @RequestParam(value = "model", defaultValue = "qwen2:7b") String model) {
        Prompt prompt = new Prompt(new UserMessage(message), OllamaOptions.builder().model(model).build());
        return this.chatModel.stream(prompt);
    }
}
