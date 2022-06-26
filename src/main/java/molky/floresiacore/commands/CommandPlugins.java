package molky.floresiacore.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class CommandPlugins implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Plugin[] list = Bukkit.getServer().getPluginManager().getPlugins();
        StringBuilder plug = new StringBuilder();
        plug.append("§cPlugins §7(§e").append(list.length).append("§7)§c:");

        for(Plugin pl : list) {
            if (pl.getName().startsWith("Floresia")) {
                plug.append(" §6").append(pl.getName()).append("§f,");
            } else {
                plug.append(" §e").append(pl.getName()).append("§f,");
            }
        }
        if(sender instanceof Player) {
            Player p = (Player) sender;
            p.sendMessage(plug.toString());
        } else {
            System.out.println(plug);
        }
        return false;
    }
}