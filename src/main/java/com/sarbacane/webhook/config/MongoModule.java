package com.sarbacane.webhook.config;

import com.fasterxml.jackson.databind.module.SimpleModule;
import org.bson.types.ObjectId;

public class MongoModule extends SimpleModule {

	public MongoModule() {
		addDeserializer(ObjectId.class, new ObjectIdDeserializer());
		addSerializer(ObjectId.class, ObjectIdSerializer.INSTANCE);
	}
}
