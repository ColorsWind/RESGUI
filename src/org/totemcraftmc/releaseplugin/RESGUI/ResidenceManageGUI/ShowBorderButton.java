package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.InventoryInteractResponse;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.InventoryInteractResponse.Type;
import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class ShowBorderButton extends AbstractButton {

	private ClaimedResidence res;

	public ShowBorderButton(ResidenceManageGUI gui) {
		super(gui);
		this.res = gui.getResidence();
	}

	@Override
	public InventoryInteractResponse onClick(InventoryAction action) {
		if (action == InventoryAction.PICKUP_ALL) {
			getPlayer().performCommand("resborder " + res.getName());
		}
		return new InventoryInteractResponse(Type.Close, null);
	}

	@Override
	public void init() {
		item = new ItemStack(Material.STAINED_GLASS);
		item.setDurability((short) 14);

		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.GREEN + "显示领地边界");
		item.setItemMeta(meta);
	}

	@Override
	public void refresh() {}

}
