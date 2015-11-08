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
		return "�����˶�";
	}

	@Override
	public String getTrueDescription() {
		return "�������������������˶�";
	}

	@Override
	public String getFalseDescription() {
		return "���������������������˶�";
	}

	@Override
	public String getToTrueClickTip() {
		return "�����������������������˶�";
	}

	@Override
	public String getToFalseClickTip() {
		return "�������ֹ���������������˶�";
	}

	@Override
	public Material getButtonMaterial() {
		return Material.PISTON_BASE;
	}

}
