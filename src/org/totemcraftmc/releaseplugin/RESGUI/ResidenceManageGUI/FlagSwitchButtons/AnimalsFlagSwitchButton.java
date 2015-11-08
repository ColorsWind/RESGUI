package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.FlagSwitchButtons;

import org.bukkit.Material;
import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.AbstractFlagSwitchButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class AnimalsFlagSwitchButton extends AbstractFlagSwitchButton {

	public AnimalsFlagSwitchButton(AbstractGUI gui, ClaimedResidence res) {
		super(gui, res);
	}

	@Override
	public String getFlagString() {
		return "animals";
	}

	@Override
	public String getFlagDescription() {
		return "��������";
	}

	@Override
	public String getTrueDescription() {
		return "������������ɶ���";
	}

	@Override
	public String getFalseDescription() {
		return "�������ﲻ�����ɶ���";
	}

	@Override
	public String getToTrueClickTip() {
		return "�������������������������";
	}

	@Override
	public String getToFalseClickTip() {
		return "�������ֹ������������������";
	}

	@Override
	public Material getButtonMaterial() {
		return Material.LEATHER;
	}

}
