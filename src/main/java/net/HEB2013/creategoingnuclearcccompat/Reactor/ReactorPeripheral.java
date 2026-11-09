package net.HEB2013.creategoingnuclearcccompat.Reactor;

import com.example.goingnuclear.reactor.ReactorControllerBlockEntity;
import com.example.goingnuclear.reactor.ReactorState;
import com.example.goingnuclear.sim.engine.OperatorCalc;
import dan200.computercraft.api.lua.LuaFunction;
import dan200.computercraft.api.peripheral.IPeripheral;
import net.minecraft.Util;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;

public class ReactorPeripheral implements IPeripheral {
    private final ReactorControllerBlockEntity blockEntity;

    public ReactorPeripheral(ReactorControllerBlockEntity blockEntity) {
        this.blockEntity = blockEntity;
    }

    // Functions we need
    // GETS
    // Physics Desk Information
    // getkEff
    @LuaFunction
    public final float getkEff() {
        float[] e = this.blockEntity.snapshot().ext();
        return e[51];
    }
    // getBeta
    @LuaFunction
    public final double getBeta() {
        float[] e = this.blockEntity.snapshot().ext();
        return e[60];
    }
    // getLambda
    @LuaFunction
    public final double getLambda() {
        float[] e = this.blockEntity.snapshot().ext();
        return e[61];
    }
    // getPower
    @LuaFunction
    public final double getPower() {
        return this.blockEntity.snapshot().flux() * 100.0F;
    }
    // getIodine
    @LuaFunction
    public final double getIodine() {
        float[] e = this.blockEntity.snapshot().ext();
        return e[93];
    }
    // getXenonEq
    @LuaFunction
    public final double getXenonEq() {
        float[] e = this.blockEntity.snapshot().ext();
        return e[94];
    }
    // getXenonPeak
    @LuaFunction
    public final double getXenonPeak() {
        float[] e = this.blockEntity.snapshot().ext();
        return e[95];
    }
    // getHottestFuel
    @LuaFunction
    public final double getMaxFuel() {
        float[] e = this.blockEntity.snapshot().ext();
        return e[24];
    }
    // getReactivity
    @LuaFunction
    public final float getReactivity() {
        float[] e = this.blockEntity.snapshot().ext();
        return e[0]; // Need to check if this matches
    }
    // getDecayHeat
    public final double getDecayHeat() {
        return this.blockEntity.snapshot().decayHeat();
    }
    // getDecayHeatAfterShutdown
    @LuaFunction
    public final double getDecayHeatAfterShutdown(int hours) {
        float[] e = this.blockEntity.snapshot().ext();

        return OperatorCalc.decayHeat(hours, e[91]) * 100.0F;
    }
    // Control Desk Information
    // getTemperature
    @LuaFunction
    public final double getTemperature() {
        return this.blockEntity.snapshot().temperature();
    }
    // getPressure
    @LuaFunction
    public final double getPressure() {
        return this.blockEntity.snapshot().pressure();
    }
    // getStartupRate
    @LuaFunction
    public final double getStartupRate() {
        float[] e = this.blockEntity.snapshot().ext();
        return e[1] > 0.01F ? 26.06F / e[1] : (e[1] < -0.01F ? 26.06F / e[1] : 0.0F);
    }
    // getFlux
    @LuaFunction
    public final double getFlux() {
        return this.blockEntity.snapshot().flux();
    }
    // getXenonPoison
    @LuaFunction
    public final double getXenonPoison() {
        return this.blockEntity.snapshot().xenon();
    }
    // getFuelLevel
    @LuaFunction
    public final double getFuelLevel() {
        float[] e = this.blockEntity.snapshot().ext();
        return e[21];
    }
    // getPrimaryCoolantLevel
    @LuaFunction
    public final double getPrimaryCoolantLevel() {
        return this.blockEntity.snapshot().coolant();
    }
    // getSpentFuelLevel
    @LuaFunction
    public final double getSpentFuelLevel() {
        return this.blockEntity.snapshot().waste();
    }
    // getContainment
    @LuaFunction
    public final float getContainment() {
        float[] e = this.blockEntity.snapshot().ext();
        return e[47];
    }
    // getHistory??PossibleEventFire

