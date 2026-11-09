package net.HEB2013.creategoingnuclearcccompat.Reactor;

import com.example.goingnuclear.reactor.ReactorControllerBlockEntity;
import com.example.goingnuclear.registry.ModBlockEntities;
import dan200.computercraft.api.peripheral.PeripheralCapability;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;

public class ReactorPeripheralProvider {
    public static void register(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(
                PeripheralCapability.get(),
                ModBlockEntities.REACTOR_CONTROLLER.get(),
                (BlockEntity be, Direction side) -> {
                    if (be instanceof ReactorControllerBlockEntity controller) {
                        return new ReactorPeripheral(controller);
                    }
                    return null;
                }
        );
    }
}
