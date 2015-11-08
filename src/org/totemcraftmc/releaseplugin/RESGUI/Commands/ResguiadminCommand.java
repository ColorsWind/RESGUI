package org.totemcraftmc.releaseplugin.RESGUI.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.ResidenceManageGUI;
import org.totemcraftmc.releaseplugin.lib.CommandLib.RootCommand;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class ResguiadminCommand extends RootCommand{

	public ResguiadminCommand() {
		super("resguiadmin", false, true);
	}
	
	@Override
	protected boolean onCall(boolean playerRun, CommandSender sender, Player player, String[] args) {
		Player p = player;
		
		if(!Residence.getPermissionManager().isResidenceAdmin(p)){
			return true;
		}
		
		if(args.length>1){
			return false;
		}
		
		ClaimedResidence res;
		if(args.length==1){
			res = Residence.getResidenceManager().getByName(args[0]);
		}else{
			res = Residence.getResidenceManager().getByLoc(p.getLocation());
		}
		
		if(res==null){
			if(args.length==1){
				p.sendMessage(ChatColor.RED+"û�н��� "+args[0]+" �����");
			}else{
				p.sendMessage(ChatColor.RED+"���λ��û�����");
			}
			return true;
		}
		
		new ResidenceManageGUI(p, res).open();;
		return true;
	}

}
