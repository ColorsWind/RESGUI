package org.totemcraftmc.releaseplugin.RESGUI;

import org.bukkit.plugin.java.JavaPlugin;
import org.totemcraftmc.releaseplugin.RESGUI.Commands.ResBorderCommand;
import org.totemcraftmc.releaseplugin.RESGUI.Commands.ResguiCommand;
import org.totemcraftmc.releaseplugin.RESGUI.Commands.ResguiadminCommand;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.GUIListener;
import org.totemcraftmc.releaseplugin.lib.GUILib.ChatHook.ChatHookManager;

public class RESGUI extends JavaPlugin {
	
	public static RESGUI instance;
	
	@Override
	public void onEnable() {
		instance = this;
		getLogger().info("本插件来自Totemcraft: http://www.totemcraftmc.org");
		
		GUIListener.register(this);
		ChatHookManager.register(this);
		
		new ResBorderCommand().register(this);
		new ResguiadminCommand().register(this);
		new ResguiCommand().register(this);
		
	}

}
