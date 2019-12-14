package component;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class FuelCounterUpperTest {


    @Test
    public void check_em(){
        assertEquals(654, new FuelCounterUpper(List.of("1969")).getFuelRequirement());
        assertEquals(33583, new FuelCounterUpper(List.of("100756")).getFuelRequirement());
        assertEquals(654+33583, new FuelCounterUpper(List.of("100756", "1969")).getFuelRequirement());
    }

}