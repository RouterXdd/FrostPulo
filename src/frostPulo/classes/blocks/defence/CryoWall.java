package frostPulo.classes.blocks.defence;

import frostPulo.classes.FPStats;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.logic.*;
import mindustry.type.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.meta.*;

import static mindustry.Vars.*;

public class CryoWall extends Wall {
    public float range = 50f;
    public StatusEffect status = StatusEffects.freezing;
    public float statusDuration = 80f;
    public CryoWall(String name){
        super(name);
        buildType = CryoWallBuild::new;
    }
    @Override
    public void setStats(){
        super.setStats();

        stats.add(FPStats.statusRange, range / tilesize, StatUnit.blocks);
    }
    public class CryoWallBuild extends WallBuild implements Ranged {
        @Override
        public void afterDestroyed(){
            Units.nearbyEnemies(team, x, y, range, u -> {
                if (u != null) {
                    u.apply(status, statusDuration);
                }
            });
        }

        @Override
        public float range() {
            return range;
        }
    }
}
