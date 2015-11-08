package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.totemcraftmc.releaseplugin.lib.AdvancedMessage.AdvancedMessage;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.InventoryInteractResponse;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.InventoryInteractResponse.Type;
import org.totemcraftmc.releaseplugin.lib.GUILib.ChatHook.ChatHook;
import org.totemcraftmc.releaseplugin.lib.GUILib.ChatHook.ChatHookManager;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class SetEnterMessageButton extends AbstractButton {

	private final ClaimedResidence res;

	public SetEnterMessageButton(ResidenceManageGUI gui) {
		super(gui);
		this.res = gui.getResidence();
	}

	@Override
	public InventoryInteractResponse onClick(InventoryAction action) {

		if (action == InventoryAction.PICKUP_ALL) {
			AdvancedMessage m = new AdvancedMessage(ChatColor.GREEN + "请在聊天栏直接输入要设置的进入领地提示语，15秒内有效。  ");
			m.color(ChatColor.GREEN);
			ItemStack i = new ItemStack(Material.STONE);
			ItemMeta meta = i.getItemMeta();
			meta.setDisplayName(ChatColor.GOLD + "变量列表");
			List<String> lore = new ArrayList<>();
			lore.add(ChatColor.RESET + "%player 表示 玩家名字");
			lore.add(ChatColor.RESET + "%residence 表示 领地名字");
			lore.add(ChatColor.RESET + "%owner 表示 主人名字");
			meta.setLore(lore);
			i.setItemMeta(meta);
			m.then("[变量列表]");
			m.color(ChatColor.GOLD);
			m.itemTooltip(i);
			m.send(getPlayer());
			ChatHookManager.registerHook(new ChatHook(getPlayer()) {
				@Override
				public void recieve(String str) {
					str = ChatColor.translateAlternateColorCodes('&', str);
					res.setEnterMessage(str);
					getPlayer().sendMessage(ChatColor.GREEN+"已设置进入领地提示语为: "+ChatColor.YELLOW+str);
				}
			});
			return new InventoryInteractResponse(Type.Close, null);
		} else if (action == InventoryAction.DROP_ONE_SLOT) {
			res.setEnterMessage(null);
		}
		return new InventoryInteractResponse(Type.RefreshButton, null);
	}

	@Override
	public void init() {
		item = new ItemStack(Material.POWERED_RAIL);
	}

	@Override
	public void refresh() {
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(ChatColor.GREEN + "设置进入领地提示语");
		List<String> lore = new ArrayList<>();
		if (res.getEnterMessage() != null) {
			lore.add(ChatColor.GOLD + "当前: " + res.getEnterMessage());
			lore.add(ChatColor.RESET + "" + ChatColor.UNDERLINE + "按Q清除进入领地提示语");
		}

		meta.setLore(lore);

		item.setItemMeta(meta);
	}

}
