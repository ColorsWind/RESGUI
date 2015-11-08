package org.totemcraftmc.releaseplugin.lib.Utils;

import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction;
import net.minecraft.server.v1_8_R3.PlayerConnection;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public final class TitleUtil {

	private TitleUtil() {}
	
	public static void sendTitle(Player player,String jsonMessage,int fadein,int keep,int fadeout){
		if(player==null){
			return;
		}
		PacketPlayOutTitle setTime = new PacketPlayOutTitle(fadein, keep, fadeout);
		PacketPlayOutTitle title = new PacketPlayOutTitle(EnumTitleAction.TITLE, ChatSerializer.a(jsonMessage));
		PlayerConnection conn = ((CraftPlayer)player).getHandle().playerConnection;
		if(conn==null){
			return;
		}
		conn.sendPacket(setTime);
		conn.sendPacket(title);
	}
	
	public static void sendSubTitle(Player player,String jsonMessage){
		if(player ==null)return;
		PacketPlayOutTitle subTitle = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, ChatSerializer.a(jsonMessage));
		PlayerConnection conn = ((CraftPlayer)player).getHandle().playerConnection;
		if(conn==null)return;
		conn.sendPacket(subTitle);
	}
	
}
