package molky.floresiacore.controller;

import molky.floresiacore.FloresiaCoreMain;
import molky.floresiacore.commands.*;
import org.bukkit.command.CommandExecutor;

public class CommandManager {
    private final static FloresiaCoreMain pl = FloresiaCoreMain.getInstance();

    public static void setup() {
        registerCommand("addlore", new CommandAddlore());
        registerCommand("ss", new CommandMenuSs());
        registerCommand("rename", new CommandRename());
        registerCommand("rtp", new CommandRtp());
        registerCommand("plugins", new CommandPlugins());

    }

    private static void registerCommand(String command, Object commandClass) {
        pl.getCommand(command).setExecutor((CommandExecutor) commandClass);
    }
}
