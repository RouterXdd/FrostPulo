package frostPulo.content;

import arc.graphics.Color;
import mindustry.type.*;

public class FPItems {
    public static Item
        cryoCrystal, whiteCompound
            ;
    public static void load(){
        cryoCrystal = new Item("cryo-crystal", Color.valueOf("87ceeb")){{
            flammability = -1.5f;
        }};
        whiteCompound = new Item("white-compound", Color.white){{
            charge = 0.3f;
        }};
    }
}
