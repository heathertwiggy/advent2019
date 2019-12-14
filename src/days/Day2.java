package days;

import component.FuelCounterUpper;
import component.FuelCounterUpper2;
import computer.ShipComputer;
import util.Input;

public class Day2 implements Dayable {

    @Override
    public String day() {
        return "2";
    }

    @Override
    public String computeOne() {
        return String.valueOf(new ShipComputer(Input.list(2).get(0)).compute());
    }

    @Override
    public String computeTwo() {
        //return String.valueOf(new FuelCounterUpper2(Input.list(1)).getFuelRequirement());
        return "null";
    }

    @Override
    public String correctResultOne() {
        return "4690667";
    }

    @Override
    public String correctResultTwo() {
        return "s";
    }

}
