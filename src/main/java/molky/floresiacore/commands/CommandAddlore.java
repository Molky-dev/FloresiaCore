package molky.floresiacore.commands;

import molky.floresiacore.controller.FloresiaMessages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class CommandAddlore implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 0) {
                p.sendMessage(FloresiaMessages.prefix + "§6La commandes est : §e/addlore §6<§eLORE§6>");
            } else {
                ItemMeta im = p.getItemInHand().getItemMeta();
                StringBuilder sb = new StringBuilder();
                for (String str : args) {
                    sb.append(str.replace("&", "§")).append(" ");
                }
                if(im.getLore() == null) {
                    ArrayList<String> lore = new ArrayList<String>();
                    lore.add(sb.toString());
                    im.setLore(lore);

                } else {
                    ArrayList<String> lore = new ArrayList<String>();
                    lore.addAll(im.getLore());
                    lore.add(sb.toString());
                    im.setLore(lore);
                }
                p.getItemInHand().setItemMeta(im);
                p.sendMessage(FloresiaMessages.prefix + "§6La lore ajoutée à ton item est: " + sb.toString());

            }
        }

        return false;
    }
}
