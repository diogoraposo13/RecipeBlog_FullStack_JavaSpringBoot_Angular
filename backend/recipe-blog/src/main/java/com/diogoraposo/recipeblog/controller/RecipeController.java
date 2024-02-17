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

    @PostMapping("/user/{userId}")
    public Recipe createRecipe(@RequestBody Recipe recipe, @PathVariable Long userId) throws Exception {

        User user = userService.findUserById(userId);

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

    @PutMapping("/{id}/like/user/{userId}")
    public Recipe likeRecipe(@PathVariable Long userId, @PathVariable Long id) throws Exception {

        User user = userService.findUserById(userId);

        Recipe updatedRecipe= recipeService.likeRecipe(id,user);

        return updatedRecipe;
    }

    @DeleteMapping("/{recipeId}")
    public String deleteRecipe(@PathVariable Long recipeId) throws Exception {

        recipeService.deleteRecipe(recipeId);
        return "recipe deleted successfully";

    }
}
