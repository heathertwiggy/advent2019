package component.wires;

import java.util.LinkedList;
import java.util.stream.IntStream;

class Wire {
    LinkedList<Point> path = new LinkedList<>();
    // int minX = 0, minY = 0, maxX = 0, maxY = 0;

    public Wire() {
        path.add(Point.origin()); // humbug
    }

    void take(Step step){
        IntStream.range(0, step.length)
                .forEach(move -> {
                    path.add(step.dir.movement.apply(position()));
                });
    }

    Point position(){
        return path.getLast();
    }


}