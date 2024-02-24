package com.paultaranto;

import org.bukkit.plugin.java.JavaPlugin;

import com.paultaranto.commands.GetPlayers;

public class Main extends JavaPlugin
{
	public static Main instance;
	
	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEnable() {
		instance = this;
		
		this.init();
	}
	
	private void init()
	{
		getCommand("online").setExecutor(new GetPlayers());
	}
	
	public static Main getInstance()
	{
		return instance;
	}
}
