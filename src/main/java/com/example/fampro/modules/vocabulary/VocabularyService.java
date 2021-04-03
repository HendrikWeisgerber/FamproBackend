package com.example.fampro.modules.vocabulary;

import java.util.List;

public interface VocabularyService {
    List<Vocabulary> getAll();
    Vocabulary add(Vocabulary vocabulary);
}
