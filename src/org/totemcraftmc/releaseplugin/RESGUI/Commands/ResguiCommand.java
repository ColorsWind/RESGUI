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
				msg(ChatColor.RED + "����ط�û�����");
			} else {
				msg(ChatColor.RED + "û�н���" + args[0] + "�����");
			}
			return true;
		}

		if (!res.getPermissions().playerHas(p.getUniqueId().toString(), "admin", false)) {
			if (!res.getOwner().equalsIgnoreCase(p.getName())) {
				msg(ChatColor.RED + "��û�й���" + res.getName() + "��Ȩ��");
				return true;
			}
		}

		AbstractGUI gui = new ResidenceManageGUI(p, res);
		gui.open();
		return true;
	}

}
