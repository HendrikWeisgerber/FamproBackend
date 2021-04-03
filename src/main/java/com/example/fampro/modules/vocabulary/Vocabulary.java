package com.example.fampro.modules.vocabulary;



import com.example.fampro.modules.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.*;
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


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "vocabularies")
    private Set<User> users = new HashSet<>();


    public Vocabulary(String german, String english) {
        super();
        this.german = german;
        this.english = english;
    }

    public Vocabulary(){}
}