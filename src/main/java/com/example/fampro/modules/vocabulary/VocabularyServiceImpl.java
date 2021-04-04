
package com.example.fampro.modules.vocabulary;

import com.example.fampro.modules.user.User;
import com.example.fampro.modules.user.UserRepository;
import com.example.fampro.modules.vocabulary.request.CreateVocabulary;
import com.example.fampro.modules.vocabulary.request.UpdateVocabulary;
import com.example.fampro.utils.exception.UserNotFoundException;
import com.example.fampro.utils.exception.VocabularyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VocabularyServiceImpl implements VocabularyService {
    @Autowired
    VocabularyRepository vocabularyRepository;

    @Autowired
    UserRepository userRepository;


    @Override
    public List<Vocabulary> getAll(){
        List<Vocabulary> vocabularies = vocabularyRepository.findAll();
        List<Vocabulary> vocabularyResponse =new ArrayList<>();
        vocabularies.forEach(vocabulary -> vocabularyResponse.add(vocabulary));
        return vocabularyResponse;
    }

    @Override
    public Vocabulary add(CreateVocabulary vocabulary){
        Vocabulary addVocab = new Vocabulary(vocabulary);
        User owner = userRepository.findByEmail(vocabulary.getOwnersEmail());

        addVocab.setUser(owner);
        owner = userRepository.save(owner);
        addVocab= vocabularyRepository.save(addVocab);
        return addVocab;
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

    @Override
    public List<Vocabulary> findByUser(String email) throws UserNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user ==null){
            throw new UserNotFoundException("No User with that email adress could be found");
        }
        List<Vocabulary> usersVocabularys = vocabularyRepository.findByUser(user);
        return  usersVocabularys;
    }
}