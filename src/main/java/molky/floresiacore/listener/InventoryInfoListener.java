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

public class InventoryInfoListener implements Listener {
    private Inventory inv;


    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player p = (Player) event.getWhoClicked();
        ItemStack is = event.getCurrentItem();

        if (is != null) {
            if (event.getInventory().getName().startsWith("§cInformations §4• (§c")) {
                event.setCancelled(true);
                if (is.getItemMeta().getDisplayName().equals("§aMondes")) {
                    inv = Bukkit.createInventory(null, 9 * 5, "§cInformations §4• (§c1§4/§c6§4)");
                    initializeMondes();
                    openInventory(p);
                }
                if (is.getItemMeta().getDisplayName().equals("§fRéglement")) {
                    inv = Bukkit.createInventory(null, 9 * 5, "§cInformations §4• (§c2§4/§c6§4)");
                    initializeReglement();
                    openInventory(p);
                }
                if (is.getItemMeta().getDisplayName().equals("§cObjets désactivé")) {
                    inv = Bukkit.createInventory(null, 9 * 5, "§cInformations §4• (§c3§4/§c6§4)");
                    initializeObjets();
                    openInventory(p);
                }
                if (is.getItemMeta().getDisplayName().equals("§bLiens important")) {
                    inv = Bukkit.createInventory(null, 9 * 5, "§cInformations §4• (§c4§4/§c6§4)");
                    initializeLiens();
                    openInventory(p);
                }
                if (is.getItemMeta().getDisplayName().equals("§dCommandes")) {
                    inv = Bukkit.createInventory(null, 9 * 5, "§cInformations §4• (§c5§4/§c6§4)");
                    initializeCommandes();
                    openInventory(p);
                }
                if (is.getItemMeta().getDisplayName().equals("§eGagner de l'argent")) {
                    inv = Bukkit.createInventory(null, 9 * 5, "§cInformations §4• (§c6§4/§c6§4)");
                    initializeArgent();
                    openInventory(p);
                }
            }
        }
    }

    public void initializeMondes() {
        CommandInfo.initializeBase(inv, 10);
    }

    public void initializeReglement() {
        CommandInfo.initializeBase(inv, 11);

    }

    public void initializeObjets() {
        CommandInfo.initializeBase(inv, 12);

    }

    public void initializeLiens() {
        CommandInfo.initializeBase(inv, 14);

    }

    public void initializeCommandes() {
        CommandInfo.initializeBase(inv, 15);

    }

    public void initializeArgent() {
        CommandInfo.initializeBase(inv, 16);

    }

    public void openInventory(HumanEntity ent) {
        ent.openInventory(inv);
    }
}
