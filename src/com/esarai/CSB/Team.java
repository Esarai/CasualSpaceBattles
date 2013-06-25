package com.esarai.CSB;

import java.util.ArrayList;
import java.util.HashMap;
import org.bukkit.ChatColor;

import org.bukkit.entity.Player;

public class Team {
	
	ArrayList<Player> members = new ArrayList<Player>();
	ArrayList<Ship> ships = new ArrayList<Ship>();
	HashMap<Player, Rank> ranks = new HashMap<Player, Rank>();
	HashMap<Rank, Integer> rankOrder = new HashMap<Rank, Integer>();
	ArrayList<Rank> rankList = new ArrayList<Rank>();
	ColorMap colors;
	String name;
	String tag;
	String desc;
	String color;
	ChatColor colorCode;
	int colorInt, indCap, kills, deaths, shipKills, shipDeaths, battleWins, battleLosses;
	float money, playerKD, shipKD, battleKD;
	
	
	public Team(Player p) {
		Player leader = p;
		Rank r = new Rank("Leader");
		r.canModerate = true;
		r.canModerate = true;
		ranks.put(p, r); rankList.add(r); rankOrder.put(r, 10);
		Rank m = new Rank("Member");
		ranks.put(p, m); rankList.add(m); rankOrder.put(m, 0);
		members.add(leader);
		indCap = 0; kills = 0; deaths = 0; shipKills = 0; shipDeaths = 0; battleWins = 0; battleLosses = 0;
		money = 0; playerKD = 0; shipKD = 0; battleKD = 0;		
	}
	
	//=========Team Appearance Administration=========
	
	public void setName(String n){
		name = n;
	}
	
	public String getName(){
		return name;
	}
	
	public void setTag(String n){
		tag = n;
	}
	
	public String getTag(){
		return tag;
	}
	
	public void setDesc(String d){
		desc = d;
	}
	
	public String getDesc(){
		return desc;
	}
	
	public void setColor(String c){
		color = c;
		colorCode = colors.getColorCode(c);
		colorInt = colors.getColorByte(colorCode);
	}
	
	public ChatColor getColorCode(){
		return colorCode;
	}
	
	public int getColorByte(){
		return colorInt;
	}
	
	//=========Team Membership Administration=========
	
	public void addPlayer(Player p) {				//Add player to team.
		members.add(p);
	}
	
	public void removePlayer(Player p) {			//Kick player from team.
		members.remove(p);
	}
	
	public void addShip(Ship s) {					//Associates a ship with this team.
		ships.add(s);
	}
	
	public void removeShip(Ship s) {				//Removes a vessel from team.
		ships.remove(s);
	}
	
	public void defineRank(String n, int i) {		//Define a new, team-specific rank with seniority i.
		for (Rank r : rankList) {
			if (r.name.equalsIgnoreCase(n)) {					//Must insert error message for fail due to existing rank.
				return;
			}
			else {
				Rank rank = new Rank(n);			//Must insert completion message.
				rankOrder.put(rank, i);
			}
		}
	}
	
	
	//=========Team Score Administration Methods=========
	
	public void addWin(){
		battleWins++;
	}

	public void addLoss(){
		battleWins++;
	}

	public void addKill(){
		kills++;
	}

	public void addDeath(){
		deaths++;
	}
	
	public void addShipKill(){
		shipKills++;
	}
	
	public void addShipLoss(){
		shipDeaths++;
	}
	
	public void adjustWins(int k){
		battleWins = battleWins+k;
	}
	
	public void adjustLosses(int k){
		battleLosses = battleLosses+k;
	}
	
	public void adjustKills(int k){
		kills = kills+k;
	}
	
	public void adjustDeaths(int k){
		deaths = deaths + k;
	}

	public void adjustShipKills(int k){
		shipKills = shipKills+k;
	}
	
	public void adjustShipDeaths(int k){
		shipDeaths = shipDeaths + k;
	}
}
