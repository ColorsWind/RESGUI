package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.FlagSwitchButtons;

import org.bukkit.Material;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.AbstractFlagSwitchButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;

public class TpFlagSwitchButton extends AbstractFlagSwitchButton {

	public TpFlagSwitchButton(AbstractGUI gui, ClaimedResidence res) {
		super(gui, res);
	}

	@Override
	public String getFlagString() {
		return "tp";
	}

	@Override
	public String getFlagDescription() {
		return "����Ȩ��";
	}

	@Override
	public String getTrueDescription() {
		return "������ҿ��Դ��͵�������";
	}

	@Override
	public String getFalseDescription() {
		return "������Ҳ��ܴ��͵�������";
	}

	@Override
	public String getToTrueClickTip() {
		return "���������������Ҵ��͵�������";
	}

	@Override
	public String getToFalseClickTip() {
		return "�������ֹ������Ҵ��͵�������";
	}

	@Override
	public Material getButtonMaterial() {
		return Material.ENDER_PEARL;
	}

}
