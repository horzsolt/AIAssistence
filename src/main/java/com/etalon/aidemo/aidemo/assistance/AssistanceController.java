package com.etalon.aidemo.aidemo.assistance;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/assistance")
@CrossOrigin
//@Slf4j
public class AssistanceController {

    private final LangChain4jAssistant langChain4JAssistant;

    public AssistanceController(LangChain4jAssistant langChain4JAssistant) {
        this.langChain4JAssistant = langChain4JAssistant;
    }

    
    @PostMapping
    public String chat_(@RequestBody ChatMessage chatMessage) {
        //log.debug(chatMessage.getMessage());
        String result = langChain4JAssistant.chat(chatMessage.getChatId(), chatMessage.getMessage());
        //log.debug(result);
        return result;
    }
    
}
