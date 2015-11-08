package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.ResidencePlayerListGUI.PlayerFlagManageGUI.PlayerFlagSwitchButtons;

import org.bukkit.Material;
import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.ResidencePlayerListGUI.PlayerFlagManageGUI.AbstractPlayerFlagSwitchButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class TpPlayerFlagSwitchButton extends AbstractPlayerFlagSwitchButton {

	public TpPlayerFlagSwitchButton(AbstractGUI gui, String uuid, String playerName,
			ClaimedResidence res) {
		super(gui, uuid, playerName, res);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getFlagString() {
		return "tp";
	}

	@Override
	public String getFlagDescription() {
		return "����Ȩ��";
	}

	@Override
	public String getTrueDescription() {
		return playerName+" ���Դ��͵�������";
	}

	@Override
	public String getFalseDescription() {
		return playerName+" ���ܴ��͵�������";
	}

	@Override
	public String getToTrueClickTip() {
		return "��������� "+playerName+" ���͵�������";
	}

	@Override
	public String getToFalseClickTip() {
		return "�������ֹ "+playerName+" ���͵�������";
	}

	@Override
	public Material getButtonMaterial() {
		return Material.ENDER_PEARL;
	}

}
