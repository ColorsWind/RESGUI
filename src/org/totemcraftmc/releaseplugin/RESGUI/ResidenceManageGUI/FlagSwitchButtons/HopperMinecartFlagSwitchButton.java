package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.FlagSwitchButtons;

import org.bukkit.Material;
import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.AbstractFlagSwitchButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class HopperMinecartFlagSwitchButton extends AbstractFlagSwitchButton {

	public HopperMinecartFlagSwitchButton(AbstractGUI gui, ClaimedResidence res) {
		super(gui, res);
	}

	@Override
	public String getFlagString() {
		return "hopperminecart";
	}

	@Override
	public String getFlagDescription() {
		return "©����";
	}

	@Override
	public String getTrueDescription() {
		return "©�������������﹤��";
	}

	@Override
	public String getFalseDescription() {
		return "©�������������ﲻ����";
	}

	@Override
	public String getToTrueClickTip() {
		return "���������©�������������﹤��";
	}

	@Override
	public String getToFalseClickTip() {
		return "�������ֹ©�������������﹤��";
	}

	@Override
	public Material getButtonMaterial() {
		return Material.HOPPER_MINECART;
	}

}
