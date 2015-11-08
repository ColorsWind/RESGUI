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
					p.sendMessage(ChatColor.RED + "���������ȷ�����ʧ��");
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

		getPlayer().sendMessage("��a�밴 ��c\"t\" ��a��ֱ������Ҫ��ӵ���ҵ����֣�15������Ч");
		return new InventoryInteractResponse(Type.Close, null);

	}

	@Override
	public void init() {

		item = new ItemStack(Material.SKULL_ITEM);
		item.setDurability((short) 3);

		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.GREEN + "���һ�����");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GOLD + "������������������Ҫ��ӵ���ҵ�����");
		lore.add(ChatColor.RED + "�����ɺ����ҽ�ӵ�������ص�ȫ�̷���Ȩ��");
		lore.add(ChatColor.RED + "������Ҫ�뼰ʱ����");
		meta.setLore(lore);

		item.setItemMeta(meta);
	}

	@Override
	public void refresh() {
		return;
	}

}
