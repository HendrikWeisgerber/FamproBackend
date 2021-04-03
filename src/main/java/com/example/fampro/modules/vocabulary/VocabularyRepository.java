package com.example.fampro.modules.vocabulary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface VocabularyRepository extends JpaRepository<Vocabulary, Integer> {
    //List<Vocabulary> findByBenutzer(String benutzer);
}
