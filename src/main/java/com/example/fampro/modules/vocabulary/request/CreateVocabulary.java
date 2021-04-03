package com.example.fampro.modules.vocabulary.request;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class CreateVocabulary {
    private String german;
    private String english;


    public CreateVocabulary(String german, String english) {
        this.german = german;
        this.english = english;

    }
}
