package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.ResidencePlayerListGUI.PlayerFlagManageGUI.PlayerFlagSwitchButtons;

import org.bukkit.Material;
import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.ResidencePlayerListGUI.PlayerFlagManageGUI.AbstractPlayerFlagSwitchButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class ContainerPlayerFlagSwitchButton extends
		AbstractPlayerFlagSwitchButton {

	public ContainerPlayerFlagSwitchButton(AbstractGUI gui, String uuid, String playerName,
			ClaimedResidence res) {
		super(gui, uuid, playerName, res);
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
		return playerName+" ���Է����������ڵ�����";
	}

	@Override
	public String getFalseDescription() {
		return playerName+" �����Է����������ڵ�����";
	}

	@Override
	public String getToTrueClickTip() {
		return "��������� "+playerName+" �����������ڵ�����";
	}

	@Override
	public String getToFalseClickTip() {
		return "�������ֹ "+playerName+" �����������ڵ�����";
	}

	@Override
	public Material getButtonMaterial() {
		return Material.CHEST;
	}

}
