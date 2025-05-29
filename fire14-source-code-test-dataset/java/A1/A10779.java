public class Scores implements Comparable<Scores>{
    private int first;
    private int second;
    private int third;

    public Scores(int total) {
        first = second = third = total / 3;

        if( (total % 3) == 1 ) {
            first += 1;
        }
        else if( (total % 3) == 2 ) {
            first += 1;
            second += 1;
        }
    }

    public Scores(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public int compareTo(Scores otherScores) {
        return this.getTotal() - otherScores.getTotal();
    }

    public int getHighest() {
        if(first >= second && first >= third)
            return first;
        else if(second >= first && second >= third)
            return second;
        else
            return third;
    }

    public int getScore(int position) {
        switch(position) {
            case 1:
                return first;
            case 2:
                return second;
            case 3:
                return third;
            default:
                return -1;
        }
    }

    public int getTotal() {
        return first + second + third;
    }

    public void minMax(int positionToGain, int positionToLose) {
        if( positionToGain == 1 ) {
            if( positionToLose == 2 ) {
                first += 1;
                second -= 1;
            }
            else if( positionToLose == 3 ) {
                first += 1;
                third -= 1;
            }
        }
        else if( positionToGain == 2 ) {
            if( positionToLose == 1 ) {
                second += 1;
                first -= 1;
            }
            else if( positionToLose == 3 ) {
                second += 1;
                third -= 1;
            }
        }
        else if( positionToGain == 3 ) {
            if( positionToLose == 1 ) {
                third += 1;
                first -= 1;
            }
            else if( positionToLose == 2 ) {
                third += 1;
                second -= 1;
            }
        }
    }

    public void skew() {
        if( getTotal() <= 2 )
            return;

        if( (getTotal() % 3) == 0 ) {   // All equal
            minMax(1, 2);
        }
        else if( (getTotal() % 3) == 1 ) {  // 2 Small
            minMax(2, 3);
        }
        else if( (getTotal() % 3) == 2 ) {  // 2 Big
            minMax(1, 2);
        }
    }
}
