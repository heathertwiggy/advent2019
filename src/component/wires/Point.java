package component.wires;

import util.Pair;

import java.util.Objects;

class Point  {
    final Pair<Integer, Integer> me;
    final int x;
    final int y;
    final boolean origin;

    public int manhattan(){
        return Math.abs(x) + Math.abs(y);
    }

    private Point(){
        me = Pair.of(0, 0);
        this.x = 0;
        this.y = 0;
        this.origin = true;
    }

    public Point(int x, int y) {
        me = Pair.of(x, y);
        this.x = x;
        this.y = y;
        this.origin = false;
    }

    public Point(Pair<Integer, Integer> me) {
        this(me.left, me.right);
    }

    public Point up(){
        return new Point(x, y+1);
    }

    public Point down(){
        return new Point(x, y-1);
    }

    public Point left(){
        return new Point(x-1, y);
    }

    public Point right(){
        return new Point(x+1, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        if (this.origin && ((Point) o).origin) return false;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public static Point origin(){
        return new Point();
    }
}
