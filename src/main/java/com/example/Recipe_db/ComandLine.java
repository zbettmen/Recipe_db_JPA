package com.example.Recipe_db;

import com.example.Recipe_db.Data.IngridentRepository;
import com.example.Recipe_db.Data.RecipeIngredientRepository;
import com.example.Recipe_db.Data.RecipeRepository;
import com.example.Recipe_db.entity.Ingredient;
import com.example.Recipe_db.entity.Recipe;
import com.example.Recipe_db.entity.RecipeIngredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
       Recipe r = new Recipe("Rijad");
      recipeRepository.save(r);
        System.out.println(r);
        System.out.println(recipeRepository.findByRecipeByNameContains("d"));
    }





}
