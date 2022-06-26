package molky.floresiacore.listener;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlaceBlockListener implements Listener {

    @EventHandler
    public void onPlaceBlock(BlockPlaceEvent event) {
        Player p = event.getPlayer();
        Block blk = event.getBlockPlaced();
        Material m = blk.getType();
        if(m == Material.OBSIDIAN && p.getItemInHand().hasItemMeta()) {
            if(p.getItemInHand().getItemMeta().getDisplayName().equals("§6Légende de l'obsidienne")) {
                Location loc = event.getBlockPlaced().getLocation();
                if (p.getLocation().getPitch() > 60) {
                    if (p.getLocation().add(1, 0, 0).getBlock().getType().equals(Material.AIR)) {
                        p.teleport(p.getLocation().add(1, 0, 0));
                    }
                    if (p.getLocation().add(-1, 0, 0).getBlock().getType().equals(Material.AIR)) {
                        p.teleport(p.getLocation().add(-1, 0, 0));

                    }
                    if (p.getLocation().add(0, 0, -1).getBlock().getType().equals(Material.AIR)) {
                        p.teleport(p.getLocation().add(0, 0, -1));

                    }
                    if (p.getLocation().add(0, 0, 1).getBlock().getType().equals(Material.AIR)) {
                        p.teleport(p.getLocation().add(0, 0, 1));

                    }
                }
                for (int i = (int) loc.getY(); i < 255; i++) {
                    loc.setY(i);
                    Location location = p.getLocation();
                    location.setX(loc.getX());
                    location.setY(loc.getY() + 1);
                    location.setZ(loc.getZ());
                    if (location.getBlock().getType().equals(Material.AIR)) {
                        loc.getBlock().setType(Material.OBSIDIAN);
                    } else {
                        loc.getBlock().setType(Material.OBSIDIAN);
                        break;
                    }
                }
            }
        }
        if(m == Material.ENDER_STONE) {
            Location loc = event.getBlockPlaced().getLocation();
            if(p.getLocation().getPitch() > 60) {
                if(p.getLocation().add(1,0,0).getBlock().getType().equals(Material.AIR)) {
                    p.teleport(p.getLocation().add(1,0,0));
                }
                if(p.getLocation().add(-1,0,0).getBlock().getType().equals(Material.AIR)) {
                    p.teleport(p.getLocation().add(-1,0,0));

                }
                if(p.getLocation().add(0,0,-1).getBlock().getType().equals(Material.AIR)) {
                    p.teleport(p.getLocation().add(0,0,-1));

                }
                if(p.getLocation().add(0,0,1).getBlock().getType().equals(Material.AIR)) {
                    p.teleport(p.getLocation().add(0,0,1));

                }
            }
            for(int i = (int) loc.getY(); i<255; i++) {
                loc.setY(i);
                Location location = p.getLocation();
                location.setX(loc.getX());
                location.setY(loc.getY() + 1);
                location.setZ(loc.getZ());
                if(location.getBlock().getType().equals(Material.AIR)) {
                    loc.getBlock().setType(Material.ENDER_STONE);
                } else {
                    loc.getBlock().setType(Material.ENDER_STONE);
                    break;
                }
            }
        }
    }
}
