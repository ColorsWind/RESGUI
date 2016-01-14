package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI;

import org.bukkit.entity.Player;
import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.FlagSwitchButtons.*;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class ResidenceManageGUI extends AbstractGUI {

	private final ClaimedResidence res;

	public ResidenceManageGUI(Player p, ClaimedResidence res) {
		super(p);
		this.res = res;

		registerButton(new BuildFlagSwitchButton(this, res), 0);
		registerButton(new UseFlagSwitchButton(this, res), 1);
		registerButton(new ContainerFlagSwichButton(this, res), 2);
//		registerButton(new AttackanimalsFlagSwitchButton(this, res), 3);
		registerButton(new MoveFlagSwitchButton(this, res), 3);
		registerButton(new TpFlagSwitchButton(this, res), 4);
		registerButton(new PVPFlagSwitchButton(this, res), 5);
//		registerButton(new HopperMinecartFlagSwitchButton(this, res), 6);

		registerButton(new MonstersFlagSwtichButton(this, res), 9);
		registerButton(new AnimalsFlagSwitchButton(this, res), 10);
		registerButton(new PistonFlagSwitchButton(this, res), 11);
		registerButton(new FlowFlagSwtichButton(this, res), 12);
		registerButton(new WaterflowFlagSwitchButton(this, res), 13);
		registerButton(new LavaflowFlagSwitchButton(this, res), 14);
		registerButton(new CreeperFlagSwitchButton(this, res), 15);
		registerButton(new TntFlagSwitchButton(this, res), 16);

		LineButton lineButton = new LineButton(this);
		for (int i = 18; i < 27; i++) {
			registerButton(lineButton, i);
		}
		
		registerButton(new SettpButton(this, res), 27);
		
		registerButton(new SetEnterMessageButton(this), 28);
		registerButton(new SetLeaveMessageButton(this), 29);
		
		registerButton(new SubZoneListButton(this), 30);
		registerButton(new ParentResidenceButton(this), 31);
		
		registerButton(new ShowBorderButton(this), 32);
		
		registerButton(new DeleteButton(this), 33);
		
		registerButton(new OpenPlayerListButton(this, res), 35);

	}

	@Override
	public void onClose() {
		return;
	}

	@Override
	public String getTitle() {
		return "领地 " + res.getName() + " 的管理面板";
	}

	public boolean checkPerm() {
		if (res.getPermissions().playerHas(getPlayer().getUniqueId().toString(), "admin", false)
				|| res.getPermissions().getOwnerUUID().equals(getPlayer().getUniqueId())) {
			return true;
		}
		
		return false;
	}
	
	public ClaimedResidence getResidence(){
		return res;
	}

}
