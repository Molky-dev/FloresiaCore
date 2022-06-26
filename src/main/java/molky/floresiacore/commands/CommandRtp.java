package molky.floresiacore.commands;

import molky.floresiacore.FloresiaCoreMain;
import molky.floresiacore.controller.FloresiaMessages;
import molky.floresiacore.controller.GuiController;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Random;

public class CommandRtp implements CommandExecutor {
    private Inventory inv;
    Player p;
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
        p = (Player) sender;

        inv = Bukkit.createInventory(null, 9, "§6Téléportation Aléatoire");

        initializeItems();
        openInventory(p);

        return false;
    }

    public void initializeItems() {
        for(int i = 0;i < 9; i++) {
            inv.setItem(i, GuiController.createGuiItem(Material.STAINED_GLASS_PANE, " ", 1));
        }
        inv.setItem(1, GuiController.createGuiItem(Material.WOOL, "§6Téléportation Proche", 5, "§6Téléporation entre §eX §6et §ex Blocs"));
        inv.setItem(4, GuiController.createGuiItem(Material.WOOL, "§6Téléportation Moyenne", 1, "§6Téléporation entre §eX §6et §ex Blocs"));
        inv.setItem(7, GuiController.createGuiItem(Material.WOOL, "§6Téléportation Lointaine", 14,"§6Téléporation entre §eX §6et §ex Blocs"));
    }

    public void openInventory(final HumanEntity ent) {
        ent.openInventory(inv);
    }


}
