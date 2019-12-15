package component.wires;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

enum Direction{
    U(Point::up),
    D(Point::down),
    L(Point::left),
    R(Point::right);

    public final Function<Point, Point> movement;

    public static Map<String, Direction> map = Arrays.stream(values())
            .collect(Collectors.toMap(Direction::name, Function.identity()));

    Direction(Function<Point, Point> movement){
        this.movement = movement;
    }
}
