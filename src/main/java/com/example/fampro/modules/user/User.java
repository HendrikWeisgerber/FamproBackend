package com.example.fampro.modules.user;


import com.example.fampro.modules.user.request.CreateUser;
import com.example.fampro.modules.vocabulary.Vocabulary;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="user")
@Getter @Setter
public class User {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO) @Id
    private int id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Email //@Id
    private String email;

    private Timestamp created;
    private Timestamp lastUpdated;




    @OneToMany(mappedBy = "user")
    private Set<Vocabulary> vocabularies = new HashSet<>();

    public User(String vorname, String nachname, String email) {
        this.firstName = vorname;
        this.lastName = nachname;
        this.email = email;
        this.created= new Timestamp(System.currentTimeMillis());
    }

    public User() {
        this.created= new Timestamp(System.currentTimeMillis());
    }

    public User (CreateUser user){
        this(user.getFirstName(), user.getLastName(), user.getEmail());
        this.created= new Timestamp(System.currentTimeMillis());
    }


}