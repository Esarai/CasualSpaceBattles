package com.esarai.CSB;

import java.util.HashMap;

import org.bukkit.ChatColor;

public class ColorMap {

	public final HashMap<ChatColor, Byte> colorMap = new HashMap<ChatColor,Byte>();
	public final HashMap<String, ChatColor> colorStrMap = new HashMap<String, ChatColor>();
	
	public ColorMap(){
		colorMap.put(ChatColor.WHITE, (byte)0);
		colorMap.put(ChatColor.GOLD, (byte)1);
		colorMap.put(ChatColor.LIGHT_PURPLE, (byte)2);
		colorMap.put(ChatColor.BLUE, (byte)3);
		colorMap.put(ChatColor.YELLOW, (byte)4);
		colorMap.put(ChatColor.GREEN, (byte)5);
		colorMap.put(ChatColor.RED, (byte)6);
		colorMap.put(ChatColor.DARK_GRAY, (byte)7);
		colorMap.put(ChatColor.GRAY, (byte)8);
		colorMap.put(ChatColor.DARK_AQUA, (byte)9);
		colorMap.put(ChatColor.DARK_PURPLE, (byte)10);
		colorMap.put(ChatColor.DARK_BLUE, (byte)11);
		colorMap.put(ChatColor.AQUA, (byte)12);
		colorMap.put(ChatColor.DARK_GREEN, (byte)13);
		colorMap.put(ChatColor.DARK_RED, (byte)14);
		colorMap.put(ChatColor.BLACK, (byte)15);
	
		colorStrMap.put("white", ChatColor.WHITE);
		colorStrMap.put("orange", ChatColor.GOLD);
		colorStrMap.put("lightpurple", ChatColor.LIGHT_PURPLE);
		colorStrMap.put("lightblue", ChatColor.BLUE);
		colorStrMap.put("yellow", ChatColor.YELLOW);
		colorStrMap.put("green", ChatColor.GREEN);
		colorStrMap.put("pink", ChatColor.RED);
		colorStrMap.put("darkgray", ChatColor.DARK_GRAY);
		colorStrMap.put("gray", ChatColor.GRAY);
		colorStrMap.put("teal", ChatColor.DARK_AQUA);
		colorStrMap.put("purple", ChatColor.DARK_PURPLE);
		colorStrMap.put("blue", ChatColor.DARK_BLUE);
		colorStrMap.put("brown", ChatColor.AQUA);
		colorStrMap.put("darkgreen", ChatColor.DARK_GREEN);
		colorStrMap.put("red", ChatColor.DARK_RED);
		colorStrMap.put("black", ChatColor.BLACK);
	}
	
	public Byte getColorByte(ChatColor c){
		Byte colorInt = colorMap.get(c);
		return colorInt;
	}
	
	public ChatColor getColorCode(String s){
		ChatColor colorCode = colorStrMap.get(s);
		return colorCode;
	}
}
