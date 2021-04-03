
package com.example.fampro.modules.vocabulary;

import com.example.fampro.modules.vocabulary.request.CreateVocabulary;
import com.example.fampro.modules.vocabulary.request.UpdateVocabulary;
import com.example.fampro.utils.exception.VocabularyNotFoundException;
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
    public Vocabulary add(CreateVocabulary vocabulary){
        Vocabulary zuSpeicherndeVocabulary = new Vocabulary(vocabulary);
        vocabularyRepository.save(zuSpeicherndeVocabulary);
        return zuSpeicherndeVocabulary;
    }

    @Override
    public Vocabulary updateVocabulary(UpdateVocabulary update, long id) {
        Vocabulary vocabulary = vocabularyRepository.findById(id);
        if (vocabulary==null){throw new VocabularyNotFoundException("The vocabulary could not be found");}
        if(update.getGerman()!=null){
            vocabulary.setGerman(update.getGerman());
        }
        if(update.getEnglish()!=null){
            vocabulary.setEnglish(update.getEnglish());
        }
        vocabulary = vocabularyRepository.save(vocabulary);
        return vocabulary;
    }


    @Override
    public void deleteId(long id) throws VocabularyNotFoundException {
        Vocabulary vocabulary = vocabularyRepository.findById(id);
        vocabularyRepository.delete(vocabulary);
    }
}