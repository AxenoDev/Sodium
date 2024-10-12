package me.axeno.sodium;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import me.axeno.sodium.managers.Managers;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Sodium extends JavaPlugin
{

    private final Managers managers = new Managers();
    @Getter private static Sodium instance;
    @Getter private static Logger log;

    @Override
    public void onLoad()
    {

    }

    @Override
    public void onEnable()
    {

        instance = this;

        log = getLogger();

        managers.initConfig(this);
        managers.init(this);



    }

    @Override
    public void onDisable()
    {
        managers.cleanup();
    }
}