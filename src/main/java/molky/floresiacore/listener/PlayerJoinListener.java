package molky.floresiacore.listener;

import molky.floresiacore.controller.ScoreboardController;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        p.setScoreboard(ScoreboardController.createNewScoreboard(p));
    }
}
