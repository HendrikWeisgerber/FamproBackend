package com.example.fampro.modules.vocabulary.request;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter @Setter
public class CreateVocabulary {
    private String german;
    private String english;

    @Email
    private String ownersEmail;


    public CreateVocabulary(String german, String english, @NotNull String email) {
        this.german = german;
        this.english = english;
        this.ownersEmail=email;
    }
}
