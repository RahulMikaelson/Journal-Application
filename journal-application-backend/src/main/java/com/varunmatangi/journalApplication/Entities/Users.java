package com.varunmatangi.journalApplication.Entities;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "Users")
public class Users {

    private ObjectId id;
    @Indexed(unique = true)
    private String userName;
    @Indexed(unique = true)
    private String email;
    private String password;
    private List<String> rolls;
}
