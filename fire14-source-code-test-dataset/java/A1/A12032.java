package jp.funnything.competition.util;

import java.util.Comparator;

import com.google.common.base.Objects;

public class Pair< T1 , T2 > {
    public static < T1 extends Comparable< T1 > , T2 extends Comparable< T2 > > Comparator< Pair< T1 , T2 > > getFirstComarator() {
        return new Comparator< Pair< T1 , T2 > >() {
            @Override
            public int compare( final Pair< T1 , T2 > o1 , final Pair< T1 , T2 > o2 ) {
                final int c = o1.first.compareTo( o2.first );
                return c != 0 ? c : o1.second.compareTo( o2.second );
            }
        };
    }

    public static < T1 extends Comparable< T1 > , T2 extends Comparable< T2 > > Comparator< Pair< T1 , T2 > > getSecondComarator() {
        return new Comparator< Pair< T1 , T2 > >() {
            @Override
            public int compare( final Pair< T1 , T2 > o1 , final Pair< T1 , T2 > o2 ) {
                final int c = o1.second.compareTo( o2.second );
                return c != 0 ? c : o1.first.compareTo( o2.first );
            }
        };
    }

    public T1 first;
    public T2 second;

    public Pair( final Pair< T1 , T2 > that ) {
        this.first = that.first;
        this.second = that.second;
    }

    public Pair( final T1 first , final T2 second ) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals( final Object obj ) {
        if ( this == obj ) {
            return true;
        }

        if ( obj == null || getClass() != obj.getClass() ) {
            return false;
        }

        final Pair< ? , ? > that = ( Pair< ? , ? > ) obj;

        return Objects.equal( this.first , that.first ) && Objects.equal( this.first , that.first );
    }

    @Override
    public int hashCode() {
        final int prime = 31;

        int result = 1;
        result = prime * result + ( first == null ? 0 : first.hashCode() );
        result = prime * result + ( second == null ? 0 : second.hashCode() );

        return result;
    }

    @Override
    public String toString() {
        return "Pair [first=" + first + ", second=" + second + "]";
    }
}
