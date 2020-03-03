package com.example.Recipe_db.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Recipe {

    @Id
    private int recipeId;
    private String recipeName;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            orphanRemoval = true,
            mappedBy = "recipe"

    )

    private List<RecipeIngredient> recipeIngredients;

    @OneToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}

    )
    @JoinColumn(name = "instruction_id")
    private RecipeInstruction instruction;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}
    )
    @JoinTable(
            name = "recipe_recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_category_id")

    )
    private List<RecipeCategory> categories;

    public boolean addRecipeCategory(RecipeCategory recipeCategory){
        if(recipeCategory == null) return false;

        if(categories.contains(recipeCategory)) return false;
            return categories.add(recipeCategory);
    }

    public boolean removeRecipeCategory(RecipeCategory recipeCategory){
        if(recipeCategory == null) return false;

        if (!categories.contains(recipeCategory)) return false;

        return categories.remove(recipeCategory);
    }

    public boolean addRecipeIngrident(RecipeIngredient recipeIngredient){
        if (recipeIngredient == null) return false;

        if(recipeIngredient.g)

    }

    public Recipe(int recipeId, String recipeName, RecipeInstruction instruction) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.instruction = instruction;
    }

    public Recipe(String recipeName, RecipeInstruction instruction) {
        this(0,recipeName,instruction);


    }

    public Recipe (String recipeName){
        this(0,recipeName,null);

    }
    public Recipe(){

    }

    public int getRecipeId() {
        return recipeId;
    }



    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public RecipeInstruction getInstruction() {
        return instruction;
    }

    public void setInstruction(RecipeInstruction instruction) {
        this.instruction = instruction;
    }

    public List<RecipeCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<RecipeCategory> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return recipeId == recipe.recipeId &&
                Objects.equals(recipeName, recipe.recipeName) &&
                Objects.equals(instruction, recipe.instruction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeId, recipeName, instruction);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeId=" + recipeId +
                ", recipeName='" + recipeName + '\'' +
                ", instruction=" + instruction +
                '}';
    }
}

