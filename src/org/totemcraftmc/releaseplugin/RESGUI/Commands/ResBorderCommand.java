package org.totemcraftmc.releaseplugin.RESGUI.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.totemcraftmc.releaseplugin.RESGUI.ResidenceBorderDrawer.ResidenceBorderDrawer;
import org.totemcraftmc.releaseplugin.lib.CommandLib.RootCommand;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class ResBorderCommand extends RootCommand {

	public ResBorderCommand() {
		super("resborder", false, true);
	}

	@Override
	protected boolean onCall(boolean playerRun, CommandSender sender, Player player, String[] args) {

		if (args.length != 1) {
			return false;
		}

		String resName = args[0];

		ClaimedResidence res = Residence.getResidenceManager().getByName(resName);
		if (res == null) {
			sender.sendMessage(ChatColor.RED+"未找到名字为 "+resName+" 的领地");
			return true;
		}
		
		ResidenceBorderDrawer.tempDraw(player, res, 5);
		return true;
	}

}
