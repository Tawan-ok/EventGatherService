package com.example.EventGather.repository;

import com.example.EventGather.model.entity.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<Event,String> {

}
