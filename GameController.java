package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import model.Event;
import model.GameModel;
import view.GameView;

public class GameController {
	private GameModel model;
	private GameView view;
	private Random random = new Random();

	public GameController(GameModel model, GameView view) {
		this.model = model;
		this.view = view;
	}

	public void startGame() {
		do {
			model = new GameModel();
			view.showIntro();
			view.waitForAction();

			// 50件イベント作成
			List<Event> events = Arrays.asList(
					new Event("魔物が出現！一人で戦う", "戦闘", 10, 15, 0,
							Arrays.asList("勇者は剣を振り回した！", "火の魔法を唱えた！", "魔物の弱点を突いた！")),
					new Event("魔物が出現！仲間と戦う", "戦闘", 20, 20, 0,
							Arrays.asList("勇者と仲間が連携攻撃！", "仲間が魔法援護！", "クリティカルヒット！")),
					new Event("魔物から逃げた", "戦闘", 5, 0, 0,
							Arrays.asList("相手の隙を見て逃げた！", "木陰に隠れてやり過ごした！", "壁を越えて逃げた！")),
					new Event("仲間が加わった！", "仲間", 15, 0, 0,
							Arrays.asList("新しい仲間が加わった！")),
					new Event("仲間がスキル習得", "仲間", 10, 0, 0,
							Arrays.asList("仲間が新しい魔法を習得！")),
					new Event("回復の泉発見", "回復", 12, 0, 20,
							Arrays.asList("泉で体力を回復！", "仲間と休息を取った！")),
					new Event("薬草発見", "回復", 8, 0, 15,
							Arrays.asList("薬草で傷を癒した！")),
					new Event("落とし穴に落ちた", "罠", -5, 10, 0,
							Arrays.asList("落とし穴に落ちてダメージ！")),
					new Event("小さな罠にかかった", "罠", -3, 5, 0,
							Arrays.asList("小さな罠にかかって少し傷ついた！")),
					new Event("宝箱発見", "宝", 20, 0, 0,
							Arrays.asList("宝箱を開けて金貨を入手！")),
					new Event("隠された財宝", "宝", 25, 0, 0,
							Arrays.asList("隠された財宝を発見！")),
					new Event("ボス出現！仲間と戦う", "戦闘", 30, 25, 0,
							Arrays.asList("ボスに挑む！仲間が援護！")),
					new Event("謎の商人と遭遇", "宝", 15, 0, 0,
							Arrays.asList("商人から貴重なアイテムを入手！")),
					new Event("強敵出現！一人で戦う", "戦闘", 15, 20, 0,
							Arrays.asList("強敵に挑む！剣で攻撃！", "魔法でダメージ！")),
					new Event("奇跡が起きた！全員回復", "回復", 20, 0, 25,
							Arrays.asList("奇跡で全員回復！")),
					new Event("仲間がピンチ！救出", "仲間", 12, 0, 0,
							Arrays.asList("仲間を助けて戦力アップ！")),
					new Event("迷宮で迷った", "罠", -10, 10, 0,
							Arrays.asList("迷宮で迷って疲労！")),
					new Event("隠し通路発見！宝箱", "宝", 18, 0, 0,
							Arrays.asList("隠し通路から宝箱発見！")),
					new Event("古代魔物と遭遇！仲間と戦闘", "戦闘", 25, 20, 0,
							Arrays.asList("古代魔物に挑む！仲間が援護！")),
					new Event("勇者修行でパワーアップ", "仲間", 10, 0, 0,
							Arrays.asList("勇者が修行してパワーアップ！")),
					new Event("宝物庫発見！", "宝", 35, 0, 0,
							Arrays.asList("宝物庫を発見して大金をゲット！")),

					new Event("罠の部屋発見", "罠", -7, 7, 0, Arrays.asList("罠の部屋でダメージ！")),
					new Event("魔法書発見", "宝", 12, 0, 0, Arrays.asList("魔法書を入手！")),
					new Event("仲間が回復魔法習得", "仲間", 10, 0, 0, Arrays.asList("仲間が回復魔法を習得！")),
					new Event("隠された洞窟発見", "宝", 20, 0, 0, Arrays.asList("洞窟から宝を発見！")),
					new Event("怪しい商人と遭遇", "宝", 15, 0, 0, Arrays.asList("怪しい商人からアイテム入手！")),
					new Event("強敵出現！仲間と戦う", "戦闘", 25, 20, 0, Arrays.asList("強敵に挑む！仲間が援護！")),
					new Event("回復の泉発見2", "回復", 15, 0, 20, Arrays.asList("泉で体力回復！")),
					new Event("落石に襲われる", "罠", -8, 12, 0, Arrays.asList("落石でダメージ！")),
					new Event("古代宝箱発見", "宝", 30, 0, 0, Arrays.asList("古代宝箱を発見！")),
					new Event("仲間が罠を回避", "仲間", 12, 0, 0, Arrays.asList("仲間が罠を回避！")),
					new Event("魔物の群れ出現", "戦闘", 20, 15, 0, Arrays.asList("魔物の群れに挑む！")),
					new Event("宝物庫発見2", "宝", 25, 0, 0, Arrays.asList("宝物庫発見！")),
					new Event("魔法の泉発見", "回復", 18, 0, 25, Arrays.asList("魔法の泉で回復！")),
					new Event("仲間のスキル強化", "仲間", 10, 0, 0, Arrays.asList("仲間のスキル強化！")),
					new Event("怪しい罠発見", "罠", -5, 8, 0, Arrays.asList("罠に少しダメージ！")),
					new Event("巨大魔物出現！", "戦闘", 30, 25, 0, Arrays.asList("巨大魔物に挑む！")),
					new Event("商人の宝箱", "宝", 15, 0, 0, Arrays.asList("商人の宝箱を入手！")),
					new Event("仲間救出作戦", "仲間", 12, 0, 0, Arrays.asList("仲間を救出して戦力増加！")),
					new Event("迷宮の罠発動", "罠", -10, 12, 0, Arrays.asList("迷宮の罠でダメージ！")),
					new Event("隠し財宝発見", "宝", 20, 0, 0, Arrays.asList("隠し財宝を入手！")),
					new Event("奇跡の回復", "回復", 20, 0, 25, Arrays.asList("奇跡で全員回復！")),
					new Event("強敵再挑戦", "戦闘", 25, 20, 0, Arrays.asList("強敵に挑む！")),
					new Event("宝箱発見3", "宝", 25, 0, 0, Arrays.asList("宝箱発見！")),
					new Event("罠の部屋2", "罠", -7, 10, 0, Arrays.asList("罠でダメージ！")),
					new Event("魔物の群れ2", "戦闘", 20, 18, 0, Arrays.asList("魔物の群れに挑む！")),
					new Event("回復の泉3", "回復", 15, 0, 20, Arrays.asList("泉で回復！")),
					new Event("仲間加わる2", "仲間", 12, 0, 0, Arrays.asList("仲間が加わった！")));

			Event lastEvent = null;

			for (int i = 1; i <= 50; i++) {
				List<Event> candidates = new ArrayList<>(events);
				if (lastEvent != null)
					candidates.remove(lastEvent);
				if (candidates.isEmpty())
					candidates.addAll(events);

				Event selected = candidates.get(random.nextInt(candidates.size()));

				// 戦闘
				if (selected.getType().equals("戦闘")) {
					model.battle(selected.getDamage(), selected.getScore());
				} else if (selected.getType().equals("仲間")) {
					model.addScore(selected.getScore());
					model.addAlly();
				} else if (selected.getType().equals("回復")) {
					model.healHero(selected.getHeal());
					model.healAlly(selected.getHeal());
					model.addScore(selected.getScore());
				} else if (selected.getType().equals("宝")) {
					model.addScore(selected.getScore());
				} else if (selected.getType().equals("罠")) {
					model.damageHero(selected.getDamage());
					model.damageAlly(selected.getDamage());
					model.addScore(selected.getScore());
				}

				lastEvent = selected;

				String detail = selected.getRandomAction();
				if (!detail.isEmpty())
					detail = " → " + detail;

				view.showPath(selected.getName() + detail +
						" | HP: " + model.getHeroLP() +
						" | 仲間LP: " + model.getAllyLP() +
						" | スコア: " + model.getScore());

				if (model.getHeroLP() <= 0) {
					view.showPath("勇者のHPが0になった！冒険は強制終了！");
					break;
				}
			}

			// 結果判定
			int finalScore = model.getScore();
			String finalResult;
			if (model.getHeroLP() <= 0 || finalScore < 800)
				finalResult = "ゲームオーバー！";
			else
				finalResult = "冒険成功！伝説の勇者となった！";

			view.showResult(finalResult, finalScore);

		} while (view.askRetry());

		System.out.println("ゲームを終了します。");
	}
}