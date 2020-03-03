package com.example.Recipe_db.Data;

import com.example.Recipe_db.entity.Ingredient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IngridentRepository  extends CrudRepository<Ingredient,Integer> {

    Optional<Ingredient> findByIngredientName(String ingredientName);

    @Query("SELECT i FROM Ingredient i WHERE i.ingredientName LIKE %:ingredientName%")
    List<Ingredient> findByIngridentByNameContains(@Param("ingredientName") String ingredientName);



}
