import java.io.BufferedReader;
import java.io.InputStreamReader;

class DWtG {
    public static BufferedReader br = null;
    public static int numCases;
    public static int numDancers;
    public static int numSurprises;
    public static int p; // p is given by the problem as the "best score"
    public static String[] input;

    public static void main(String[] args) {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));

            numCases = Integer.parseInt(br.readLine().trim());

            for(int i = 0; i < numCases; i++) {
                input = br.readLine().split(" ");
                numDancers = Integer.parseInt(input[0]);
                numSurprises = Integer.parseInt(input[1]);
                p = Integer.parseInt(input[2]);
                int maxDancers = 0;

                for(int j = 3; j < input.length; j++) {
                    if(maxReg(Integer.parseInt(input[j])) >= p)
                        maxDancers++;
                    else if(numSurprises > 0 && maxSpecial(Integer.parseInt(input[j])) >= p) {
                        maxDancers++;
                        numSurprises--;
                    }
                }
                System.out.println("Case #" + (i+1) + ": " + maxDancers);
            }
        }
        catch(Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
    }

    public static int maxReg(int n) {
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;
        else if(n == 2)
            return 1;
        else if(n % 3 == 0)
            return (n / 3);
        else if(n % 3 == 1)
            return (n / 3) + 1;
        else if(n % 3 == 2)
            return (n / 3) + 1;
        return -1;
    }

    public static int maxSpecial(int n) {
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;
        else if(n == 2)
            return 2;
        else if(n % 3 == 0)
            return (n / 3) + 1;
        else if(n % 3 == 1)
            return (n / 3) + 1;
        else if(n % 3 == 2)
            return (n / 3) + 2;
        return -1;
    }
}
