package util;

import java.util.Objects;

public class Pair<A, B> {
    public final A left;
    public final B right;

    private Pair(A left, B right) {
        if (left == null || right == null) throw new IllegalArgumentException("no nulls. a:" + left + ", b:" +right);
        this.left = left;
        this.right = right;
    }

    public A getLeft() {
        return left;
    }

    public B getRight() {
        return right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return left.equals(pair.left) &&
                right.equals(pair.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    public static <A,B> Pair<A, B> of(A left, B right){
        return new Pair<>(left, right);
    }
}
