package com.sarbacane.webhook;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
public class WebHookRecorderApplication {
	public static void main(String[] args) throws Exception {
		run(WebHookRecorderApplication.class, args);
	}
}
