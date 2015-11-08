package org.totemcraftmc.releaseplugin.lib.CommandLib;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class RootCommand extends AbstractCommandExecutor implements
		CommandExecutor {

	public RootCommand(String key, boolean consoleRun, boolean playerRun) {
		super(key, null, consoleRun, playerRun);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		
		return call(sender, label, args);

	}

	public void register(JavaPlugin plugin) {
		PluginCommand c = plugin.getCommand(key);
		if(c==null){
			plugin.getLogger().severe(key+"ÉÐÎ´ÔÚplugin.ymlÖÐÉùÃ÷");
			return;
		}
		c.setExecutor(this);
		c.setAliases(getAlias());
	}

}