package jp.funnything.competition.util;

public enum Direction {
    UP , DOWN , LEFT , RIGHT;

    public int dx() {
        switch ( this ) {
        case UP:
        case DOWN:
            return 0;
        case LEFT:
            return -1;
        case RIGHT:
            return 1;
        default:
            throw new RuntimeException( "assert" );
        }
    }

    public int dy() {
        switch ( this ) {
        case UP:
            return -1;
        case DOWN:
            return 1;
        case LEFT:
        case RIGHT:
            return 0;
        default:
            throw new RuntimeException( "assert" );
        }
    }

    public Direction reverese() {
        switch ( this ) {
        case UP:
            return DOWN;
        case DOWN:
            return UP;
        case LEFT:
            return RIGHT;
        case RIGHT:
            return LEFT;
        default:
            throw new RuntimeException( "assert" );
        }
    }

    public Direction turnLeft() {
        switch ( this ) {
        case UP:
            return LEFT;
        case DOWN:
            return RIGHT;
        case LEFT:
            return DOWN;
        case RIGHT:
            return UP;
        default:
            throw new RuntimeException( "assert" );
        }
    }

    public Direction turnRight() {
        switch ( this ) {
        case UP:
            return RIGHT;
        case DOWN:
            return LEFT;
        case LEFT:
            return UP;
        case RIGHT:
            return DOWN;
        default:
            throw new RuntimeException( "assert" );
        }
    }
}
