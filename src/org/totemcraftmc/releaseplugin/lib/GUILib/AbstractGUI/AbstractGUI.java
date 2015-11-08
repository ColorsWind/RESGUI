package org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.totemcraftmc.releaseplugin.lib.Utils.FormatUtil;

public abstract class AbstractGUI implements InventoryHolder{
	
	private WeakReference<Player> player;
	private HashMap<Integer,AbstractButton> buttons = new HashMap<Integer, AbstractButton>();
	private Inventory inv;
	
	private boolean inited = false;
	
	public AbstractGUI(Player p) {
		player = new WeakReference<Player>(p);
	}
	
	public abstract void onClose();
	
	public InventoryInteractResponse onClickBottomInv(int slot){
		return null;
	}
	
	public abstract String getTitle();
	
	protected void registerButton(AbstractButton button,int slot){
		buttons.put(slot, button);
	}
	
	protected void registerButton(AbstractButton button,int x,int y){
		int slot = x+y*9;
		registerButton(button, slot);
	}
	
	protected void init(){
		int max = 0;
		
		for(Integer i : buttons.keySet()){
			if(i>max){
				max=i;
			}
		}
		
		int row = max/9+1;
		
		inv = Bukkit.createInventory(this, row*9, FormatUtil.trimString(getTitle(), 32));
		
		for(Entry<Integer,AbstractButton> en : buttons.entrySet()){
			
			en.getValue().init();
			en.getValue().refresh();
			inv.setItem(en.getKey(), en.getValue().getItemStack());
			
		}
		inited = true;
	}
	
	public void open(){
		if(!player.isEnqueued()){
			
			if(!inited)init();
			player.get().openInventory(inv);
			
		}
	}
	
	public int getSlotByButton(AbstractButton button){
		
		for(Entry<Integer,AbstractButton> en : buttons.entrySet()){
			if(en.getValue().equals(button)){
				return en.getKey();
			}
		}
		
		return -1;
	}
	
	public AbstractButton getButtonBySlot(int slot){
		return buttons.get(slot);
	}
	
	public Player getPlayer(){
		if(!player.isEnqueued()){
			return player.get();
		}
		return null;
	}
	
	public Inventory getInventory(){
		return inv;
	}
}
