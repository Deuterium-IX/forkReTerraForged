package etcodehome.freeterraforged.world.worldgen.cell.terrain.populator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

import etcodehome.freeterraforged.world.worldgen.cell.heightmap.Levels;

class ArchipelagoPopulatorTest {
    @Test
    void shelfDetailStaysSubmergedAcrossWorldScales() throws Exception {
        Method detail = method("addSubmergedDetail", float.class, float.class, Levels.class);
        for (int scale : new int[] {256, 1024, 2048}) {
            Levels levels = new Levels(scale, 2048, 2048, 63);
            for (int depth : new int[] {0, 1, 30, 300, 1500}) {
                float shelf = levels.water(-depth);
                float result = (float) detail.invoke(null, shelf, 6.0F, levels);
                assertTrue(result <= levels.water, "Shelf must not emerge above the waterline");
                assertTrue(result >= shelf, "Additive seabed detail must not lower the shelf");
                assertEquals(Math.min(depth, 6), (result - shelf) * scale, 0.001F);
            }
        }
    }

    @Test
    void supportsTheFullShallowsWidthSliderRange() throws Exception {
        Method width = method("beachWidth", float.class);
        assertEquals(0.45F, (float) width.invoke(null, 0.45F));
        assertEquals(0.50F, (float) width.invoke(null, 0.50F));
    }

    @Test
    void coastalTransitionStartsAtAmbientOceanAndReachesTheIslandCoast() throws Exception {
        Method edge = method("continentEdge", float.class, float.class, float.class, float.class);
        float ocean = 0.10F;
        float coast = 0.35F;
        float shelfEnd = 0.20F;
        assertEquals(ocean, (float) edge.invoke(null, 0.0F, shelfEnd, ocean, coast), 0.0001F);
        assertEquals(coast, (float) edge.invoke(null, shelfEnd, shelfEnd, ocean, coast), 0.0001F);
        float previous = ocean;
        for (int step = 1; step <= 20; step++) {
            float value = (float) edge.invoke(null, shelfEnd * step / 20.0F, shelfEnd, ocean, coast);
            assertTrue(value >= previous && value <= coast, "Ocean-to-coast transition must be monotonic");
            previous = value;
        }
    }

    // Exercise PR #232's numerical boundaries without booting a loader-specific registry.
    private static Method method(String name, Class<?>... parameters) throws Exception {
        Method method = ArchipelagoPopulator.class.getDeclaredMethod(name, parameters);
        method.setAccessible(true);
        return method;
    }
}
