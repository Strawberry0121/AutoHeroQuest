package com.example.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.model.Event;
import com.example.model.GameModel;

@Controller
public class GameController {

    private List<Event> events = new ArrayList<>();
    private Random random = new Random();

    public GameController() {
        events.add(new Event("魔物が出現！一人で戦う", "戦闘", 10,
                Arrays.asList("剣で攻撃！", "火の魔法を唱えた！", "弱点を突いた！")));
        events.add(new Event("回復の泉を発見！", "回復", 12,
                Arrays.asList("泉で回復！", "仲間と休息！")));
        events.add(new Event("宝箱を発見！", "宝", 15,
                Arrays.asList("金貨を入手！", "レアアイテムゲット！")));
        events.add(new Event("落とし穴に落ちた！", "罠", -5,
                Arrays.asList("ダメージを受けた！")));
        events.add(new Event("天空の魔物出現！", "戦闘", 28,
                Arrays.asList("空からの攻撃！")));
    }

    @GetMapping("/")
    public String start() {
        return "start"; // start.html を返す
    }

    @PostMapping("/game/start")
    public String startGame() {
        return "redirect:/game/auto";
    }
   
    @GetMapping("/game/auto")
    public String autoPlay(Model model) throws Exception {
        GameModel game = new GameModel();
        int step = 0;

        while(game.getHeroLP() > 0 && step < 1) {
            List<Event> candidates = new ArrayList<>(events);
            GameModel.EventResult lastEventResult = game.getHistory().isEmpty() ? null :
                    game.getHistory().get(game.getHistory().size() - 1);

            if(lastEventResult != null) {
                String lastName = lastEventResult.getName();
                candidates.removeIf(e -> e.getName().equals(lastName));
            }

            Event selected = candidates.get(random.nextInt(candidates.size()));

            int hpChange = 0;
            switch(selected.getType()) {
                case "戦闘":
                    hpChange = -5 - random.nextInt(15);
                    game.changeHeroLP(hpChange);
                    game.addScore(selected.getScore() + game.getAllyCount()*2);
                    break;
                case "回復":
                    hpChange = 5 + random.nextInt(15);
                    game.changeHeroLP(hpChange);
                    game.addScore(selected.getScore());
                    break;
                default:
                    hpChange = 0;
                    game.addScore(selected.getScore());
            }

            game.addEventResult(selected, hpChange);
            step++;
        }

        // --- ここで history を model に追加する ---
        model.addAttribute("history", game.getHistory());
        model.addAttribute("finalScore", game.getScore());
        model.addAttribute("message", game.getHeroLP() <= 0 ? "ゲームオーバー！" : "伝説の勇者になった！");

        return "result";
    }
}