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
		target.sendMessage("��û��ʹ�ø������Ȩ��");
	}
	
	public static void noPlayerFoundMessage(CommandSender target,String playerName){
		target.sendMessage("�Ҳ�������"+playerName+"�����");
	}
	
	public static void illegalArgumentMessage(CommandSender target){
		target.sendMessage("��������ȷ");
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
	 * ûʲô����
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
