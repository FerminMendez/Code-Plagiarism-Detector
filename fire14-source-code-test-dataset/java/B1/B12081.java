package jp.funnything.competition.util;

import java.util.Iterator;

/**
 * Do NOT change the element in iteration
 */
public class Combination implements Iterable< int[] > , Iterator< int[] > {
    private final int _n;
    private final int _k;
    private int[] _data;

    public Combination( final int n , final int k ) {
        if ( k < 0 || k > n ) {
            throw new IllegalArgumentException();
        }

        _n = n;
        _k = k;
    }

    @Override
    public boolean hasNext() {
        return _data == null || _data.length > 0 && _data[ 0 ] < _n - _k;
    }

    @Override
    public Iterator< int[] > iterator() {
        return this;
    }

    @Override
    public int[] next() {
        if ( _data == null ) {
            _data = new int[ _k ];
            for ( int index = 0 ; index < _k ; index++ ) {
                _data[ index ] = index;
            }
        } else {
            int i = 0;

            while ( i < _k - 1 && _data[ i + 1 ] == _data[ i ] + 1 ) {
                _data[ i ] = i++;
            }

            _data[ i ]++;
        }

        return _data;
    }

    @Override
    public void remove() {
    }
}
