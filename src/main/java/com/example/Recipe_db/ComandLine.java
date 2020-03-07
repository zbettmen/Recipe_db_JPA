package com.example.Recipe_db;

import com.example.Recipe_db.Data.IngridentRepository;
import com.example.Recipe_db.Data.RecipeIngredientRepository;
import com.example.Recipe_db.Data.RecipeRepository;
import com.example.Recipe_db.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Component
public class ComandLine implements CommandLineRunner {

    private RecipeRepository recipeRepository;
    private RecipeIngredientRepository recipeIngredientRepository;



    @Autowired
    public ComandLine(RecipeRepository recipeRepository, RecipeIngredientRepository recipeIngredientRepository) {
        this.recipeRepository = recipeRepository;
        this.recipeIngredientRepository = recipeIngredientRepository;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {


        RecipeCategory recipeCategory = new RecipeCategory("hej");






        Ingredient i = new Ingredient("Rijadhej");
        RecipeIngredient ri = new RecipeIngredient(i,3, Measurement.KG);



       Recipe r = new Recipe("Rijad");

       r.addRecipeCategory(recipeCategory);
        System.out.println(recipeRepository.findRecipeByCategory("hej"));
       r.addRecipeIngrident(ri);
       recipeRepository.save(r);
        System.out.println(r);
        System.out.println(recipeRepository.findRecipeByIngredient("Rijadhej"));

        System.out.println("-----------------------"+recipeRepository.findRecipeFromCategories(Arrays.asList("hej")));





    }





}
