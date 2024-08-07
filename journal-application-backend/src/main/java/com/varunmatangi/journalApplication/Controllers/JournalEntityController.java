package com.varunmatangi.journalApplication.Controllers;

import com.varunmatangi.journalApplication.Entities.JournalEntity;
import com.varunmatangi.journalApplication.Services.JournalEntityService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api/v1/journal")
public class JournalEntityController {

    @Autowired
    private JournalEntityService entityService;

    @GetMapping("/all")
    public ResponseEntity<List<JournalEntity>> getAllJournals(){
        List<JournalEntity> journals = entityService.getAllJournals();
        if(journals.isEmpty()){
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(journals,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JournalEntity> getJournalById(@PathVariable ObjectId id){
        Optional<JournalEntity>journalEntity = entityService.getJournalById(id);
        if(journalEntity.isPresent()){
            return new ResponseEntity<>( journalEntity.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/create")
    public ResponseEntity<JournalEntity> createJournal(@RequestBody JournalEntity journalEntity){
        try{
            journalEntity.setDateTime(LocalDateTime.now());
            return new ResponseEntity<>(entityService.saveJournal(journalEntity),HttpStatus.CREATED);
        }catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<JournalEntity> updateJournal(@PathVariable ObjectId id, @RequestBody JournalEntity entity) {
        JournalEntity journalEntity = entityService.updateJournal(id,entity);
        if (journalEntity != null) {
            return new ResponseEntity<>(journalEntity,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> deleteJournal(@PathVariable ObjectId id){
        entityService.deleteJournal(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
