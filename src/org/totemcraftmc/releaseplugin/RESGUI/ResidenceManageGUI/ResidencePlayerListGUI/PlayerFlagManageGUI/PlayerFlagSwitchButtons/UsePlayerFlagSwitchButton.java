package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.ResidencePlayerListGUI.PlayerFlagManageGUI.PlayerFlagSwitchButtons;

import org.bukkit.Material;
import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.ResidencePlayerListGUI.PlayerFlagManageGUI.AbstractPlayerFlagSwitchButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class UsePlayerFlagSwitchButton extends AbstractPlayerFlagSwitchButton {

	public UsePlayerFlagSwitchButton(AbstractGUI gui, String uuid, String playerName,
			ClaimedResidence res) {
		super(gui, uuid, playerName, res);
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
		return playerName+" 可以与这个领地内的拉杆等物品进行交互";
	}

	@Override
	public String getFalseDescription() {
		return playerName+" 不可以与这个领地内的拉杆等物品进行交互";
	}

	@Override
	public String getToTrueClickTip() {
		return "点击来允许 "+playerName+" 与这个领地内的拉杆等物品进行交互";
	}

	@Override
	public String getToFalseClickTip() {
		return "点击来禁止 "+playerName+" 与这个领地内的拉杆等物品进行交互";
	}


	@Override
	public Material getButtonMaterial() {
		return Material.LEVER;
	}

}
