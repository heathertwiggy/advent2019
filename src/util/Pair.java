package util;

public class Pair<A, B> {
    public final A left;
    public final B right;

    private Pair(A left, B right) {
        this.left = left;
        this.right = right;
    }

    public A getLeft() {
        return left;
    }

    public B getRight() {
        return right;
    }

    public static <A,B> Pair<A, B> of(A left, B right){
        return new Pair<>(left, right);
    }
}
