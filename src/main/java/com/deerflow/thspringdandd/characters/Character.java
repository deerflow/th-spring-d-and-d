package com.deerflow.thspringdandd.characters;

public class Character {
    private Integer id;
    private String name;
    private CharacterType type;
    private Integer lifePoints;

    Character() {
    }

    Character(String name, CharacterType type, int lifePoints) {
        this.id = Characters.list.size() + 1;
        this.name = name;
        this.type = type;
        this.lifePoints = lifePoints;
    }

    Character(Integer id, String name, CharacterType type, int lifePoints) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.lifePoints = lifePoints;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {
        this.type = type;
    }

    public Integer getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(Integer lifePoints) {
        this.lifePoints = lifePoints;
    }
}
