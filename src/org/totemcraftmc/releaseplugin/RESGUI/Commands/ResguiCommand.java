package org.totemcraftmc.releaseplugin.RESGUI.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.ResidenceManageGUI;
import org.totemcraftmc.releaseplugin.lib.CommandLib.RootCommand;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class ResguiCommand extends RootCommand {

	public ResguiCommand() {
		super("resgui", false, true);
		setPermission("tcgui.resgui");
	}

	@Override
	protected boolean onCall(boolean playerRun, CommandSender sender, Player player, String[] args) {
		if (args.length > 1) {
			return false;
		}

		Player p = player;

		ClaimedResidence res = null;

		if (args.length == 0) {
			res = Residence.getResidenceManager().getByLoc(p.getLocation());
		} else {
			res = Residence.getResidenceManager().getByName(args[0]);
		}

		if (res == null) {
			if (args.length == 0) {
				msg(ChatColor.RED + "这个地方没有领地");
			} else {
				msg(ChatColor.RED + "没有叫做" + args[0] + "的领地");
			}
			return true;
		}

		if (!res.getPermissions().playerHas(p.getUniqueId().toString(), "admin", false)) {
			if (!res.getOwner().equalsIgnoreCase(p.getName())) {
				msg(ChatColor.RED + "你没有管理" + res.getName() + "的权限");
				return true;
			}
		}

		AbstractGUI gui = new ResidenceManageGUI(p, res);
		gui.open();
		return true;
	}

}
