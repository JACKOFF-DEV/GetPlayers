package com.paultaranto.Events;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class PlayerJoin extends PlayerListener 
{
	@Override 
    public void onPlayerJoin(PlayerJoinEvent event) 
    { 
		var playerNames = new ArrayList<String>(); 
		var onlinePlayers = event.getPlayer().getServer().getOnlinePlayers(); 
		for(var player : onlinePlayers) 
		{ 
			playerNames.add(((Player)player).getDisplayName()); 
		}
  
		var jsonObj = new JSONObject(); 
		var jsonArray = new JSONArray();
		jsonArray.addAll(playerNames);
  
		jsonObj.put("Player count", playerNames.size());
		jsonObj.put("Online players", jsonArray);
  
		try 
		{ 
			var fileWriter = new FileWriter("./cocks.json");
			fileWriter.write(jsonObj.toJSONString());
	  
			fileWriter.flush(); 
			fileWriter.close(); 
		} 
		catch (IOException e) { } 
	}
	 
	
	@Override
	public void onPlayerQuit(PlayerQuitEvent event) 
	{	
		var playerNames = new ArrayList<String>(); 
		var onlinePlayers = event.getPlayer().getServer().getOnlinePlayers(); 
		for(var player : onlinePlayers) 
		{ 
			if (player.getDisplayName().equals(event.getPlayer().getDisplayName()))
			{
				continue;
			}
			
			playerNames.add(((Player)player).getDisplayName()); 
		}
	  
	    var jsonObj = new JSONObject(); 
	    var jsonArray = new JSONArray();
	    jsonArray.addAll(playerNames);
	  
	    jsonObj.put("Player count", playerNames.size());
	    jsonObj.put("Online players", jsonArray);
	    
	    try 
	    { 
		    var fileWriter = new FileWriter("./cocks.json");
		    fileWriter.write(jsonObj.toJSONString());
	  
		    fileWriter.flush(); 
		    fileWriter.close(); 
	    } 
	    catch (IOException e) 
	    {   
	    }
	}
}
