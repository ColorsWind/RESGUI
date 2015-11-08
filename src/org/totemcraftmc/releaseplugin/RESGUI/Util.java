package org.totemcraftmc.releaseplugin.RESGUI;

import java.lang.reflect.Field;

import org.bukkit.Location;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class Util {

	public static int setTpLoc(ClaimedResidence res, Location loc) {
		try {
			Location tpLoc;
			Field tpLocField = ClaimedResidence.class.getDeclaredField("tpLoc");
			tpLocField.setAccessible(true);
			tpLoc = (Location) tpLocField.get(res);
			
			if (loc == null) {
				tpLocField.set(res, null);
				return 1;
			}

			if (!res.containsLoc(loc)) {
				return 0;
			}
			
			tpLocField.set(res, loc);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 1;
		}
	}
}
