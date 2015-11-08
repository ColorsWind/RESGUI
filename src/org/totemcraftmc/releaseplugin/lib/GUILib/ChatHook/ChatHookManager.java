package org.totemcraftmc.releaseplugin.lib.GUILib.ChatHook;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.totemcraftmc.releaseplugin.lib.GUILib.ChatHook.ChatHook;
import org.totemcraftmc.releaseplugin.lib.GUILib.ChatHook.ChatHookManager;

public class ChatHookManager implements Listener{
	
	private static WeakHashMap<Player,ChatHook> hooks = new WeakHashMap<Player,ChatHook>();
	private static Timer timer = new Timer();
	
	private static JavaPlugin plugin;
	public static void register(JavaPlugin plugin){
		ChatHookManager.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(new ChatHookManager(), plugin);
	}
	
	public static void registerHook(ChatHook hook){
		hooks.put(hook.getPlayer(), hook);
	}
	
	public static void startTimer(){
		new Thread(timer).start();;
	}
	
	public static void stopTimer(){
		timer.run = false;
	}
	
	private static class Timer implements Runnable{
		
		boolean run = true;

		@Override
		public void run() {
			
			while(run){
				
				Iterator<Entry<Player,ChatHook>> ite = hooks.entrySet().iterator();
				while(ite.hasNext()){
					Entry<Player, ChatHook> e = ite.next();
					
					if(e.getValue().getLife()<=0){
						ite.remove();
						continue;
					}
					
					e.getValue().reduceLife();
					
				}
				
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	@EventHandler(priority=EventPriority.LOW)
	void onChat(AsyncPlayerChatEvent e){
				
		final ChatHook hook = hooks.get(e.getPlayer());
		if(hook==null){
			return;
		}
		
		
		hooks.remove(e.getPlayer());
		
		e.setCancelled(true);
		
		final String msg = e.getMessage();
		Bukkit.getScheduler().runTask(plugin, new Runnable() {
			
			@Override
			public void run() {
				hook.recieve(msg);
			}
			
		});
	}
	
	
}
