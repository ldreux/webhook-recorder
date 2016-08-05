package com.sarbacane.webhook.controller;

import com.sarbacane.webhook.model.WebHook;
import com.sarbacane.webhook.repository.WebHookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@ConfigurationProperties(prefix = "webhook")
public class RecorderController {
	@Autowired
	private WebHookRepository webHookRepository;

	@ResponseStatus(ACCEPTED)
	@RequestMapping(method = POST, value = "record")
	public void record(WebHook webHook) throws IOException {
		webHookRepository.insert(webHook);

	}
}
