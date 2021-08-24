package com.deerflow.thspringdandd.characters;

public class Character {

    private Integer id;
    private String name;
    private String type;
    private Integer lifePoints;

    Character() {
    }

    Character(String name, String type, int lifePoints) {
        this.id = Characters.list.size() + 1;
        this.name = name;
        this.type = type;
        this.lifePoints = lifePoints;
    }

    Character(int id, String name, String type, int lifePoints) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.lifePoints = lifePoints;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }
}
