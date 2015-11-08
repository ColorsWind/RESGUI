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
		return "TNT��ը";
	}

	@Override
	public String getTrueDescription() {
		return "TNT�������������ﱬը";
	}

	@Override
	public String getFalseDescription() {
		return "TNT�������������ﱬը";
	}

	@Override
	public String getToTrueClickTip() {
		return "���������TNT���������ﱬը";
	}

	@Override
	public String getToFalseClickTip() {
		return "�������ֹTNT���������ﱬը";
	}

	@Override
	public Material getButtonMaterial() {
		return Material.TNT;
	}

}
