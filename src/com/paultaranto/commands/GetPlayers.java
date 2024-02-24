package com.paultaranto.commands;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetPlayers implements CommandExecutor
{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
		
		var playerNames = new ArrayList<String>();
		for(var player : sender.getServer().getOnlinePlayers())
		{
			playerNames.add(((Player)player).getDisplayName());
		}
		
		sender.sendMessage(playerNames.toString());
		
		return true;
	}

}
