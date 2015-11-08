package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.ResidencePlayerListGUI.PlayerFlagManageGUI.PlayerFlagSwitchButtons;

import org.bukkit.Material;
import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.ResidencePlayerListGUI.PlayerFlagManageGUI.AbstractPlayerFlagSwitchButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class AttackanimalsPlayerFlagSwitchButton extends
		AbstractPlayerFlagSwitchButton {

	public AttackanimalsPlayerFlagSwitchButton(AbstractGUI gui,String uuid,
			String playerName, ClaimedResidence res) {
		super(gui, uuid, playerName, res);
	}

	@Override
	public String getFlagString() {
		return "attackanimals";
	}

	@Override
	public String getFlagDescription() {
		return "��������Ȩ��";
	}

	@Override
	public String getTrueDescription() {
		return playerName +" ���Թ�����������Ķ���";
	}

	@Override
	public String getFalseDescription() {
		return playerName +" �����Թ�����������Ķ���";
	}

	@Override
	public String getToTrueClickTip() {
		return "��������� "+playerName+" ������������Ķ���";				
	}

	@Override
	public String getToFalseClickTip() {
		return "�������ֹ "+playerName+" ������������Ķ���";
	}

	@Override
	public Material getButtonMaterial() {
		return Material.DIAMOND_SWORD;
	}

}
