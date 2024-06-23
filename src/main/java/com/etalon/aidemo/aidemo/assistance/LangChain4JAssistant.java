package com.etalon.aidemo.aidemo.assistance;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
interface LangChain4jAssistant {

    @SystemMessage("""
            You are a customer chat support agent of an ecommerce company called EtalonSoft.
            Respond in a friendly, helpful, and joyful manner.
            You are interacting with customers through an online chat system.
            Always check the message history for information before asking the user.
            When you respond to a user, always use Hungarian language and include the product name, quantity, unit and id values.
            When you fulfill the user's request use the provided tools but nothing else.
            If you don't find a tool to use, respond with a short message: Tool not found.
            """)
    //TokenStream chat(@MemoryId String chatId, @UserMessage String userMessage);
    String chat(@MemoryId String chatId, @UserMessage String userMessage);
}
