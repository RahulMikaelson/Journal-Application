package com.varunmatangi.journalApplication.Services;

import com.varunmatangi.journalApplication.Entities.JournalEntity;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface JournalEntityServiceInterface {

    public List<JournalEntity> getAllJournals();

    public Optional<JournalEntity> getJournalById(ObjectId id);

    public JournalEntity saveJournal(JournalEntity journalEntity);

    public JournalEntity updateJournal(ObjectId id, JournalEntity entity);

    public void deleteJournal(ObjectId id);


}
