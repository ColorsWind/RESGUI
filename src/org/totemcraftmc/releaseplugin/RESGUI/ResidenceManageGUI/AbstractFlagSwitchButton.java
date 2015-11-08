package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.InventoryInteractResponse;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.InventoryInteractResponse.Type;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.ClaimedResidence;
import com.bekvon.bukkit.residence.protection.FlagPermissions.FlagState;
public abstract class AbstractFlagSwitchButton extends AbstractButton {

	protected final ClaimedResidence res;
	public AbstractFlagSwitchButton(AbstractGUI gui,ClaimedResidence res) {
		super(gui);
		this.res = res;
	}

	@Override
	public InventoryInteractResponse onClick(InventoryAction action) {
		if(!action.equals(InventoryAction.PICKUP_ALL)){
			return new InventoryInteractResponse(Type.DoNothing, null);
		}
		
		if(!Residence.getPermissionManager().getGroup(getPlayer()).hasFlagAccess(getFlagString())){
			getPlayer().sendMessage(ChatColor.RED+"你没有权限更改领地的 "+getFlagString()+" 权限");
			return new InventoryInteractResponse(Type.Close, null);
		}
		
		res.getPermissions().setFlag(getFlagString(), resHasFlag()?FlagState.FALSE:FlagState.TRUE);
		
		return new InventoryInteractResponse(Type.RefreshButton, null);
	}

	@Override
	public void init() {
		item = new ItemStack(getButtonMaterial());
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName("");
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add("");
		meta.setLore(lore);
		
		item.setItemMeta(meta);

	}

	@Override
	public void refresh() {
		
		boolean flagtrue = resHasFlag();
		ChatColor color = flagtrue ? ChatColor.GREEN : ChatColor.RED;
		
		item.setAmount(flagtrue?1:0);
		
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(color+getFlagDescription()+ChatColor.RESET+"("+getFlagString()+")");
		
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.YELLOW+""+ChatColor.ITALIC+(flagtrue?getTrueDescription():getFalseDescription()));
		lore.add(ChatColor.RESET+""+ChatColor.UNDERLINE+(flagtrue?getToFalseClickTip():getToTrueClickTip()));
		meta.setLore(lore);
		
		meta.addItemFlags(ItemFlag.values());
		
		item.setItemMeta(meta);
		
	}
	
	protected boolean resHasFlag(){
		
		return res.getPermissions().has(getFlagString(), false);
		
	}
	
	public abstract String getFlagString();
	
	public abstract String getFlagDescription();
	
	public abstract String getTrueDescription();
	
	public abstract String getFalseDescription();
	
	public abstract String getToTrueClickTip();
	
	public abstract String getToFalseClickTip();
	
	public abstract Material getButtonMaterial();
	
	
}
