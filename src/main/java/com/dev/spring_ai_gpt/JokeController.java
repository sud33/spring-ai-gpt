package com.dev.spring_ai_gpt;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class JokeController {

    private final ChatClient client;

    @Value("classpath:/templates/dad_joke.st")
    private Resource dadJokeTemplatedResource;

    @Value("classpath:/templates/top10.st")
    private Resource top10TemplatedResource;

    public JokeController(ChatClient.Builder builder)
    {
        this.client = builder
                .build();
    }

    @GetMapping("/one-liner-joke/{jokeType}")
    public String getJoke(@PathVariable String jokeType) {


        PromptTemplate promptTemplate = new PromptTemplate(dadJokeTemplatedResource);
        Prompt dynamicVal = promptTemplate.create(Map.of("jokeType", jokeType));
        return client.prompt(dynamicVal).call().content();
    }

    @GetMapping("/top-10/{type}/{genre}")
    public String getTop10Type(@PathVariable String type, @PathVariable String genre) {

        PromptTemplate promptTemplate = new PromptTemplate(top10TemplatedResource);
        Map dynaMap = new HashMap();
        dynaMap.put("type", type);
        dynaMap.put("genre",genre);
        Prompt dynamicVal = promptTemplate.create(dynaMap);
        return client.prompt(dynamicVal).call().content();
    }
}
