package com.example.Recipe_db.Data;

import com.example.Recipe_db.entity.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IngridentRepository  extends CrudRepository<Ingredient,Integer> {

    Optional<Ingredient> findByIngredientName(String ingredientName);

}
