package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.FlagSwitchButtons;

import org.bukkit.Material;
import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.AbstractFlagSwitchButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class PVPFlagSwitchButton extends AbstractFlagSwitchButton {

	public PVPFlagSwitchButton(AbstractGUI gui, ClaimedResidence res) {
		super(gui, res);
	}

	@Override
	public String getFlagString() {
		return "pvp";
	}

	@Override
	public String getFlagDescription() {
		return "PVP";
	}

	@Override
	public String getTrueDescription() {
		return "玩家可以在这个领地里PVP";
	}

	@Override
	public String getFalseDescription() {
		return "玩家不可以在这个领地里PVP";
	}

	@Override
	public String getToTrueClickTip() {
		return "点击来允许玩家在这个领地PVP";
	}

	@Override
	public String getToFalseClickTip() {
		return "点击来禁止玩家在这个领地PVP";
	}

	@Override
	public Material getButtonMaterial() {
		return Material.DIAMOND_SWORD;
	}

}
