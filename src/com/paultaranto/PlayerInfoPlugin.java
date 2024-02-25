package com.paultaranto;

import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.paultaranto.commands.GetPlayers;
import com.paultaranto.Events.PlayerJoin;

public class PlayerInfoPlugin extends JavaPlugin
{
	public static PlayerInfoPlugin instance;
	
	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		this.clearJson();
	}

	@Override
	public void onEnable() {
		instance = this;
		
		this.clearJson();
		
		this.registerCommands();
		this.registerEvents();
	}
	
	private void clearJson() 
	{
		var jsonObj = new JSONObject(); 
		var jsonArray = new JSONArray();
		jsonArray.addAll(new ArrayList<String>());
  
		jsonObj.put("Player count", 0);
		jsonObj.put("Online players", jsonArray);
  
		try 
		{ 
			var fileWriter = new FileWriter("./player-info.json");
			fileWriter.write(jsonObj.toJSONString());
	  
			fileWriter.flush(); 
			fileWriter.close(); 
		} 
		catch (IOException e) { } 	
	}

	private void registerCommands()
	{
		getCommand("online").setExecutor(new GetPlayers());
	}
	
	private void registerEvents()
	{
		this.getServer().getPluginManager().registerEvent(Type.PLAYER_JOIN, (Listener)new PlayerJoin(), Priority.Highest, this);
		this.getServer().getPluginManager().registerEvent(Type.PLAYER_QUIT, (Listener)new PlayerJoin(), Priority.Highest, this);
		this.getServer().getPluginManager().registerEvent(Type.PLAYER_FISH, (Listener)new PlayerJoin(), Priority.Highest, this);
	}
	
	public static PlayerInfoPlugin getInstance()
	{
		return instance;
	}
}
