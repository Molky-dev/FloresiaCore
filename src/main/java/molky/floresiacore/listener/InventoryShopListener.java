package molky.floresiacore.listener;

import molky.floresiacore.commands.CommandShop;
import molky.floresiacore.controller.GuiController;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


public class InventoryShopListener implements Listener {
    private Inventory inv;

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player p = (Player) event.getWhoClicked();
        ItemStack is = event.getCurrentItem();

        if(is != null) {
            if(is.getItemMeta().getDisplayName().equals("§cRetour") && is.getType().equals(Material.DARK_OAK_DOOR_ITEM)) {
                event.setCancelled(true);
                inv = Bukkit.createInventory(null, 9 * 6, "§6Shop");
                CommandShop.openInventory(p);

            }
            if (event.getInventory().getName().equals("§6Shop")) {
                event.setCancelled(true);
                if(is.getItemMeta().getDisplayName().equals("§5Divers")) {
                    event.setCancelled(true);
                    inv = Bukkit.createInventory(null, 9 * 6, is.getItemMeta().getDisplayName());
                    initializeItemDivers();
                    openInventory(p);
                }
                if(is.getItemMeta().getDisplayName().equals("§eMinerais")) {
                    event.setCancelled(true);
                    inv = Bukkit.createInventory(null, 9 * 6, is.getItemMeta().getDisplayName());
                    initializeItemMinerais();
                    openInventory(p);
                }
                if(is.getItemMeta().getDisplayName().equals("§3Potions")) {
                    event.setCancelled(true);
                    inv = Bukkit.createInventory(null, 9 * 6, is.getItemMeta().getDisplayName());
                    initializeItemPotions();
                    openInventory(p);
                }
                if(is.getItemMeta().getDisplayName().equals("§8Cultures §fet §7Loots")) {
                    event.setCancelled(true);
                    inv = Bukkit.createInventory(null, 9 * 6, is.getItemMeta().getDisplayName());
                    initializeItemCulture();
                    openInventory(p);
                }
                if(is.getItemMeta().getDisplayName().equals("§4Pillages")) {
                    event.setCancelled(true);
                    inv = Bukkit.createInventory(null, 9 * 6, is.getItemMeta().getDisplayName());
                    initializeItemPillages();
                    openInventory(p);
                }
                if(is.getItemMeta().getDisplayName().equals("§4Blocs")) {
                    event.setCancelled(true);
                    inv = Bukkit.createInventory(null, 9 * 6, is.getItemMeta().getDisplayName());
                    initializeItemBlocs();
                    openInventory(p);
                }
                if(is.getItemMeta().getDisplayName().equals("§bAlchimie")) {
                    event.setCancelled(true);
                    inv = Bukkit.createInventory(null, 9 * 6, is.getItemMeta().getDisplayName());
                    initializeItemAlchimie();
                    openInventory(p);
                }
                if(is.getItemMeta().getDisplayName().equals("§9Spawners")) {
                    event.setCancelled(true);
                    inv = Bukkit.createInventory(null, 9 * 6, is.getItemMeta().getDisplayName());
                    initializeVitrespawners();
                    openInventory(p);
                }
                if(is.getItemMeta().getDisplayName().equals("§aKits")) {
                    event.setCancelled(true);
                    inv = Bukkit.createInventory(null, 9 * 6, is.getItemMeta().getDisplayName());
                    initializeItemKits();
                    openInventory(p);
                }
                if(is.getItemMeta().getDisplayName().equals("§bGrades")) {
                    event.setCancelled(true);
                    inv = Bukkit.createInventory(null, 9 * 6, is.getItemMeta().getDisplayName());
                    initializeItemGrades();
                    openInventory(p);
                }
            }


        }
    }

    private void initializeItemCulture() {
        CommandShop.initializeBase(inv);
        inv.setItem(49, GuiController.createGuiItem(Material.DARK_OAK_DOOR_ITEM, "§cRetour"));
    }

    private void initializeItemPotions() {
        CommandShop.initializeBase(inv);
        inv.setItem(49, GuiController.createGuiItem(Material.DARK_OAK_DOOR_ITEM, "§cRetour"));
    }

    private void initializeItemMinerais() {
        CommandShop.initializeBase(inv);
        inv.setItem(49, GuiController.createGuiItem(Material.DARK_OAK_DOOR_ITEM, "§cRetour"));
    }

    private void initializeItemPillages() {
        CommandShop.initializeBase(inv);
        inv.setItem(49, GuiController.createGuiItem(Material.DARK_OAK_DOOR_ITEM, "§cRetour"));
    }

    private void initializeItemBlocs() {
        CommandShop.initializeBase(inv);
        inv.setItem(49, GuiController.createGuiItem(Material.DARK_OAK_DOOR_ITEM, "§cRetour"));
    }

    private void initializeItemAlchimie() {
        CommandShop.initializeBase(inv);
        inv.setItem(49, GuiController.createGuiItem(Material.DARK_OAK_DOOR_ITEM, "§cRetour"));
    }

    private void initializeVitrespawners() {
        CommandShop.initializeBase(inv);
        inv.setItem(49, GuiController.createGuiItem(Material.DARK_OAK_DOOR_ITEM, "§cRetour"));
    }

    private void initializeItemGrades() {
        CommandShop.initializeBase(inv);
        inv.setItem(49, GuiController.createGuiItem(Material.DARK_OAK_DOOR_ITEM, "§cRetour"));
    }

    private void initializeItemKits() {
        CommandShop.initializeBase(inv);
        inv.setItem(49, GuiController.createGuiItem(Material.DARK_OAK_DOOR_ITEM, "§cRetour"));
    }

    public void initializeItemDivers() {
        CommandShop.initializeBase(inv);
        inv.setItem(49, GuiController.createGuiItem(Material.DARK_OAK_DOOR_ITEM, "§cRetour"));

    }

    public void openInventory(HumanEntity ent) {
        ent.openInventory(inv);
    }

}
