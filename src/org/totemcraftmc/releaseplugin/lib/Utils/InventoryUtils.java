package org.totemcraftmc.releaseplugin.lib.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.minecraft.server.v1_8_R3.PacketPlayOutSetSlot;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;


public final class InventoryUtils {
	
	private InventoryUtils() {}
	
	public static int count(Inventory inv){
		if(inv == null){
			return 0;
		}
		int count = 0;
		for(int i = 0 ; i < inv.getSize();i++){
			if(inv.getItem(i)!=null){
				count++;
			}
		}
		return count;
	}
	
	public static List<ItemStack> getItems(Inventory inv,int endSlot){
		
		if(inv.getSize()<endSlot){
			endSlot = inv.getSize();
		}
		
		List<ItemStack> items = new ArrayList<ItemStack>();
		for(int i = 0 ; i < endSlot ; i++){
			if(inv.getItem(i) != null){
				items.add(inv.getItem(i));
			}
		}
		return items;
		
	}
	
	public static void sendSlotChange(ItemStack item, int stack, Player p) {
		
		int x = stack / 9 + 1;
		int y = stack % 9 + 1;
		
		if(stack<0){
			x=-1;
			y=-1;
		}
		
		net.minecraft.server.v1_8_R3.ItemStack nms = CraftItemStack
				.asNMSCopy(item);
		((CraftPlayer) p).getHandle().playerConnection
				.sendPacket(new PacketPlayOutSetSlot(x, y, nms));
	}
	
	public static final void clearAllFromPlayer(Player player){
		Inventory inv = player.getInventory();
		for(int i = 0  ; i < 36 ; i++){
			inv.setItem(i, null);
		}
		EntityEquipment equip = player.getEquipment();
		equip.setHelmet(null);
		equip.setChestplate(null);
		equip.setLeggings(null);
		equip.setBoots(null);
		
		player.setLevel(0);
		player.setExp(0);
		
		for(PotionEffectType x : PotionEffectType.values()){
			if(x == null){
				continue;
			}
			if(player.hasPotionEffect(x)){
				player.removePotionEffect(x);
			}
		}
	}
	
	public static final boolean checkInventory(Player player){
		for(int i = 0 ; i < 36 ; i++){
			if(player.getInventory().getItem(i)!=null){
				return false;
			}
		}
		
		EntityEquipment equip = player.getEquipment();
		if(equip.getHelmet() != null){
			return false;
		}
		
		if(equip.getChestplate() != null){
			return false;
		}
		
		if(equip.getLeggings() != null){
			return false;
		}
		
		if(equip.getBoots() != null){
			return false;
		}
		
		return true;
	}
	
	public static String getItemName(ItemStack item){

		ItemMeta meta = item.getItemMeta();
		if(meta==null||meta.getDisplayName()==null||meta.getDisplayName().isEmpty()){
			return getMaterialName(item.getType());
		}
		return meta.getDisplayName();

	}
	
	public static String getMaterialName(Material m){
		String def = m.toString().replace("_"," ").toLowerCase();
		def = def.substring(0,1).toUpperCase()+def.substring(1);
		Pattern p = Pattern.compile("[ ]");
		Matcher matcher = p.matcher(def);
		while(matcher.find()){
			def = def.substring(0,matcher.start()+1)+def.substring(matcher.start()+1,matcher.start()+2).toUpperCase()+def.substring(matcher.start()+2);
		}
		return def;
	}
	
	public static int calcLeft(Inventory inv,ItemStack i){
		if(i==null){
			return 0;
		}

		i.setAmount(1);
		int count = 0;
		for(ItemStack item : inv.getContents()){
			if(item==null){
				continue;
			}
			if(item.isSimilar(i)){
				count+=item.getAmount();
			}
		}

		return count;
	}
	
	public static boolean canPutIn(PlayerInventory inv,ItemStack item,int amount){
		return canPutIn((Inventory)inv,item,amount);
	}
	
	public static boolean canPutIn(Inventory inv , ItemStack item,int amount){
		item = new ItemStack(item);
		item.setAmount(1);

		int avail = 0;
		for(ItemStack i : inv.getContents()){
			if(i==null || i.getType().equals(Material.AIR)){
				avail+=item.getMaxStackSize();
				continue;
			}

			if(i.isSimilar(item)){
				avail+=item.getMaxStackSize()-i.getAmount();
			}
		}

		return avail>=amount;
	}
	
}
