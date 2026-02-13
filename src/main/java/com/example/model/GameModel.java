package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class GameModel {
    private int heroLP = 100;
    private int score = 0;
    private int allyCount = 0;
    private List<EventResult> history = new ArrayList<>();

    public int getHeroLP() { return heroLP; }
    public int getScore() { return score; }
    public int getAllyCount() { return allyCount; }
    public List<EventResult> getHistory() { return history; }

    public void addScore(int s) { score += s; }
    public void addAlly() { allyCount++; }
    public void changeHeroLP(int delta) { 
        heroLP += delta; 
        if(heroLP < 0) heroLP = 0; 
    }

    // 履歴追加
    public void addEventResult(Event e, int hpChange) {
        history.add(new EventResult(
            e.getName(),
            e.getRandomAction(),
            hpChange,
            heroLP
        ));
    }

    // 冒険履歴用クラス
    public static class EventResult {
        private String name;
        private String action;
        private int hpChange;
        private int currentHP;

        public EventResult(String name, String action, int hpChange, int currentHP) {
            this.name = name;
            this.action = action;
            this.hpChange = hpChange;
            this.currentHP = currentHP;
        }

        public String getName() { return name; }
        public String getAction() { return action; }
        public int getHpChange() { return hpChange; }
        public int getCurrentHP() { return currentHP; }
    }
}