package component.wires;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Step {
    Direction dir;
    int length;

    public Step(String step) {
        this.dir = Direction.map.get(step.substring(0, 1));
        this.length = Integer.parseInt(step.substring(1));
    }

    static List<Step> parse(String rawWire){
        return Arrays.stream(rawWire.split(",")).map(Step::new).collect(Collectors.toList());
    }
}