package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.ResidencePlayerListGUI.PlayerFlagManageGUI.PlayerFlagSwitchButtons;

import org.bukkit.Material;
import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.ResidencePlayerListGUI.PlayerFlagManageGUI.AbstractPlayerFlagSwitchButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class BuildPlayerFlagSwtichButton extends AbstractPlayerFlagSwitchButton {

	public BuildPlayerFlagSwtichButton(AbstractGUI gui,String uuid, String playerName,
			ClaimedResidence res) {
		super(gui,uuid, playerName, res);
	}

	@Override
	public String getFlagString() {
		return "build";
	}

	@Override
	public String getFlagDescription() {
		return "建筑权限";
	}

	@Override
	public String getTrueDescription() {
		return playerName+" 可以在这个领地里建筑";
	}

	@Override
	public String getFalseDescription() {
		return playerName+" 不能在这个领地里建筑";
	}

	@Override
	public String getToTrueClickTip() {
		return "点击来允许 "+playerName+" 在这个领地里建筑";
	}

	@Override
	public String getToFalseClickTip() {
		return "点击来禁止 "+playerName+" 在这个领地里建筑";
	}

	@Override
	public Material getButtonMaterial() {
		return Material.DIAMOND_PICKAXE;
	}

}
