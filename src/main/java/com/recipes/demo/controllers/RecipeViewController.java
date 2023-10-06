package com.recipes.demo.controllers;

import com.recipes.demo.model.Recipe;
import com.recipes.demo.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RecipeViewController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeViewController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipes")
    public String allRecipes(Model model) {
        List<Recipe> recipeList = recipeService.getRecipeList();
        System.out.println(recipeList);
        model.addAttribute("recipeList", recipeList);
        return "allrecipes";
    }
}
