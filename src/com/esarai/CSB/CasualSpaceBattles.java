package com.esarai.CSB;

import java.util.ArrayList;

import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class CasualSpaceBattles extends JavaPlugin implements Listener {

	ArrayList<Team> teams = new ArrayList<Team>();
	
	
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}
	public void onDisable() {
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (label.equalsIgnoreCase("create")) {											//Creates a new team.
			if (args[0].equalsIgnoreCase("team")){
				if (!args[1].isEmpty()) {
				String name = args[1];
					for (Team t : teams) {
						if (name.equalsIgnoreCase(t.name)) {								//check to make sure a team with the same name does not exist.
							sender.sendMessage("A team with that name already exists!");
							return false;
						}
						
						if (t.members.contains(sender)) {									//Check to make sure player is not currently part of a team.
							sender.sendMessage("You are already part of a team.");
							return false;
						}
						
					}
					
					Team newTeam = new Team((Player) sender);
					newTeam.name = args[1];
					teams.add(newTeam);
					sender.sendMessage("Team '"+name+"' created!");
					Player players[] = sender.getServer().getOnlinePlayers();
					for (Player p : players) {
						p.sendMessage("A new team, '"+name+",' has been created.");
					}
					return true;
				}
				
				else {
					sender.sendMessage("Please define a team name.");
					return false;
				}	
			}	
		}
		
		return false;
	}
	
	public void onPlayerDisconnect(PlayerQuitEvent event) {
		Player player = event.getPlayer();
	}
	
	public void onPlayerInteract(PlayerInteractEvent event){
		
		Block block = event.getClickedBlock();
		Player player = event.getPlayer();
	}
	
	public void onRedstoneEvent(BlockRedstoneEvent event){
	
	}
	
	public void onPlayerRespawnEvent(PlayerRespawnEvent event){
		
	}
	
	public void onEntityExplodeEvent(EntityExplodeEvent event){
		
	}
	
	public void onBlockBreakEvent(BlockBreakEvent event){
		
	}
	
	public void onBlockPlaceEvent(BlockPlaceEvent event){
		
	}
	
}
