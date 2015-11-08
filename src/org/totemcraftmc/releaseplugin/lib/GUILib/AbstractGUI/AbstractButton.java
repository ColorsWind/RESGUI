package org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.inventory.ItemStack;
import org.totemcraftmc.releaseplugin.lib.Utils.InventoryUtils;

public abstract class AbstractButton {

	protected final AbstractGUI owner;
	protected ItemStack item;
	public AbstractButton(AbstractGUI gui) {
		this.owner = gui;
	}
	
	public abstract InventoryInteractResponse onClick(InventoryAction action);
	
	public abstract void init();
	
	public abstract void refresh();
	
	protected ItemStack getItemStack(){
		return item;
	}
	
	protected void sendUpdatePacket(){
		int slot = owner.getSlotByButton(this);
		if(slot!=-1){
			Player p = getPlayer();
			if(p==null)return;
			InventoryUtils.sendSlotChange(getItemStack(), slot, p);
		}
	}
	
	protected Player getPlayer(){
		return owner.getPlayer();
	}
	
	protected AbstractGUI getOwnerGUI(){
		return owner;
	}
	
	
}
