package molky.floresiacore.commands;

import molky.floresiacore.controller.FloresiaMessages;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;

public class CommandRename implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if (p.getItemInHand().getType() == Material.AIR) {
                p.sendMessage("§6Floresia §e>> §6Tu n'as pas d'item dans les mains.");
            } else {
                if (args.length == 0) {
                    p.sendMessage("§6Floresia §e>> §6La commandes est : §e/rename §6<§eNOM§6>");
                } else {
                    ItemMeta im = p.getItemInHand().getItemMeta();
                    StringBuilder sb = new StringBuilder();
                    for (String str : args) {
                        sb.append(str.replace("&", "§")).append(" ");
                    }

                    im.setDisplayName(sb.toString());

                    p.getItemInHand().setItemMeta(im);
                    p.sendMessage(FloresiaMessages.prefix + "§6Ton item a été renommé en: " + sb.toString());
                }
            }
        }



        return false;
    }
}
