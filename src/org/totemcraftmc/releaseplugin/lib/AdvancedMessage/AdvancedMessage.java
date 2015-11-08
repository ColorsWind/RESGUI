package org.totemcraftmc.releaseplugin.lib.AdvancedMessage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.sf.json.JSONException;
import net.sf.json.util.JSONBuilder;
import net.sf.json.util.JSONStringer;

import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class AdvancedMessage {

	public AdvancedMessage(String firstPartText) {
		messageParts.add(new MessagePart(firstPartText));
	}

	public AdvancedMessage color(ChatColor color) {
		if (!color.isColor()) {
			throw new IllegalArgumentException((new StringBuilder(
					String.valueOf(color.name()))).append(" is not a color")
					.toString());
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
				throw new IllegalArgumentException((new StringBuilder(
						String.valueOf(style.name())))
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
		onHover("show_achievement",
				(new StringBuilder("achievement.")).append(name).toString());
		return this;
	}

	public AdvancedMessage itemTooltip(String itemJSON) {
		onHover("show_item", itemJSON);
		return this;
	}

	public AdvancedMessage itemTooltip(ItemStack itemStack) {
		return itemTooltip(CraftItemStack.asNMSCopy(itemStack)
				.save(new NBTTagCompound()).toString());
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
		JSONStringer json = new JSONStringer();
		try {
			if (messageParts.size() == 1) {
				latest().writeJson(json);
			} else {
				json.object().key("text").value("").key("extra").array();
				
				MessagePart part;
				for (Iterator<MessagePart> iterator = messageParts.iterator(); iterator
						.hasNext(); part.writeJson(json))
					part = (MessagePart) iterator.next();

				json.endArray().endObject();
			}
		} catch (JSONException | IOException e) {
			throw new RuntimeException("invalid message");
		}
		return json.toString();
	}

	public void send(Player player) {
		((CraftPlayer) player).getHandle().playerConnection
				.sendPacket(new PacketPlayOutChat(ChatSerializer
						.a(toJSONString())));
	}

	private MessagePart latest() {
		return (MessagePart) messageParts.get(messageParts.size() - 1);
	}

	private String makeMultilineTooltip(String lines[]) {
		JSONStringer json = new JSONStringer();
		try {
			json.object().key("id").value(1L);
			json.key("tag").object().key("display").object();
			json.key("Name").value(
					(new StringBuilder("\\u00A7f")).append(
							lines[0].replace("\"", "\\\"")).toString());
			json.key("Lore").array();
			for (int i = 1; i < lines.length; i++) {
				String line = lines[i];
				json.value(line.isEmpty() ? " " : ((Object) (line.replace("\"",
						"\\\""))));
			}

			json.endArray().endObject().endObject().endObject();
		} catch (JSONException e) {
			throw new RuntimeException("invalid tooltip");
		}
		return json.toString();
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
	
    public static class MessagePart
    {
    	
        public JSONBuilder writeJson(JSONBuilder json) throws IOException
        {
        	json.object().key("text").value(text);
            if(color != null)
            	json.key("color").value(color.name().toLowerCase());
            if(styles != null)
            {
                ChatColor achatcolor[];
                int j = (achatcolor = styles).length;
                for(int i = 0; i < j; i++)
                {
                    ChatColor style = achatcolor[i];
                    json.key(style != ChatColor.UNDERLINE ? style.name().toLowerCase() : "underlined").value(true);
                }

            }
            if(clickActionName != null && clickActionData != null)
            	json.key("clickEvent").object().key("action").value(clickActionName).key("value").value(clickActionData).endObject();
            if(hoverActionName != null && hoverActionData != null)
            	json.key("hoverEvent").object().key("action").value(hoverActionName).key("value").value(hoverActionData).endObject();
            return json.endObject();
        }
		
        public ChatColor color;
        public ChatColor styles[];
        public String clickActionName;
        public String clickActionData;
        public String hoverActionName;
        public String hoverActionData;
        public final String text;

        public MessagePart(String text)
        {
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