package com.diogoraposo.recipeblog.controller;

import com.diogoraposo.recipeblog.model.Recipe;
import com.diogoraposo.recipeblog.model.User;
import com.diogoraposo.recipeblog.repository.UserRepository;
import com.diogoraposo.recipeblog.service.RecipeService;
import com.diogoraposo.recipeblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;
    @Autowired
    private UserService userService;

    @PostMapping()
    public Recipe createRecipe(@RequestBody Recipe recipe, @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.findUserByJwt(jwt);

        return recipeService.createRecipe(recipe,user);
    }

    @GetMapping()
    public List<Recipe> getAllRecipes() throws Exception {

        List<Recipe> recipeList = recipeService.findAllRecipe();
        return recipeList;

    }

    @PutMapping("/{id}")
    public Recipe updateRecipe(@RequestBody Recipe recipe, @PathVariable Long id) throws Exception {

        Recipe updatedRecipe = recipeService.updateRecipe(recipe,id);

        return updatedRecipe;
    }

    @PutMapping("/{id}/like")
    public Recipe likeRecipe(@RequestHeader("Authorization") String jwt, @PathVariable Long id) throws Exception {

        User user = userService.findUserByJwt(jwt);

        Recipe updatedRecipe= recipeService.likeRecipe(id,user);

        return updatedRecipe;
    }

    @DeleteMapping("/{recipeId}")
    public String deleteRecipe(@PathVariable Long recipeId) throws Exception {

        recipeService.deleteRecipe(recipeId);
        return "recipe deleted successfully";

    }
}
