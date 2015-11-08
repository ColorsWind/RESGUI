package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI;

import java.lang.reflect.Field;
import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

import org.totemcraftmc.releaseplugin.RESGUI.Util;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.InventoryInteractResponse;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.InventoryInteractResponse.Type;

public class SettpButton extends AbstractButton {

	private final ClaimedResidence res;

	public SettpButton(AbstractGUI gui, ClaimedResidence res) {
		super(gui);
		this.res = res;
	}

	@Override
	public InventoryInteractResponse onClick(InventoryAction action) {

		if (action.equals(InventoryAction.PICKUP_ALL)) {

			if(Util.setTpLoc(res, getPlayer().getLocation()) == 0){
				getPlayer().sendMessage(ChatColor.RED+"你所在的位置不在改领地之内");
				return new InventoryInteractResponse(Type.Close, null);
			}

			return new InventoryInteractResponse(Type.RefreshButton, null);
		} else if (action.equals(InventoryAction.DROP_ONE_SLOT)) {
			Util.setTpLoc(res, null);
			return new InventoryInteractResponse(Type.RefreshButton, null);
		}

		return new InventoryInteractResponse(Type.DoNothing, null);

	}

	@Override
	public void init() {
		item = new ItemStack(Material.ENDER_PORTAL_FRAME);

	}

	@Override
	public void refresh() {
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.GREEN + "设置领地传送点");

		Location tploc = null;
		try {
			Field f = ClaimedResidence.class.getDeclaredField("tpLoc");
			f.setAccessible(true);
			tploc = (Location) f.get(res);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ArrayList<String> list = new ArrayList<String>();
		if (tploc == null) {
			list.add(ChatColor.RED + "现在没有设置传送点，将传送到领地周围");
		} else {
			String loc = tploc.getBlockX() + "," + tploc.getBlockY() + "," + tploc.getBlockZ();
			list.add(ChatColor.GOLD + "当前传送点: " + loc);
			list.add(ChatColor.WHITE + "" + ChatColor.UNDERLINE + "按Q来清除已经设置的传送点");
		}

		meta.setLore(list);
		item.setItemMeta(meta);
	}

}