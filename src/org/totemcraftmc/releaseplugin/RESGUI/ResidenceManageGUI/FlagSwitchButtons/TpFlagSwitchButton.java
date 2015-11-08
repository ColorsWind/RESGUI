package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.FlagSwitchButtons;

import org.bukkit.Material;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.AbstractFlagSwitchButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;

public class TpFlagSwitchButton extends AbstractFlagSwitchButton {

	public TpFlagSwitchButton(AbstractGUI gui, ClaimedResidence res) {
		super(gui, res);
	}

	@Override
	public String getFlagString() {
		return "tp";
	}

	@Override
	public String getFlagDescription() {
		return "传送权限";
	}

	@Override
	public String getTrueDescription() {
		return "其他玩家可以传送到这个领地";
	}

	@Override
	public String getFalseDescription() {
		return "其他玩家不能传送到这个领地";
	}

	@Override
	public String getToTrueClickTip() {
		return "点击来允许其他玩家传送到这个领地";
	}

	@Override
	public String getToFalseClickTip() {
		return "点击来禁止其他玩家传送到这个领地";
	}

	@Override
	public Material getButtonMaterial() {
		return Material.ENDER_PEARL;
	}

}
