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
		return "漏斗矿车";
	}

	@Override
	public String getTrueDescription() {
		return "漏斗矿车在这个领地里工作";
	}

	@Override
	public String getFalseDescription() {
		return "漏斗矿车在这个领地里不工作";
	}

	@Override
	public String getToTrueClickTip() {
		return "点击来允许漏斗矿车在这个领地里工作";
	}

	@Override
	public String getToFalseClickTip() {
		return "点击来禁止漏斗矿车在这个领地里工作";
	}

	@Override
	public Material getButtonMaterial() {
		return Material.HOPPER_MINECART;
	}

}
