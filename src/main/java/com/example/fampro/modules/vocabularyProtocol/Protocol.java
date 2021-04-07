package com.example.fampro.modules.vocabularyProtocol;


import com.example.fampro.modules.vocabulary.Vocabulary;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Getter @Setter
public class Protocol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private boolean lastCheck;

    @UpdateTimestamp
    private Timestamp lastUpdated;

    @CreationTimestamp
    private Timestamp created;

    private int counter;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name ="vocabulary_id")
    private Vocabulary vocabulary;

    public Protocol(boolean lastCheck, Vocabulary vocabulary){
        super();
        this.counter=1;
        this.lastCheck=lastCheck;
        this.vocabulary =vocabulary;
    }

    public Protocol(){

    }


}
