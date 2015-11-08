package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.ResidencePlayerListGUI.PlayerFlagManageGUI.PlayerFlagSwitchButtons;

import org.bukkit.Material;
import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.ResidencePlayerListGUI.PlayerFlagManageGUI.AbstractPlayerFlagSwitchButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class MovePlayerFlagSwitchButton extends AbstractPlayerFlagSwitchButton {

	public MovePlayerFlagSwitchButton(AbstractGUI gui, String uuid, String playerName,
			ClaimedResidence res) {
		super(gui, uuid, playerName, res);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getFlagString() {
		return "move";
	}

	@Override
	public String getFlagDescription() {
		return "�ƶ�Ȩ��";
	}

	@Override
	public String getTrueDescription() {
		return playerName+" ���������������ƶ�";
	}

	@Override
	public String getFalseDescription() {
		return playerName+" ���������������ƶ�";
	}

	@Override
	public String getToTrueClickTip() {
		return "��������� "+playerName+" �����������ƶ�";
	}

	@Override
	public String getToFalseClickTip() {
		return "�������ֹ "+playerName+" �����������ƶ�";
	}

	@Override
	public Material getButtonMaterial() {
		return Material.LEATHER_BOOTS;
	}

}
