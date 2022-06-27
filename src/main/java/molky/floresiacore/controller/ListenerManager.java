package molky.floresiacore.controller;

import molky.floresiacore.FloresiaCoreMain;
import molky.floresiacore.listener.*;
import org.bukkit.event.Listener;

public class ListenerManager {
    private final static FloresiaCoreMain pl = FloresiaCoreMain.getInstance();

    public static void setup() {
        registerEvent(new InventoryListener());
        registerEvent(new MessageListener());
        registerEvent(new PlaceBlockListener());
        registerEvent(new InventoryShopListener());
        registerEvent(new PlayerJoinListener());
        registerEvent(new InventoryInfoListener());
        registerEvent(new InventoryBoutiqueListener());
    }

    private static void registerEvent(Listener listener) {
        pl.getServer().getPluginManager().registerEvents(listener, pl);
    }

}