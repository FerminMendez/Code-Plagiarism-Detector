import java.io.BufferedReader;
import java.io.InputStreamReader;

class RN {
    private static BufferedReader br = null;
    private static int numCases;
    private static int lowerBound, upperBound;
    private static String[] input;

    public static void main(String[] args) throws Exception {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            numCases = Integer.parseInt(br.readLine().trim());

            for(int i = 0; i < numCases; i++) {
                int numRecycled = 0;
                input = br.readLine().split(" ");
                lowerBound = Integer.parseInt(input[0]);
                upperBound = Integer.parseInt(input[1]);

                for(int j = lowerBound; j < upperBound; j++) {
                    String s = j + "";
                    for(int k = 0; k < s.length()-1; k++) {
                        String temp = s.substring(s.length()-1-k) + s.substring(0, s.length()-k-1);
                        //System.out.println("From " + s + " to " + temp + " with k = " + k);
                        int num = Integer.parseInt(temp);
                        if(num == j) continue;
                        //if(num >= lowerBound && num <= upperBound && !used[num]) {
                        if(num >= lowerBound && num <= upperBound && num > j) {
                            //System.out.println("From " + s + " to " + temp + " with k = " + k);
                            //System.out.println("\t" + j + "\t" + num);
                            numRecycled++;
                            //used[num] = true;
                            //used[j] = true;
                        }
                    }
                }

                System.out.println("Case #" + (i+1) + ": " + numRecycled);
            }
        }
        catch(Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
    }
}
