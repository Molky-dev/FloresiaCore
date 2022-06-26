package molky.floresiacore.controller;

import molky.floresiacore.FloresiaCoreMain;
import molky.floresiacore.listener.InventoryListener;
import molky.floresiacore.listener.MessageListener;
import molky.floresiacore.listener.PlaceBlockListener;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class ListenerManager {
    private final static FloresiaCoreMain pl = FloresiaCoreMain.getInstance();

    public static void setup() {
        registerEvent(new InventoryListener());
        registerEvent(new MessageListener());
        registerEvent(new PlaceBlockListener());

    }

    private static void registerEvent(Listener listener) {
        pl.getServer().getPluginManager().registerEvents(listener, pl);
    }

}