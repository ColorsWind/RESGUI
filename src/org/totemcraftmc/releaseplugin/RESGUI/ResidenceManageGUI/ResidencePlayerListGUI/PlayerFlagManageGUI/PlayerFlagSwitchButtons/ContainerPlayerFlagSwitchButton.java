package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.ResidencePlayerListGUI.PlayerFlagManageGUI.PlayerFlagSwitchButtons;

import org.bukkit.Material;
import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.ResidencePlayerListGUI.PlayerFlagManageGUI.AbstractPlayerFlagSwitchButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class ContainerPlayerFlagSwitchButton extends
		AbstractPlayerFlagSwitchButton {

	public ContainerPlayerFlagSwitchButton(AbstractGUI gui, String uuid, String playerName,
			ClaimedResidence res) {
		super(gui, uuid, playerName, res);
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
		return playerName+" 可以访问这个领地内的容器";
	}

	@Override
	public String getFalseDescription() {
		return playerName+" 不可以访问这个领地内的容器";
	}

	@Override
	public String getToTrueClickTip() {
		return "点击来允许 "+playerName+" 访问这个领地内的容器";
	}

	@Override
	public String getToFalseClickTip() {
		return "点击来禁止 "+playerName+" 访问这个领地内的容器";
	}

	@Override
	public Material getButtonMaterial() {
		return Material.CHEST;
	}

}
