package days;

import component.FuelCounterUpper;
import component.FuelCounterUpper2;
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
    public String computeTwo() {
        return String.valueOf(new FuelCounterUpper2(Input.list(1)).getFuelRequirement());
    }

    @Override
    public String correctResultTwo() {
        return "4973628";
    }

    @Override
    public String correctResultOne() {
        return "3317668";
    }
}
