package component.fuel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FuelCounterUpper2 extends FuelCounterUpper {

    public FuelCounterUpper2(List<String> masses) {
        super(masses);
    }

    @Override
    public int getFuelRequirement() {
        return intMasses()
                .flatMap(i -> IntStream.iterate(i, x -> x > 0, mass2Fuel))
                .sum()
                - intMasses().sum(); // <- well this was embarrassing, not sure how to avoid including first element in the iteration. Oh well.

        // return intMasses().flatMap(i -> fuels(i).stream().mapToInt(x->x)).sum();
    }

    List<Integer> fuels(Integer start){
        // i mean this works too, but streams are fun.
        int fuel = mass2Fuel.applyAsInt(start);
        List<Integer> fuels = new ArrayList<>(20);
        fuels.add(fuel);
        while (fuel > 0){
            fuel = mass2Fuel.applyAsInt(fuel);
            if (fuel > 0){
                fuels.add(fuel);
            }
        }

        return fuels;
    }


}
