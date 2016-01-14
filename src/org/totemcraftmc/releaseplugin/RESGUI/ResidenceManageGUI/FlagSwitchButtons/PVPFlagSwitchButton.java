package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.FlagSwitchButtons;

import org.bukkit.Material;
import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.AbstractFlagSwitchButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class PVPFlagSwitchButton extends AbstractFlagSwitchButton {

	public PVPFlagSwitchButton(AbstractGUI gui, ClaimedResidence res) {
		super(gui, res);
	}

	@Override
	public String getFlagString() {
		return "pvp";
	}

	@Override
	public String getFlagDescription() {
		return "PVP";
	}

	@Override
	public String getTrueDescription() {
		return "��ҿ�������������PVP";
	}

	@Override
	public String getFalseDescription() {
		return "��Ҳ���������������PVP";
	}

	@Override
	public String getToTrueClickTip() {
		return "��������������������PVP";
	}

	@Override
	public String getToFalseClickTip() {
		return "�������ֹ�����������PVP";
	}

	@Override
	public Material getButtonMaterial() {
		return Material.DIAMOND_SWORD;
	}

}
