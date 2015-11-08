package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.FlagSwitchButtons;

import org.bukkit.Material;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.AbstractFlagSwitchButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;

public class UseFlagSwitchButton extends AbstractFlagSwitchButton {

	public UseFlagSwitchButton(AbstractGUI gui, ClaimedResidence res) {
		super(gui, res);
	}

	@Override
	public String getFlagString() {
		return "use";
	}

	@Override
	public String getFlagDescription() {
		return "使用权限";
	}

	@Override
	public String getTrueDescription() {
		return "其他玩家可以与这个领地内的拉杆等物品进行交互";
	}

	@Override
	public String getFalseDescription() {
		return "其他玩家不可以与这个领地内的拉杆等物品进行交互";
	}

	@Override
	public String getToTrueClickTip() {
		return "点击来允许其他玩家与这个领地内的拉杆等物品进行交互";
	}

	@Override
	public String getToFalseClickTip() {
		return "点击来禁止其他玩家与这个领地内的拉杆等物品进行交互";
	}

	@Override
	public Material getButtonMaterial() {
		return Material.LEVER;
	}

}
