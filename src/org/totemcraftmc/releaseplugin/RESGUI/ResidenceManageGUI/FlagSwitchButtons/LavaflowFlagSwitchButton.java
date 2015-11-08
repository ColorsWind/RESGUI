package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.FlagSwitchButtons;

import org.bukkit.Material;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.AbstractFlagSwitchButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;

public class LavaflowFlagSwitchButton extends AbstractFlagSwitchButton {

	public LavaflowFlagSwitchButton(AbstractGUI gui, ClaimedResidence res) {
		super(gui, res);
	}

	@Override
	public String getFlagString() {
		return "lavaflow";
	}

	@Override
	public String getFlagDescription() {
		return "Һ��������r[��c�ҽ���f]";
	}

	@Override
	public String getTrueDescription() {
		return "�ҽ�������������������";
	}

	@Override
	public String getFalseDescription() {
		return "�ҽ�������������������";
	}

	@Override
	public String getToTrueClickTip() {
		return "����������ҽ���������������";
	}

	@Override
	public String getToFalseClickTip() {
		return "�������ֹ�ҽ���������������";
	}

	@Override
	public Material getButtonMaterial() {
		return Material.LAVA_BUCKET;
	}

}
