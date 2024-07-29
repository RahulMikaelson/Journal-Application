package com.varunmatangi.journalApplication.Entities;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "Journals")
@Data
public class JournalEntity {
    private ObjectId id;
    private String title;
    private String content;
    private LocalDateTime dateTime;
}
