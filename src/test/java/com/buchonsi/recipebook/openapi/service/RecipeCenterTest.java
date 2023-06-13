package com.buchonsi.recipebook.openapi.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RecipeCenterTest {

    @Autowired
    RecipeCenter recipeCenter;


    @Test
    void getApi(){
        String recipe = recipeCenter.getRecipe();
        System.out.println("recipe = " + recipe);

    }

}