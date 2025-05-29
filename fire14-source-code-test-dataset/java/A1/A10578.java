package codejam2012.qualification.b;

public final class Triplet {

    public final int a;
    public final int b;
    public final int c;
    public final int total;
    public final boolean surprising;

    private Triplet(int a, int b, int c, int total) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.total = total;
        surprising = Math.abs(a - b) > 1 || Math.abs(a - c) > 1 || Math.abs(b - c) > 1;
    }

    public static Triplet of(int a, int b, int c, int total) {
        return new Triplet(a, b, c, total);
    }

    public boolean hasAtLeast(int p) {
        return a >= p || b >= p || c >= p;
    }

    @Override
    public String toString() {
        return String.format("(%d,%d,%d)%s = %d", a, b, c, surprising ? "*" : "", total);
    }
}
