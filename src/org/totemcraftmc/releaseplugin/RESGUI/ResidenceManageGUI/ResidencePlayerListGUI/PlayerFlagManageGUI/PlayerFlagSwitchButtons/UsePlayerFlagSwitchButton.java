package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.ResidencePlayerListGUI.PlayerFlagManageGUI.PlayerFlagSwitchButtons;

import org.bukkit.Material;
import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.ResidencePlayerListGUI.PlayerFlagManageGUI.AbstractPlayerFlagSwitchButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class UsePlayerFlagSwitchButton extends AbstractPlayerFlagSwitchButton {

	public UsePlayerFlagSwitchButton(AbstractGUI gui, String uuid, String playerName,
			ClaimedResidence res) {
		super(gui, uuid, playerName, res);
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
		return playerName+" �������������ڵ����˵���Ʒ���н���";
	}

	@Override
	public String getFalseDescription() {
		return playerName+" ���������������ڵ����˵���Ʒ���н���";
	}

	@Override
	public String getToTrueClickTip() {
		return "��������� "+playerName+" ���������ڵ����˵���Ʒ���н���";
	}

	@Override
	public String getToFalseClickTip() {
		return "�������ֹ "+playerName+" ���������ڵ����˵���Ʒ���н���";
	}


	@Override
	public Material getButtonMaterial() {
		return Material.LEVER;
	}

}
