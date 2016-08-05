package com.sarbacane.webhook.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WebHook {
	private String id;

	@JsonProperty("name")
	private String displayName;
	private String email;
	private String kind;

	// For bounces
	private String smtpDescription;
	private String category;
	private Integer returnCode;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
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
