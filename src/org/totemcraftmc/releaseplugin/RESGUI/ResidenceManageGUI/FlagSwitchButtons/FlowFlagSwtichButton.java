package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.FlagSwitchButtons;

import org.bukkit.Material;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.AbstractFlagSwitchButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;

public class FlowFlagSwtichButton extends AbstractFlagSwitchButton {

	public FlowFlagSwtichButton(AbstractGUI gui, ClaimedResidence res) {
		super(gui, res);
	}

	@Override
	public String getFlagString() {
		return "flow";
	}

	@Override
	public String getFlagDescription() {
		return "Һ��������r[��bˮ��r/��c�ҽ� ��d(�ܿ���)��r]";
	}

	@Override
	public String getTrueDescription() {
		return "Һ�������������������";
	}

	@Override
	public String getFalseDescription() {
		return "Һ�岻����������������";
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
		return Material.BUCKET;
	}

}
