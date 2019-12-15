package component.wires;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WireIntersectorTest {


    @Test
    public void wire_test_one() {
        assertEquals(
                159,
                new WireIntersector(
                        "R75,D30,R83,U83,L12,D49,R71,U7,L72",
                        "U62,R66,U55,R34,D71,R55,D58,R83"
                ).naiveClosestIntersection().get());
    }

    @Test
    public void wire_test_two() {
        assertEquals(
                135,
                new WireIntersector(
                        "R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51",
                        "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7"
                ).naiveClosestIntersection().get());
    }

    @Test
    public void wire_test_twoone() {
        assertEquals(
                159,
                new WireIntersector(
                        "R75,D30,R83,U83,L12,D49,R71,U7,L72",
                        "U62,R66,U55,R34,D71,R55,D58,R83"
                ).closestIntersection().get());
    }

    @Test
    public void wire_test_twotwo() {
        assertEquals(
                135,
                new WireIntersector(
                        "R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51",
                        "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7"
                ).closestIntersection().get());
    }
}