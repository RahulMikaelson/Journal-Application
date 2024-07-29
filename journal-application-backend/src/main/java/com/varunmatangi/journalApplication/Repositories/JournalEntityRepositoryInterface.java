package com.varunmatangi.journalApplication.Repositories;

import com.varunmatangi.journalApplication.Entities.JournalEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public interface JournalEntityRepositoryInterface extends MongoRepository<JournalEntity, ObjectId> {
}
