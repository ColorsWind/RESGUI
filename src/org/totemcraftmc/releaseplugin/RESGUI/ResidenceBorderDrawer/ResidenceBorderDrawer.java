package org.totemcraftmc.releaseplugin.RESGUI.ResidenceBorderDrawer;

import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import com.bekvon.bukkit.residence.protection.ClaimedResidence;
import com.bekvon.bukkit.residence.protection.CuboidArea;

public class ResidenceBorderDrawer {

	private final WeakReference<Player> wPlayer;
	private final ClaimedResidence res;
	private HashSet<Vector> blocks = new HashSet<>();

	private ResidenceBorderDrawer(ClaimedResidence res, Player p) {
		this.wPlayer = new WeakReference<Player>(p);
		this.res = res;
	}

	public Player getPlayer() {

		if (wPlayer.isEnqueued()) {
			return null;
		}

		if (wPlayer.get() == null) {
			return null;
		}

		if (!wPlayer.get().isOnline()) {
			return null;
		}

		return wPlayer.get();
	}

	public ClaimedResidence getResidence() {
		return res;
	}

	@SuppressWarnings("deprecation")
	public void draw() {
		Player p = getPlayer();
		if (p != null) {
			for (CuboidArea area : res.getAreaArray()) {
				Location hLoc = area.getHighLoc();
				Location lLoc = area.getLowLoc();

				int xL = hLoc.getBlockX() - lLoc.getBlockX() + 1;
				int yL = hLoc.getBlockY() - lLoc.getBlockY() + 1;
				int zL = hLoc.getBlockZ() - lLoc.getBlockZ() + 1;

				Vector x1, x2, x3, x4;
				Vector y1, y2, y3, y4;
				Vector z1, z2, z3, z4;

				x1 = new Vector(lLoc.getBlockX() - 1, lLoc.getBlockY() - 1, lLoc.getBlockZ() - 1);
				x2 = new Vector(x1.getBlockX(), x1.getBlockY() + 1 + yL, x1.getBlockZ());
				x3 = new Vector(x1.getBlockX(), x1.getBlockY(), x1.getBlockZ() + 1 + zL);
				x4 = new Vector(x1.getBlockX(), x2.getBlockY(), x3.getBlockZ());

				y1 = new Vector(lLoc.getBlockX() - 1, lLoc.getBlockY() - 1, lLoc.getBlockZ() - 1);
				y2 = new Vector(y1.getBlockX() + 1 + xL, y1.getBlockY(), y1.getBlockZ());
				y3 = new Vector(y1.getBlockX(), y1.getBlockY(), y1.getBlockZ() + 1 + zL);
				y4 = new Vector(y2.getBlockX(), y1.getBlockY(), y3.getBlockZ());

				z1 = new Vector(lLoc.getBlockX() - 1, lLoc.getBlockY() - 1, lLoc.getBlockZ() - 1);
				z2 = new Vector(z1.getBlockX() + 1 + xL, z1.getBlockY(), z1.getBlockZ());
				z3 = new Vector(z1.getBlockX(), z1.getBlockY() + 1 + yL, z1.getBlockZ());
				z4 = new Vector(z2.getBlockX(), z3.getBlockY(), z1.getBlockZ());

				for (Vector xTempOrigin : new Vector[] { x1, x2, x3, x4 }) {
					for (int i = 0; i < xL + 1; i++) {
						Vector xtemp = new Vector(xTempOrigin.getBlockX(), xTempOrigin.getBlockY(), xTempOrigin.getBlockZ())
								.add(new Vector(i, 0, 0));
						if (blocks.add(xtemp)) {
							p.sendBlockChange(new Location(Bukkit.getWorld(res.getWorld()), xtemp.getBlockX(), xtemp.getBlockY(),
									xtemp.getBlockZ()), Material.STAINED_GLASS, (byte) 14);
						}
					}
				}

				for (Vector yTempOrigin : new Vector[] { y1, y2, y3, y4 }) {
					for (int i = 0; i < yL + 1; i++) {
						Vector ytemp = new Vector(yTempOrigin.getBlockX(), yTempOrigin.getBlockY(), yTempOrigin.getBlockZ())
								.add(new Vector(0, i, 0));
						if (blocks.add(ytemp)) {
							p.sendBlockChange(new Location(Bukkit.getWorld(res.getWorld()), ytemp.getBlockX(), ytemp.getBlockY(),
									ytemp.getBlockZ()), Material.STAINED_GLASS, (byte) 14);
						}
					}
				}

				for (Vector zTempOrigin : new Vector[] { z1, z2, z3, z4 }) {
					for (int i = 0; i < zL + 1; i++) {
						Vector ztemp = new Vector(zTempOrigin.getBlockX(), zTempOrigin.getBlockY(), zTempOrigin.getBlockZ())
								.add(new Vector(0, 0, i));
						if (blocks.add(ztemp)) {
							p.sendBlockChange(new Location(Bukkit.getWorld(res.getWorld()), ztemp.getBlockX(), ztemp.getBlockY(),
									ztemp.getBlockZ()), Material.STAINED_GLASS, (byte) 14);
						}
					}
				}

				Vector fin = new Vector(hLoc.getBlockX() + 1, hLoc.getBlockY() + 1, hLoc.getBlockZ() + 1);
				if (blocks.add(fin)) {
					p.sendBlockChange(
							new Location(Bukkit.getWorld(res.getWorld()), fin.getBlockX(), fin.getBlockY(), fin.getBlockZ()),
							Material.STAINED_GLASS, (byte) 14);
				}

			}
		}
	}

	@SuppressWarnings("deprecation")
	public void reset() {
		Player p = wPlayer.get();
		if (wPlayer != null && !wPlayer.isEnqueued() && wPlayer.get() != null) {
			Iterator<Vector> ite = blocks.iterator();
			while (ite.hasNext()) {
				Vector v = ite.next();
				org.bukkit.World w = Bukkit.getWorld(res.getWorld());
				Location loc = new Location(w, v.getBlockX(), v.getBlockY(), v.getBlockZ());
				Block b = loc.getBlock();
				p.sendBlockChange(loc, b.getType(), b.getData());
				ite.remove();
			}
		}
	}

	public static void tempDraw(Player p, ClaimedResidence res, int second) {
		LifeCacher.push(new ResidenceBorderDrawer(res, p), second);
	}

}
