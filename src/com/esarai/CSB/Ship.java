package com.esarai.CSB;

import java.util.ArrayList;
import java.util.Stack;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Ship {

	ArrayList<Player> Crew = new ArrayList<Player>();
	ArrayList<Subsystem> subsystems = new ArrayList<Subsystem>();
	
	Stack<Block> shipStructure = new Stack<Block>();
	
	Stack<Block> openList = new Stack<Block>();
	Stack<Block> visitedList = new Stack<Block>();
	Stack<Block> containedStack = new Stack<Block>();
	
	Player captain;
	World world;
	
	
	public Ship(Player p, World w, Block b) {
		
	}
	
	public void searchStructure(Player p){
		Location parseLoc;
		Block openBlock = p.getLocation().getBlock();
		
		openList.add(openBlock);
		
		while (!openList.empty()) {
						
			for (int i = -1; i < 2; i++) {
				for (int j = -1; j < 2; j++) {
					for (int k = -1; k < 2; k++) {
						parseLoc = openBlock.getLocation().add(i,j,k);
						if ( (parseLoc.getBlock().getTypeId() == 22) || 
								(parseLoc.getBlock().getTypeId() == 41) || 
								(parseLoc.getBlock().getTypeId() == 42) || 
								(parseLoc.getBlock().getTypeId() == 46) || 
								(parseLoc.getBlock().getTypeId() == 57)) {
							
							if (!openList.contains(parseLoc.getBlock())) {
								if (!visitedList.contains(parseLoc.getBlock())) {
									openList.push(parseLoc.getBlock());
									containedStack.push(parseLoc.getBlock());
								}
							}
						}
					}
				}
			}
			
			openBlock = openList.pop();
			visitedList.add(openBlock);
	}
}
