import java.io.*;

/**
 * User: Andrii Baranov
 * Date: 14.04.12
 * Time: 12:59
 */
public class DancingGooglers {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("B-small-attempt0.in"));

        int testCases = Integer.parseInt(br.readLine());
        int[] maximumGooglers = new int[testCases];

        String paramString;
        int surprising, maxRes, googlersNumber;
        for (int i = 0; i < testCases; ++i) {
            paramString = br.readLine();
            String params[] = paramString.split(" ");

            googlersNumber = Integer.parseInt(params[0]);
            surprising = Integer.parseInt(params[1]);
            maxRes = Integer.parseInt(params[2]);

            int[] sumOfResults = new int[googlersNumber];
            for (int j = 0; j < googlersNumber; ++j) {
                sumOfResults[j] = Integer.parseInt(params[3 + j]);
            }

            maximumGooglers[i] = numOfBestResults(googlersNumber, surprising, maxRes, sumOfResults);
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter("B-small-out.txt"));
        for (int i = 0; i < maximumGooglers.length; i++) {
            bw.write("Case #" + (i + 1) + ": " + maximumGooglers[i]);
            if (i + 1 < maximumGooglers.length) {
                bw.write("\n");
            }
        }
        bw.close();

    }

    private static int numOfBestResults(int googlersNumber, int surprising, int maxRes, int[] sumOfResults) {
        int res = 0;
        int transformSurprising = 0;

        if(maxRes == 0){
            return googlersNumber;
        }
        if(maxRes == 1){
            for(int i =0; i < googlersNumber; i++){
                if (sumOfResults[i]> 0){
                    res++;
                }
            }
            return res;
        }

        for (int i = 0; i < googlersNumber; ++i) {

            if ((sumOfResults[i] / 3 + 1) >= maxRes) {
                if ((sumOfResults[i] % 3 == 0) && ((sumOfResults[i] / 3 + 1) == maxRes)) {
                    transformSurprising++;
                    res++;
                } else {
                    res++;
                }

            } else if ((sumOfResults[i] % 3 == 2) && ((sumOfResults[i] / 3 + 2) == maxRes)) {
                transformSurprising++;
                res++;
            }
        }

        if (transformSurprising > surprising) {
            return res - (transformSurprising - surprising);
        }
        return res;
    }
}
