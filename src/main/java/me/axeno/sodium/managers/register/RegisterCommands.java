package me.axeno.sodium.managers.register;

import me.axeno.sodium.commands.AlertCommand;
import revxrsal.commands.bukkit.BukkitCommandHandler;

public class RegisterCommands
{
    public void registerCommands(BukkitCommandHandler handler)
    {

        handler.register(
                new AlertCommand()
        );

    }
}
