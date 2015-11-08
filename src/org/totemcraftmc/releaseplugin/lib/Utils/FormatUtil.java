package org.totemcraftmc.releaseplugin.lib.Utils;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public final class FormatUtil {
	
	private static DecimalFormat format = new DecimalFormat(".00");
	
	private FormatUtil() {
		// TODO Auto-generated constructor stub
	}

	public static String formatTime(long second) {
		if (second <= 0) {
			return "0秒";
		}

		int years = 0, days = 0, hours = 0, minutes = 0, seconds = 0;

		years = (int) (second / 31536000);
		second -= years * 31536000;
		days = (int) (second / 86400);
		second -= days * 86400;
		hours = (int) (second / 3600);
		second -= hours * 3600;
		minutes = (int) (second / 60);
		second -= minutes * 60;
		seconds = (int) second;
		StringBuilder sb = new StringBuilder();
		if (years != 0)
			sb.append(years + "年");
		if (days != 0)
			sb.append(days + "天");
		if (hours != 0)
			sb.append(hours + "时");
		if (minutes != 0)
			sb.append(minutes + "分");
		if (second != 0)
			sb.append(seconds + "秒");

		if(sb.charAt(sb.length()-1)=='分'){
			sb.append('钟');
		}
		return sb.toString();
	}
	
	public static String formatDouble(double distance){
		if(distance>1E7)return format.format(distance/1E7)+"鐧句竾";
		if(distance>1E5)return format.format(distance/1E5)+"涓?";
		return format.format(distance);
	}
	
	public static String formatStringList(List<String> list){
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < list.size() ; i++){
			sb.append(list.get(i));
			if(i<list.size()-1){
				sb.append("\n");
			}
		}
		return sb.toString();
	}
	
	public static final String formatLocation(Location loc){
		StringBuilder sb = new StringBuilder();
		sb.append(loc.getWorld().getName());
		sb.append(",");
		sb.append(loc.getX());
		sb.append(",");
		sb.append(loc.getY());
		sb.append(",");
		sb.append(loc.getZ());
		sb.append(",");
		sb.append(loc.getYaw());
		sb.append(",");
		sb.append(loc.getPitch());
		return sb.toString();
	}
	
	public static String fill(int source,int max){
		StringBuilder sb = new StringBuilder(source+"");
		int length = source/10;
		for(int i = length ; i < max ; i++){
			sb.append(" ");
		}
		return sb.toString();
	}
	
	public static String fill(double source,int max){
		
		StringBuilder sb = new StringBuilder(format.format(source));
		int length = intlength((int)source)+3;
		for(int i = length ; i < max ; i++){
			sb.append(" ");
		}
		return sb.toString();
	}
	
	public static String fill(String source,int max){
		StringBuilder sb = new StringBuilder(source);
		for(int i = strlength(source) ; i < max ; i ++){
			sb.append(" ");
		}
		return sb.toString();
	}
	
	public static int strlength(String str){
		Pattern p = Pattern.compile("[\u2e80-\ufe4f]");
		Matcher m = p.matcher(str);
		int chnum = 0;
		
		while(m.find()){
			chnum++;
		}
		
		return str.length()+chnum;
	}
	
	public static int intlength(int a){
		int leng = 0;
		while(true){
			if(a/10 > 0){
				a/=10;
				leng++;
			}else{
				break;
			}
		}
		return leng+1;
	}
	
	public static boolean isCHChar(char c){
		return Character.toString(c).matches("[\u2e80-\ufe4f]");
	}
	
	public static String arrangeParams(String[] args,int startIndex){
		if(args.length-1<startIndex)return null;
		StringBuilder sb = new StringBuilder();
		for(int i = startIndex;i<args.length;i++){
			sb.append(args[i]);
			if(i!=args.length-1){
				sb.append(" ");
			}
		}
		
		return sb.toString();
	}
	
	public static String trimString(String original , int maxLength){
		if(original==null)return null;
		
		if(maxLength>=strlength(original)){
			return original;
		}
		
		int length = 0;
		
		for(int i = 0 ; i < original.length() ; i++){
			int l = isCHChar(original.charAt(i))?2:1;
			if(length+l>maxLength-3){
				return original.substring(0, i)+"...";
			}
			length+=l;
		}
		
		return original;
		
//		String str = original.substring(0, (maxLength<original.length())?maxLength:original.length());
//		str = str.substring(0, str.length()-3);
//		str= str+"...";
//		return str;
	}
	
	public static String formatString(String str,int maxLength){
		maxLength+=str.length()-ChatColor.stripColor(str).length();
		return fill(trimString(str, maxLength), maxLength);
	}
	
	public static ItemStack varible(ItemStack item, Map<String, String> varibles) {
		ItemMeta meta = item.getItemMeta();
		if (meta == null) return item;

		String title = meta.getDisplayName();
		if (title != null) {
			title = varible(title, varibles);
		}
		meta.setDisplayName(title);

		List<String> lore = meta.getLore();
		if (lore != null && !lore.isEmpty()) {
			for (int i = 0; i < lore.size(); i++) {
				lore.set(i, varible(lore.get(i), varibles));
			}
		}
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}

	public static String varible(String original, Map<String, String> varibles) {
		for (Map.Entry<String, String> e : varibles.entrySet()) {
			original = original.replace(e.getKey(), e.getValue());
		}
		return original;
	}
	
}
