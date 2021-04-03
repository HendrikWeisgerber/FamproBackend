package com.example.fampro.modules.vocabulary.request;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdateVocabulary {

    private String english;
    private String german;

    public UpdateVocabulary(String english, String german) {
        this.english = english;
        this.german = german;
    }
}
