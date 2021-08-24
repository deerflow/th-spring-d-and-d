package com.deerflow.thspringdandd.characters;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class CharacterController {
    @GetMapping("/characters")
    public String charactersList(Model model) {
        model.addAttribute("characters", Characters.list);
        return "charactersList";
    }

    @GetMapping("/characters/new")
    public String createCharacterForm(Model model)
    {
        model.addAttribute("character", new Character());
        return "createCharacterForm";
    }

    @PostMapping("/characters/new")
    public RedirectView createCharacter(@ModelAttribute Character character)
    {
        Characters.list.add(character);
        return new RedirectView("/characters");
    }

    @GetMapping("/characters/{id}")
    public String getCharacterById(Model model, @PathVariable(value = "id") int id)
    {
        for (Character character : Characters.list) {
            if (character.getId() == id) {
                model.addAttribute("character", character);
            }
        }
        return "oneCharacter";
    }
}
