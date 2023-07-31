package frostPulo.content;

import mindustry.content.Planets;
import mindustry.type.SectorPreset;

public class FPSectors {
    public static SectorPreset
            icePlate, frozenLegion, freezeOut, abandonedComplex, iceSpiral, cryoCleft, afterFrost, mountain
            ;
    public static void load(){
        icePlate = new SectorPreset("ice-plate", Planets.serpulo, 73){{
            captureWave = 35;

        }};
    }
}
