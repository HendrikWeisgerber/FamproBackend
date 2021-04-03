package com.example.fampro.modules.user;


import com.example.fampro.modules.vocabulary.Vocabulary;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="user")
@Getter @Setter
public class User {

    @Column(name = "id")
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastname")
    private String lastname;

    //@Email
    private String email;

    private Timestamp created;
    private Timestamp lastUpdated;



    @JsonIgnore
    @ManyToMany(fetch= FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable( name = "user_vocabulary",
            joinColumns ={@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name= "vocabulary_id")})
    private Set<Vocabulary> vocabularies = new HashSet<>();

    public User(String vorname, String nachname) {
        this.firstName = vorname;
        this.lastname = nachname;
        this.created= new Timestamp(System.currentTimeMillis());
    }

    public User() {

    }


}