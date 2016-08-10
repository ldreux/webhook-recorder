package com.sarbacane.webhook.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.time.Instant;

public class WebHook {
	@Id
	private ObjectId id;

	private String email;
	private String type;
	private String sendId;

	private Instant insertDate;
	private String json;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Instant getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Instant insertDate) {
		this.insertDate = insertDate;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}
	public String getSendId() {
		return sendId;
	}

	public void setSendId(String sendId) {
		this.sendId = sendId;
	}

}
