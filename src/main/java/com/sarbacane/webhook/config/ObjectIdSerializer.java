package com.sarbacane.webhook.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.bson.types.ObjectId;

import java.io.IOException;

public class ObjectIdSerializer extends StdSerializer<ObjectId> {
	
	public static final ObjectIdSerializer INSTANCE = new ObjectIdSerializer();
	    private ObjectIdSerializer() { super(ObjectId.class); }

	@Override
	public void serialize(ObjectId id, JsonGenerator json, SerializerProvider provider) throws IOException {
		if (id == null) {
			json.writeNull();
		} else {
			json.writeString(id.toString());
		}
	}
}
