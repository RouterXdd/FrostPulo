package frostPulo.classes.blocks.defence;

import arc.Core;
import arc.graphics.g2d.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.world.*;

public class StatusMine extends Block {
    public final int timerDamage = timers++;

    public float cooldown = 80f;
    public float tileDamage = 5f;
    public float damage = 13;
    public Effect onEffect = Fx.landShock;
    public StatusEffect status = StatusEffects.freezing;
    public float statusTime = 60;
    public float teamAlpha = 0.3f;
    public TextureRegion teamRegion;

    public StatusMine(String name){
        super(name);
        update = false;
        destructible = true;
        solid = false;
        targetable = false;
        buildType = StatusMineBuild::new;
    }
    @Override
    public void load(){
        super.load();
        teamRegion = Core.atlas.find(name + "-team");
    }

    public class StatusMineBuild extends Building {

        @Override
        public void drawTeam(){
            //no
        }

        @Override
        public void draw(){
            super.draw();
            Draw.color(team.color, teamAlpha);
            Draw.rect(teamRegion, x, y);
            Draw.color();
        }

        @Override
        public void drawCracks(){
            //no
        }

        @Override
        public void unitOn(Unit unit){
            if(enabled && unit.team != team && timer(timerDamage, cooldown)){
                onEffect.at(x, y, 0);
                damage(tileDamage);
                unit.damage(damage);
                unit.apply(status, statusTime);
            }
        }
    }
}
