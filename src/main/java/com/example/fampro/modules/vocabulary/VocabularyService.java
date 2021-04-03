package com.example.fampro.modules.vocabulary;

import com.example.fampro.modules.vocabulary.request.CreateVocabulary;
import com.example.fampro.modules.vocabulary.request.UpdateVocabulary;
import com.example.fampro.utils.exception.VocabularyNotFoundException;

import java.util.List;

public interface VocabularyService {
    List<Vocabulary> getAll();
    Vocabulary add(CreateVocabulary vocabulary);
    Vocabulary updateVocabulary(UpdateVocabulary update, long id)throws VocabularyNotFoundException;
    void deleteId(long id) throws VocabularyNotFoundException;
}
