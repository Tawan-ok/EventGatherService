package com.example.EventGather.model.entity;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "events")
@Getter
@Setter
public class Event {
    @Id
    private String id;
    private String title;
    private String description;
    private String location;
    private String date;
    private String time;
    private String organizerId;
    private List<String> participantIds;
}
