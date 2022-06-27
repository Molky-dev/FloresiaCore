package molky.floresiacore.listener;

import molky.floresiacore.FloresiaCoreMain;
import molky.floresiacore.commands.CommandMenuSs;
import molky.floresiacore.controller.FloresiaMessages;
import molky.floresiacore.controller.GuiController;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Random;

public class InventoryListener implements Listener {
    private Inventory inv;
    private SkullMeta s;
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

        Player p = (Player) event.getWhoClicked();
        HashMap<String, Integer> i = new HashMap<>();
        ItemStack is = event.getCurrentItem();

        if (is != null && is.getType() == Material.SKULL_ITEM && event.getInventory().getName().equals("§6Modération")) {
            event.setCancelled(true);
            s = (SkullMeta) event.getCurrentItem().getItemMeta();
            inv = Bukkit.createInventory(null, 45, "§6Sanctionner §e" + getPlayer(s).getName());
            initializeItems(s);
            openInventory(p, inv);
        }
        if (is != null && event.getInventory().getName().startsWith("§6Sanctionner")) {
            event.setCancelled(true);
            if(is.getType().equals(Material.ARROW)) {
                Player kp = Bukkit.getPlayer(event.getInventory().getName().replace("§6Sanctionner §e" ,""));
                kp.kickPlayer("§6Tu as été exclu par : §e" + p.getName());
                p.sendMessage("§6Tu as exclus : §e" + kp.getName());
                p.closeInventory();
                Bukkit.broadcastMessage(FloresiaMessages.prefix + "§e" + kp.getName() + " §6a été exclu par §e" + p.getName());
            }

        }
        if (is != null && event.getInventory().getName().equals("§6Téléportation Aléatoire")) {

            event.setCancelled(true);
            Location defaultloc = p.getLocation();
            i.put(p.getName(), 6);
            if(is.getType().equals(Material.WOOL)) {
                Location teleportLocation;

                p.closeInventory();
                if(is.getItemMeta().getDisplayName() == "§6Téléportation Proche") {
                    teleportLocation = loc(-1000, 1000);
                    while (true) {
                        if (teleportLocation.getBlock().getType() == Material.LAVA || teleportLocation.getBlock().getType() == Material.AIR) {
                            teleportLocation = loc(-1000, 1000);
                        } else {
                            break;
                        }
                    }
                    Location finalTeleportLocation = teleportLocation;
                    (new BukkitRunnable() {
                        public void run() {
                            if(p.getLocation().getZ() == defaultloc.getZ() && p.getLocation().getX() == defaultloc.getX() && p.getLocation().getY() == defaultloc.getY()) {
                                i.put(p.getName(), i.get(p.getName()) - 1);
                                p.sendMessage(FloresiaMessages.prefix + "§6Téléportation dans §e" + i.get(p.getName()) + "§6 secondes. §6Ne bougez pas.");
                                if (i.get(p.getName()) == 0) {
                                    p.teleport(finalTeleportLocation);
                                    p.sendMessage(FloresiaMessages.prefix + "§6Tu as été téléporté aléatoirement.");
                                    this.cancel();

                                }
                            } else {
                                p.sendMessage(FloresiaMessages.prefix + "§6Tu as bougé, téléportation annulée.");
                                this.cancel();
                            }
                        }
                    }).runTaskTimer(FloresiaCoreMain.getInstance(), 0, 20);
                }
                if(is.getItemMeta().getDisplayName() == "§6Téléportation Moyenne") {
                    teleportLocation = loc(-7000, 7000);
                    while (true) {
                        if (teleportLocation.getBlock().getType() == Material.LAVA || teleportLocation.getBlock().getType() == Material.AIR) {
                            teleportLocation = loc(-7000, 7000);
                        } else {
                            break;
                        }
                    }
                    Location finalTeleportLocation1 = teleportLocation;
                    (new BukkitRunnable() {
                        public void run() {
                            if(p.getLocation().getZ() == defaultloc.getZ() && p.getLocation().getX() == defaultloc.getX() && p.getLocation().getY() == defaultloc.getY()) {
                                i.put(p.getName(), i.get(p.getName()) - 1);
                                p.sendMessage(FloresiaMessages.prefix + "§6Téléportation dans §e" + i.get(p.getName()) + "§6 secondes. §6Ne bougez pas.");
                                if (i.get(p.getName()) == 0) {
                                    p.teleport(finalTeleportLocation1);
                                    p.sendMessage(FloresiaMessages.prefix + "§6Tu as été téléporté aléatoirement.");
                                    this.cancel();

                                }
                            } else {
                                p.sendMessage(FloresiaMessages.prefix + "§6Tu as bougé, téléportation annulée.");
                                this.cancel();
                            }
                        }
                    }).runTaskTimer(FloresiaCoreMain.getInstance(), 0, 20);
                }
                if(is.getItemMeta().getDisplayName() == "§6Téléportation Lointaine")  {
                    teleportLocation = loc(-9000, 9000);
                    while (true) {
                        if (teleportLocation.getBlock().getType() == Material.LAVA || teleportLocation.getBlock().getType() == Material.AIR) {
                            teleportLocation = loc(-9000, 9000);

                        } else {
                            break;
                        }
                    }
                    Location finalTeleportLocation2 = teleportLocation;
                    (new BukkitRunnable() {
                        public void run() {
                            if(p.getLocation().getZ() == defaultloc.getZ() && p.getLocation().getX() == defaultloc.getX() && p.getLocation().getY() == defaultloc.getY()) {
                                i.put(p.getName(), i.get(p.getName()) - 1);
                                p.sendMessage(FloresiaMessages.prefix + "§6Téléportation dans §e" + i.get(p.getName()) + "§6 secondes. §6Ne bougez pas.");
                                if (i.get(p.getName()) == 0) {
                                    p.teleport(finalTeleportLocation2);
                                    p.sendMessage(FloresiaMessages.prefix + "§6Tu as été téléporté aléatoirement.");
                                    this.cancel();

                                }
                            } else {
                                p.sendMessage(FloresiaMessages.prefix + "§6Tu as bougé, téléportation annulée.");
                                this.cancel();
                            }
                        }
                    }).runTaskTimer(FloresiaCoreMain.getInstance(), 0, 20);
                }
            }
        }

    }

    final Location loc(int l, int h) {
        int max = h;
        int min = l;
        int x = (new Random().nextInt((max - min) + 1) + min);
        int z = (new Random().nextInt((max - min) + 1) + min);
        Location targetLocation = new Location(Bukkit.getWorld("world"), x, 0.0D, z);
        targetLocation.setY(Bukkit.getWorld("world").getHighestBlockYAt(targetLocation));
        return targetLocation;
    }
    public void initializeItems(SkullMeta s) {
        inv.setItem(4, CommandMenuSs.getHead(getPlayer(s)));
        for (int i = 9; i <= 17; i++) {
            inv.setItem(i, GuiController.createGuiItem(Material.STAINED_GLASS_PANE, "", ""));

        }
        inv.setItem(28, GuiController.createGuiItem(Material.IRON_BARDING, "§eJail", "§6Cliquez pour Jail : §e" + s.getOwner()));
        inv.setItem(30, GuiController.createGuiItem(Material.ARROW, "§eKick", "§6Cliquez pour Kick : §e" + s.getOwner()));
        inv.setItem(32, GuiController.createGuiItem(Material.DIAMOND_SWORD, "§eBan", "§6Cliquez pour Ban : §e" + s.getOwner()));
        inv.setItem(34, GuiController.createGuiItem(Material.STRING, "§eMute", "§6Cliquez pour Mute : §e" + s.getOwner()));
    }

    public void initializeItemsBan() {
        inv.setItem(4, CommandMenuSs.getHead(getPlayer(s)));
        for (int i = 9; i <= 17; i++) {
            inv.setItem(i, GuiController.createGuiItem(Material.STAINED_GLASS_PANE, "", ""));

        }
    }

    public void openInventory(final HumanEntity ent, final Inventory inv) {
        ent.openInventory(inv);
    }

    public String getOwner(SkullMeta s) {
        return s.getOwner();
    }

    public Player getPlayer(SkullMeta s) {
        Player p = Bukkit.getPlayer(s.getOwner());
        return p;
    }
}
