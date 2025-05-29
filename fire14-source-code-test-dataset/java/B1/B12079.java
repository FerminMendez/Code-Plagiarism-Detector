package jp.funnything.competition.util;

import java.util.List;

import com.google.common.collect.Lists;

public class Lists2 {
    public static < T > List< T > newArrayListAsArray( final int length ) {
        final List< T > list = Lists.newArrayListWithCapacity( length );

        for ( int index = 0 ; index < length ; index++ ) {
            list.add( null );
        }

        return list;
    }
}
