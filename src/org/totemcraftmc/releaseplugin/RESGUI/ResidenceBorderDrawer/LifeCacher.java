package org.totemcraftmc.releaseplugin.RESGUI.ResidenceBorderDrawer;

import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.Map.Entry;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.totemcraftmc.releaseplugin.RESGUI.RESGUI;

class LifeCacher {

	static BukkitTask timer;

	static WeakHashMap<Player, ResidenceBorderDrawer> pMap = new WeakHashMap<>();
	static WeakHashMap<ResidenceBorderDrawer, Integer> lMap = new WeakHashMap<>();

	static void push(ResidenceBorderDrawer drawer, int second) {

		if (timer == null) {
			timer = new BukkitRunnable() {
				@Override
				public void run() {

					Iterator<Entry<ResidenceBorderDrawer, Integer>> ite = lMap.entrySet().iterator();
					while (ite.hasNext()) {
						Entry<ResidenceBorderDrawer, Integer> en = ite.next();
						if (en.getValue() <= 0) {
							if (en.getKey().getPlayer() != null) {
								en.getKey().reset();
							}
							ite.remove();
							pMap.remove(en.getKey().getPlayer());
						}
						en.setValue(en.getValue()-1);
					}

				}
			}.runTaskTimer(RESGUI.instance, 20, 20);
		}

		ResidenceBorderDrawer exist;
		if ((exist = pMap.get(drawer.getPlayer())) != null) {
			if (exist.getResidence().equals(drawer.getResidence())) {
				lMap.put(exist, second);
				return;
			} else {
				exist.reset();
				lMap.remove(exist);
			}
		}

		pMap.put(drawer.getPlayer(), drawer);
		lMap.put(drawer, second);
		drawer.draw();
	}
}
