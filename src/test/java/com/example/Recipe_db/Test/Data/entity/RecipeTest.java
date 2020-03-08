package com.example.Recipe_db.Test.Data.entity;

import com.example.Recipe_db.entity.Ingredient;
import com.example.Recipe_db.entity.Recipe;
import com.example.Recipe_db.entity.RecipeCategory;
import com.example.Recipe_db.entity.RecipeIngredient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.*;

public class RecipeTest {
 private Recipe recipe;
 private RecipeCategory recipeCategory;
 private RecipeCategory recipeCategory2;

 private RecipeIngredient recipeIngredient;
 private RecipeIngredient recipeIngredient2;

 @BeforeEach
    void setUp(){
     recipe = new Recipe("JuggeGryta");
     recipeCategory = new RecipeCategory("Test category");
     recipeCategory2 = new RecipeCategory("Test category2");
     recipeIngredient = new RecipeIngredient(new Ingredient("Test ingredient"));
     recipeIngredient2 = new RecipeIngredient(new Ingredient("test"));

 }
    @Test
    public void addRecipeCategory_test(){
        recipe.addRecipeCategory(recipeCategory);
        recipe.addRecipeCategory(recipeCategory2);

        assertNotNull(recipe.getCategories());
        assertEquals(2,recipe.getCategories().size());
    }

    @Test
    public void removeRecipeCategory_test(){
        recipe.addRecipeCategory(recipeCategory);
        recipe.addRecipeCategory(recipeCategory2);
        recipe.removeRecipeCategory(recipeCategory);

        assertNotNull(recipe.getCategories());
        assertEquals(1,recipe.getCategories().size());
    }

    @Test
    public void addRecipeIngredient_test(){
        recipe.addRecipeIngrident(recipeIngredient);
        recipe.addRecipeIngrident(recipeIngredient2);

        assertNotNull(recipe.getRecipeIngredients());
        assertEquals(1,recipe.getRecipeIngredients().size());
    }


    @Test
    public void removeRecipeIngredient_test(){
        recipe.addRecipeIngrident(recipeIngredient);
        recipe.addRecipeIngrident(recipeIngredient2);
        recipe.deleteRecipeIngrident(recipeIngredient);

        assertNotNull(recipe.getRecipeIngredients());
        assertEquals(0,recipe.getRecipeIngredients().size());
    }









}
