package com.deerflow.thspringdandd.characters;

import java.util.ArrayList;
import java.util.List;

public class Characters {

    public static List<Character> list = new ArrayList<>(
            List.of(
                    new Character(1, "Girouette", CharacterType.Mage, 11),
                    new Character(2, "Pizza", CharacterType.Warrior, 25),
                    new Character(3, "Plouk", CharacterType.Mage, 19)
            )
    );
}
