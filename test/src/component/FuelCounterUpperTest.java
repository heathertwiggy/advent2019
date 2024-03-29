package component;

import component.fuel.FuelCounterUpper;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class FuelCounterUpperTest {


    @Test
    public void check_em_day_1_1(){
        assertEquals(654, new FuelCounterUpper(List.of("1969")).getFuelRequirement());
        assertEquals(33583, new FuelCounterUpper(List.of("100756")).getFuelRequirement());
        assertEquals(654+33583, new FuelCounterUpper(List.of("100756", "1969")).getFuelRequirement());
    }

}