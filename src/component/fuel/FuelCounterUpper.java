package component.fuel;

import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class FuelCounterUpper {

    private final List<String> masses;
    protected final IntUnaryOperator mass2Fuel = i -> (i / 3) - 2;
    protected final IntUnaryOperator mass2FuelLoud = i -> {
        int abbna = (i / 3) - 2;
        System.out.println("out: " + abbna);
        return abbna;
    };

    public FuelCounterUpper(List<String> masses) {
        this.masses = masses;
    }

    public int getFuelRequirement(){
        return intMasses().map(mass2Fuel).sum();
    }

    protected final IntStream intMasses() {
        return masses.stream().mapToInt(Integer::valueOf);
    }
}
