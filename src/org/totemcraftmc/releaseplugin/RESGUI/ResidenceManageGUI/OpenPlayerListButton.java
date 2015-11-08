package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.ResidencePlayerListGUI.ResidencePlayerListGUI;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.InventoryInteractResponse;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.InventoryInteractResponse.Type;

public class OpenPlayerListButton extends AbstractButton {

	final ClaimedResidence res;
	public OpenPlayerListButton(AbstractGUI gui,ClaimedResidence res) {
		super(gui);
		this.res = res;
	}

	@Override
	public InventoryInteractResponse onClick(InventoryAction action) {
		if(!action.equals(InventoryAction.PICKUP_ALL)){
			return new InventoryInteractResponse(Type.DoNothing, null);
		}
		
		return new InventoryInteractResponse(Type.OpenAnother, new ResidencePlayerListGUI(getPlayer(), res));
	}

	@Override
	public void init() {
		item = new ItemStack(Material.SKULL_ITEM);
		item.setDurability((short) 3);
		
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.GREEN+"单独管理指定玩家的权限");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GOLD+"点击来对指定玩家的权限进行管理");
		lore.add(ChatColor.RED+"这里的设置将无视领地的全局设置");
		meta.setLore(lore);
		
		item.setItemMeta(meta);
	}

	@Override
	public void refresh() {
		return;
	}

}
