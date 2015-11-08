package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.FlagSwitchButtons;

import org.bukkit.Material;
import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.AbstractFlagSwitchButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class AnimalsFlagSwitchButton extends AbstractFlagSwitchButton {

	public AnimalsFlagSwitchButton(AbstractGUI gui, ClaimedResidence res) {
		super(gui, res);
	}

	@Override
	public String getFlagString() {
		return "animals";
	}

	@Override
	public String getFlagDescription() {
		return "动物生成";
	}

	@Override
	public String getTrueDescription() {
		return "这个领地里会生成动物";
	}

	@Override
	public String getFalseDescription() {
		return "这个领地里不会生成动物";
	}

	@Override
	public String getToTrueClickTip() {
		return "点击来允许动物生成在这个领地里";
	}

	@Override
	public String getToFalseClickTip() {
		return "点击来禁止动物生成在这个领地里";
	}

	@Override
	public Material getButtonMaterial() {
		return Material.LEATHER;
	}

}
