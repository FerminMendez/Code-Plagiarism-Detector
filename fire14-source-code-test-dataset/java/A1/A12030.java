package jp.funnything.prototype;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import jp.funnything.competition.util.CompetitionIO;
import jp.funnything.competition.util.Packer;

import org.apache.commons.io.FileUtils;

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

            final int n = values[ 0 ];
            final int s = values[ 1 ];
            final int p = values[ 2 ];
            final int[] ts = Arrays.copyOfRange( values , 3 , values.length );

            if ( n != ts.length ) {
                throw new RuntimeException( "assert" );
            }

            io.write( index + 1 , solve( s , p , ts ) );
        }

        io.close();

        pack();
    }

    int solve( final int s , final int p , final int[] ts ) {
        int count = 0;
        int consumed = 0;

        for ( final int sum : ts ) {
            // if not surprising
            int max = sum % 3 == 0 ? sum / 3 : sum / 3 + 1;

            if ( max >= p ) {
                count++;
                continue;
            }

            if ( consumed < s && sum > 1 ) {
                // if surprising
                max = sum % 3 == 2 ? sum / 3 + 2 : sum / 3 + 1;

                if ( max >= p ) {
                    consumed++;
                    count++;
                }
            }
        }

        return count;
    }
}
