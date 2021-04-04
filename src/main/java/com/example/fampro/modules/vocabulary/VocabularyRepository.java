package com.example.fampro.modules.vocabulary;

import com.example.fampro.modules.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface VocabularyRepository extends JpaRepository<Vocabulary, Integer> {
    Vocabulary findById(long id);
    List<Vocabulary> findByUser(User user);
}
