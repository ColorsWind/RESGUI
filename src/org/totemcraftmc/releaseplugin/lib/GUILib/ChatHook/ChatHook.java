package org.totemcraftmc.releaseplugin.lib.GUILib.ChatHook;

import java.lang.ref.WeakReference;

import org.bukkit.entity.Player;

public abstract class ChatHook {

	private final WeakReference<Player> player;
	private int life = 15;
	public ChatHook(Player p) {
		player = new WeakReference<Player>(p);
	}
	
	public abstract void recieve(String str);
	
	public final Player getPlayer(){
		if(player.isEnqueued()){
			return null;
		}
		return player.get();
	}
	
	public int getLife(){
		return life;
	}
	
	public void reduceLife(){
		life--;
	}
	
}
