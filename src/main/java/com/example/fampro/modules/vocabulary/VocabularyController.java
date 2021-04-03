
package com.example.fampro.modules.vocabulary;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/vokabel")
public class VocabularyController {

    @Autowired
    VocabularyServiceImpl vocabularyServiceImpl;
    @Autowired
    VocabularyService vocabularyService;

    @RequestMapping(value="/all")
    public ResponseEntity<List<Vocabulary>>findAll(){
        return ResponseEntity.ok(vocabularyService.getAll());
    }

    @PostMapping(value="/add", produces = "application/json")
    public ResponseEntity<Vocabulary> add(@RequestBody Vocabulary vocabulary, UriComponentsBuilder uriComponentsBuilder){
        Vocabulary vocabularyAdd = vocabularyService.add(vocabulary);
        UriComponents uriComponents = uriComponentsBuilder.path("Vocabulary/{id}").buildAndExpand(vocabularyAdd.getId());
        URI location = uriComponents.toUri();
        return ResponseEntity.created(location).body(vocabularyAdd);
    }


}