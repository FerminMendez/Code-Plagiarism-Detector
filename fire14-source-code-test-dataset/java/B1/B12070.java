package jp.funnything.prototype;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import jp.funnything.competition.util.CompetitionIO;
import jp.funnything.competition.util.Packer;

import org.apache.commons.io.FileUtils;

import com.google.common.collect.Sets;

public class Runner {
    public static void main( final String[] args ) throws Exception {
        new Runner().run();
    }

    void pack() {
        try {
            final File dist = new File( "dist" );

            if ( dist.exists() ) {
                FileUtils.deleteQuietly( dist );
            }

            final File workspace = new File( dist , "workspace" );

            FileUtils.copyDirectory( new File( "src/main/java" ) , workspace );
            FileUtils.copyDirectory( new File( "../../../../CompetitionUtil/Lib/src/main/java" ) , workspace );

            Packer.pack( workspace , new File( dist , "sources.zip" ) );
        } catch ( final IOException e ) {
            throw new RuntimeException( e );
        }
    }

    void run() throws Exception {
        final CompetitionIO io = new CompetitionIO();

        final int t = io.readInt();

        for ( int index = 0 ; index < t ; index++ ) {
            final int[] values = io.readInts();
            final int a = values[ 0 ];
            final int b = values[ 1 ];

            io.write( index + 1 , solve( a , b ) );
        }

        io.close();

        pack();
    }

    int solve( final int a , final int b ) {
        int count = 0;

        final int nDigit = ( int ) Math.floor( Math.log10( a ) ) + 1;
        final int next = ( int ) Math.pow( 10 , nDigit - 1 );
        final Set< Integer > already = Sets.newTreeSet();

        for ( int n = a ; n + 1 <= b ; n++ ) {
            if ( already.contains( n ) ) {
                continue;
            }

            int inRange = 1;
            already.add( n );

            for ( int base = 10 , m = next ; base < n ; base *= 10 , m /= 10 ) {
                final int v = n / base + n % base * m;

                if ( already.contains( v ) ) {
                    continue;
                }

                if ( v >= a && v <= b ) {
                    inRange++;
                    already.add( v );
                }
            }

            count += inRange * ( inRange - 1 ) / 2;
        }

        return count;
    }
}
