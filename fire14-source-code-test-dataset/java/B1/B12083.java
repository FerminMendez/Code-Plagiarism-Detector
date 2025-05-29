package jp.funnything.competition.util;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Do NOT change the element in iteration
 */
public class Permutation implements Iterable< int[] > , Iterator< int[] > {
    public static int[] fromNumber( long value , final int n ) {
        final int[] data = new int[ n ];

        for ( int index = 0 ; index < n ; index++ ) {
            data[ index ] = index;
        }

        for ( int index = 1 ; index < n ; index++ ) {
            final int pos = ( int ) ( value % ( index + 1 ) );

            value /= index + 1;

            final int swap = data[ index ];
            data[ index ] = data[ pos ];
            data[ pos ] = swap;
        }

        return data;
    }

    public static long toNumber( final int[] perm ) {
        final int[] data = Arrays.copyOf( perm , perm.length );

        long c = 0;

        for ( int index = data.length - 1 ; index > 0 ; index-- ) {
            int pos = 0;
            for ( int index_ = 1 ; index_ <= index ; index_++ ) {
                if ( data[ index_ ] > data[ pos ] ) {
                    pos = index_;
                }
            }

            final int t = data[ index ];
            data[ index ] = data[ pos ];
            data[ pos ] = t;

            c = c * ( index + 1 ) + pos;
        }

        return c;
    }

    private final int _n;
    private final int[] _data;
    private final int[] _count;
    int _k;

    public Permutation( final int n ) {
        _n = n;

        _data = new int[ n ];
        for ( int index = 0 ; index < n ; index++ ) {
            _data[ index ] = index;
        }

        _count = new int[ n + 1 ];
        for ( int index = 1 ; index <= n ; index++ ) {
            _count[ index ] = index;
        }

        _k = 1;
    }

    @Override
    public boolean hasNext() {
        return _k < _n;
    }

    @Override
    public Iterator< int[] > iterator() {
        return this;
    }

    @Override
    public int[] next() {
        final int i = _k % 2 != 0 ? _count[ _k ] : 0;

        final int t = _data[ _k ];
        _data[ _k ] = _data[ i ];
        _data[ i ] = t;

        for ( _k = 1 ; _count[ _k ] == 0 ; _k++ ) {
            _count[ _k ] = _k;
        }
        _count[ _k ]--;

        return _data;
    }

    @Override
    public void remove() {
    }
}
