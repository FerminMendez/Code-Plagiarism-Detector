import java.io.*;
import java.util.*;

public class Tres {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("tres.txt"));
        int T = Integer.parseInt(in.readLine());
        for(int t = 0; t < T; t++) {
            String[] temp = in.readLine().split(" ");
            int A = Integer.parseInt(temp[0]);
            int B = Integer.parseInt(temp[1]);
            HashMap<String, Integer> matches = new HashMap<String, Integer>();
            for(int i = A; i <= B; i++) {
                String s = new Integer(i).toString();
                int j;
                for(j = 0; j < s.length(); j++) {
                    String stemp = s.substring(j) + s.substring(0,j);
                    if(matches.containsKey(stemp)) {
                        matches.put(stemp, matches.get(stemp)+1);
                        //System.out.println(s + " matched with " + stemp);
                        break;
                    }
                }
                if(j == s.length()) matches.put(s, 1);
            }
            int answer = 0;
            for(String s : matches.keySet()) {
                int itemp = matches.get(s);
                answer += itemp*(itemp-1)/2;
            }
            System.out.println("Case #" + (t+1) + ": " + answer);
        }
        in.close();
    }
}