package jp.funnything.prototype;

import static java.lang.Math.abs;

import java.io.File;
import java.io.IOException;

import jp.funnything.competition.util.CompetitionIO;
import jp.funnything.competition.util.Packer;

import org.apache.commons.io.FileUtils;
import org.apache.commons.math.fraction.Fraction;
import org.apache.commons.math.util.MathUtils;

public class Runner {
    public static void main( final String[] args ) throws Exception {
        new Runner().run();
    }

    boolean isValid( final int d , final boolean[][] map , final int ox , final int oy , int dx , int dy ) {
        final Fraction fox = new Fraction( ox * 2 + 1 );
        final Fraction foy = new Fraction( oy * 2 + 1 );
        Fraction x = new Fraction( ox * 2 + 1 );
        Fraction y = new Fraction( oy * 2 + 1 );

        Fraction sumDiffX = new Fraction( 0 );
        Fraction sumDiffY = new Fraction( 0 );

        for ( ; ; ) {
            final Fraction diffX =
                    new Fraction( dx > 0 ? ( int ) Math.floor( x.doubleValue() + 1 ) : ( int ) Math.ceil( x.doubleValue() - 1 ) ).subtract( x );
            final Fraction diffY =
                    new Fraction( dy > 0 ? ( int ) Math.floor( y.doubleValue() + 1 ) : ( int ) Math.ceil( y.doubleValue() - 1 ) ).subtract( y );

            if ( abs( diffX.doubleValue() * dy ) < abs( diffY.doubleValue() * dx ) ) {
                x = x.add( diffX );
                y = y.add( diffX.multiply( dy ).divide( dx ) );
                sumDiffX = sumDiffX.add( diffX.abs() );
                sumDiffY = sumDiffY.add( diffX.multiply( dy ).divide( dx ).abs() );
            } else {
                y = y.add( diffY );
                x = x.add( diffY.multiply( dx ).divide( dy ) );
                sumDiffY = sumDiffY.add( diffY.abs() );
                sumDiffX = sumDiffX.add( diffY.multiply( dx ).divide( dy ).abs() );
            }

            if ( sumDiffX.multiply( sumDiffX ).add( sumDiffY.multiply( sumDiffY ) ).compareTo( new Fraction( d * d * 2 * 2 ) ) > 0 ) {
                return false;
            }

            if ( x.equals( fox ) && y.equals( foy ) ) {
                return true;
            }

            final int nx = x.intValue() / 2 + ( dx > 0 ? 0 : -1 );
            final int ny = y.intValue() / 2 + ( dy > 0 ? 0 : -1 );

            if ( x.getDenominator() == 1 && x.getNumerator() % 2 == 0 && y.getDenominator() == 1 && y.getNumerator() % 2 == 0 ) {
                if ( map[ ny ][ nx ] ) {
                    final int px = x.intValue() / 2 + ( dx > 0 ? -1 : 0 );
                    final int py = y.intValue() / 2 + ( dy > 0 ? -1 : 0 );

                    if ( map[ py ][ nx ] ) {
                        if ( map[ ny ][ px ] ) {
                            dx = -dx;
                            dy = -dy;
                        } else {
                            dx = -dx;
                        }
                    } else {
                        if ( map[ ny ][ px ] ) {
                            dy = -dy;
                        } else {
                            return false;
                        }
                    }
                }
            } else {
                if ( x.getDenominator() == 1 && x.getNumerator() % 2 == 0 ) {
                    if ( map[ y.intValue() / 2 ][ nx ] ) {
                        dx = -dx;
                    }
                } else if ( y.getDenominator() == 1 && y.getNumerator() % 2 == 0 ) {
                    if ( map[ ny ][ x.intValue() / 2 ] ) {
                        dy = -dy;
                    }
                }
            }
        }
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
            final int h = values[ 0 ];
            final int w = values[ 1 ];
            final int d = values[ 2 ];

            final char[][] map = new char[ h ][];
            for ( int y = 0 ; y < h ; y++ ) {
                final char[] l = io.read().toCharArray();

                if ( l.length != w ) {
                    throw new RuntimeException( "assert" );
                }

                map[ y ] = l;
            }

            io.write( index + 1 , solve( d , map ) );
        }

        io.close();

        pack();
    }

    int solve( final int d , final char[][] map ) {
        int count = 0;

        int ox = -1;
        int oy = -1;
        final boolean[][] parsed = new boolean[ map.length ][];

        for ( int y = 0 ; y < map.length ; y++ ) {
            parsed[ y ] = new boolean[ map[ y ].length ];

            for ( int x = 0 ; x < map[ y ].length ; x++ ) {
                final char c = map[ y ][ x ];

                if ( c == '#' ) {
                    parsed[ y ][ x ] = true;
                }

                if ( c == 'X' ) {
                    ox = x;
                    oy = y;
                }
            }
        }

        for ( int dy = -d ; dy <= d ; dy++ ) {
            for ( int dx = -d ; dx <= d ; dx++ ) {
                if ( dx == 0 && dy == 0 ) {
                    continue;
                }

                if ( MathUtils.gcd( dx , dy ) != 1 ) {
                    continue;
                }

                if ( dx * dx + dy * dy > d * d ) {
                    continue;
                }

                if ( isValid( d , parsed , ox , oy , dx , dy ) ) {
                    count++;
                }
            }
        }

        return count;
    }
}
