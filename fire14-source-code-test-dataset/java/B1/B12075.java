package jp.funnything.competition.util;

public class Prof {
    private long _start;

    public Prof() {
        reset();
    }

    private long calcAndReset() {
        final long ret = System.currentTimeMillis() - _start;

        reset();

        return ret;
    }

    private void reset() {
        _start = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return String.format( "Prof: %f (s)" , calcAndReset() / 1000.0 );
    }

    public String toString( final String head ) {
        return String.format( "%s: %f (s)" , head , calcAndReset() / 1000.0 );
    }
}
