package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.FlagSwitchButtons;

import org.bukkit.Material;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.AbstractFlagSwitchButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;

public class LavaflowFlagSwitchButton extends AbstractFlagSwitchButton {

	public LavaflowFlagSwitchButton(AbstractGUI gui, ClaimedResidence res) {
		super(gui, res);
	}

	@Override
	public String getFlagString() {
		return "lavaflow";
	}

	@Override
	public String getFlagDescription() {
		return "液体流动§r[§c岩浆§f]";
	}

	@Override
	public String getTrueDescription() {
		return "岩浆可以在这个领地里流动";
	}

	@Override
	public String getFalseDescription() {
		return "岩浆不能在这个领地里流动";
	}

	@Override
	public String getToTrueClickTip() {
		return "点击来允许岩浆在这个领地里流动";
	}

	@Override
	public String getToFalseClickTip() {
		return "点击来禁止岩浆在这个领地里流动";
	}

	@Override
	public Material getButtonMaterial() {
		return Material.LAVA_BUCKET;
	}

}
