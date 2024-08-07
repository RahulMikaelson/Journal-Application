package com.varunmatangi.journalApplication.Repositories;

import com.varunmatangi.journalApplication.Entities.Users;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepositoryInterface extends MongoRepository<Users, ObjectId> {

    public Users findByUserName(String userName);
}
