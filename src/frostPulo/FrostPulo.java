package frostPulo;

import arc.*;
import arc.util.*;
import frostPulo.content.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;

public class FrostPulo extends Mod{

    public FrostPulo(){
    }

    @Override
    public void loadContent(){
        FPStatuses.load();
        FPWeather.load();
        FPItems.load();
        FPUnits.load();
        FPBlocks.load();
        FPSectors.load();
        FPTechTree.load();
    }

}
