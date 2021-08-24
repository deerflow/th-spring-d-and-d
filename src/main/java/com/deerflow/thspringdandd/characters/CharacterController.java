package com.deerflow.thspringdandd.characters;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class CharacterController {
    @GetMapping("/characters")
    public String charactersList(Model model) {
        model.addAttribute("characters", Characters.findAll());
        return "charactersList";
    }

    @GetMapping("/characters/new")
    public String createCharacterForm(Model model) {
        model.addAttribute("character", new Character());
        return "createCharacterForm";
    }

    @PostMapping("/characters/new")
    public RedirectView createCharacter(@ModelAttribute Character character) {
        Characters.createOne(character);
        return new RedirectView("/characters");
    }

    @DeleteMapping("/characters/delete/{id}")
    public RedirectView deleteCharacter(@PathVariable(value = "id") int id) {
        Characters.deleteOne(id);
        return new RedirectView("/characters");
    }

    @GetMapping("/characters/{id}")
    public String getCharacterById(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("character", Characters.findById(id));
        return "oneCharacter";
    }
}
