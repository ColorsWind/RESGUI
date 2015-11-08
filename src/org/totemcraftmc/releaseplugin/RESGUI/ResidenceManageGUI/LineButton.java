package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI;

import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.InventoryInteractResponse;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.InventoryInteractResponse.Type;

public class LineButton extends AbstractButton {

	public LineButton(AbstractGUI gui) {
		super(gui);
		// TODO Auto-generated constructor stub
	}

	@Override
	public InventoryInteractResponse onClick(InventoryAction action) {
		return new InventoryInteractResponse(Type.DoNothing, null);
	}

	@Override
	public void init() {
		item = new ItemStack(Material.STAINED_GLASS_PANE);
		item.setDurability((short)15);
		
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("-");
		
		item.setItemMeta(meta);
		
	}

	@Override
	public void refresh() {
		return;
	}

}
