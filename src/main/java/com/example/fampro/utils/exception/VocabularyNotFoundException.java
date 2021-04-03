package com.example.fampro.utils.exception;

import com.example.fampro.modules.vocabulary.Vocabulary;

public class VocabularyNotFoundException extends RuntimeException{
    public VocabularyNotFoundException(String message){super(message);}
}
