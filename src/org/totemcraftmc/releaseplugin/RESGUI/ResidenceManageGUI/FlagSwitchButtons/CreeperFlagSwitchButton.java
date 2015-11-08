package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.FlagSwitchButtons;

import org.bukkit.Material;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.AbstractFlagSwitchButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;

public class CreeperFlagSwitchButton extends AbstractFlagSwitchButton {

	public CreeperFlagSwitchButton(AbstractGUI gui, ClaimedResidence res) {
		super(gui, res);
	}

	@Override
	public String getFlagString() {
		return "creeper";
	}

	@Override
	public String getFlagDescription() {
		return "�����߱�ը";
	}

	@Override
	public String getTrueDescription() {
		return "�����߿������������ﱬը";
	}

	@Override
	public String getFalseDescription() {
		return "�����߲��������������ﱬը";
	}

	@Override
	public String getToTrueClickTip() {
		return "������������������������ﱬը";
	}

	@Override
	public String getToFalseClickTip() {
		return "�������ֹ���������������ﱬը";
	}

	@Override
	public Material getButtonMaterial() {
		return Material.SULPHUR;
	}

}
