package models;

import enums.Difficulty;

public class Problem {

    private  String name;
    private String description;
    private Difficulty difficulty;
    private Tag tag;
    private Integer score;

    public Problem(String name, String description, Difficulty difficulty, Tag tag, Integer score) {
        this.name = name;
        this.description = description;
        this.difficulty = difficulty;
        this.tag = tag;
        this.score = score;
    }


    public String getDescription() {
        return description;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public Tag getTag() {
        return tag;
    }

    public Integer getScore() {
        return score;
    }

    public String getName() {
        return name;
    }
}
