package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.SubZoneListGUI;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.LineButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.InventoryInteractResponse;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.InventoryInteractResponse.Type;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class SubZoneListGUI extends AbstractGUI {

	private final ClaimedResidence res;

	public SubZoneListGUI(Player p, ClaimedResidence res) {
		super(p);
		this.res = res;

		int slot = 0;
		for (String subzone : res.getSubzoneList()) {
			if (slot == 36) {
				registerButton(new AbstractButton(this) {
					@Override
					public void refresh() {
					}

					@Override
					public InventoryInteractResponse onClick(InventoryAction action) {
						return new InventoryInteractResponse(Type.DoNothing, null);
					}

					@Override
					public void init() {
						item = new ItemStack(Material.BARRIER);
						ItemMeta meta = item.getItemMeta();
						meta.setDisplayName(ChatColor.RED + "�ݲ�֧����ʾ����");
						item.setItemMeta(meta);
					}
				}, 35);
				slot = 35;
				break;
			}
			registerButton(new SubZoneButton(this, res.getSubzone(subzone)), slot++);
		}

		int line = slot % 9;
		for (int i = line * 9; i < line * 9 + 9; i++) {
			registerButton(new LineButton(this), i);
		}
		
		registerButton(new BackButton(this, res), (line+1)*9);
	}

	@Override
	public void onClose() {
	}

	@Override
	public String getTitle() {
		return "��� " + res.getName() + " ��������б�";
	}

	public ClaimedResidence getResidence() {
		return res;
	}

}
