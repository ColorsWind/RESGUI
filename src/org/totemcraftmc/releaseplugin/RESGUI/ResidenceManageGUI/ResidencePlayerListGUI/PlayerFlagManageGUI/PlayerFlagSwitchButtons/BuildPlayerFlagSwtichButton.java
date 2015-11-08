package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.ResidencePlayerListGUI.PlayerFlagManageGUI.PlayerFlagSwitchButtons;

import org.bukkit.Material;
import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.ResidencePlayerListGUI.PlayerFlagManageGUI.AbstractPlayerFlagSwitchButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class BuildPlayerFlagSwtichButton extends AbstractPlayerFlagSwitchButton {

	public BuildPlayerFlagSwtichButton(AbstractGUI gui,String uuid, String playerName,
			ClaimedResidence res) {
		super(gui,uuid, playerName, res);
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
		return playerName+" �������������ｨ��";
	}

	@Override
	public String getFalseDescription() {
		return playerName+" �������������ｨ��";
	}

	@Override
	public String getToTrueClickTip() {
		return "��������� "+playerName+" ���������ｨ��";
	}

	@Override
	public String getToFalseClickTip() {
		return "�������ֹ "+playerName+" ���������ｨ��";
	}

	@Override
	public Material getButtonMaterial() {
		return Material.DIAMOND_PICKAXE;
	}

}
