package component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FuelCounterUpper {

    List<String> masses;

    public FuelCounterUpper(List<String> masses) {
        this.masses = masses;
    }

    public int getFuelRequirement(){
        return masses.stream().mapToInt(Integer::valueOf)
                .map(i -> (i/3)-2)
                .sum();
    }
}
