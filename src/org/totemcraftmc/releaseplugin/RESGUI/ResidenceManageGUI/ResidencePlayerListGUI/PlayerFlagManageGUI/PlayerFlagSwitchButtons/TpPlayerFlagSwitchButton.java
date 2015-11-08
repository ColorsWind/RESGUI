package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.ResidencePlayerListGUI.PlayerFlagManageGUI.PlayerFlagSwitchButtons;

import org.bukkit.Material;
import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.ResidencePlayerListGUI.PlayerFlagManageGUI.AbstractPlayerFlagSwitchButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class TpPlayerFlagSwitchButton extends AbstractPlayerFlagSwitchButton {

	public TpPlayerFlagSwitchButton(AbstractGUI gui, String uuid, String playerName,
			ClaimedResidence res) {
		super(gui, uuid, playerName, res);
		// TODO Auto-generated constructor stub
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
		return playerName+" 可以传送到这个领地";
	}

	@Override
	public String getFalseDescription() {
		return playerName+" 不能传送到这个领地";
	}

	@Override
	public String getToTrueClickTip() {
		return "点击来允许 "+playerName+" 传送到这个领地";
	}

	@Override
	public String getToFalseClickTip() {
		return "点击来禁止 "+playerName+" 传送到这个领地";
	}

	@Override
	public Material getButtonMaterial() {
		return Material.ENDER_PEARL;
	}

}