    // getRodInsertion
    @LuaFunction
    public final int getInsertion() {
        return this.blockEntity.getInsertion();

    }
    // getPeriod
    @LuaFunction
    public final float getPeriod() {
        float[] e = this.blockEntity.snapshot().ext();
        return e[1];
    }
    // getBoron
    @LuaFunction
    public final double getBoron() {
        float[] e = this.blockEntity.snapshot().ext();
        return e[22];
    }
    // getAxialOffset
    @LuaFunction
    public final float getAxialOffset() {
        float[] e = this.blockEntity.snapshot().ext();
        return e[7];
    }
    // getThermalPower
    @LuaFunction
    public final float getThermalPower() {
        float[] e = this.blockEntity.snapshot().ext();
        return e[8];
    }
    // getDNBR
    @LuaFunction
    public final float getDNBR() {
        float[] e = this.blockEntity.snapshot().ext();
        return e[5];
    }
    // getVoid
    @LuaFunction
    public final float getVoid() {
        float[] e = this.blockEntity.snapshot().ext();
        return e[6];
    }
    // getHotLegTemp
    @LuaFunction
    public final double getHotLegTemp() {
        float[] e = this.blockEntity.snapshot().ext();
        return e[15];
    }
    // getColdLegTemp
    @LuaFunction
    public final double getColdLegTemp() {
        float[] e = this.blockEntity.snapshot().ext();
        return e[16];
    }
    // getSGLevel
    @LuaFunction
    public final float getSGLevel() {
        float[] e = this.blockEntity.snapshot().ext();
        return e[9];
    }
    // getSteamFlow
    @LuaFunction
    public final float getSteamOutput() {
        float[] e = this.blockEntity.snapshot().ext();
        return e[10];
    }
    // getElectric
    @LuaFunction
    public final double getElectric() {
        float[] e = this.blockEntity.snapshot().ext();
        return e[11];
    }
    // getINES
    @LuaFunction
    public final double getINES() {
        float[] e = this.blockEntity.snapshot().ext();
        return e[13];
    }
    // getTrips
    @LuaFunction
    public final Map<Integer, String> getTrips() {
        Map<Integer, String> tripMap = new LinkedHashMap<>();
        String[] TRIPS = new String[]{"flux_high", "pressure_high", "pressure_low", "flow_low", "sg_level_low", "over_temperature", "flux_rate_high", "containment_high", "turbine_trip", "manual", "no_dc"};
        float[] e = this.blockEntity.snapshot().ext();
        int trips = (int)e[12];
        int alarms = (int)e[13];
        for(int i = 0; i < TRIPS.length; ++i) {
            boolean on = (trips >> i & 1) != 0;
            boolean al = (alarms >> i & 1) != 0;
            if (on) {
                tripMap.put(i + 1, TRIPS[i]);
            }
        }
        return tripMap;
    }
    // getAxialPower
    @LuaFunction
    public final Map<Integer, Float> getAxialPower() {
        Map<Integer, Float> axialMap = new LinkedHashMap<>();
        float[] e = this.blockEntity.snapshot().ext();
        for(int i = 0; i < 8; ++i) {
            axialMap.put(i+1, e[36 + (7-i)]);
        }
        return axialMap;
    }
    // getRodPosition
    @LuaFunction
    public final Map<Integer, Integer> getRodPosition() {
        Map<Integer, Integer> rodPositions = new LinkedHashMap<>();
        float[] e = this.blockEntity.snapshot().ext();
        int th = 8 * (12 + 1) - 2;
        rodPositions.put(1, Math.round(th * Mth.clamp(e[18], 0.0F, 1.0F)));
        rodPositions.put(2, Math.round(th * Mth.clamp(e[18 + 1], 0.0F, 1.0F)));
        return rodPositions;
    }
    // getCoreMap
    @LuaFunction
    public final Map<Integer, Map<Integer, Object[]>> getCoreMap() {
        Map<Integer, Map<Integer, Object[]>> coreMap = new LinkedHashMap<>();
        float[] e = this.blockEntity.snapshot().ext();
        int cw = Math.round(e[144]);
        int cd = Math.round(e[145]);
        int w = 120;
        int h = 120;

        if (cw > 0 && cd > 0 && cw * cd <= 169) {
            boolean blink = Util.getMillis() / 400L % 2L == 0L;
            int cell = Mth.clamp(Math.min((w - 2) / cw, (h - 2) / cd), 2, 16);
            for(int z = 0; z < cd; ++z) {
                Map<Integer, Object[]> map = new LinkedHashMap<>();
                for(int i = 0; i < cw; ++i) {
                    float v = e[150 + i + z * cw];
                    boolean uncovered = v < 0.0F;
                    v = Math.abs(v);
                    int kind = (int)(v / 16.0F);
                    float power = v - kind * 16.0F;
                    Object[] tmp = {kind, power};
                    map.put(i+1, tmp);
                }
                coreMap.put(z+1, map);
            }
        }
        return coreMap;
    }
    // getModeration
    @LuaFunction
    public final float getModeration() {
        return this.blockEntity.snapshot().ext()[146];
    }
    // getLeakage
    @LuaFunction
    public final float getLeakage() {
        return this.blockEntity.snapshot().ext()[147];
    }
    // getPeaking
    @LuaFunction
    public final float getPeaking() {
        return this.blockEntity.snapshot().ext()[148];
    }
    // getRodReach
    @LuaFunction
    public final float getRodReach() {
        return this.blockEntity.snapshot().ext()[149];
    }
    // getMaxClad
    @LuaFunction
    public final float getMaxClad() {
        return this.blockEntity.snapshot().ext()[25];
    }
    // getMelt
    @LuaFunction
    public final float getMelt() {
        return this.blockEntity.snapshot().ext()[45];
    }
    // getOutputSU
    @LuaFunction
    public final float getOutputSU() {
        float[] e = this.blockEntity.snapshot().ext();
        double atFull = (double)14400.0F;
        float fill = Mth.clamp((float)((double)e[26] / atFull), 0.0F, 1.2F);
        return e[8] * 2200000.0F * Math.min(1.0F, fill / Math.max(0.01F, e[8]));
    }
    // getHeatSink
    public final String getHeatSink() {
        float[] e = this.blockEntity.snapshot().ext();
        boolean linked = e[27] > 0.5F;
        return linked ? "steam_line" : "legacy";
    }

