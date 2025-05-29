package jp.funnything.competition.util;

import java.util.Arrays;
import java.util.List;

import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;

public class Prime {
    public static class PrimeData {
        public int[] list;
        public boolean[] map;

        private PrimeData( final int[] values , final boolean[] map ) {
            list = values;
            this.map = map;
        }
    }

    public static long[] factorize( long n , final int[] primes ) {
        final List< Long > factor = Lists.newArrayList();

        for ( final int p : primes ) {
            if ( n < p * p ) {
                break;
            }

            while ( n % p == 0 ) {
                factor.add( ( long ) p );
                n /= p;
            }
        }

        if ( n > 1 ) {
            factor.add( n );
        }

        return Longs.toArray( factor );
    }

    public static PrimeData prepare( final int n ) {
        final List< Integer > primes = Lists.newArrayList();

        final boolean[] map = new boolean[ n ];
        Arrays.fill( map , true );

        map[ 0 ] = map[ 1 ] = false;

        primes.add( 2 );
        for ( int composite = 2 * 2 ; composite < n ; composite += 2 ) {
            map[ composite ] = false;
        }

        for ( int value = 3 ; value < n ; value += 2 ) {
            if ( map[ value ] ) {
                primes.add( value );
                for ( int composite = value * 2 ; composite < n ; composite += value ) {
                    map[ composite ] = false;
                }
            }
        }

        return new PrimeData( Ints.toArray( primes ) , map );
    }
}
