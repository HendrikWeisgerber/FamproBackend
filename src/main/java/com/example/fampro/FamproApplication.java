package com.example.fampro;

import com.example.fampro.modules.user.User;
import com.example.fampro.modules.user.UserRepository;
import com.example.fampro.modules.vocabulary.Vocabulary;
import com.example.fampro.modules.vocabulary.VocabularyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableJpaRepositories(basePackages = "com.example.fampro.module")
@SpringBootApplication
public class FamproApplication implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    @Autowired
    VocabularyRepository vocabularyRepository;

    public static void main(String[] args) {
        SpringApplication.run(FamproApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User hendrik = new User("Hendrik", "Weisgerber", "Hendrik@hpe.com");
        User daniel = new User("Daniel", "Weisgerber","daniel@hoandme.com");

        Vocabulary hello = new Vocabulary("hallo","hello");
        Vocabulary world = new Vocabulary("Welt","World");

        hendrik.getVocabularies().add(hello);
        hendrik.getVocabularies().add(world);
        daniel.getVocabularies().add(hello);

        hello.getUsers().add(hendrik);
        world.getUsers().add(hendrik);
        hello.getUsers().add(daniel);

        this.vocabularyRepository.save(hello);
        this.vocabularyRepository.save(world);

        this.userRepository.save(hendrik);
        this.userRepository.save(daniel);




    }
}