package com.example.Recipe_db.Data;

import com.example.Recipe_db.entity.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends CrudRepository <Recipe, Integer> {
    Optional<Recipe> findByRecipeName(String name);

    @Query("SELECT r FROM Recipe r WHERE r.recipeName LIKE %:recipeName%")
    List<Recipe> findByRecipeByNameContains(@Param("recipeName") String recipeName);

    @Query("SELECT r FROM Recipe r JOIN FETCH r.recipeIngredients recipeIngredient WHERE recipeIngredient.ingredient.ingredientName = :ingredientName")
    List<Recipe> findRecipeByIngredient(@Param("ingredientName") String ingredientName);


    @Query("SELECT r FROM Recipe r JOIN FETCH r.categories recipeCategory WHERE recipeCategory.category = :categoryName")
    List<Recipe> findRecipeByCategory(@Param("categoryName")String categoryName);


    @Query("SELECT r FROM Recipe r JOIN FETCH r.categories recipeCategory WHERE recipeCategory.category IN :listOfCategoryName")
    List<Recipe> findRecipeFromCategories(@Param("listOfCategoryName") List<String> listOfCategoryName);








}
