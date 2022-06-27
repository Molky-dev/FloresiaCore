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

public class CommandInfo implements CommandExecutor {

    private static Inventory inv;
    private static Player p;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
         p = (Player) sender;


         openInventory(p);

        return false;
    }

    public static void initializeBase(Inventory inv, int in) {
        int[] redstainedglass = {0, 4, 8, 9, 10, 11, 12, 14, 15, 16, 17 , 22};
        int[] orangestainedglass = {in};
        inv.setItem(13, GuiController.getHead(p,"§e" + FloresiaMessages.etoile + " §dLe informations t'aident à comprendre Floresia §e" + FloresiaMessages.etoile));
        for(Integer i : redstainedglass) {
            inv.setItem(i, GuiController.createGuiItem(Material.STAINED_GLASS_PANE, "§e" + FloresiaMessages.etoile + " " + "§6Floresia Infos" + " " + "§e" + FloresiaMessages.etoile, 14));
        }
        for(Integer i : orangestainedglass) {
            inv.setItem(i, GuiController.createGuiItem(Material.STAINED_GLASS_PANE, "§e" + FloresiaMessages.etoile + " " + "§6Floresia Infos" + " " + "§e" + FloresiaMessages.etoile, 1));
        }
        inv.setItem(1, GuiController.createGuiItem(Material.GRASS, "§aMondes", "§e" +  FloresiaMessages.etoile + " " + "§6Obtiens des informations sur les mondes." + " §e" +  FloresiaMessages.etoile));
        inv.setItem(2, GuiController.createGuiItem(Material.BOOK_AND_QUILL, "§fRéglement", "§e" +  FloresiaMessages.etoile + " " + "§6Tiens toi au courrant de nos règles." + " §e" +  FloresiaMessages.etoile));
        inv.setItem(3, GuiController.createGuiItem(Material.GOLDEN_APPLE, "§cObjets désactivé", 1, "§e" +  FloresiaMessages.etoile + " " + "§6Liste des objet désactivé."+ " §e" +  FloresiaMessages.etoile));
        inv.setItem(5, GuiController.createGuiItem(Material.NAME_TAG, "§bLiens important",  "§e" +  FloresiaMessages.etoile + " " + "§6Rejoins nous sur nos différant résaux."+ " §e" +  FloresiaMessages.etoile));
        inv.setItem(6, GuiController.createGuiItem(Material.REDSTONE_TORCH_ON, "§dCommandes",  "§e" +  FloresiaMessages.etoile + " " + "§6Voici les commandes principale."+ " §e" +  FloresiaMessages.etoile));
        inv.setItem(7, GuiController.createGuiItem(Material.GOLD_BLOCK, "§eGagner de l'argent", "§e" +  FloresiaMessages.etoile + " " + "§6Voici comment gagner de l'argent."+ " §e" +  FloresiaMessages.etoile));

    }

    public static void initializeItems(Inventory inv) {
        initializeBase(inv, 10);

    }

    public static void openInventory(HumanEntity ent) {
        inv = Bukkit.createInventory(null, 9 * 5, "§cInformations §4• (§c1§4/§c6§4)");
        initializeItems(inv);
        ent.openInventory(inv);
    }

}
