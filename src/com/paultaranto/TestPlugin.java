package com.paultaranto;

import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.paultaranto.commands.GetPlayers;
import com.paultaranto.Events.PlayerJoin;

public class TestPlugin extends JavaPlugin
{
	public static TestPlugin instance;
	
	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEnable() {
		instance = this;
		
		this.registerCommands();
		this.registerEvents();
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
	
	public static TestPlugin getInstance()
	{
		return instance;
	}
}
