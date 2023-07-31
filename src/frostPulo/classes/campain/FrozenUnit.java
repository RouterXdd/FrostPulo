package frostPulo.classes.campain;

import arc.math.*;
import arc.util.*;
import frostPulo.content.*;
import mindustry.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.ui.*;
import mindustry.world.*;

public class FrozenUnit extends Block {
    public int waveCounter = 22;
    public int minEscape = 200;
    public int maxEscape = 300;
    public float escapeTime = Mathf.random(minEscape, maxEscape);
    public UnitType unitFr = FPUnits.reinforcementFlare;
    public FrozenUnit(String name) {
        super(name);
        destructible = true;
        solid = false;
        update = true;
        buildType = FrozenUnitBuild::new;
    }
    @Override
    public void setBars(){
        super.setBars();
                addBar("escape", (FrozenUnitBuild e) -> new Bar("bar.progress", Pal.ammo, e::fraction));
    }
    public class FrozenUnitBuild extends Building {
        public float escapeProgress;
        public @Nullable Unit unit;
        public float fraction(){
            return escapeProgress;
        }
        @Override
        public void updateTile(){
                escapeProgress += edelta() / escapeTime;
                if (optionalEfficiency > 0 && escapeProgress >= 1f && Vars.state.wave >= waveCounter) {
                    kill();
                }
        }
        @Override
        public void afterDestroyed(){
            unit = unitFr.create(Vars.state.rules.waveTeam);
            unit.set(x, y);
            unit.rotation = 90f;
            unit.add();
        }
    }
}
