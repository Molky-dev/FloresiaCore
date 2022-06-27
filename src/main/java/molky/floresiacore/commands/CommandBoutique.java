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

public class CommandBoutique implements CommandExecutor {
    private static Player p;
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {

        p = (Player) sender;

        openInventory(p);

        return false;
    }

    public static void initializeBase(Inventory inv) {
        int[] redstainedglass = {10, 12, 14, 16, 18, 26, 28, 30, 32, 34};
        int[] orangestainedglass = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 17, 27, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44};
        inv.setItem(4, GuiController.getHead(p,"§e" + FloresiaMessages.etoile + " §dLe shop te permets de d'acheter et revendre §e" + FloresiaMessages.etoile, "§e" + FloresiaMessages.etoile + " §6Essaies d'avoir la plus grande §afortune §6de §cFloresia " + "§e" + FloresiaMessages.etoile));
        for(Integer i : orangestainedglass) {
            inv.setItem(i, GuiController.createGuiItem(Material.STAINED_GLASS_PANE, "§e" + FloresiaMessages.etoile + " " + "§6Floresia Boutique" + " " + "§e" + FloresiaMessages.etoile, 1));
        }
        for(Integer i : redstainedglass) {
            inv.setItem(i, GuiController.createGuiItem(Material.STAINED_GLASS_PANE, "§e" + FloresiaMessages.etoile + " " + "§6Floresia Boutique" + " " + "§e" + FloresiaMessages.etoile, 14));
        }
    }

    public static void initializeItems(Inventory inv) {
        initializeBase(inv);
        inv.setItem(11, GuiController.createGuiItem(Material.WOOD_SWORD, "§7Paysan"));
        inv.setItem(13, GuiController.createGuiItem(Material.IRON_SWORD, "§2Hatamoto"));
        inv.setItem(15, GuiController.createGuiItem(Material.DIAMOND_SWORD, "§4Bushi"));
        inv.setItem(29, GuiController.createGuiItem(Material.STONE_SWORD, "§bArtisan"));
        inv.setItem(31, GuiController.createGuiItem(Material.GOLD_SWORD, "§5Samouraï"));
        inv.setItem(33, GuiController.createGuiItem(Material.BOW, "§eFlor§6esien"));
    }

    public static void openInventory(HumanEntity ent) {
        Inventory inv = Bukkit.createInventory(null, 9 * 5, "§cBoutique");
        initializeItems(inv);
        ent.openInventory(inv);
    }
}
