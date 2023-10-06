package com.recipes.demo.services;

import com.recipes.demo.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {

    private List<Recipe> recipeList = new ArrayList<>();

    public void addRecipe(Recipe recipe) {
        recipeList.add(recipe);
    }

    public List<Recipe> getRecipeList() {
        return recipeList;
    }
}
