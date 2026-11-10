package net.HEB2013.creategoingnuclearcccompat;

import net.HEB2013.creategoingnuclearcccompat.Pool.SpentFuelPoolPeripheralProvider;
import net.HEB2013.creategoingnuclearcccompat.Reactor.ReactorPeripheralProvider;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;



// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(GoingNuclearCCCompat.MODID)
public class GoingNuclearCCCompat {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "goingnuclearcccompat";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public GoingNuclearCCCompat(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(ReactorPeripheralProvider::register);
        LOGGER.info("Registering Reactor Controller Peripheral");
        modEventBus.addListener(SpentFuelPoolPeripheralProvider::register);
        LOGGER.info("Registering Spent Fuel Pool Peripheral");
        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);


        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("Create: Going Nuclear CC:Tweaked Compat Started, welcome to my mod :)");
    }
}

