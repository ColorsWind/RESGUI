package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.FlagSwitchButtons;

import org.bukkit.Material;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.AbstractFlagSwitchButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;

public class FlowFlagSwtichButton extends AbstractFlagSwitchButton {

	public FlowFlagSwtichButton(AbstractGUI gui, ClaimedResidence res) {
		super(gui, res);
	}

	@Override
	public String getFlagString() {
		return "flow";
	}

	@Override
	public String getFlagDescription() {
		return "液体流动§r[§b水§r/§c岩浆 §d(总开关)§r]";
	}

	@Override
	public String getTrueDescription() {
		return "液体可以在这个领地里流动";
	}

	@Override
	public String getFalseDescription() {
		return "液体不能在这个领地里流动";
	}

	@Override
	public String getToTrueClickTip() {
		return "点击来允许液体在这个领地里流动";
	}

	@Override
	public String getToFalseClickTip() {
		return "点击来禁止液体在这个领地里流动";
	}

	@Override
	public Material getButtonMaterial() {
		return Material.BUCKET;
	}

}
