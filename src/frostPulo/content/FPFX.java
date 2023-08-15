package frostPulo.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import frostPulo.graphics.FPPal;
import mindustry.entities.*;

import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;

public class FPFX {
    public static final Rand rand = new Rand();
    public static final Vec2 v = new Vec2();
    public static final Effect
            tearing = new Effect(8f, e -> {
        color(e.color, FPPal.armorTeared, e.fin());

        alpha(e.fslope() * 0.78f);

        float length = 3f + e.finpow() * 10f;
        rand.setSeed(e.id);
        for(int i = 0; i < rand.random(3, 5); i++){
            v.trns(rand.random(360f), rand.random(length));
            Fill.circle(e.x + v.x, e.y + v.y, rand.random(0.8f, 1.7f) + e.fslope() * 1.1f);
        }
    });
}
