package jp.funnything.competition.util;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;

import org.apache.commons.io.FileUtils;

public class CompetitionIO {
    private final QuestionReader _reader;
    private final AnswerWriter _writer;

    /**
     * Default constructor. Use latest "*.in" as input
     */
    public CompetitionIO() {
        this( null , null , null );
    }

    public CompetitionIO( final File input , final File output ) {
        this( input , output , null );
    }

    public CompetitionIO( File input , File output , final String format ) {
        if ( input == null ) {
            for ( final File file : FileUtils.listFiles( new File( "." ) , new String[] { "in" } , false ) ) {
                if ( input == null || file.lastModified() > input.lastModified() ) {
                    input = file;
                }
            }

            if ( input == null ) {
                throw new RuntimeException( "No *.in found" );
            }
        }

        if ( output == null ) {
            final String inPath = input.getPath();

            if ( !inPath.endsWith( ".in" ) ) {
                throw new IllegalArgumentException();
            }

            output = new File( inPath.replaceFirst( ".in$" , ".out" ) );
        }

        _reader = new QuestionReader( input );
        _writer = new AnswerWriter( output , format );
    }

    public CompetitionIO( final String format ) {
        this( null , null , format );
    }

    public void close() {
        _reader.close();
        _writer.close();
    }

    public String read() {
        return _reader.read();
    }

    public BigDecimal[] readBigDecimals() {
        return _reader.readBigDecimals();
    }

    public BigDecimal[] readBigDecimals( final String separator ) {
        return _reader.readBigDecimals( separator );
    }

    public BigInteger[] readBigInts() {
        return _reader.readBigInts();
    }

    public BigInteger[] readBigInts( final String separator ) {
        return _reader.readBigInts( separator );
    }

    /**
     * Read line as single integer
     */
    public int readInt() {
        return _reader.readInt();
    }

    /**
     * Read line as multiple integer, separated by space
     */
    public int[] readInts() {
        return _reader.readInts();
    }

    /**
     * Read line as multiple integer, separated by 'separator'
     */
    public int[] readInts( final String separator ) {
        return _reader.readInts( separator );
    }

    /**
     * Read line as single integer
     */
    public long readLong() {
        return _reader.readLong();
    }

    /**
     * Read line as multiple integer, separated by space
     */
    public long[] readLongs() {
        return _reader.readLongs();
    }

    /**
     * Read line as multiple integer, separated by 'separator'
     */
    public long[] readLongs( final String separator ) {
        return _reader.readLongs( separator );
    }

    /**
     * Read line as token list, separated by space
     */
    public String[] readTokens() {
        return _reader.readTokens();
    }

    /**
     * Read line as token list, separated by 'separator'
     */
    public String[] readTokens( final String separator ) {
        return _reader.readTokens( separator );
    }

    public void write( final int questionNumber , final Object result ) {
        _writer.write( questionNumber , result );
    }

    public void write( final int questionNumber , final String result ) {
        _writer.write( questionNumber , result );
    }

    public void write( final int questionNumber , final String result , final boolean tee ) {
        _writer.write( questionNumber , result , tee );
    }
}
