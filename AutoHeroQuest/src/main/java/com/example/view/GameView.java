package com.example.view;

import java.util.Scanner;

public class GameView {
    private Scanner scanner = new Scanner(System.in);

    public void showIntro() {
        System.out.println("=== 勇者の自動冒険 ===");
        System.out.println("Enterキーを押すと勇者が冒険を進めます！");
    }

    public void waitForAction() {
        System.out.println("Enterキーを押して冒険開始...");
        scanner.nextLine();
    }

    public void showPath(String pathDescription) {
        System.out.println(pathDescription);
    }

    public void showResult(String result, int score) {
        System.out.println("\n=== 冒険結果 ===");
        System.out.println(result);
        System.out.println("最終スコア: " + score);
        System.out.println("=================");
    }

    public boolean askRetry() {
        System.out.println("もう一度冒険しますか？ (y:リトライ / n:終了) ");
        String input = scanner.nextLine().trim().toLowerCase();
        return input.equals("y");
    }
}