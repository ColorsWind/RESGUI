package org.totemcraftmc.releaseplugin.lib.AdvancedMessage;

import com.google.gson.stream.JsonWriter;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AdvancedMessage {

	public AdvancedMessage(String firstPartText) {
		messageParts.add(new MessagePart(firstPartText));
	}

	public AdvancedMessage color(ChatColor color) {
		if (!color.isColor()) {
			throw new IllegalArgumentException((new StringBuilder(String.valueOf(color.name())))
					.append(" is not a color").toString());
		} else {
			latest().color = color;
			return this;
		}
	}

	public AdvancedMessage style(ChatColor styles[]) {
		ChatColor achatcolor[];
		int j = (achatcolor = styles).length;
		for (int i = 0; i < j; i++) {
			ChatColor style = achatcolor[i];
			if (!style.isFormat())
				throw new IllegalArgumentException((new StringBuilder(String.valueOf(style.name())))
						.append(" is not a style").toString());
		}

		latest().styles = styles;
		return this;
	}

	public AdvancedMessage file(String path) {
		onClick("open_file", path);
		return this;
	}

	public AdvancedMessage link(String url) {
		onClick("open_url", url);
		return this;
	}

	public AdvancedMessage suggest(String command) {
		onClick("suggest_command", command);
		return this;
	}

	public AdvancedMessage command(String command) {
		onClick("run_command", command);
		return this;
	}

	public AdvancedMessage achievementTooltip(String name) {
		onHover("show_achievement", (new StringBuilder("achievement.")).append(name).toString());
		return this;
	}

	public AdvancedMessage itemTooltip(String itemJSON) {
		onHover("show_item", itemJSON);
		return this;
	}

	public AdvancedMessage itemTooltip(ItemStack itemStack) {
		return itemTooltip(
				CraftItemStack.asNMSCopy(itemStack).save(new NBTTagCompound()).toString());
	}

	public AdvancedMessage tooltip(String text) {
		String lines[] = text.split("\\n");
		if (lines.length <= 1)
			onHover("show_text", text);
		else
			itemTooltip(makeMultilineTooltip(lines));
		return this;
	}

	public AdvancedMessage then(Object obj) {
		messageParts.add(new MessagePart(obj.toString()));
		return this;
	}

	public String toJSONString() {
		StringWriter writer = new StringWriter();
		JsonWriter json = new JsonWriter(writer);

		try {
			if (messageParts.size() == 1) {
				latest().writeJson(json);

			} else {
				json.beginObject().name("text").value("").name("extra").beginArray();

				MessagePart part;
				for (Iterator<MessagePart> iterator = messageParts.iterator(); iterator
						.hasNext(); part.writeJson(json))
					part = iterator.next();

				json.endArray().endObject();
			}
			json.flush();
			writer.flush();
		} catch (IOException e) {
			throw new RuntimeException("invalid message");
		}

		return writer.toString();
	}

	public void send(Player player) {
		((CraftPlayer) player).getHandle().playerConnection
				.sendPacket(new PacketPlayOutChat(ChatSerializer.a(toJSONString())));
	}

	private MessagePart latest() {
		return messageParts.get(messageParts.size() - 1);
	}

	private String makeMultilineTooltip(String lines[]) {
		StringWriter writer = new StringWriter();
		JsonWriter json = new JsonWriter(writer);
		try {
			json.beginObject().name("id").value(1L);
			json.name("tag").beginObject().name("display").beginObject();
			json.name("Name").value((new StringBuilder("\\u00A7f"))
					.append(lines[0].replace("\"", "\\\"")).toString());
			json.name("Lore").beginArray();
			for (int i = 1; i < lines.length; i++) {
				String line = lines[i];
				json.value(line.isEmpty() ? " " : (line.replace("\"", "\\\"")));
			}

			json.endArray().endObject().endObject().endObject();

			json.flush();
			json.close();
			writer.flush();
		} catch (IOException e) {
			throw new RuntimeException("invalid tooltip");
		}
		return writer.toString();
	}

	private void onClick(String name, String data) {
		MessagePart latest = latest();
		latest.clickActionName = name;
		latest.clickActionData = data;
	}

	private void onHover(String name, String data) {
		MessagePart latest = latest();
		latest.hoverActionName = name;
		latest.hoverActionData = data;
	}

	private final List<MessagePart> messageParts = new ArrayList<MessagePart>();

	public static class MessagePart {

		public JsonWriter writeJson(JsonWriter json) throws IOException {
			json.beginObject().name("text").value(text);
			if (color != null) {
				json.name("color").value(color.name().toLowerCase());
			}
			if (styles != null) {
				ChatColor achatcolor[];
				int j = (achatcolor = styles).length;
				for (int i = 0; i < j; i++) {
					ChatColor style = achatcolor[i];
					json.name(style != ChatColor.UNDERLINE ? style.name().toLowerCase()
							: "underlined").value(true);
				}

			}
			if (clickActionName != null && clickActionData != null) {
				json.name("clickEvent").beginObject().name("action").value(clickActionName)
						.name("value").value(clickActionData).endObject();
			}
			if (hoverActionName != null && hoverActionData != null) {
				json.name("hoverEvent").beginObject().name("action").value(hoverActionName)
						.name("value").value(hoverActionData).endObject();
			}
			return json.endObject();
		}

		public ChatColor color;
		public ChatColor styles[];
		public String clickActionName;
		public String clickActionData;
		public String hoverActionName;
		public String hoverActionData;
		public final String text;

		public MessagePart(String text) {
			color = null;
			styles = null;
			clickActionName = null;
			clickActionData = null;
			hoverActionName = null;
			hoverActionData = null;
			this.text = text;
		}
	}

}