package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.SubZoneListGUI;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.InventoryInteractResponse;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.InventoryInteractResponse.Type;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class SubZoneButton extends AbstractButton {

	private final ClaimedResidence res;

	public SubZoneButton(AbstractGUI gui, ClaimedResidence res) {
		super(gui);
		this.res = res;
	}

	@Override
	public InventoryInteractResponse onClick(InventoryAction action) {

		if (action == InventoryAction.PICKUP_ALL) {
			getPlayer().performCommand("resgui " + res.getName());
		}
		return new InventoryInteractResponse(Type.DoNothing, null);
	}

	@Override
	public void init() {
		item = new ItemStack(Material.BOOKSHELF);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(ChatColor.GOLD + "子领地: " + res.getName());
		List<String> lore = new ArrayList<>();
		lore.add(ChatColor.RESET + "" + ChatColor.UNDERLINE + "点击来打开子领地的管理界面");
		meta.setLore(lore);

		item.setItemMeta(meta);
	}

	@Override
	public void refresh() {
	}

}
