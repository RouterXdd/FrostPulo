package frostPulo.content;

import mindustry.content.*;
import mindustry.entities.abilities.ArmorPlateAbility;
import mindustry.entities.bullet.*;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.*;
import mindustry.graphics.Pal;
import mindustry.type.*;
import mindustry.type.ammo.ItemAmmoType;
import mindustry.world.meta.*;

public class FPUnits {
    public static UnitType
    reinforcementFlare,
    amalgam,
    omega
            ;
    public static void load(){
        reinforcementFlare = new UnitType("reinforcement-flare"){{
            speed = 3f;
            accel = 0.08f;
            drag = 0.04f;
            flying = true;
            health = 1100;
            engineOffset = 5.75f;
            targetFlags = new BlockFlag[]{BlockFlag.generator, null};
            hitSize = 10;
            itemCapacity = 10;
            constructor = UnitEntity::create;
            outlineColor = Pal.gray;

            weapons.add(new Weapon(){{
                y = 1f;
                x = 2f;
                reload = 5f;
                ejectEffect = Fx.casing1;
                bullet = new BasicBulletType(2.5f, 5){{
                    width = 7f;
                    height = 10f;
                    lifetime = 50f;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    ammoMultiplier = 2;
                }};
                shootSound = Sounds.pew;
            }});
        }};

        omega = new UnitType("omega-mech"){{
            speed = 0.61f;
            hitSize = 11f;
            rotateSpeed = 4f;
            health = 14000;
            armor = 20f;
            mechFrontSway = 0.3f;
            ammoType = new ItemAmmoType(FPItems.cryoCrystal);
            constructor = MechUnit::create;
            canBoost = true;
            abilities.add(new ArmorPlateAbility(){{
                healthMultiplier = 2.5f;
            }});

            weapons.add(new Weapon("frostpulo-omega-mech-weapon"){{
                top = false;
                y = 0.5f;
                x = 9.75f;
                reload = 70f;
                recoil = 3f;
                shake = 2f;
                ejectEffect = Fx.casing2;
                shootSound = Sounds.missile;
                shoot = new ShootSpread(){{
                    shots = 5;
                    spread = 4;
                }};
                bullet = new MissileBulletType(4f, 70){{
                    hitEffect = Fx.blastExplosion;
                    knockback = 1f;
                    lifetime = 80f;
                    width = height = 8f;
                    splashDamageRadius = 20f;
                    splashDamage = 50f;
                    homingPower = 0.6f;
                    weaveRandom = true;
                    weaveScale = 0.8f;
                    weaveMag = 2;
                    backColor = Pal.bulletYellowBack;
                    frontColor = Pal.bulletYellow;
                }};
            }});
        }};
    }
}
