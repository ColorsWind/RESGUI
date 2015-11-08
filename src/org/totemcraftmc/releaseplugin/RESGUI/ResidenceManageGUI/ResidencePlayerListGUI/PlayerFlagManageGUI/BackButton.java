package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.ResidencePlayerListGUI.PlayerFlagManageGUI;

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

public class BackButton extends AbstractButton {

	final ClaimedResidence res;
	public BackButton(AbstractGUI gui, ClaimedResidence res) {
		super(gui);
		this.res = res;
	}

	@Override
	public InventoryInteractResponse onClick(InventoryAction action) {
		if(action == InventoryAction.PICKUP_ALL){
			return new InventoryInteractResponse(Type.OpenAnother, new ResidencePlayerListGUI(getPlayer(), res));
		}
		
		return new InventoryInteractResponse(Type.DoNothing, null);
	}

	@Override
	public void init() {
		item = new ItemStack(Material.STAINED_GLASS_PANE);
		item.setDurability((short) 4);
		
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.GOLD+"返回上一级菜单");
		
		item.setItemMeta(meta);

	}

	@Override
	public void refresh() {
		return;
	}

}
