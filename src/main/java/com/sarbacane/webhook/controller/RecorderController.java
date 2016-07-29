package com.sarbacane.webhook.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.nio.file.Files.newOutputStream;
import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.util.StreamUtils.copy;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@ConfigurationProperties(prefix = "webhook")
public class RecorderController {
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
	private String outFolderPath = System.getProperty("java.io.tmpdir");
	private SecureRandom random = new SecureRandom();

	@ResponseStatus(ACCEPTED)
	@RequestMapping(method = POST, value = "record")
	public void record(HttpServletRequest httpRequest) throws IOException {
		Path outputFile = Paths.get(outFolderPath, FORMATTER.format(LocalDateTime.now()) + "-" + nextSessionId());
		ServletInputStream inputStream = httpRequest.getInputStream();

		try (OutputStream out = newOutputStream(outputFile)) {
			copy(inputStream, out);
		}
	}

	public String getOutFolderPath() {
		return outFolderPath;
	}

	public void setOutFolderPath(String outFolderPath) {
		this.outFolderPath = outFolderPath;
	}

	public String nextSessionId() {
		return new BigInteger(130, random).toString(32);
	}
}
