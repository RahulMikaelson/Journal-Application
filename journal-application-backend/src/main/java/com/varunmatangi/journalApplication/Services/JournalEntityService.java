package com.varunmatangi.journalApplication.Services;

import com.varunmatangi.journalApplication.Entities.JournalEntity;
import com.varunmatangi.journalApplication.Repositories.JournalEntityRepositoryInterface;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class JournalEntityService  implements  JournalEntityServiceInterface{

    @Autowired
    private JournalEntityRepositoryInterface repositoryInterface;
    @Override
    public List<JournalEntity> getAllJournals() {
        return repositoryInterface.findAll();
    }

    @Override
    public Optional<JournalEntity> getJournalById(ObjectId id) {
        return repositoryInterface.findById(id);
    }

    @Override
    public JournalEntity saveJournal(JournalEntity journalEntity) {
        return repositoryInterface.save(journalEntity);
    }

    @Override
    public JournalEntity updateJournal(ObjectId id, JournalEntity entity) {
        JournalEntity journalEntity = repositoryInterface.findById(id).orElse(null);
        if(journalEntity==null){
            return null;
        }
        journalEntity.setTitle((entity.getTitle()!=null || entity.getTitle().equals(""))? entity.getTitle() : journalEntity.getTitle());
        journalEntity.setContent((entity.getContent()!=null || entity.getContent().equals("")? entity.getContent() : journalEntity.getContent()));
        return repositoryInterface.save(journalEntity);
    }


    @Override
    public void deleteJournal(ObjectId id) {
        repositoryInterface.deleteById(id);
    }
}
