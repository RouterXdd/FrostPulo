package frostPulo.classes.statuses;

import arc.graphics.g2d.*;
import arc.math.*;
import arc.util.Time;
import frostPulo.content.FPFX;
import mindustry.entities.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.world.meta.*;
import frostPulo.classes.*;

public class ArmorTearingStatus extends StatusEffect {
    public float timerTear;
    public float tearTime = 20;
    public float armorTear = 2;
    public ArmorTearingStatus(String name) {
        super(name);
        effectChance = 1;
        healthMultiplier = 0.5f;
        effect = FPFX.tearing;
        permanent = true;
    }

    @Override
    public void update(Unit unit, float time) {
        timerTear += Time.delta / tearTime;
        if(timerTear >= tearTime) {
            if (unit.armor > 0) {
                unit.armor(unit.armor - armorTear);
            }
        }
    }

    @Override
    public void setStats() {
        super.setStats();
        stats.add(FPStats.armorTeared, armorTear);
    }
}

