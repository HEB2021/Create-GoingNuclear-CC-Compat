package net.HEB2013.creategoingnuclearcccompat.mixins;

import net.HEB2013.creategoingnuclearcccompat.util.ISpentFuelPool;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;


import java.util.ArrayList;

@Mixin(targets = "com.example.goingnuclear.fuelcycle.SpentFuelPoolBlockEntity", remap = false)
public abstract class SpentFuelPoolMixin implements ISpentFuelPool {
    @Shadow
    private ArrayList<double[]> batches;

    @Override
    public int getBatchCount(){
        return this.batches != null ? this.batches.size() : 0;
    }


}

