package template;

import java.util.Objects;

public class Pair<T1, T2> implements Comparable<Pair<T1, T2>>{
    private T1 o1;
    private T2 o2;

    public Pair(T1 o1, T2 o2) {
        this.o1 = o1;
        this.o2 = o2;
    }


    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Pair)) {return false;}
        return (compareTo((Pair<T1, T2>)other) == 0);
    }

    @Override
    public int compareTo(Pair<T1, T2> other) {
        int c1 = ((Comparable<T1>) o1).compareTo(other.getO1());
        if (c1 != 0) {return c1;}
        int c2 = ((Comparable<T2>) o2).compareTo(other.getO2());
        return c2;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.o1);
        hash = 83 * hash + Objects.hashCode(this.o2);
        return hash;
    }

    @Override
    public String toString()
    { 
           return "[" + o1 + ", " + o2 + "]"; 
    }

    public T1 getO1() {
        return o1;
    }

    public void setO1(T1 o1) {
        this.o1 = o1;
    }

    public T2 getO2() {
        return o2;
    }

    public void setO2(T2 o2) {
        this.o2 = o2;
    }
}
