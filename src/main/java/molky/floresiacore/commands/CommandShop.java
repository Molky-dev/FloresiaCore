package molky.floresiacore.commands;

import molky.floresiacore.controller.FloresiaMessages;
import molky.floresiacore.controller.GuiController;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class CommandShop implements CommandExecutor {
    private static Player p;
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {

        p = (Player) sender;

        openInventory(p);

        return false;
    }

    public static void initializeBase(Inventory inv) {
        int[] redstainedglass = {0, 8, 37, 43, 45, 53};
        int[] orangestainedglass = {1, 3, 5, 7, 9, 17, 27, 35, 36, 44, 46, 47, 51, 52};
        inv.setItem(4, GuiController.getHead(p,"§e" + FloresiaMessages.etoile + " §dLe shop te permets de d'acheter et revendre §e" + FloresiaMessages.etoile, "§e" + FloresiaMessages.etoile + " §6Essaies d'avoir la plus grande §afortune §6de §cFloresia " + "§e" + FloresiaMessages.etoile));
        for(Integer i : orangestainedglass) {
            inv.setItem(i, GuiController.createGuiItem(Material.STAINED_GLASS_PANE, "§e" + FloresiaMessages.etoile + " " + "§6Floresia Shop" + " " + "§e" + FloresiaMessages.etoile, 1));
        }
        for(Integer i : redstainedglass) {
            inv.setItem(i, GuiController.createGuiItem(Material.STAINED_GLASS_PANE, "§e" + FloresiaMessages.etoile + " " + "§6Floresia Shop" + " " + "§e" + FloresiaMessages.etoile, 14));
        }
    }

    public static void initializeItems(Inventory inv) {

        initializeBase(inv);
        inv.setItem(10, GuiController.createGuiItem(Material.COOKED_BEEF, "§5Divers"));
        inv.setItem(16, GuiController.createGuiItem(Material.POTION, "§3Potions"));
        inv.setItem(21, GuiController.createGuiItem(Material.DIAMOND_ORE, "§eMinerais"));
        inv.setItem(23, GuiController.createGuiItem(Material.GRASS, "§4Blocs"));
        inv.setItem(28, GuiController.createGuiItem(Material.COOKED_FISH, "§8Cultures §fet §7Loots"));
        inv.setItem(31, GuiController.createGuiItem(Material.TNT, "§4Pillages"));
        inv.setItem(34, GuiController.createGuiItem(Material.BREWING_STAND_ITEM, "§bAlchimie"));
        inv.setItem(48, GuiController.createGuiItem(Material.MOB_SPAWNER, "§9Spawners"));
        inv.setItem(49, GuiController.createGuiItem(Material.DIAMOND_CHESTPLATE, "§aKits"));
        inv.setItem(50, GuiController.createGuiItem(Material.DIAMOND_SWORD, "§bGrades"));
    }

    public static void openInventory(HumanEntity ent) {
        Inventory inv = Bukkit.createInventory(null, 9 * 6, "§6Shop");
        initializeItems(inv);
        ent.openInventory(inv);
    }
}



