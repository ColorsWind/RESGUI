package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.FlagSwitchButtons;

import org.bukkit.Material;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.AbstractFlagSwitchButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;

public class PistonFlagSwitchButton extends AbstractFlagSwitchButton {

	public PistonFlagSwitchButton(AbstractGUI gui, ClaimedResidence res) {
		super(gui, res);
	}

	@Override
	public String getFlagString() {
		return "piston";
	}

	@Override
	public String getFlagDescription() {
		return "活塞运动";
	}

	@Override
	public String getTrueDescription() {
		return "活塞可以在这个领地里运动";
	}

	@Override
	public String getFalseDescription() {
		return "活塞不可以在这个领地里运动";
	}

	@Override
	public String getToTrueClickTip() {
		return "点击来允许活塞在这个领地里运动";
	}

	@Override
	public String getToFalseClickTip() {
		return "点击来禁止活塞在这个领地里运动";
	}

	@Override
	public Material getButtonMaterial() {
		return Material.PISTON_BASE;
	}

}
