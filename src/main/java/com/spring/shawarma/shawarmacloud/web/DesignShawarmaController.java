package com.spring.shawarma.shawarmacloud.web;

import com.spring.shawarma.shawarmacloud.Ingredient;
import com.spring.shawarma.shawarmacloud.Shawarma;
import com.spring.shawarma.shawarmacloud.ShawarmaOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.spring.shawarma.shawarmacloud.Ingredient.Type;

import javax.validation.Valid;

@Controller
@RequestMapping("/design")
@SessionAttributes("shawarmaOrder")
public class DesignShawarmaController {

    private static final Logger logger = LoggerFactory.getLogger(DesignShawarmaController.class);

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("CLLA", "Classic lavash", Ingredient.Type.WRAP),
                new Ingredient("GALA", "Garlic lavash", Ingredient.Type.WRAP),
                new Ingredient("CHLA", "Cheese lavash", Ingredient.Type.WRAP),
                new Ingredient("PITA", "Pita", Ingredient.Type.WRAP),
                new Ingredient("CHIC", "Chicken", Ingredient.Type.MEAT),
                new Ingredient("PORK", "Pork", Ingredient.Type.MEAT),
                new Ingredient("TOMA", "Tomatoes", Ingredient.Type.VEGGIES),
                new Ingredient("CUCU", "Cucumbers", Ingredient.Type.VEGGIES),
                new Ingredient("CLSA", "Classic sauce", Ingredient.Type.SAUCE),
                new Ingredient("CHSA", "Cheese sauce", Ingredient.Type.SAUCE),
                new Ingredient("SPSA", "Spacy sauce", Ingredient.Type.SAUCE),
                new Ingredient("CHAD", "Cheese", Ingredient.Type.ADDITIVES),
                new Ingredient("JAAD", "Jalapeno", Ingredient.Type.ADDITIVES)
        );

        Type[] types = Ingredient.Type.values();

        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
    }

    @ModelAttribute(name = "shawarmaOrder")
    public ShawarmaOrder order() {
        return new ShawarmaOrder();
    }

    @ModelAttribute(name = "shawarma")
    public Shawarma shawarma() {
        return new Shawarma();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(e -> e.getType().equals(type))
                .collect(Collectors.toList());
    }

    @PostMapping
    public String processShawarma(@Valid Shawarma shawarma,
                                  Errors errors,
                                  @ModelAttribute ShawarmaOrder shawarmaOrder) {

        if (errors.hasErrors()) {
            return "design";
        }

        shawarmaOrder.addShawarma(shawarma);
        logger.info("Processing Shawarma: {}", shawarma);
        return "redirect:/orders/current";
    }
}
