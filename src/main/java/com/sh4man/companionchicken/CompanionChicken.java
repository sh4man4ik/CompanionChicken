package com.sh4man.companionchicken;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = CompanionChicken.MODID, name = CompanionChicken.NAME, version = CompanionChicken.VERSION)
public class CompanionChicken
{
    public static final String MODID = "companionchicken";
    public static final String NAME = "CompanionChicken";
    public static final String VERSION = "1.0";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(this);
    }
}
