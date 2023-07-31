package frostPulo.content;

import arc.graphics.Color;
import mindustry.type.StatusEffect;

public class FPStatuses {
    public static StatusEffect
            snowed, rained, whiteout
            ;
    public static void load(){
        snowed = new StatusEffect("snowed"){{
            color = Color.white;
            speedMultiplier = 0.9f;
        }};
        rained = new StatusEffect("rained"){{
            color = Color.blue;
            healthMultiplier = 0.9f;
        }};
        whiteout = new StatusEffect("whiteout"){{
            color = Color.white;
            speedMultiplier = 0.4f;
            reloadMultiplier = 0.5f;
        }};
    }
}
