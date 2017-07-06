package io.smartmachine.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class KubclientApplication {

	private static final Logger log = LoggerFactory.getLogger(KubclientApplication.class);

	@Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate template) {
        return args -> {
            Greeting greeting = template.getForObject("http://serviceone/greeting", Greeting.class);
            log.info(greeting.toString());
        };
    }

	public static void main(String[] args) {
        SpringApplication.run(KubclientApplication.class);
    }
}
