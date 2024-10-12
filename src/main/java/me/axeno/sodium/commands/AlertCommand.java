package me.axeno.sodium.commands;

import me.axeno.sodium.utils.constant.MessageManager;
import me.axeno.sodium.utils.constant.MessageType;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Named;

public class AlertCommand
{
    @Command("alert")
    public void onAlertCommand(CommandSender sender, @Named("Alert Message") String[] message)
    {
        StringBuilder builder = new StringBuilder();
        for (String s : message)
        {
            builder.append(s).append(" ");
        }
        String alertMessage = builder.toString().trim();
        for(Player online : sender.getServer().getOnlinePlayers())
        {
            MessageManager.sendMessageType(online, alertMessage, MessageType.INFO, true);
        }
    }
}
