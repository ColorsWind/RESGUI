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
		return "�ƶ�Ȩ��";
	}

	@Override
	public String getTrueDescription() {
		return "������ҿ��������������ƶ�";
	}

	@Override
	public String getFalseDescription() {
		return "������Ҳ��������������ƶ�";
	}

	@Override
	public String getToTrueClickTip() {
		return "���������������������������ƶ�";
	}

	@Override
	public String getToFalseClickTip() {
		return "�������ֹ������������������ƶ�";
	}

	@Override
	public Material getButtonMaterial() {
		return Material.LEATHER_BOOTS;
	}

}
