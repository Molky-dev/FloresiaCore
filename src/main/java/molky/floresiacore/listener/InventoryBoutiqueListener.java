package molky.floresiacore.listener;

import molky.floresiacore.commands.CommandInfo;
import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryBoutiqueListener implements Listener {
    private Inventory inv;


    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player p = (Player) event.getWhoClicked();
        ItemStack is = event.getCurrentItem();

        if (is != null) {
            if (event.getInventory().getName().equals("§cBoutique")) {
                event.setCancelled(true);

            }
        }
    }


    public void openInventory(HumanEntity ent) {
        ent.openInventory(inv);
    }
}
