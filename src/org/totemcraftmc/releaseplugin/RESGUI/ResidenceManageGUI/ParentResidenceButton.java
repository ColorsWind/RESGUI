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

public class ParentResidenceButton extends AbstractButton {

	private final ClaimedResidence res;
	public ParentResidenceButton(ResidenceManageGUI gui) {
		super(gui);
		this.res = gui.getResidence();
	}

	@Override
	public InventoryInteractResponse onClick(InventoryAction action) {
		
		if(res.getParent()==null){
			return new InventoryInteractResponse(Type.RefreshButton, null);
		}else{
			getPlayer().performCommand("resgui "+res.getParent().getName());
			return new InventoryInteractResponse(Type.DoNothing, null);
		}
		
	}

	@Override
	public void init() {
		item = new ItemStack(Material.TRIPWIRE_HOOK);
	}

	@Override
	public void refresh() {
		
		ItemMeta meta = item.getItemMeta();
		if(res.getParent()==null){
			meta.setDisplayName(ChatColor.RED+"这个领地不是任意一个领地的子领地");
			item.setAmount(0);
		}else{
			meta.setDisplayName(ChatColor.GREEN+"父领地: "+res.getParent().getName());
			List<String> lore = new ArrayList<>();
			lore.add(ChatColor.RESET+""+ChatColor.UNDERLINE+"点击来打开父领地的管理界面");
			meta.setLore(lore);
			item.setAmount(1);
		}
		item.setItemMeta(meta);
	}

}
