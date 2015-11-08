package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.ResidencePlayerListGUI;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.InventoryInteractResponse;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.InventoryInteractResponse.Type;
import org.totemcraftmc.releaseplugin.lib.GUILib.ChatHook.ChatHook;
import org.totemcraftmc.releaseplugin.lib.GUILib.ChatHook.ChatHookManager;
import org.totemcraftmc.releaseplugin.lib.Utils.PlayerUtil;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;
import com.bekvon.bukkit.residence.protection.FlagPermissions.FlagState;

public class AddPlayerButton extends AbstractButton {

	final ClaimedResidence res;

	public AddPlayerButton(AbstractGUI gui, ClaimedResidence res) {
		super(gui);
		this.res = res;
	}

	@Override
	public InventoryInteractResponse onClick(InventoryAction action) {

		if (!action.equals(InventoryAction.PICKUP_ALL)) {
			return new InventoryInteractResponse(Type.DoNothing, null);
		}

		ChatHookManager.registerHook(new ChatHook(getPlayer()) {

			@Override
			public void recieve(String str) {

				OfflinePlayer toAdd = PlayerUtil.getLocalOfflinePlayer(str);

				Player p = getPlayer();

				if (toAdd == null || !toAdd.hasPlayedBefore()) {
					p.sendMessage(ChatColor.RED + "玩家名不正确，添加失败");
					return;
				}
				
				String uuidStr = toAdd.getUniqueId().toString();
				res.getPermissions().setPlayerFlag(uuidStr, "build", FlagState.TRUE);
				res.getPermissions().setPlayerFlag(uuidStr, "use", FlagState.TRUE);
				res.getPermissions().setPlayerFlag(uuidStr, "container", FlagState.TRUE);
				res.getPermissions().setPlayerFlag(uuidStr, "attackanimals", FlagState.TRUE);
				res.getPermissions().setPlayerFlag(uuidStr, "move", FlagState.TRUE);
				res.getPermissions().setPlayerFlag(uuidStr, "tp", FlagState.TRUE);

				new ResidencePlayerListGUI(getPlayer(), res).open();
				return;
			}

		});

		getPlayer().sendMessage("§a请按 §c\"t\" §a键直接输入要添加的玩家的名字，15秒内有效");
		return new InventoryInteractResponse(Type.Close, null);

	}

	@Override
	public void init() {

		item = new ItemStack(Material.SKULL_ITEM);
		item.setDurability((short) 3);

		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.GREEN + "添加一个玩家");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GOLD + "点击后在聊天框中输入要添加的玩家的名字");
		lore.add(ChatColor.RED + "添加完成后该玩家将拥有你的领地的全盘访问权限");
		lore.add(ChatColor.RED + "如有需要请及时设置");
		meta.setLore(lore);

		item.setItemMeta(meta);
	}

	@Override
	public void refresh() {
		return;
	}

}
