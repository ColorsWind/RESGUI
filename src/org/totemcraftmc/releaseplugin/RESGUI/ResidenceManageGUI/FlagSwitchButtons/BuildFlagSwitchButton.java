package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.FlagSwitchButtons;

import org.bukkit.Material;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.AbstractFlagSwitchButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;

public class BuildFlagSwitchButton extends AbstractFlagSwitchButton{

	public BuildFlagSwitchButton(AbstractGUI gui, ClaimedResidence res) {
		super(gui, res);
	}

	@Override
	public String getFlagString() {
		return "build";
	}

	@Override
	public String getFlagDescription() {
		return "����Ȩ��";
	}

	@Override
	public String getTrueDescription() {
		return "������ҿ������������ڽ��н���";
	}

	@Override
	public String getFalseDescription() {
		return "������Ҳ��������������ڽ��н���";
	}

	@Override
	public String getToTrueClickTip() {
		return "�������������������������ڽ��н���";
	}

	@Override
	public String getToFalseClickTip() {
		return "�������ֹ����������������ڽ��н���";
	}

	@Override
	public Material getButtonMaterial() {
		return Material.DIAMOND_PICKAXE;
	}
	
}
