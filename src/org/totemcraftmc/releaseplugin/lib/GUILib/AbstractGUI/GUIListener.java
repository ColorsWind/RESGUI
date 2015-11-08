package org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.GUIListener;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.InventoryInteractResponse;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.InventoryInteractResponse.Type;
import org.totemcraftmc.releaseplugin.lib.Utils.InventoryUtils;

public class GUIListener implements Listener {
	
	private static JavaPlugin plugin;
	public static void register(JavaPlugin plugin) {
		GUIListener.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(new GUIListener(), plugin);
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onClick(InventoryClickEvent e) {

		if (!(e.getWhoClicked() instanceof Player)) {
			return;
		}

		Inventory inv = e.getInventory();

		if (!(inv.getHolder() instanceof AbstractGUI)) {
			return;
		}

		AbstractGUI gui = (AbstractGUI) inv.getHolder();
		Player p = (Player) e.getWhoClicked();
		if (!p.equals(gui.getPlayer())) {
			return;
		}

		e.setCancelled(true);

		if (e.getClickedInventory() == null) {
			return;
		}

		if (!e.getClickedInventory().equals(inv)) {

			clearCursor(p);

			if (e.getClickedInventory().equals(e.getView().getBottomInventory())) {
				InventoryInteractResponse response = gui.onClickBottomInv(e.getSlot());
				if (response == null) {
					return;
				}

				switch (response.getType()) {
				case Close:
					p.closeInventory();
					break;
				case DoNothing:
					break;
				case OpenAnother:
					final AbstractGUI another = response.getGUI();
					Bukkit.getScheduler().runTask(plugin, new Runnable() {

						@Override
						public void run() {
							another.open();
						}
					});
					break;
				case RefreshButton:
					break;
				default:
					break;
				}
			}
			return;
		}

		AbstractButton button = gui.getButtonBySlot(e.getSlot());
		if (button == null)
			return;

		InventoryInteractResponse response = button.onClick(e.getAction());

		if (response == null) {
			response = new InventoryInteractResponse(Type.DoNothing, null);
		}

		switch (response.getType()) {
		case Close:
			p.closeInventory();
			break;
		case DoNothing:
			clearCursor(p);
			break;
		case OpenAnother:
			final AbstractGUI another = response.getGUI();
			Bukkit.getScheduler().runTask(plugin, new Runnable() {

				@Override
				public void run() {
					another.open();
				}
			});

			break;
		case RefreshButton:
			clearCursor(p);
			button.refresh();
			gui.getInventory().setItem(e.getSlot(), button.getItemStack());
			button.sendUpdatePacket();
			break;
		}
		return;
	}

	@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
	void onClose(InventoryCloseEvent e) {
		if(e.getInventory()==null||e.getInventory().getHolder()==null)return;
		if(e.getInventory().getHolder() instanceof AbstractGUI){
			AbstractGUI g = (AbstractGUI)e.getInventory().getHolder();
			g.onClose();
		}
	}

	private void clearCursor(Player p) {
		InventoryUtils.sendSlotChange(null, -1, p);
	}
}
