package component.wires;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

public class WireIntersector {

    String rawWire1;
    String rawWire2;
    List<Step> path1;
    List<Step> path2;

    Wire wire1 = new Wire();
    Wire wire2 = new Wire();

    public WireIntersector(String rawWire1, String rawWire2) {
        this.rawWire1 = rawWire1;
        this.rawWire2 = rawWire2;
        path1 = Step.parse(rawWire1);
        path2 = Step.parse(rawWire2);
    }

    public Optional<Integer> naiveClosestIntersection(){
        path1.forEach(wire1::take);
        path2.forEach(wire2::take);

        // took 366 966ms
        return naiveClosestIntersection(wire1, wire2).map(Point::manhattan);
    }

    public Optional<Integer> closestIntersection(){
        path1.forEach(wire1::take);
        path2.forEach(wire2::take);

        // took 330ms (parallel streams)
        // took 250 ms (sequential streams)
        // then slowed to ~450 ms sequential when I moved things out of wire. Huh!
        return closestIntersection(wire1, wire2).map(Point::manhattan);
    }

    Optional<Point> naiveClosestIntersection(Wire one, Wire two){
        Queue<Intersection> intersections = new PriorityQueue<>();

        // this is inefficient as hell, but eh.
        for (Point p1 : one.path){
            for (Point p2 : two.path){
                if (p1.equals(p2)){
                    intersections.add(new Intersection(p1));
                }
            }
        }

        return intersections.size() > 0 ? Optional.of(intersections.peek().point) : Optional.empty();
    }

    Optional<Point> closestIntersection(Wire one, Wire two){
        // still pretty bit naive tho, but fast enough.
        // basically, instead of comparing *all* points to all other points,
        // compare only those that have the same manhattan distance.
        // for the current problem size this result in a speedup of x1300 or so.
        Queue<Intersection> intersections = new PriorityQueue<>();

        Map<Integer, Set<Point>> candidates1 = one.path.stream().collect(Collectors.groupingBy(Point::manhattan, toSet()));
        Map<Integer, Set<Point>> candidates2 = two.path.stream().collect(Collectors.groupingBy(Point::manhattan, toSet()));

        Set<Integer> keys = new HashSet<>(candidates1.keySet().size() + candidates2.keySet().size());
        keys.addAll(candidates1.keySet());
        keys.addAll(candidates2.keySet());

        for (Integer key : keys){
            if (candidates1.containsKey(key) && candidates2.containsKey(key)){
                for (Point p1 : candidates1.get(key)){
                    for (Point p2 : candidates2.get(key)){
                        if (p1.equals(p2)){
                            intersections.add(new Intersection(p1));
                        }
                    }
                }
            }
        }

        //keys.stream()
        //        .filter(key -> candidates1.containsKey(key) && candidates2.containsKey(key))
        //        .flatMap(key -> {
        //        //.forEach(key -> {
        //            Set<Point> intersection = new HashSet<>(candidates1.get(key));
        //            intersection.retainAll(candidates2.get(key));
        //            //intersection.stream().map(Intersection::new).forEach(intersections::add);
        //            return intersection.stream();
        //        })
        //        //;
        //        .map(Intersection::new)
        //        .forEach(intersections::add);

        return intersections.size() > 0 ? Optional.of(intersections.peek().point) : Optional.empty();
    }

    static class Intersection implements Comparable<Intersection>{
        final int distance;
        final Point point;

        Intersection(Point point) {
            this.point = point;
            distance = point.manhattan();
        }

        @Override
        public int compareTo(Intersection o) {
            return distance - o.distance;
        }
    }

}
