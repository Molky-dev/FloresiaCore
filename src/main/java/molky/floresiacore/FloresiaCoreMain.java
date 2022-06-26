package molky.floresiacore;

import molky.floresiacore.controller.CommandManager;
import molky.floresiacore.controller.ListenerManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class FloresiaCoreMain extends JavaPlugin {
    private static FloresiaCoreMain instance;

    @Override
    public void onEnable() {
        instance = this;
        System.out.println("FloresiaCore ON");
        CommandManager.setup();
        ListenerManager.setup();

    }

    @Override
    public void onDisable() {

    }

    public static FloresiaCoreMain getInstance() {
        return instance;
    }

}
