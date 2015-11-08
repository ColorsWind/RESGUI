package org.totemcraftmc.releaseplugin.lib.Utils;

import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerListHeaderFooter;

import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public final class MessageUtil {

	private MessageUtil() {}
	
	public static void noPermissionMessage(CommandSender target){
		target.sendMessage("你没有使用该命令的权限");
	}
	
	public static void noPlayerFoundMessage(CommandSender target,String playerName){
		target.sendMessage("找不到叫做"+playerName+"的玩家");
	}
	
	public static void illegalArgumentMessage(CommandSender target){
		target.sendMessage("参数不正确");
	}
	
	public static void actionBarMessage(Player player,String message){
		CraftPlayer p = (CraftPlayer) player;
		net.minecraft.server.v1_8_R3.IChatBaseComponent cbc = ChatSerializer
				.a((new StringBuilder("{\"text\": \""))
						.append(message.replaceAll("&", "\247")).append("\"}")
						.toString());
		PacketPlayOutChat ppoc = new PacketPlayOutChat(cbc, (byte) 2);
		p.getHandle().playerConnection.sendPacket(ppoc);
	}
	
	/**
	 * 没什么卵用
	 * @param player
	 * @param header
	 * @param footer
	 */
	@Deprecated
	public static void listHeaderFooter(Player player,String header,String footer){
		
		String json = "{\"text\": \"}"+header+"\"}";
		
		net.minecraft.server.v1_8_R3.IChatBaseComponent h = ChatSerializer.a(json);
		
		((CraftPlayer)player).getHandle().playerConnection.sendPacket(new PacketPlayOutPlayerListHeaderFooter(h));
		
	}
	
}
