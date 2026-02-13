package com.example.model;

import java.util.List;
import java.util.Random;

public class Event {
    private String name;
    private String type;
    private int score;
    private List<String> actions;
    private Random random = new Random();

    public Event(String name, String type, int score, List<String> actions) {
        this.name = name;
        this.type = type;
        this.score = score;
        this.actions = actions;
    }

    public String getName() { return name; }
    public String getType() { return type; }
    public int getScore() { return score; }

    public String getRandomAction() {
        if(actions == null || actions.isEmpty()) return "";
        return actions.get(random.nextInt(actions.size()));
    }
}