    // getEnrichment
    @LuaFunction
    public final float getEnrichment() {
        return this.blockEntity.snapshot().enrichment();
    }
    // getRadiation
    @LuaFunction
    public final float getRadiation() {
        return this.blockEntity.getRadiation();
    }
    // getState
    @LuaFunction
    public final String getState() {
        ReactorState reactor_State = this.blockEntity.getState();
        return switch (reactor_State) {
            case ReactorState.COLD -> "cold";
            case ReactorState.CRITICAL -> "critical";
            case ReactorState.FUEL_DAMAGE -> "fuel_damage";
            case ReactorState.HEATING -> "heating";
            case ReactorState.MELTDOWN -> "meltdown";
            case ReactorState.OVERHEATED -> "overheated";
            case ReactorState.POWER -> "power";
        };
    }

    // Reactor Multiblock Fluid Tank Levels
    // getSteamTankLevel
    @LuaFunction
    public final int getSteamTankLevel() {
        return this.blockEntity.steam.getFluidAmount();
    }
    // getCoolantTankLevel
    @LuaFunction
    public final int getCoolantTankLevel() {
        return this.blockEntity.coldBuffer.getFluidAmount();
    }
    // getFuelTankLevel
    @LuaFunction
    public final int getFuelTankLevel() {
        return this.blockEntity.fuel.getFluidAmount();
    }
    // getWasteTankLevel
    @LuaFunction
    public final int getWasteTankLevel() {
        return this.blockEntity.waste.getFluidAmount();
    }

    // IS
    // isPumpActive
    @LuaFunction
    public final boolean isPumpActive() {
        return this.blockEntity.snapshot().pump();
    }
    // isAlarm
    @LuaFunction
    public final boolean isAlarm() {
        return this.blockEntity.alarm();
    }
    // isReliefValveOpen
    @LuaFunction
    public final boolean isVenting() {
        return this.blockEntity.isVenting();
    }
    // isScrammed
    @LuaFunction
    public final boolean isScrammed() {
        return this.blockEntity.isScrammed();
    }
    // isOn
    @LuaFunction
    public final boolean isOn() {
        return this.blockEntity.getInsertion() < 100;
    }
    // isRodStop
    @LuaFunction
    public final boolean isRodStop() {
        return this.blockEntity.rodStop();
    }
    // SET
    // setRodInsertion
    public final void setInsertion(int value) {
        this.blockEntity.setInsertion(value);
    }
    // setPumps
    @LuaFunction
    public final void setPump(boolean on) {
        if (this.blockEntity.snapshot().pump() && !on) {
            this.blockEntity.togglePump();
        }
        if (!this.blockEntity.snapshot().pump() && on) {
            this.blockEntity.togglePump();
        }

    }
    // setReliefValve
    @LuaFunction
    public final void setReliefValve() {
        this.blockEntity.toggleManualValve();
    }
    //
    // ACTIONS
    // scram
    @LuaFunction
    public final void scram() {
        this.blockEntity.remoteScram();
    }
    // on
    @LuaFunction
    public final void on() {
        this.blockEntity.powerOn();
    }
    // off
    @LuaFunction
    public final void off() {
        this.blockEntity.powerOff();
    }
    @NotNull
    @Override
    public String getType() {
        return "reactor_controller";
    }
    @Override
    public boolean equals(@Nullable IPeripheral other) {
        return this == other;
    }
    @LuaFunction
    public final String egg() {
        return "can u add me as a easteregg lol - apple i guess (Going Nuclear Dev)";
    }
}