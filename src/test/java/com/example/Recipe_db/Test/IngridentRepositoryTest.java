package com.example.Recipe_db.Test;

import com.example.Recipe_db.Data.IngridentRepository;
import com.example.Recipe_db.entity.Ingredient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@DataJpaTest

class IngridentRepositoryTest {

    @Autowired private IngridentRepository testObject;
    @Autowired private TestEntityManager entityManager;

    private Ingredient ingredient;
    private List<Ingredient> data ()  {
        return Arrays.asList(new Ingredient ("JuggeKrydda"),
                new Ingredient("JuggenIkryddan")
        );
    }



    @BeforeEach
    void setUp(){
        
        ingredient = testObject.save(data().get(1));
        entityManager.flush();


    }



    @Test
    void testFindByIngredientName(){
       String name = "JuggeKrydda";
       Optional<Ingredient> result = testObject.findByIngredientName(name);
       assertTrue(result.isPresent());
       assertEquals(ingredient,result.get());
    }


    @Test
    void testFindByIngredientNameContains(){
        String contains = "r";
        List<Ingredient> result = testObject.findByIngridentByNameContains(contains);

        assertEquals(1, result.size());
        assertTrue(result.contains(ingredient));
    }



}



