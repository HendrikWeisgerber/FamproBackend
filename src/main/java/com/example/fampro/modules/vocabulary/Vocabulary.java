package com.example.fampro.modules.vocabulary;



import com.example.fampro.modules.user.User;
import com.example.fampro.modules.vocabulary.request.CreateVocabulary;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Vocabulary {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)  @Column(name= "id")
    private long id;

    @Column(name="german")
    private String german;

    @Column(name="english")
    private String english;

    private Date created;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "vocabularies")
    private Set<User> users = new HashSet<>();


    public Vocabulary(String german, String english) {
        super();
        this.german = german;
        this.english = english;
        this.created= new Date();
    }

    public Vocabulary(){
        this.created= new Date();
    }



    public Vocabulary(CreateVocabulary vocabulary){
        this(vocabulary.getGerman(), vocabulary.getEnglish());
        this.created= new Date();
    }
}

