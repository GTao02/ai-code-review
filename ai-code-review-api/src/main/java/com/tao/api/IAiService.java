package com.tao.api;

import org.springframework.ai.chat.model.ChatResponse;
import reactor.core.publisher.Flux;

/**
 * ai 模型对接接口
 */
public interface IAiService {

    /**
     * 生成文本
     * @param model 模型
     * @param message 消息
     * @return {@link ChatResponse}
     */
    ChatResponse generate(String model, String message);

    /**
     * 生成文本流
     * @param model 模型
     * @param message 消息
     * @return {@link ChatResponse}
     */
    Flux<ChatResponse> generateStream(String model, String message);

}
