import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.Arrays;

/**
 * Competition
 * @author shibink
 *
 */
public class DancingScore {

    public static int getCount(String googleLang) {
        int count = 0;

        if ((googleLang == null) || (googleLang.isEmpty())) {
            return 0;
        }        
        
        String[] strArray = googleLang.split(" ");
        
        // Min 1 player should be there
        if (strArray.length <= 3) {
            return 0;
        }
        int numPlayers = Integer.parseInt(strArray[0]);
        
        int numSurprises = Integer.parseInt(strArray[1]);
        int key = Integer.parseInt(strArray[2]);
        int [] totalPoints = new int [numPlayers];
        boolean isSurprise = false;

        if (key == 0) {
            return numPlayers;
        }
        for (int i =0, j = 3; i<numPlayers; i++, j++) {
           totalPoints[i] = Integer.parseInt(strArray[j]);
        }
        Arrays.sort(totalPoints);
        
        for (int i=numPlayers - 1; i >=0; i--) {
            isSurprise = false;
            if (key == 1) {
                if (totalPoints[i] != 0) {
                count++;
                }
                continue;
            }
            if ((key * 3) <= totalPoints[i]) 
            {
                count++;
                continue;
            }

            if (key + ((key - 2) * 2) <= totalPoints[i]) {

                if (((key * 3) == totalPoints[i]) || (((key * 2) + key-1) == totalPoints[i])
                    || ((((key-1)*2) + key) == totalPoints[i]) || (((key * 2) + key+1) == totalPoints[i])
                    || ((((key+1)*2) + key) == totalPoints[i])) {
                        isSurprise = false;
                    } else {
                        isSurprise = true;
                    }
                
                if (isSurprise) {
                    if (numSurprises > 0) {
                        numSurprises--;
                        count++;
                    }
                } else {
                    count++;
                }
            }
            else {
                // No more triplets can be part of the target count since array is sorted
                break;
            }
        }
        
        return count;
    }

    public static void processFile(String fileName) throws IOException {
        FileInputStream fstream = new FileInputStream(fileName);
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        // use buffering
        Writer output = new BufferedWriter(new FileWriter("output.txt"));

        try {
            String strLine = null;
            int numPlayers = 0;
            int count = 0;

            if ((strLine = br.readLine()) != null) {
                count = Integer.parseInt(strLine);
            }
            // Read File Line By Line
            for (int i = 1; i <= count; i++) {
                if ((strLine = br.readLine()) == null) {
                    return;
                }

                numPlayers = getCount(strLine);
                System.out.println("Case #" + i + ": " + numPlayers);

                StringBuffer outBuff = new StringBuffer("Case #" + i + ": " + numPlayers + "\n");
                output.write(outBuff.toString());
            }

        } finally {
            // Close the input stream
            in.close();
            output.close();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        String fileName = "input.in";
        try {
            processFile(fileName);
        } catch (IOException e) {
            // TODO Log error
        }
        return;
    }
}
