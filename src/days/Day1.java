package days;

import component.FuelCounterUpper;
import util.Input;

public class Day1 implements Dayable {

    @Override
    public String day() {
        return "1";
    }

    @Override
    public String computeOne() {
        return String.valueOf(new FuelCounterUpper(Input.list(1)).getFuelRequirement());
    }

    @Override
    public String correctResultOne() {
        return "3317668";
    }
}
