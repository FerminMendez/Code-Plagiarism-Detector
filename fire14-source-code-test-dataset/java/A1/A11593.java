/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dancingwithgooglers;

import java.io.*;

/**
 *
 * @author Intellitech
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static int isGreat(long S, long total_score, boolean can_be_great)
    {
        long[] local_score = new long[3];

        for (int i = 0; i < 3; i++)
        {
            local_score[i] = total_score/3;
        }

        int rem = (int) (total_score % 3);
        int i = 0;

        while (rem > 0)
        {
            local_score[i]++;
            rem--;
            i++;
        }

        if (local_score[0] >= S)
            return 1;

        if (can_be_great == false)
            return 0;

        if (local_score[0] == local_score[1] && local_score[1] != 0)
        {
            local_score[0]++;
            local_score[1]--;
        }
        if (local_score[0] >= S)
            return 2;
        return 0;

    }
    public static void main(String[] args) throws Exception {
        // TODO code application logic here        
        BufferedReader reader = new BufferedReader(new FileReader(new File("input.txt")));
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("output.txt")));
        reader.readLine();

        String input = "";
        int CASE = 1;
        while ((input = reader.readLine()) != null)
        {
            String[] tokens = input.split(" ");
            int N = Integer.parseInt(tokens[0]);
            long S = Long.parseLong(tokens[1]);
            long P = Long.parseLong(tokens[2]);

            boolean can_be_great = false;
            if (S > 0)
                can_be_great = true;
            int total_count = 0;
            for (int i = 0; i < N; i++)
            {
                long currentMax = Long.parseLong(tokens[i+3]);
                int result = isGreat(P, currentMax, can_be_great);
                if (result == 1)
                    total_count++;
                else if (result == 2)
                {
                    S--;
                    total_count++;
                    if (S <= 0)
                        can_be_great = false;
                }
            }

            writer.write("Case #" + CASE + ": " + total_count+"\n");
            CASE++;
        }
        writer.close();
        reader.close();

    }

}
