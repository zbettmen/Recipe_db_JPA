package com.example.Recipe_db;

import com.example.Recipe_db.Data.IngridentRepository;
import com.example.Recipe_db.entity.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ComandLine implements CommandLineRunner {

    private IngridentRepository ingridentRepository;

    @Autowired
    public ComandLine(IngridentRepository ingridentRepository) {
        this.ingridentRepository = ingridentRepository;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        ingridentRepository.save(new Ingredient("Bruce Wayne"));

    }
}
