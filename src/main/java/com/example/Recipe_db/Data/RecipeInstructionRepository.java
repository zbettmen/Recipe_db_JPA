package com.example.Recipe_db.Data;


import com.example.Recipe_db.entity.Ingredient;
import com.example.Recipe_db.entity.RecipeInstruction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeInstructionRepository extends CrudRepository<RecipeInstruction,String> {

    @Query("SELECT i FROM Ingredient i WHERE i.ingredientName LIKE %:ingredientName%")
    List<Ingredient> findByIngridentByNameContains(@Param("ingredientName") String ingredientName);


}
