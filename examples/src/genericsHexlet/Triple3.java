package genericsHexlet;

public class Triple3<T1, T2, T3> extends Tuple3<T1,T2> {
    private final T3 middle;

    public Triple3(final T1 left, final T2 right, final T3 middle) {
        super(left,right);
        this.middle = middle;
    }
    public T3 getMiddle() {
        return middle;
    }

}
