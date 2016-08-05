package com.sarbacane.webhook.repository;

import com.sarbacane.webhook.model.WebHook;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WebHookRepository extends MongoRepository<WebHook, String> {
}
