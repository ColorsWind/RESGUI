package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.ResidencePlayerListGUI.PlayerFlagManageGUI.PlayerFlagSwitchButtons;

import org.bukkit.Material;
import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.ResidencePlayerListGUI.PlayerFlagManageGUI.AbstractPlayerFlagSwitchButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

public class AttackanimalsPlayerFlagSwitchButton extends
		AbstractPlayerFlagSwitchButton {

	public AttackanimalsPlayerFlagSwitchButton(AbstractGUI gui,String uuid,
			String playerName, ClaimedResidence res) {
		super(gui, uuid, playerName, res);
	}

	@Override
	public String getFlagString() {
		return "attackanimals";
	}

	@Override
	public String getFlagDescription() {
		return "攻击动物权限";
	}

	@Override
	public String getTrueDescription() {
		return playerName +" 可以攻击这个领地里的动物";
	}

	@Override
	public String getFalseDescription() {
		return playerName +" 不可以攻击这个领地里的动物";
	}

	@Override
	public String getToTrueClickTip() {
		return "点击来允许 "+playerName+" 攻击这个领地里的动物";				
	}

	@Override
	public String getToFalseClickTip() {
		return "点击来禁止 "+playerName+" 攻击这个领地里的动物";
	}

	@Override
	public Material getButtonMaterial() {
		return Material.DIAMOND_SWORD;
	}

}
