package com.sarbacane.webhook.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.bson.types.ObjectId;

import java.io.IOException;

public class ObjectIdDeserializer extends JsonDeserializer<ObjectId> {
	@Override
	public ObjectId deserialize(JsonParser jp,
								DeserializationContext context) throws IOException {
		if (!ObjectId.isValid(jp.getText()))
			throw context.mappingException("invalid ObjectId " + jp.getText());
		return new ObjectId(jp.getText());
	}
}
