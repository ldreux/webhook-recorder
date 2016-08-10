package com.sarbacane.webhook;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sarbacane.webhook.config.MongoModule;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;
import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static com.fasterxml.jackson.databind.SerializationFeature.FAIL_ON_EMPTY_BEANS;
import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;
import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
public class WebHookRecorderApplication {
	public static void main(String[] args) throws Exception {
		run(WebHookRecorderApplication.class, args);
	}

	@Bean
	@Primary
	public ObjectMapper objectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setVisibility(FIELD, ANY);
		mapper.setSerializationInclusion(NON_NULL);
		mapper.configure(FAIL_ON_EMPTY_BEANS, false);
		mapper.configure(WRITE_DATES_AS_TIMESTAMPS, false);
		mapper.configure(FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.registerModule(new JavaTimeModule());
		mapper.registerModule(new MongoModule());
		return mapper;
	}
}
