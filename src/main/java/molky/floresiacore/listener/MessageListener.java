package molky.floresiacore.listener;

import molky.floresiacore.controller.EnchantByName;
import molky.floresiacore.controller.GuiController;
import molky.floresiacore.controller.IntegerToRoman;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.apache.commons.lang.WordUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.ItemStack;



public class MessageListener implements Listener {

    @EventHandler
    public void onMessage(AsyncPlayerChatEvent event) {
        for(Player p : Bukkit.getOnlinePlayers()) {
            if(event.getMessage().contains(p.getName())) {
                event.setMessage(event.getMessage().replace(p.getName(), "§6" + p.getName() + "§r"));
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 100, 1);
            }
        }

        if(event.getMessage().contains("[i]")) {
            event.setCancelled(true);
            ItemStack is = event.getPlayer().getItemInHand();
            String name;
            if(is.hasItemMeta()) {
                StringBuilder sb = new StringBuilder();
                if(is.getItemMeta().hasDisplayName()) {
                    name = is.getItemMeta().getDisplayName();
                } else {
                    name = WordUtils.capitalize(is.getType().toString().replace("_", " ").toLowerCase());

                }
                sb.append(name).append(" §f(#").append(is.getTypeId()).append(")").append("\n");

                if(is.getItemMeta().hasEnchants()) {
                    for (Enchantment encht : is.getItemMeta().getEnchants().keySet()) {
                        int i = is.getEnchantmentLevel(encht);
                        sb.append("§7").append(EnchantByName.enchantmentName(encht.getName())).append(" ").append(IntegerToRoman.intToRoman(i)).append("\n");
                    }
                }
                if(is.getItemMeta().hasLore()) {
                    for (String lore : is.getItemMeta().getLore()) {
                        sb.append(lore).append("\n");
                    }
                }

                if(EnchantByName.getSwordInt(is.getType()) != 0 && is.getEnchantments().containsKey(Enchantment.DAMAGE_ALL)) {
                    if(is.getEnchantmentLevel(Enchantment.DAMAGE_ALL) > 0) {
                        sb.append("\n").append("§9+").append(String.valueOf(1.25 * is.getEnchantmentLevel(Enchantment.DAMAGE_ALL) + EnchantByName.getSwordInt(is.getType())).replace(".0", "")).append(" ").append("Attack Damage");
                    } else {
                        sb.append("\n").append("§c").append(String.valueOf(1.25 * is.getEnchantmentLevel(Enchantment.DAMAGE_ALL) + EnchantByName.getSwordInt(is.getType())).replace(".0", "")).append(" ").append("Attack Damage");

                    }
                }
                sb.append("\n§8minecraft:").append(is.getType().toString().toLowerCase());

                TextComponent message = new TextComponent("§7(" + name + "§7)");


                message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(sb.toString()).create()));
                for(Player p  : Bukkit.getOnlinePlayers()) {
                    TextComponent pseudo = new TextComponent(event.getPlayer().getDisplayName() + "§8➤ §r" + event.getMessage().replace("[i]", "") + " ");
                    pseudo.addExtra(message);
                    p.spigot().sendMessage(pseudo);
                }
                event.setMessage(event.getMessage().replace("[i]", ""));
            }
        }

        if(event.getMessage().contains("test de pd")) {
            ItemStack is = GuiController.createGuiItem(Material.OBSIDIAN, "§6Légende de l'obsidienne", "§6CETTE OBSIDIENNE VIENS DE LOIN", "§eLa légende raconte qu'elle crée une colonne", "§4En OBSIDIENNE");
            event.getPlayer().getInventory().addItem(is);
        }
     }
}
