package com.deerflow.thspringdandd.characters;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CharacterController {
    @GetMapping("/characters")
    public String charactersList(Model model) {
        model.addAttribute("characters", Characters.list);
        return "charactersList";
    }
}
