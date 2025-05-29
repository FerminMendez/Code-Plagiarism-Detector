import java.io.*;

public class G2 {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("d:\\B-small-attempt0.in"));
        int n = Integer.parseInt(in.readLine());
        int cnt;
        int surprize;
        int min;
        int[] points;
        BufferedWriter out = new BufferedWriter(new FileWriter("d:\\g2o.txt"));
        for (int i = 1; i <= n; i++) {
            String[] s = in.readLine().split(" ");
            cnt = Integer.parseInt(s[0]);
            surprize = Integer.parseInt(s[1]);
            min = Integer.parseInt(s[2]);
            points = new int[cnt];
            for (int j = 0; j < cnt; j++) {
                points[j] = Integer.parseInt(s[3 + j]);
            }
            int answer = solve(cnt, surprize, min, points);
            System.err.println("Case #" + i + ": " + answer);
            out.write("Case #" + i + ": " + answer);
            out.newLine();
        }
        out.close();
    }

    private static int solve(int cnt, int surprize, int min, int[] points) {
        int anywayTotal = 0;
        int surprizingTotal = 0;
        
        int anywayMax = 0;
        int surprizingMax = 0;

        for (int point : points) {
            int whole = (point) / 3;
            int part = point % 3;
            if (point > 0 && part == 0) {
                whole--;
                part = 3;
            }
            anywayMax = surprizingMax = whole;    
            
            switch (part) {
                case 1:
                    anywayMax++;
                    break;
                case 2:
                case 3:
                    anywayMax++;
                    surprizingMax+=2;
                    break;
            }
            if (anywayMax >= min)
                anywayTotal++;
            else if (surprizingMax >= min)
                surprizingTotal++;

        }
        return anywayTotal + Math.min(surprize, surprizingTotal);
    }
}
