package org.totemcraftmc.releaseplugin.lib.Utils;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PlayerUtil {

	private PlayerUtil() {
	}

	public static final void dropItemsToPlayer(HashMap<Integer, ItemStack> itemsMap, Player p) {

		for (ItemStack item : itemsMap.values()) {
			p.getLocation().getWorld().dropItemNaturally(p.getLocation(), item);
		}

	}

	public static final void createLocationTeleportTask(Player p, Location loc, String name,
			double fee) {
		// LocationPlayerTeleportTask.createNormalTask(p, loc, true, name);
	}

	public static OfflinePlayer getLocalOfflinePlayer(String name) {
		Player exact;
		if ((exact = Bukkit.getPlayerExact(name)) != null) {
			return exact;
		}
		for (OfflinePlayer p : Bukkit.getOfflinePlayers()) {
			if (p.getName().equalsIgnoreCase(name)) {
				return p;
			}

		}
		return null;
	}

	public static OfflinePlayer getLocalOfflinePlayer(UUID uuid) {
		Player exact;
		if ((exact = Bukkit.getPlayer(uuid)) != null) {
			return exact;
		}
		for (OfflinePlayer p : Bukkit.getOfflinePlayers()) {

			if (p.getUniqueId().equals(uuid)) {
				return p;
			}

		}
		return null;
	}

}
