package com.recipes.demo.controllers;

import com.recipes.demo.model.Recipe;
import com.recipes.demo.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recipes")
public class RecipeAddController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeAddController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/add")
    public String displayRecipeForm(Model model) {
        model.addAttribute("recipe", new Recipe());
        return "recipe";
    }

    @PostMapping("/add")
    public String recipeSubmit(@ModelAttribute Recipe recipe, Model model) {
        recipeService.addRecipe(recipe);
        model.addAttribute("recipe", recipe);
        return "redirect:/recipes";
    }
}
