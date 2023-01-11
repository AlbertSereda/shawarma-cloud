package com.spring.shawarma.shawarmacloud.web;

import com.spring.shawarma.shawarmacloud.Ingredient;
import com.spring.shawarma.shawarmacloud.Ingredient.Type;
import com.spring.shawarma.shawarmacloud.Shawarma;
import com.spring.shawarma.shawarmacloud.ShawarmaOrder;
import com.spring.shawarma.shawarmacloud.data.IngredientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping("/design")
@SessionAttributes("shawarmaOrder")
public class DesignShawarmaController {

    private static final Logger logger = LoggerFactory.getLogger(DesignShawarmaController.class);

    private final IngredientRepository ingredientRepo;

    public DesignShawarmaController(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        Iterable<Ingredient> ingredients = ingredientRepo.findAll();

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

    private Iterable<Ingredient> filterByType(Iterable<Ingredient> ingredients, Type type) {
        return StreamSupport.stream(ingredients.spliterator(), false)
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
