
package com.example.fampro.modules.vocabulary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VocabularyServiceImpl implements VocabularyService {
    @Autowired
    VocabularyRepository vocabularyRepository;


    @Override
    public List<Vocabulary> getAll(){
        List<Vocabulary> vocabularies = vocabularyRepository.findAll();
        List<Vocabulary> vocabularyResponse =new ArrayList<>();
        vocabularies.forEach(vocabulary -> vocabularyResponse.add(vocabulary));
        return vocabularyResponse;
    }

    @Override
    public Vocabulary add(Vocabulary vocabulary){
        Vocabulary zuSpeicherndeVocabulary = vocabulary;
        vocabularyRepository.save(zuSpeicherndeVocabulary);
        return vocabulary;



    }

}