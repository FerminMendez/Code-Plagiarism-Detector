package jp.funnything.competition.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

import org.apache.commons.io.IOUtils;

public class QuestionReader {
    private final BufferedReader _reader;

    public QuestionReader( final File input ) {
        try {
            _reader = new BufferedReader( new FileReader( input ) );
        } catch ( final FileNotFoundException e ) {
            throw new RuntimeException( e );
        }
    }

    public void close() {
        IOUtils.closeQuietly( _reader );
    }

    public String read() {
        try {
            return _reader.readLine();
        } catch ( final IOException e ) {
            throw new RuntimeException( e );
        }
    }

    public BigDecimal[] readBigDecimals() {
        return readBigDecimals( " " );
    }

    public BigDecimal[] readBigDecimals( final String separator ) {
        final String[] tokens = readTokens( separator );

        final BigDecimal[] values = new BigDecimal[ tokens.length ];
        for ( int index = 0 ; index < tokens.length ; index++ ) {
            values[ index ] = new BigDecimal( tokens[ index ] );
        }

        return values;
    }

    public BigInteger[] readBigInts() {
        return readBigInts( " " );
    }

    public BigInteger[] readBigInts( final String separator ) {
        final String[] tokens = readTokens( separator );

        final BigInteger[] values = new BigInteger[ tokens.length ];
        for ( int index = 0 ; index < tokens.length ; index++ ) {
            values[ index ] = new BigInteger( tokens[ index ] );
        }

        return values;
    }

    public int readInt() {
        final int[] values = readInts();

        if ( values.length != 1 ) {
            throw new IllegalStateException( "Try to read single interger, but the line contains zero or multiple values" );
        }

        return values[ 0 ];
    }

    public int[] readInts() {
        return readInts( " " );
    }

    public int[] readInts( final String separator ) {
        final String[] tokens = readTokens( separator );

        final int[] values = new int[ tokens.length ];
        for ( int index = 0 ; index < tokens.length ; index++ ) {
            values[ index ] = Integer.parseInt( tokens[ index ] );
        }

        return values;
    }

    public long readLong() {
        final long[] values = readLongs();

        if ( values.length != 1 ) {
            throw new IllegalStateException( "Try to read single interger, but the line contains zero or multiple values" );
        }

        return values[ 0 ];
    }

    public long[] readLongs() {
        return readLongs( " " );
    }

    public long[] readLongs( final String separator ) {
        final String[] tokens = readTokens( separator );

        final long[] values = new long[ tokens.length ];
        for ( int index = 0 ; index < tokens.length ; index++ ) {
            values[ index ] = Long.parseLong( tokens[ index ] );
        }

        return values;
    }

    public String[] readTokens() {
        return readTokens( " " );
    }

    public String[] readTokens( final String separator ) {
        return read().split( separator );
    }
}
