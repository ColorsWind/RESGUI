package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.FlagSwitchButtons;

import org.bukkit.Material;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.AbstractFlagSwitchButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;

public class CreeperFlagSwitchButton extends AbstractFlagSwitchButton {

	public CreeperFlagSwitchButton(AbstractGUI gui, ClaimedResidence res) {
		super(gui, res);
	}

	@Override
	public String getFlagString() {
		return "creeper";
	}

	@Override
	public String getFlagDescription() {
		return "爬行者爆炸";
	}

	@Override
	public String getTrueDescription() {
		return "爬行者可以在这个领地里爆炸";
	}

	@Override
	public String getFalseDescription() {
		return "爬行者不可以在这个领地里爆炸";
	}

	@Override
	public String getToTrueClickTip() {
		return "点击来允许爬行者在这个领地里爆炸";
	}

	@Override
	public String getToFalseClickTip() {
		return "点击来禁止爬行者在这个领地里爆炸";
	}

	@Override
	public Material getButtonMaterial() {
		return Material.SULPHUR;
	}

}
