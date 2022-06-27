package molky.floresiacore.controller;

import molky.floresiacore.FloresiaCoreMain;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

public class ScoreboardController {
    private static final HashMap<Player, HashMap<Integer, String>> currentScoreboard = new HashMap<>();

    private static final HashMap<Player, Scoreboard> scoreboard = new HashMap<>();

    private static int highlightIndex = 0;

    public static void setup() {

        for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
            Scoreboard newScoreboard = ScoreboardController.createNewScoreboard(onlinePlayers);
            onlinePlayers.setScoreboard(newScoreboard);
        }

        new BukkitRunnable() {
            @Override
            public void run() {
                ScoreboardController.updateColors();
                for (Player onlinePlayers : Bukkit.getOnlinePlayers())
                    ScoreboardController.updateScoreboard(onlinePlayers);
            }
        }.runTaskTimer(FloresiaCoreMain.getInstance(), 0, 2);

    }

    private static void updateColors() {
        highlightIndex++;
        if (highlightIndex == 50) {
            highlightIndex = 0;
        }
    }

    private static void updateScoreboard(Player p) {
        Scoreboard scoreboardOfPlayer = scoreboard.get(p);
        scoreboard.put(p, scoreboardOfPlayer);
        Objective ob = scoreboardOfPlayer.getObjective("Floresia");
        if (ob == null) {
            ob = scoreboardOfPlayer.registerNewObjective("Floresia", "dummy");
            ob.setDisplaySlot(DisplaySlot.SIDEBAR);
        }
        StringBuilder titleBuilder = new StringBuilder();
        int index = 0;
        for (char titleChar : "FLORESIA".toCharArray()) {
            if (index == highlightIndex || index == highlightIndex - 1) {
                titleBuilder.append("§e§l");
            } else {
                titleBuilder.append("§6§l");
            }
            titleBuilder.append(titleChar);
            index++;
        }
        ob.setDisplayName(titleBuilder.toString().replace("§6§lF§6§lL§6§lO§6§lR", "§6§lFLOR").replace("§6§lE§6§lS§6§lI§6§lA", "§6§lESIA").replace("§6§lF§6§lL§6§lO", "§6§lFLO").replace("§6§lS§6§lI§6§lA", "§6§lSIA"));
        addScoreboardStatistics(p, ob);
        p.setScoreboard(scoreboardOfPlayer);
    }

    private static void addScoreboardStatistics(Player p, Objective ob) {
        HashMap<Integer, String> currentScoreboardOfPlayer = currentScoreboard.get(p);
        if (currentScoreboardOfPlayer.size() == 0) {
            Score space0 = ob.getScore(" ");
            space0.setScore(11);

            Score title1 = ob.getScore("§6§l" + p.getName());
            title1.setScore(10);

            Score space1 = ob.getScore("  ");
            space1.setScore(9);

            Score username = ob.getScore("§7▻  Grade : §r" + p.getDisplayName().replace(p.getName(), "").replace("[", "").replace("]", ""));
            username.setScore(8);

            Score Floresiacoins = ob.getScore("§7▻  Argent : §r" + "SOON");
            Floresiacoins.setScore(7);

            Score space2 = ob.getScore("   ");
            space2.setScore(6);

            Score title2 = ob.getScore("§6§lInfos");
            title2.setScore(5);

            Score space3 = ob.getScore("     ");
            space3.setScore(4);

            Score ping = ob.getScore("§7▻  Ping : §r" + getPing(p));
            ping.setScore(3);

            Score space4 = ob.getScore("      ");
            space4.setScore(2);

            Score ip = ob.getScore("§6§lplay.floresia.fr");
            ip.setScore(1);

            currentScoreboardOfPlayer.put(11, " ");
            currentScoreboardOfPlayer.put(10, "§6§l" + p.getName());
            currentScoreboardOfPlayer.put(9, "  ");
            currentScoreboardOfPlayer.put(8, "§7▻  Grade : §r" + p.getDisplayName().replace(p.getName(), "").replace("[", "").replace("]", ""));
            currentScoreboardOfPlayer.put(7, "§7▻  Argent : §r" + "SOON");
            currentScoreboardOfPlayer.put(6, "   ");
            currentScoreboardOfPlayer.put(5, "§6§lInfos");
            currentScoreboardOfPlayer.put(4, "    ");
            currentScoreboardOfPlayer.put(3, "§7▻  Ping : §r" + getPing(p));
            currentScoreboardOfPlayer.put(2, "     ");
            currentScoreboardOfPlayer.put(1, "§b§lplay.floresia.fr");
        }else {
            for (int scoreNumber : currentScoreboardOfPlayer.keySet()) {
                String scoreName = currentScoreboardOfPlayer.get(scoreNumber);
                switch (scoreNumber) {
                    case 3:
                        if (!scoreName.equals("§7▻  Ping : §r" + getPing(p))) {
                            ob.getScoreboard().resetScores(scoreName);
                            Score score = ob.getScore("§7▻  Ping : §r" + getPing(p));
                            score.setScore(scoreNumber);
                            currentScoreboardOfPlayer.put(3, "§7▻  Ping : §r" + getPing(p));
                        }
                        break;
                    case 8:
                        if (!scoreName.equals(p.getDisplayName().replace(p.getName(), "").replace("[", "").replace("]", ""))) {
                            ob.getScoreboard().resetScores(scoreName);
                            Score score = ob.getScore("§7▻  Grade : §r" + p.getDisplayName().replace(p.getName(), "").replace("[", "").replace("]", ""));
                            score.setScore(scoreNumber);
                            currentScoreboardOfPlayer.put(8, "§7▻  Grade : §r" +  p.getDisplayName().replace(p.getName(), "").replace("[", "").replace("]", ""));
                        }
                        break;
                    default:
                        break;
                }
            }
        }

    }

    private static Method getHandleMethod;
    private static Field pingField;

    public static int getPing(Player player) {
        try {
            if (getHandleMethod == null)
                getHandleMethod = player.getClass().getDeclaredMethod("getHandle");
            Object craftPlayer = getHandleMethod.invoke(player);
            if (pingField == null)
                pingField = craftPlayer.getClass().getDeclaredField("ping");
            return pingField.getInt(craftPlayer);
        } catch (Exception e) {
            return -1;
        }
    }
    public static Scoreboard createNewScoreboard(Player p) {
        scoreboard.put(p, Bukkit.getScoreboardManager().getNewScoreboard());
        currentScoreboard.put(p, new HashMap<>());
        return scoreboard.get(p);
    }
}