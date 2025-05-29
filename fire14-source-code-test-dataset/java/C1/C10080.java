package jp.funnything.competition.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

public class AnswerWriter {
    private static final String DEFAULT_FORMAT = "Case #%d: %s\n";

    private final BufferedWriter _writer;
    private final String _format;

    public AnswerWriter( final File output , final String format ) {
        try {
            _writer = new BufferedWriter( new FileWriter( output ) );
            _format = format != null ? format : DEFAULT_FORMAT;
        } catch ( final IOException e ) {
            throw new RuntimeException( e );
        }
    }

    public void close() {
        IOUtils.closeQuietly( _writer );
    }

    public void write( final int questionNumber , final Object result ) {
        write( questionNumber , result.toString() , true );
    }

    public void write( final int questionNumber , final String result ) {
        write( questionNumber , result , true );
    }

    public void write( final int questionNumber , final String result , final boolean tee ) {
        try {
            final String content = String.format( _format , questionNumber , result );

            if ( tee ) {
                System.out.print( content );
                System.out.flush();
            }

            _writer.write( content );
        } catch ( final IOException e ) {
            throw new RuntimeException( e );
        }
    }
}
