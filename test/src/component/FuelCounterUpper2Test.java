package component;

import component.fuel.FuelCounterUpper2;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FuelCounterUpper2Test {

    @Test
    public void check_em_day_1_2(){
        assertEquals(966, new FuelCounterUpper2(List.of("1969")).getFuelRequirement());
        assertEquals(50346, new FuelCounterUpper2(List.of("100756")).getFuelRequirement());
        assertEquals(966+50346, new FuelCounterUpper2(List.of("100756", "1969")).getFuelRequirement());
    }
}