package frostPulo.classes.entities.bullets;

import arc.math.*;
import frostPulo.content.FPFX;
import mindustry.entities.bullet.*;
import mindustry.gen.*;

public class ArmorTearBullet extends BasicBulletType {
    public float tearChance = 30, tearAmount = 2;
    public ArmorTearBullet(float speed, float damage){
        super(speed, damage);
    }
    @Override
    public void hitEntity(Bullet b, Hitboxc entity, float health){
        if(entity instanceof Unit unit){
            unit.damage(b.damage);
            if (Mathf.chance(tearChance) && unit.armor > 0) {
                FPFX.tearing.at(unit.x, unit.y, 20);
                unit.armor(unit.armor - tearAmount);
            }
        }
    }
}
