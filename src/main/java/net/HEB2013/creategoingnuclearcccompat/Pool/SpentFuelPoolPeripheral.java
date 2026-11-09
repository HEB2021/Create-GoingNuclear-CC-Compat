package net.HEB2013.creategoingnuclearcccompat.Pool;

import com.example.goingnuclear.fuelcycle.SpentFuelPoolBlockEntity;
import dan200.computercraft.api.lua.LuaFunction;
import dan200.computercraft.api.peripheral.IPeripheral;
import net.HEB2013.creategoingnuclearcccompat.util.ISpentFuelPool;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SpentFuelPoolPeripheral implements IPeripheral {
    private final SpentFuelPoolBlockEntity blockEntity;

    public SpentFuelPoolPeripheral(SpentFuelPoolBlockEntity blockEntity) {
        this.blockEntity = blockEntity;
    }

    @NotNull
    @Override
    public String getType() {
        return "spent_fuel_pool";
    }
    @Override
    public boolean equals(@Nullable IPeripheral other) {
        return this == other;
    }


    @LuaFunction
    public final int getStoredFuel() {
        return this.blockEntity.store.tank.getFluidAmount();
    }

    @LuaFunction
    public final int getStoredWater() {
        return this.blockEntity.water.getFluidAmount();
    }

    @LuaFunction
    public final int getMinutesToNextCooled() {
        return this.blockEntity.minutesToNext();
    }

    @LuaFunction
    public final int getBatches() {
        return ((ISpentFuelPool) this.blockEntity).getBatchCount();
    }

    @LuaFunction
    public final float getHeat() {
        return (float) this.blockEntity.store.heat();
    }

    @LuaFunction
    public final float getCooledPercent() {
        return this.blockEntity.cooledFraction();
    }

    @LuaFunction
    public final float getLong() {
        return (float) this.blockEntity.store.longBq;
    }

    @LuaFunction
    public final float getMedium() {
        return (float) this.blockEntity.store.mediumBq;
    }

    @LuaFunction
    public final float getShort() {
        return (float) this.blockEntity.store.shortBq;
    }
}