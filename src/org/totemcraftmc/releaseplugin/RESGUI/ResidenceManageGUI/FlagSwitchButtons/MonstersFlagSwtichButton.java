package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.FlagSwitchButtons;

import org.bukkit.Material;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.AbstractFlagSwitchButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;

public class MonstersFlagSwtichButton extends AbstractFlagSwitchButton {

	public MonstersFlagSwtichButton(AbstractGUI gui, ClaimedResidence res) {
		super(gui, res);
	}

	@Override
	public String getFlagString() {
		return "monsters";
	}

	@Override
	public String getFlagDescription() {
		return "怪物生成";
	}

	@Override
	public String getTrueDescription() {
		return "这个领地里会生成怪物";
	}

	@Override
	public String getFalseDescription() {
		return "这个领地里不会生成怪物";
	}

	@Override
	public String getToTrueClickTip() {
		return "点击来允许怪物生成在这个领地里";
	}

	@Override
	public String getToFalseClickTip() {
		return "点击来禁止怪物生成在这个领地里";
	}

	@Override
	public Material getButtonMaterial() {
		return Material.MOB_SPAWNER;
	}

}
