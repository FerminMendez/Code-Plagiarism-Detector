package dancingwiththegooglers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Emmanuel JS Hoarau - Google Code Jam 2012
 */
public class DancingWithTheGooglers {
    
    /*
     * Possible combos:
     * - 1 1 1 => may suprisingly be 0 1 2 (max+1)
     * - 1 1 2 => may suprisingly be 0 2 2 (max unchanged)
     * - 1 2 2 => may suprisingly be 1 1 3 (max+1)
     * 
     * Limits: 0 is min
     * - 0 0 0
     * - 0 0 1
     */
    String executeLine(final String line) {
        String words[] = line.split(" ");
        int n = 0;
        int nbGooglers = Integer.parseInt(words[n++]);
        int nbSurprises = Integer.parseInt(words[n++]);
        int p = Integer.parseInt(words[n++]);
        int result = 0;
        for (int i = 0; i < nbGooglers; ++i) {
            int sum = Integer.parseInt(words[n++]);

            // judge #1 (min)
            int note1 = sum/3;
            int remains = sum-note1;
            // judge #2
            int note2 = remains/2;
            remains -= note2;
            // judge #3 (max)
            int note3 = remains;

            if (note3 >= p) {
                ++result;
            } else {
                if ((sum > 1) && (note3 == (p - 1)) && (nbSurprises > 0) && (note3 == note2)) {
                    ++result;
                    --nbSurprises;
                }
            }
        }
        return Integer.toString(result);
    }

    void execute() {
        try {
            InputStreamReader stream = new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader(stream);
        
            String line = reader.readLine();
            int lines = Integer.parseInt(line);
            for (int i = 1; i <= lines; ++i) {
                line = reader.readLine();
                StringBuilder out = new StringBuilder();
                out.append("Case #");
                out.append(i);
                out.append(": ");
                out.append(executeLine(line));
                System.out.println(out.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new DancingWithTheGooglers().execute();
    }
}

