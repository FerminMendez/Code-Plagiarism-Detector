import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dance {
    private static final String inFile = "B-small-attempt0.in";
    private static final String outFile = "output.txt";

    private static final int CONTESTANTS = 0;
    private static final int SURPRISES = 1;
    private static final int WINNERS = 2;
    private static final int POINTS_START = 3;

    public static void main(String[] args) throws IOException {
        /* * * Initialization -- START     * * */
        BufferedReader iStream = new BufferedReader(new FileReader(inFile));
        BufferedWriter oStream = new BufferedWriter(new FileWriter(outFile));

        int contestants = 0;
        int surprises = 0;
        int threshold = 0;
        int total = 0;
        int winners = 0;

        List<Scores> scores = null;
        String[] elements = null;
        /* * *     Initialization -- END     * * */


        total = new Integer(iStream.readLine());

        for(int i = 0; i < total; i++) {
            String line = iStream.readLine();

            scores = new ArrayList<Scores>();
            winners = 0;

            elements = line.split(" ");

            // Grab over-head data
            contestants = new Integer( elements[CONTESTANTS] );
            surprises = new Integer( elements[SURPRISES] );
            threshold = new Integer( elements[WINNERS] );

            // Allocate the scores
            for(int j = 0; j < contestants; j++) {
                int value = new Integer( elements[POINTS_START+j] );
                scores.add( new Scores(value) );
            }

            // Order from highest total to lowest
            Collections.sort(scores, Collections.reverseOrder());

            // Tally the contestants that are above the threshold
            for(int k = 0; k < scores.size(); k++) {
                if(scores.get(k).getHighest() >= threshold)
                    winners += 1;
                else if(surprises > 0){ //Skew if available
                    scores.get(k).skew();

                    if(scores.get(k).getHighest() >= threshold)
                        winners += 1;

                    surprises -= 1;
                }
            }

            oStream.write("Case #" + (i+1) + ": " + winners);
            oStream.newLine();
        }

        iStream.close();
        oStream.close();
    }
}
