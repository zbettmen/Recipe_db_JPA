package com.example.Recipe_db.Data;

import com.example.Recipe_db.entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@DataJpaTest
public class RecipeRepositoryTest {
    @Autowired
    private RecipeRepository testObject;
    @Autowired
    private TestEntityManager entityManager;


    private List<Recipe> data(){
        return Arrays.asList(
                new Recipe("Burek"),
                new Recipe("JuggeGryta"),
                new Recipe("Pizza")
        );
    }

    private Recipe testRecipe;
    private int testRecipeId;


    @BeforeEach
    void setUp(){

        Ingredient suger = new Ingredient("Suger");

        Recipe recipe = new Recipe("Test");
        Ingredient ingredient = entityManager.persist(new Ingredient("Suger"));
        RecipeIngredient recipeIngredient = new RecipeIngredient(ingredient,10,Measurement.ST);
        recipe.addRecipeIngrident(recipeIngredient);
        RecipeCategory recipeCategory1 = new RecipeCategory("Test");
        recipe.addRecipeCategory(recipeCategory1);
        recipe.setInstruction(new RecipeInstruction("Test instruction"));
        testObject.save(recipe);
        //testObject.deleteAll();







    }
    @Test
    public void recipeName_findByRecipeNameContains(){
        String name = "Test";
        List<Recipe> result = testObject.findByRecipeByNameContains(name);

        assertEquals(1,result.size());
    }

    @Test
    public void findRecipeIngrident(){
        List<Recipe> result = testObject.findRecipeByIngredient("Suger");
        assertEquals(1,result.size());
    }

    @Test
    public void findRecipeByCategory(){
        List<Recipe> actual = testObject.findRecipeByCategory("Test");


        assertEquals(1,actual.size());
    }

    @Test
    public void findRecipeByCategories_test(){
        List<Recipe> result = testObject.findRecipeFromCategories(Arrays.asList("Test"));

        assertEquals(1,result.size());




    }
    @Test
    public void findByRecipeName_test(){
        int result = testObject.findByRecipeName("Test").get().getRecipeId();


        assertEquals(testRecipeId,result);
    }











}
