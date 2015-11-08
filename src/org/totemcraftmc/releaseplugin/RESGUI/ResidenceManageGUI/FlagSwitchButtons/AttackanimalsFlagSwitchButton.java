package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.FlagSwitchButtons;

import org.bukkit.Material;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.AbstractFlagSwitchButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;

public class AttackanimalsFlagSwitchButton extends AbstractFlagSwitchButton {

	public AttackanimalsFlagSwitchButton(AbstractGUI gui, ClaimedResidence res) {
		super(gui, res);
	}

	@Override
	public String getFlagString() {
		return "attackanimals";
	}

	@Override
	public String getFlagDescription() {
		return "��������Ȩ��";
	}

	@Override
	public String getTrueDescription() {
		return "������ҿ��Թ�����������Ķ���";
	}

	@Override
	public String getFalseDescription() {
		return "������Ҳ����Թ�����������Ķ���";
	}

	@Override
	public String getToTrueClickTip() {
		return "���������������ҹ�����������Ķ���";				
	}

	@Override
	public String getToFalseClickTip() {
		return "�������ֹ������ҹ�����������Ķ���";
	}

	@Override
	public Material getButtonMaterial() {
		return Material.DIAMOND_SWORD;
	}

}
