package model;

import java.util.List;
import java.util.Random;

public class Event {
    private String name;
    private String type;
    private int score;
    private int damage;
    private int heal;
    private List<String> actions;
    private Random random = new Random();

    public Event(String name, String type, int score, int damage, int heal, List<String> actions) {
        this.name = name;
        this.type = type;
        this.score = score;
        this.damage = damage;
        this.heal = heal;
        this.actions = actions;
    }

    public String getName() { return name; }
    public String getType() { return type; }
    public int getScore() { return score; }
    public int getDamage() { return damage; }
    public int getHeal() { return heal; }

    public String getRandomAction() {
        if (actions == null || actions.isEmpty()) return "";
        return actions.get(random.nextInt(actions.size()));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Event)) return false;
        Event e = (Event)obj;
        return name.equals(e.name) && type.equals(e.type);
    }

    @Override
    public int hashCode() {
        return name.hashCode() + type.hashCode();
    }
}