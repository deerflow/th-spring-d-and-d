package com.deerflow.thspringdandd.characters;

import com.deerflow.thspringdandd.App;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class CharacterController {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @GetMapping("/characters")

    public String charactersList(Model model, RestTemplate restTemplate) {
        ResponseEntity<Character[]> characters = restTemplate.getForEntity(App.apiUrl + "/characters", Character[].class);
        model.addAttribute("characters", characters.getBody());
        return "charactersList";
    }

    @GetMapping("/characters/new")
    public String createCharacterForm(Model model) {
        model.addAttribute("character", new Character());
        return "createCharacterForm";
    }

    @PostMapping("/characters/new")
    public RedirectView createCharacter(@ModelAttribute Character character, RestTemplate restTemplate) {
        restTemplate.postForObject(App.apiUrl + "/characters", character, Boolean.class);
        return new RedirectView("/characters");
    }

    @DeleteMapping("/characters/delete/{id}")
    public RedirectView deleteCharacter(@PathVariable(value = "id") int id, RestTemplate restTemplate) {
        restTemplate.delete(App.apiUrl + "/characters/" + id);
        return new RedirectView("/characters");
    }

    @GetMapping("/characters/edit/{id}")
    public String editCharacterForm(@PathVariable(value = "id") int id, Model model, RestTemplate restTemplate) {
        Character character = restTemplate.getForObject(App.apiUrl + "/characters/" + id, Character.class);
        model.addAttribute("character", character);
        return "editCharacterForm";
    }

    @PutMapping("/characters/edit/{id}")
    public RedirectView editCharacter(@ModelAttribute Character character, @PathVariable(value = "id") int id, RestTemplate restTemplate) {
        restTemplate.put(App.apiUrl + "/characters/" + id, character);
        return new RedirectView("/characters/" + character.getId());
    }

    @GetMapping("/characters/{id}")
    public String getCharacterById(Model model, @PathVariable(value = "id") int id, RestTemplate restTemplate) {
        Character character = restTemplate.getForObject(App.apiUrl + "/characters/" + id, Character.class);
        model.addAttribute("character", character);
        return "oneCharacter";
    }
}
