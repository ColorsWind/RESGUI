package org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.ResidencePlayerListGUI.PlayerFlagManageGUI;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import com.bekvon.bukkit.residence.protection.ClaimedResidence;

import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.LineButton;
import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.ResidencePlayerListGUI.PlayerFlagManageGUI.PlayerFlagSwitchButtons.AttackanimalsPlayerFlagSwitchButton;
import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.ResidencePlayerListGUI.PlayerFlagManageGUI.PlayerFlagSwitchButtons.BuildPlayerFlagSwtichButton;
import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.ResidencePlayerListGUI.PlayerFlagManageGUI.PlayerFlagSwitchButtons.ContainerPlayerFlagSwitchButton;
import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.ResidencePlayerListGUI.PlayerFlagManageGUI.PlayerFlagSwitchButtons.MovePlayerFlagSwitchButton;
import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.ResidencePlayerListGUI.PlayerFlagManageGUI.PlayerFlagSwitchButtons.TpPlayerFlagSwitchButton;
import org.totemcraftmc.releaseplugin.RESGUI.ResidenceManageGUI.ResidencePlayerListGUI.PlayerFlagManageGUI.PlayerFlagSwitchButtons.UsePlayerFlagSwitchButton;
import org.totemcraftmc.releaseplugin.lib.GUILib.AbstractGUI.AbstractGUI;

public class PlayerFlagManageGUI extends AbstractGUI {

	final ClaimedResidence res;
	final String uuid;
	private String playerName;

	public PlayerFlagManageGUI(Player p, String uuid, ClaimedResidence res) {
		super(p);
		this.res = res;
		this.uuid = uuid;

		if (uuid.matches("^[a-z0-9]{8}-[a-z0-9]{4}-[a-z0-9]{4}-[a-z0-9]{4}-[a-z0-9]{12}$")) {
			OfflinePlayer pl = Bukkit.getOfflinePlayer(UUID.fromString(uuid));
			playerName = pl.getName();
		} else {
			playerName = uuid;
		}

		registerButton(new BuildPlayerFlagSwtichButton(this, uuid, playerName, res), 0);
		registerButton(new UsePlayerFlagSwitchButton(this, uuid, playerName, res), 1);
		registerButton(new ContainerPlayerFlagSwitchButton(this, uuid, playerName, res), 2);
//		registerButton(new AttackanimalsPlayerFlagSwitchButton(this, uuid, playerName, res), 3);
		registerButton(new MovePlayerFlagSwitchButton(this, uuid, playerName, res), 3);
		registerButton(new TpPlayerFlagSwitchButton(this, uuid, playerName, res), 4);

		LineButton lineButton = new LineButton(this);
		for (int i = 9; i <= 17; i++) {
			registerButton(lineButton, i);
		}

		registerButton(new BackButton(this, res), 18);

	}

	@Override
	public void onClose() {
		return;
	}

	@Override
	public String getTitle() {
		return "领地 " + res.getName() + " 玩家 " + playerName + " 权限控制面板";
	}

	public ClaimedResidence getResidence() {
		return res;
	}

}
