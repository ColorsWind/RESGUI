package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.FlagSwitchButtons;

import org.bukkit.Material;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.AbstractFlagSwitchButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;

public class WaterflowFlagSwitchButton extends AbstractFlagSwitchButton {

	public WaterflowFlagSwitchButton(AbstractGUI gui, ClaimedResidence res) {
		super(gui, res);
	}

	@Override
	public String getFlagString() {
		return "waterflow";
	}

	@Override
	public String getFlagDescription() {
		return "Һ��������r[��bˮ��r]";
	}

	@Override
	public String getTrueDescription() {
		return "ˮ������������������";
	}

	@Override
	public String getFalseDescription() {
		return "ˮ��������������������";
	}

	@Override
	public String getToTrueClickTip() {
		return "���������Һ����������������";
	}

	@Override
	public String getToFalseClickTip() {
		return "�������ֹҺ����������������";
	}

	@Override
	public Material getButtonMaterial() {
		return Material.WATER_BUCKET;
	}

}
