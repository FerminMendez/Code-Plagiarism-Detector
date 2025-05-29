import java.io.*;

public class RecycledNumbers {

    public static void main(String[] args) {
        BufferedReader reader = null;
        PrintWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(new File("src/C-small-attempt0.in")));
            writer = new PrintWriter(new BufferedWriter(new FileWriter(new File("src/C-small-attempt0.out"))));

            String line = reader.readLine();
            boolean seenFirstLine = false;
            int caseId = 0;
            while(line != null) {
                if(!seenFirstLine) {
                    seenFirstLine = true;
                }
                else {
                    String[] tokens = line.split(" ");
                    final int A = Integer.parseInt(tokens[0]);
                    final int B = Integer.parseInt(tokens[1]);
                    int numPairs = findNumPairs(A, B);
                    writer.println("Case #" + caseId + ": " + numPairs);
                }
                line = reader.readLine();
                caseId++;
            }
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
                writer.close();
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

    static int findNumPairs(final int A, final int B) {
        int numRecycledPairs = 0;
        for (int n=A; n<=B; n++) {
            for (int m = n+1; m<=B; m++) {
                if (isRecycled(n, m)) numRecycledPairs +=1;
            }
        }
        return numRecycledPairs;
    }

    static boolean isRecycled(int n, int m) {
        if(n >= m) {
            throw new IllegalArgumentException("n >= m");
        }
        String nStr = Integer.toString(n);
        String mStr = Integer.toString(m);
        return (mStr + mStr).contains(nStr);
    }
}
