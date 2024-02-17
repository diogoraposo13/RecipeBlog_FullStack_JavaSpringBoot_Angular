package com.diogoraposo.recipeblog.service;

import com.diogoraposo.recipeblog.model.Recipe;
import com.diogoraposo.recipeblog.model.User;
import com.diogoraposo.recipeblog.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService{

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public Recipe createRecipe(Recipe recipe, User user) {
        Recipe createdRecipe = new Recipe();

        createdRecipe.setTitle(recipe.getTitle());
        createdRecipe.setImage(recipe.getImage());
        createdRecipe.setDescription(recipe.getDescription());
        createdRecipe.setUser(user);
        createdRecipe.setCreatedAt(LocalDateTime.now());
        createdRecipe.setVegetarian(recipe.isVegetarian());

        return recipeRepository.save(createdRecipe);
    }

    @Override
    public Recipe findRecipeById(Long id) throws Exception {

        Optional<Recipe> opt = recipeRepository.findById(id);

        if(opt.isPresent()){
            return opt.get();
        }

        throw new Exception("recipe not found with id " + id);
    }

    @Override
    public void deleteRecipe(Long id) throws Exception {


        Optional<Recipe> opt = recipeRepository.findById(id);

        if(opt.isPresent()){
            recipeRepository.deleteById(id);
        }
    }

    @Override
    public Recipe updateRecipe(Recipe recipe, Long id) throws Exception {

        Recipe oldRecipe = findRecipeById(id);

        if(recipe.getTitle()!=null){
            oldRecipe.setTitle(recipe.getTitle());
        }
        if(recipe.getImage()!=null){
            oldRecipe.setImage(recipe.getImage());
        }
        if(recipe.getDescription()!=null){
            oldRecipe.setDescription(recipe.getDescription());
        }
        oldRecipe.setVegetarian(recipe.isVegetarian());


        return recipeRepository.save(oldRecipe);
    }

    @Override
    public List<Recipe> findAllRecipe() {

        return recipeRepository.findAll();
    }

    @Override
    public Recipe likeRecipe(Long recipeId, User user) throws Exception {

        Recipe recipe = findRecipeById(recipeId);

        if(recipe.getLikes().contains(user.getId())){
            recipe.getLikes().remove(user.getId());
        }else {
            recipe.getLikes().add(user.getId());
        }



        return recipeRepository.save(recipe);
    }
}
