package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.ResidencePlayerListGUI;

import java.lang.reflect.Field;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;
import com.bekvon.bukkit.residence.protection.FlagPermissions;

import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.LineButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.InventoryInteractResponse;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.InventoryInteractResponse.Type;

public class ResidencePlayerListGUI extends AbstractGUI {

	ClaimedResidence res;

	@SuppressWarnings("unchecked")
	public ResidencePlayerListGUI(Player p,ClaimedResidence res) {
		super(p);
		this.res = res;
		
		FlagPermissions flagPermissions = res.getPermissions();
		Map<String,Map<String,Boolean>> playerFlags;
		try{
			Field playerFlagsField = FlagPermissions.class.getDeclaredField("playerFlags");
			playerFlagsField.setAccessible(true);
			playerFlags = (Map<String, Map<String, Boolean>>) playerFlagsField.get(flagPermissions);
		}catch(Exception e){
			e.printStackTrace();
			return;
		}
		
		int slot = 0;
		for(String playerUUIDStr : playerFlags.keySet()){
			if(slot>34){
				registerButton(new AbstractButton(this) {
					
					@Override
					public void refresh() {
						return;
					}
					
					@Override
					public InventoryInteractResponse onClick(InventoryAction action) {
						return new InventoryInteractResponse(Type.DoNothing, null);
					}
					
					@Override
					public void init() {
						item = new ItemStack(Material.BARRIER);
						ItemMeta meta = item.getItemMeta();
						meta.setDisplayName("暂不支持更多的玩家");
						item.setItemMeta(meta);
					}
				}, slot);
				break;
			}
			registerButton(new PlayerButton(this, playerUUIDStr, res), slot++);
			
		}
		
		LineButton lineButton = new LineButton(this);
		for(int i = 36;i<=44;i++){
			registerButton(lineButton, i);
		}
		
		registerButton(new BackButton(this, res), 45);
		registerButton(new AddPlayerButton(this, res), 53);
		
	}

	@Override
	public void onClose() {

	}

	@Override
	public String getTitle() {
		return "领地 " + res.getName() + " 的成员管理面板";
	}

	public ClaimedResidence getResidence() {
		return res;
	}

}
