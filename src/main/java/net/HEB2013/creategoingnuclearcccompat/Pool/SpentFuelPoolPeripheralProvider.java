package net.HEB2013.creategoingnuclearcccompat.Pool;

import com.example.goingnuclear.fuelcycle.SpentFuelPoolBlockEntity;
import com.example.goingnuclear.registry.ModBlockEntities;
import dan200.computercraft.api.peripheral.PeripheralCapability;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;

public class SpentFuelPoolPeripheralProvider {
    public static void register(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(
                PeripheralCapability.get(),
                ModBlockEntities.SPENT_FUEL_POOL.get(),
                (BlockEntity be, Direction side) -> {
                    if (be instanceof SpentFuelPoolBlockEntity controller) {
                        return new SpentFuelPoolPeripheral(controller);
                    }
                    return null;
                }
        );
    }
}
