package com.sarbacane.webhook.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sarbacane.webhook.model.WebHook;
import com.sarbacane.webhook.repository.WebHookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static com.google.common.io.ByteStreams.toByteArray;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.time.Instant.now;
import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@ResponseBody
@ConfigurationProperties(prefix = "webhook")
public class RecorderController {
	@Autowired
	private WebHookRepository webHookRepository;

	@Autowired
	private ObjectMapper objectMapper;

	@ResponseStatus(ACCEPTED)
	@RequestMapping(method = POST, value = "record")
	public void record(HttpServletRequest request) throws IOException {
		byte[] data = toByteArray(request.getInputStream());

		WebHook webHook = objectMapper.readValue(data, WebHook.class);
		webHook.setInsertDate(now());
		webHook.setJson(new String(data, UTF_8));
		webHookRepository.insert(webHook);
	}

	@RequestMapping
	public Page<WebHook> findAll(Pageable pageable) {
		return webHookRepository.findAll(pageable);
	}
}
