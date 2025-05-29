package jp.funnything.competition.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

public class Packer {
    private static void add( final ZipArchiveOutputStream out , final File file , final int pathPrefix ) {
        if ( file.isDirectory() ) {
            final File[] children = file.listFiles();

            if ( children.length > 0 ) {
                for ( final File child : children ) {
                    add( out , child , pathPrefix );
                }
            } else {
                addEntry( out , file , pathPrefix , false );
            }
        } else {
            addEntry( out , file , pathPrefix , true );
        }
    }

    private static void addEntry( final ZipArchiveOutputStream out , final File file , final int pathPrefix , final boolean isFile ) {
        try {
            out.putArchiveEntry( new ZipArchiveEntry( file.getPath().substring( pathPrefix ) + ( isFile ? "" : "/" ) ) );

            if ( isFile ) {
                final FileInputStream in = FileUtils.openInputStream( file );
                IOUtils.copy( in , out );
                IOUtils.closeQuietly( in );
            }

            out.closeArchiveEntry();
        } catch ( final IOException e ) {
            throw new RuntimeException( e );
        }
    }

    public static void pack( final File source , final File destination ) {
        try {
            final ZipArchiveOutputStream out = new ZipArchiveOutputStream( destination );

            add( out , source , FilenameUtils.getPath( source.getPath() ).length() );

            out.finish();
            out.close();
        } catch ( final IOException e ) {
            throw new RuntimeException( e );
        }
    }
}
