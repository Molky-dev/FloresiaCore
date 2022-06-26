package molky.floresiacore.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

public class CommandMenuSs implements CommandExecutor {
    private Inventory inv;
    private int i;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
        i = 0;
        HumanEntity p = (Player) sender;
        inv = Bukkit.createInventory(null, 27, "§6Modération");

        initializeItems();
        openInventory(p);
        return false;
    }

    public static ItemStack getHead(Player player) {
        int lifePlayer = (int) player.getHealth();
        ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta skull = (SkullMeta) item.getItemMeta();
        skull.setDisplayName(player.getDisplayName());
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§6Rang: §8" + player.getDisplayName().replace(player.getName(), "").replace("[", "").replace("]", ""));
        lore.add("§6Pseudo: §e" + player.getName());
        skull.setLore(lore);
        skull.setOwner(player.getName());
        item.setItemMeta(skull);
        return item;
    }
    public void initializeItems() {
        for(Player p : Bukkit.getOnlinePlayers()) {
            inv.setItem(i, getHead(p));
            i++;
        }
    }

    public void openInventory(final HumanEntity ent) {
        ent.openInventory(inv);
    }
}
