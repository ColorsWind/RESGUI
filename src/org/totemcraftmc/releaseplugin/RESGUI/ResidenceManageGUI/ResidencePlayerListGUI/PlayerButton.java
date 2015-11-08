package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.ResidencePlayerListGUI;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.ResidenceManageGUI;
import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.ResidencePlayerListGUI.PlayerFlagManageGUI.PlayerFlagManageGUI;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.InventoryInteractResponse;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.InventoryInteractResponse.Type;
import org.totemcraftmc.releaseplugin.lib.Utils.PlayerUtil;

public class PlayerButton extends AbstractButton {

	final String uuidStr;
	final ClaimedResidence res;
	private String playerName;

	public PlayerButton(AbstractGUI gui, String uuid, ClaimedResidence res) {
		super(gui);

		this.uuidStr = uuid;
		this.res = res;
	}

	@Override
	public InventoryInteractResponse onClick(InventoryAction action) {

		if (action.equals(InventoryAction.DROP_ONE_SLOT)) {

			if (!(res.getPermissions().getOwner().equals(getPlayer().getName())
					|| res.getPermissions().playerHas(getPlayer().getName(), "admin", true))) {
				return new InventoryInteractResponse(Type.Close, null);
			}

			res.getPermissions().removeAllPlayerFlags(uuidStr);

			Player p = Bukkit.getPlayer(playerName);
			if (p != null) {
				InventoryView view;
				if ((view = p.getOpenInventory()) != null) {
					Inventory inv;
					if ((inv = view.getTopInventory()) != null) {
						InventoryHolder holder;
						if ((holder = inv.getHolder()) != null) {
							if (holder instanceof AbstractGUI) {
								if (holder instanceof ResidenceManageGUI) {
									if (((ResidenceManageGUI) holder).getResidence().equals(res)) {
										p.closeInventory();
									}
								} else if (holder instanceof ResidencePlayerListGUI) {
									if (((ResidencePlayerListGUI) holder).getResidence().equals(res)) {
										p.closeInventory();
									}
								} else if (holder instanceof PlayerFlagManageGUI) {
									if (((PlayerFlagManageGUI) holder).getResidence().equals(res)) {
										p.closeInventory();
									}
								}
							}
						}
					}
				}
			}

			return new InventoryInteractResponse(Type.OpenAnother, new ResidencePlayerListGUI(getPlayer(), res));
		} else if (action.equals(InventoryAction.PICKUP_ALL)) {
			return new InventoryInteractResponse(Type.OpenAnother, new PlayerFlagManageGUI(getPlayer(), uuidStr, res));
		}

		return new InventoryInteractResponse(Type.DoNothing, null);
	}

	@Override
	public void init() {

		item = new ItemStack(Material.SKULL_ITEM);
		item.setDurability((short) 3);

		SkullMeta meta = (SkullMeta) item.getItemMeta();

		try {
			UUID uuid = UUID.fromString(uuidStr);
			OfflinePlayer oplayer = PlayerUtil.getLocalOfflinePlayer(uuid);
			if (oplayer == null) {
				playerName = uuidStr;
			}else{
				playerName = oplayer.getName();
			}
		} catch (Exception e) {
			playerName = uuidStr;
		}

		meta.setOwner(playerName);

		List<String> lore = new ArrayList<String>();
		lore.add("");
		meta.setLore(lore);

		meta.setDisplayName(ChatColor.GREEN + "玩家: " + ChatColor.RESET + playerName);

		item.setItemMeta(meta);

	}

	@Override
	public void refresh() {

		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.RESET + "" + ChatColor.UNDERLINE + "点击来对该玩家在这个领地的权限进行管理");
		lore.add(ChatColor.RESET + "" + ChatColor.UNDERLINE + "按Q来清除对该玩家做的更改");
		lore.add(ChatColor.GOLD + "================================");
		ChatColor color = null;
		color = (res.getPermissions().playerHas(uuidStr, "build", true)) ? ChatColor.GREEN : ChatColor.RED;
		lore.add(color + "建筑(build)");
		color = (res.getPermissions().playerHas(uuidStr, "use", true)) ? ChatColor.GREEN : ChatColor.RED;
		lore.add(color + "使用(use)");
		color = (res.getPermissions().playerHas(uuidStr, "container", true)) ? ChatColor.GREEN : ChatColor.RED;
		lore.add(color + "容器(container)");
		color = (res.getPermissions().playerHas(uuidStr, "move", true)) ? ChatColor.GREEN : ChatColor.RED;
		lore.add(color + "移动(move)");
		color = (res.getPermissions().playerHas(uuidStr, "tp", true)) ? ChatColor.GREEN : ChatColor.RED;
		lore.add(color + "传送(tp)");
		lore.add(ChatColor.GOLD + "================================");

		ItemMeta meta = item.getItemMeta();
		meta.setLore(lore);
		item.setItemMeta(meta);

	}

}
