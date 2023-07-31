package frostPulo.content;

import arc.struct.*;
import frostPulo.classes.blocks.defence.*;
import frostPulo.classes.campain.FrozenUnit;
import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.entities.pattern.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;

import static mindustry.type.ItemStack.*;

public class FPBlocks {
    public static Block
            //mines
            frostMine,

            //defence
            cryoWall, cryoWallLarge,

            //turrets
            wake, riot,

            //frozen/derelict
            frozenFlare, frozenTest, frozenDuo
            ;
    public static void load() {
        Blocks.launchPad.buildVisibility = BuildVisibility.debugOnly;
        //mines
        frostMine = new StatusMine("frost-mine") {{
            requirements(Category.effect, with(Items.titanium, 20, Items.silicon, 16, Items.lead, 6));
            hasShadow = false;
            health = 100;
            cooldown = 120;
            tileDamage = 10;
            damage = 30;
            statusTime = 140;
        }};
        //defence
        cryoWall = new CryoWall("cryo-wall"){{
            requirements(Category.defense, with(Items.titanium, 6, Items.metaglass, 2));
            health = 510;
        }};
        cryoWallLarge = new CryoWall("cryo-wall-large"){{
            requirements(Category.defense, with(Items.titanium, 24, Items.metaglass, 8));
            health = 510 * 4;
            range = 100;
            size = 2;
        }};
        //turrets
        wake = new LiquidTurret("wake"){{
            requirements(Category.turret, with(Items.metaglass, 110, Items.lead, 160, Items.titanium, 90));
            ammo(
                    Liquids.cryofluid, new LiquidBulletType(Liquids.cryofluid){{
                        lifetime = 30f;
                        speed = 5f;
                        knockback = 1.6f;
                        puddleSize = 6f;
                        orbSize = 3f;
                        drag = 0.003f;
                        ammoMultiplier = 0.4f;
                        statusDuration = 60f * 2f;
                        damage = 5f;
                    }}
            );
            size = 2;
            reload = 2f;
            shoot.shots = 1;
            velocityRnd = 0.2f;
            inaccuracy = 2f;
            recoil = 1f;
            shootCone = 50f;
            liquidCapacity = 20f;
            shootEffect = Fx.shootLiquid;
            range = 150f;
            scaledHealth = 95;
            flags = EnumSet.of(BlockFlag.turret, BlockFlag.extinguisher);
        }};
        riot = new ItemTurret("riot"){{
            requirements(Category.turret, with(Items.copper, 210, Items.graphite, 105, Items.silicon, 132, Items.plastanium, 70));
            ammo(
                    FPItems.cryoCrystal, new ArtilleryBulletType(3f, 22, "shell"){{
                        hitEffect = Fx.blastExplosion;
                        knockback = 1f;
                        lifetime = 65f;
                        width = height = 11f;
                        collidesTiles = false;
                        ammoMultiplier = 2f;
                        splashDamageRadius = 36f * 0.75f;
                        splashDamage = 60f;

                        status = StatusEffects.freezing;
                        statusDuration = 130f;
                    }},
                    FPItems.whiteCompound, new ArtilleryBulletType(3f, 30, "shell"){{
                        hitEffect = Fx.blastExplosion;
                        lifetime = 65f;
                        width = height = 12f;
                        collidesTiles = false;
                        ammoMultiplier = 3f;
                        reloadMultiplier = 0.6f;
                        splashDamageRadius = 40f * 0.75f;
                        splashDamage = 45f;

                        status = FPStatuses.whiteout;
                        statusDuration = 210f;
                    }}
            );
            targetAir = false;
            size = 3;
            reload = 110f;
            velocityRnd = 0.2f;
            inaccuracy = 2f;
            recoil = 1f;
            shootCone = 50f;
            liquidCapacity = 20f;
            shootEffect = Fx.shootLiquid;
            range = 190f;
            scaledHealth = 180;
            coolant = consumeCoolant(0.3f);
            ammoEjectBack = 5f;
            ammoUseEffect = Fx.casing3Double;
            ammoPerShot = 2;
        }};
        //frozen/derelict
        frozenDuo = new ItemTurret("duo-frozen"){{
            requirements(Category.turret, BuildVisibility.sandboxOnly, with(Items.copper, 35));
            ammo(
                    Items.copper,  new BasicBulletType(2.5f, 9){{
                        width = 7f;
                        height = 9f;
                        lifetime = 60f;
                        ammoMultiplier = 2;
                    }},
                    Items.graphite, new BasicBulletType(3.5f, 18){{
                        width = 9f;
                        height = 12f;
                        reloadMultiplier = 0.6f;
                        ammoMultiplier = 4;
                        lifetime = 60f;
                    }},
                    Items.silicon, new BasicBulletType(3f, 12){{
                        width = 7f;
                        height = 9f;
                        homingPower = 0.1f;
                        reloadMultiplier = 1.5f;
                        ammoMultiplier = 5;
                        lifetime = 60f;
                    }}
            );

            shoot = new ShootAlternate(3.5f);
            recoil = 0.5f;
            shootY = 3f;
            reload = 30f;
            range = 110;
            shootCone = 15f;
            ammoUseEffect = Fx.casing1;
            health = 250;
            inaccuracy = 2f;
            rotateSpeed = 4f;
            coolant = consumeCoolant(0.1f);
            researchCostMultiplier = 0.05f;
            drawer = new DrawTurret("frozen-");

            limitRange();
        }};
        frozenFlare = new FrozenUnit("frozen-flare"){{
            requirements(Category.effect, BuildVisibility.sandboxOnly, with());
            health = 2000;
            variants = 2;
        }};
        frozenTest = new FrozenUnit("frozen-test"){{
            requirements(Category.effect, BuildVisibility.sandboxOnly, with());
            health = 2000;
            waveCounter = 0;
            unitFr = UnitTypes.mace;
        }};
    }
}
