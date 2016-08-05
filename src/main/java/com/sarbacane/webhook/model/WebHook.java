package com.sarbacane.webhook.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WebHook {
	@JsonProperty("id")
	private String webHookId;

	private String name;
	private String email;
	private String kind;

	// For bounces
	private String smtpDescription;
	private String category;
	private Integer returnCode;

	public String getWebHookId() {
		return webHookId;
	}

	public void setWebHookId(String webHookId) {
		this.webHookId = webHookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSmtpDescription() {
		return smtpDescription;
	}

	public void setSmtpDescription(String smtpDescription) {
		this.smtpDescription = smtpDescription;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(Integer returnCode) {
		this.returnCode = returnCode;
	}
}
