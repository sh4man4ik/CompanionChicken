package com.sh4man.companionchicken;

import net.minecraft.client.renderer.entity.RenderChicken;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;

@Mod(modid = CompanionChicken.MODID, name = CompanionChicken.NAME, version = CompanionChicken.VERSION)
@Mod.EventBusSubscriber(modid = CompanionChicken.MODID)
public class CompanionChicken
{
    public static final String MODID = "companionchicken";
    public static final String NAME = "CompanionChicken";
    public static final String VERSION = "1.0";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        RenderingRegistry.registerEntityRenderingHandler(CompanionChickenEntity.class, RenderChicken::new);
    }

    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityEntry> event)
    {
        event.getRegistry().register(
                EntityEntryBuilder.create()
                        .entity(CompanionChickenEntity.class)
                        .id(new ResourceLocation(CompanionChicken.MODID, "companionchicken"), 0)
                        .name("companionchicken").tracker(64, 3, true)
                        .egg(0xCFCFCF, 0xFFAA00)
                        .build()
        );
    }
}