package com.tao.test.app;

import com.alibaba.fastjson.JSON;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class OllamaTest {

    @Resource
    private OllamaChatModel ollamaChatModel;

    @Test
    public void test_ollamaApi() {
        String message = "使用Java，写一个快速排序";
        ChatResponse response = ollamaChatModel.call(new Prompt(message,
                ChatOptions.builder()
                        .model("qwen2.5-coder:1.5b")
                        .build()
        ));
        System.out.println(response.getResult());
    }
}
