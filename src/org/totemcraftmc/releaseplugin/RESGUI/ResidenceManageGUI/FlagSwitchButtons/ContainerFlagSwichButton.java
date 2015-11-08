package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.FlagSwitchButtons;

import org.bukkit.Material;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.AbstractFlagSwitchButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;

public class ContainerFlagSwichButton extends AbstractFlagSwitchButton {

	public ContainerFlagSwichButton(AbstractGUI gui, ClaimedResidence res) {
		super(gui, res);
	}

	@Override
	public String getFlagString() {
		return "container";
	}

	@Override
	public String getFlagDescription() {
		return "访问容器权限";
	}

	@Override
	public String getTrueDescription() {
		return "其他玩家可以访问这个领地内的容器";
	}

	@Override
	public String getFalseDescription() {
		return "其他玩家不可以访问这个领地内的容器";
	}

	@Override
	public String getToTrueClickTip() {
		return "点击来允许其他玩家访问这个领地内的容器";
	}

	@Override
	public String getToFalseClickTip() {
		return "点击来禁止其他玩家访问这个领地内的容器";
	}

	@Override
	public Material getButtonMaterial() {
		return Material.CHEST;
	}

}
