
package com.example.fampro.modules.vocabulary;


import com.example.fampro.modules.vocabulary.request.CreateVocabulary;
import com.example.fampro.modules.vocabulary.request.UpdateVocabulary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/vocabulary")
public class VocabularyController {

    @Autowired
    VocabularyServiceImpl vocabularyServiceImpl;
    @Autowired
    VocabularyService vocabularyService;

    @GetMapping
    public ResponseEntity<List<Vocabulary>>findAll(){
        return ResponseEntity.ok(vocabularyService.getAll());
    }

    @PostMapping
    public ResponseEntity<Vocabulary> add(@RequestBody CreateVocabulary vocabulary, UriComponentsBuilder uriComponentsBuilder){
        Vocabulary vocabularyAdd = vocabularyService.add(vocabulary);
        UriComponents uriComponents = uriComponentsBuilder.path("Vocabulary/{id}").buildAndExpand(vocabularyAdd.getId());
        URI location = uriComponents.toUri();
        return ResponseEntity.created(location).body(vocabularyAdd);
    }

    @PutMapping
    public Vocabulary updateVocabulary(UpdateVocabulary update, long id){
        return vocabularyService.updateVocabulary(update,id);
    }

    @DeleteMapping
    public void deleteVocabulary(long id){
        vocabularyService.deleteId(id);
    }

}