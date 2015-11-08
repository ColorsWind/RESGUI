package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.FlagSwitchButtons;

import org.bukkit.Material;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.AbstractFlagSwitchButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;

public class BuildFlagSwitchButton extends AbstractFlagSwitchButton{

	public BuildFlagSwitchButton(AbstractGUI gui, ClaimedResidence res) {
		super(gui, res);
	}

	@Override
	public String getFlagString() {
		return "build";
	}

	@Override
	public String getFlagDescription() {
		return "建筑权限";
	}

	@Override
	public String getTrueDescription() {
		return "其他玩家可以在这个领地内进行建筑";
	}

	@Override
	public String getFalseDescription() {
		return "其他玩家不可以在这个领地内进行建筑";
	}

	@Override
	public String getToTrueClickTip() {
		return "点击来允许其他玩家在这个领地内进行建筑";
	}

	@Override
	public String getToFalseClickTip() {
		return "点击来禁止其他玩家在这个领地内进行建筑";
	}

	@Override
	public Material getButtonMaterial() {
		return Material.DIAMOND_PICKAXE;
	}
	
}
