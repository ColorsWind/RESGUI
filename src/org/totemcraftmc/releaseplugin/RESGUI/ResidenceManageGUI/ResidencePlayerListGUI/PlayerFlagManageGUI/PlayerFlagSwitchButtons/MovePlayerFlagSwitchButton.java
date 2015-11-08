package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.ResidencePlayerListGUI.PlayerFlagManageGUI.PlayerFlagSwitchButtons;

import org.bukkit.Material;
import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.ResidencePlayerListGUI.PlayerFlagManageGUI.AbstractPlayerFlagSwitchButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class MovePlayerFlagSwitchButton extends AbstractPlayerFlagSwitchButton {

	public MovePlayerFlagSwitchButton(AbstractGUI gui, String uuid, String playerName,
			ClaimedResidence res) {
		super(gui, uuid, playerName, res);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getFlagString() {
		return "move";
	}

	@Override
	public String getFlagDescription() {
		return "移动权限";
	}

	@Override
	public String getTrueDescription() {
		return playerName+" 可以在这个领地里移动";
	}

	@Override
	public String getFalseDescription() {
		return playerName+" 不能在这个领地里移动";
	}

	@Override
	public String getToTrueClickTip() {
		return "点击来允许 "+playerName+" 在这个领地里移动";
	}

	@Override
	public String getToFalseClickTip() {
		return "点击来禁止 "+playerName+" 在这个领地里移动";
	}

	@Override
	public Material getButtonMaterial() {
		return Material.LEATHER_BOOTS;
	}

}
