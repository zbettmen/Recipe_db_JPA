package com.example.Recipe_db;

import com.example.Recipe_db.Data.IngridentRepository;
import com.example.Recipe_db.entity.Ingredient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@DataJpaTest
public class IngridentRepositoryTest {
    @Autowired
    IngridentRepository testObject;
    @Autowired
    TestEntityManager entityManager;

    private List<Ingredient> data ()  {
        return Arrays.asList(new Ingredient ("JuggeKryddor"),
                new Ingredient("JuggeKanel"),
                new Ingredient("JuggeSocker"),
                new Ingredient("JuggesKryddors")


        );

    }

    @BeforeEach
    void setUp(){

        data().forEach(testObject::save);
    }

    @Test
    public void testing35(){
        String name = "JuggeKryddor";
        Optional<Ingredient> result = testObject.findByIngredientName(name);


    }
}
