package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.InventoryInteractResponse;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.InventoryInteractResponse.Type;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class DeleteButton extends AbstractButton {

	private final ClaimedResidence res;

	public DeleteButton(ResidenceManageGUI gui) {
		super(gui);
		this.res = gui.getResidence();
	}

	@Override
	public InventoryInteractResponse onClick(InventoryAction action) {
		if (action == InventoryAction.MOVE_TO_OTHER_INVENTORY) {
			getPlayer().performCommand("res delete "+res.getName());
			return new InventoryInteractResponse(Type.Close, null);
		} else {
			return new InventoryInteractResponse(Type.DoNothing, null);
		}
	}

	@Override
	public void init() {

		item = new ItemStack(Material.LAVA_BUCKET);

		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(ChatColor.RED + "删除领地");
		List<String> lore = new ArrayList<>();
		lore.add(ChatColor.RESET + "" + ChatColor.UNDERLINE + "按住Shift点击来删除该领地");
		meta.setLore(lore);

		item.setItemMeta(meta);
	}

	@Override
	public void refresh() {
	}

}
