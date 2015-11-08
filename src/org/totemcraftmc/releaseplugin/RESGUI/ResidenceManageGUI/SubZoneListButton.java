package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.SubZoneListGUI.SubZoneListGUI;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.InventoryInteractResponse;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.InventoryInteractResponse.Type;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class SubZoneListButton extends AbstractButton {

	private final ClaimedResidence res;

	public SubZoneListButton(ResidenceManageGUI gui) {
		super(gui);
		this.res = gui.getResidence();
	}

	@Override
	public InventoryInteractResponse onClick(InventoryAction action) {

		if (res.getSubzoneList().length == 0) {
			return new InventoryInteractResponse(Type.RefreshButton, null);
		}else{
			return new InventoryInteractResponse(Type.OpenAnother, new SubZoneListGUI(getPlayer(), res));
		}

	}

	@Override
	public void init() {
		item = new ItemStack(Material.COMMAND);
	}

	@Override
	public void refresh() {
		ItemMeta meta = item.getItemMeta();
		if (res.getSubzoneList().length == 0) {
			item.setAmount(0);
			meta.setDisplayName(ChatColor.RED + "这个领地没有子领地");
		} else {
			item.setAmount(res.getSubzoneList().length);
			meta.setDisplayName(ChatColor.GREEN + "子领地列表");
		}
		item.setItemMeta(meta);
	}

}
