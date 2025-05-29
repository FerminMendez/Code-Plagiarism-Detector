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
 * Recycled Numbers
 * @author shibink
 *
 */
public class Recycle {

    public static int getCount(String str) {
        int count = 0;
        int tmp = 0;
        int numDigits = 0;

        if ((str == null) || (str.isEmpty())) {
            return count;
        }

        String[] strArray = str.split(" ");
        
        // It should be 2
        if (strArray.length != 2) {
            return 0;
        }
        int num1 = Integer.parseInt(strArray[0]);
        int num2 = Integer.parseInt(strArray[1]);
        tmp = num1;

        // Find number of digits in num1 & num2
        while (tmp > 0) {
            numDigits++;
            tmp = tmp / 10;
        }
        
        int arr[] = new int[numDigits];
        int cnt;
        for (int i = num1; i <= num2; i++) {
            Arrays.fill(arr, 0);
            cnt = 0;
            for (int val = i, j = 1; j < numDigits; j++) {
                tmp = val % 10;

                if (tmp == 0) {
                    val = val/10;
                    continue;
                }
                val = (int) (tmp * Math.pow(10, (numDigits - 1)) + (val / 10));
                for (int k=0; k<cnt; k++) {
                    if (val == arr[cnt]) {
                        continue;
                    }
                }
                arr[cnt++] = tmp;
                if ((val > i) && (val <= num2)) {
                    count++;
                }
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
            int numRecycle = 0;
            int count = 0;

            if ((strLine = br.readLine()) != null) {
                count = Integer.parseInt(strLine);
            }
            // Read File Line By Line
            for (int i = 1; i <= count; i++) {
                if ((strLine = br.readLine()) == null) {
                    return;
                }

                numRecycle = getCount(strLine);
                System.out.println("Case #" + i + ": " + numRecycle);

                StringBuffer outBuff = new StringBuffer("Case #" + i + ": " + numRecycle + "\n");
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
