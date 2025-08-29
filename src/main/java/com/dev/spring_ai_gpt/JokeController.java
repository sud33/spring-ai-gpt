package com.dev.spring_ai_gpt;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JokeController {

    private final ChatClient client;

    public JokeController(ChatClient.Builder builder)
    {
        this.client = builder
                .build();
    }

    @GetMapping("/one-liner-joke/{jokeType}")
    public String getJoke(@PathVariable String jokeType) {
        return client
                .prompt()
                .user("Tell me a one-liner " + jokeType + " joke")
                .call()
                .content();
    }
}
