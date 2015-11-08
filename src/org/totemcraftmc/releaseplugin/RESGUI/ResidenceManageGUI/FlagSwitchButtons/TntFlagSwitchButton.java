package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.FlagSwitchButtons;

import org.bukkit.Material;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.AbstractFlagSwitchButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;

public class TntFlagSwitchButton extends AbstractFlagSwitchButton {

	public TntFlagSwitchButton(AbstractGUI gui, ClaimedResidence res) {
		super(gui, res);
	}

	@Override
	public String getFlagString() {
		return "tnt";
	}

	@Override
	public String getFlagDescription() {
		return "TNT爆炸";
	}

	@Override
	public String getTrueDescription() {
		return "TNT可以在这个领地里爆炸";
	}

	@Override
	public String getFalseDescription() {
		return "TNT不能在这个领地里爆炸";
	}

	@Override
	public String getToTrueClickTip() {
		return "点击来允许TNT在这个领地里爆炸";
	}

	@Override
	public String getToFalseClickTip() {
		return "点击来禁止TNT在这个领地里爆炸";
	}

	@Override
	public Material getButtonMaterial() {
		return Material.TNT;
	}

}
