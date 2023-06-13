package com.buchonsi.recipebook.openapi.controller;

import com.buchonsi.recipebook.openapi.service.RecipeCenter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OpenApiController {

    private final RecipeCenter recipeCenter;

    public OpenApiController(RecipeCenter recipeCenter) {
        this.recipeCenter = recipeCenter;
    }

    @GetMapping("/test")
    public void getRecipe() {
        recipeCenter.getRecipe();
    }
}
