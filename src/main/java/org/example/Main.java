package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @RestController
    public class HelloWorldController {

        @GetMapping("/send")
        public String sendMessage() {
            RestTemplate restTemplate = new RestTemplate();
            String googleChatWebhookUrl = "YOUR WEBHOOK URL";

            String jsonMessage = "{ 'text' : 'Hello. Have a nice day.' }";

            restTemplate.postForEntity(googleChatWebhookUrl, jsonMessage, String.class);

            return "Message sent!";
        }
    }
}
