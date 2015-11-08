package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.FlagSwitchButtons;

import org.bukkit.Material;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.AbstractFlagSwitchButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;

public class MoveFlagSwitchButton extends AbstractFlagSwitchButton {

	public MoveFlagSwitchButton(AbstractGUI gui, ClaimedResidence res) {
		super(gui, res);
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
		return "其他玩家可以在这个领地里移动";
	}

	@Override
	public String getFalseDescription() {
		return "其他玩家不能在这个领地里移动";
	}

	@Override
	public String getToTrueClickTip() {
		return "点击来允许其他玩家在这个领地里移动";
	}

	@Override
	public String getToFalseClickTip() {
		return "点击来禁止其他玩家在这个领地里移动";
	}

	@Override
	public Material getButtonMaterial() {
		return Material.LEATHER_BOOTS;
	}

}
