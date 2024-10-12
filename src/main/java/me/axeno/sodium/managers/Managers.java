package me.axeno.sodium.managers;

import lombok.Getter;
import me.axeno.sodium.Sodium;
import me.axeno.sodium.managers.register.RegisterCommands;
import me.axeno.sodium.managers.register.RegisterEvents;
import me.axeno.sodium.utils.InteractiveHelpMenu;
import revxrsal.commands.bukkit.BukkitCommandHandler;

import java.beans.EventHandler;
import java.util.Locale;

public class Managers
{
    private Sodium sodium;

    @Getter private BukkitCommandHandler handler;
    @Getter private InteractiveHelpMenu interactiveHelpMenu;

    public void initConfig(Sodium sodium)
    {
        sodium.saveDefaultConfig();
    }

    public void init(Sodium sodium)
    {
        this.sodium = sodium;

        this.handler = BukkitCommandHandler.create(sodium);
        this.interactiveHelpMenu = InteractiveHelpMenu.create();
        this.handler.accept(interactiveHelpMenu);
        this.handler.getTranslator().setLocale(Locale.FRENCH);

        RegisterCommands registerCommands = new RegisterCommands();
        registerCommands.registerCommands(handler);

        RegisterEvents registerEvents = new RegisterEvents();
        registerEvents.registerEvents();

    }

    public void cleanup()
    {

    }
}
