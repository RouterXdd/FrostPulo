package frostPulo.content;

import mindustry.content.Weathers;
import mindustry.type.Weather;

public class FPWeather {
    public static Weather frostStorm;
    public static void load(){
        Weathers.snow.status = FPStatuses.snowed;
        Weathers.snow.statusDuration = 70;
        Weathers.rain.status = FPStatuses.rained;
        Weathers.rain.statusDuration = 85;
    }
}
