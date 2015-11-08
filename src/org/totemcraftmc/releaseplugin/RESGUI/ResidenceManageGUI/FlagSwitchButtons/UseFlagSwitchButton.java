package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.FlagSwitchButtons;

import org.bukkit.Material;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.AbstractFlagSwitchButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;

public class UseFlagSwitchButton extends AbstractFlagSwitchButton {

	public UseFlagSwitchButton(AbstractGUI gui, ClaimedResidence res) {
		super(gui, res);
	}

	@Override
	public String getFlagString() {
		return "use";
	}

	@Override
	public String getFlagDescription() {
		return "ʹ��Ȩ��";
	}

	@Override
	public String getTrueDescription() {
		return "������ҿ������������ڵ����˵���Ʒ���н���";
	}

	@Override
	public String getFalseDescription() {
		return "������Ҳ��������������ڵ����˵���Ʒ���н���";
	}

	@Override
	public String getToTrueClickTip() {
		return "�������������������������ڵ����˵���Ʒ���н���";
	}

	@Override
	public String getToFalseClickTip() {
		return "�������ֹ����������������ڵ����˵���Ʒ���н���";
	}

	@Override
	public Material getButtonMaterial() {
		return Material.LEVER;
	}

}
