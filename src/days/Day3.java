package days;

import component.wires.WireIntersector;
import util.Input;

import java.util.List;

public class Day3 implements Dayable {

    @Override
    public String day() {
        return "3";
    }

    @Override
    public String computeOne() {
        List<String> input = Input.list(3);
        WireIntersector wi = new WireIntersector(input.get(0), input.get(1));

        return wi.closestIntersection().map(String::valueOf)
                .orElseThrow(() -> new IllegalArgumentException("bad input, no intersection"));
    }

    @Override
    public String computeTwo() {
        return "nek";
    }

    @Override
    public String correctResultOne() {
        return "1285";
    }

    @Override
    public String correctResultTwo() {
        return "s";
    }

}
