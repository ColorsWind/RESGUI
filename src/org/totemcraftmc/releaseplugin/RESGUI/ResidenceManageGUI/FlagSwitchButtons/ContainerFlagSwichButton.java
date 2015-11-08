package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.FlagSwitchButtons;

import org.bukkit.Material;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.AbstractFlagSwitchButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;

public class ContainerFlagSwichButton extends AbstractFlagSwitchButton {

	public ContainerFlagSwichButton(AbstractGUI gui, ClaimedResidence res) {
		super(gui, res);
	}

	@Override
	public String getFlagString() {
		return "container";
	}

	@Override
	public String getFlagDescription() {
		return "��������Ȩ��";
	}

	@Override
	public String getTrueDescription() {
		return "������ҿ��Է����������ڵ�����";
	}

	@Override
	public String getFalseDescription() {
		return "������Ҳ����Է����������ڵ�����";
	}

	@Override
	public String getToTrueClickTip() {
		return "���������������ҷ����������ڵ�����";
	}

	@Override
	public String getToFalseClickTip() {
		return "�������ֹ������ҷ����������ڵ�����";
	}

	@Override
	public Material getButtonMaterial() {
		return Material.CHEST;
	}

}
