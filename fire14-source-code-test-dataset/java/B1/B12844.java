package ru.guredd.codejam;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Qualification2012C {

    public void solve() {

        int count = Integer.valueOf(Main.inputData.get(0));
        for (int i = 0; i < count; i++) {
            int result = 0;

            String data = Main.inputData.get(i + 1);

            StringTokenizer st = new StringTokenizer(data, " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            for (int j = A; j <= B; j++) {
                result += calculateRecycled(j,j,A,B);
            }

            Main.outputData.add("Case #" + (i + 1) + ": " + result);
        }
    }

    private int calculateRecycled(int v, int orig, int A, int B) {
        char[] charV = String.valueOf(v).toCharArray();
        char[] shiftedV = new char[charV.length];
        do {
            System.arraycopy(charV, 1, shiftedV, 0, charV.length - 1);
            shiftedV[charV.length - 1] = charV[0];
            charV = Arrays.copyOf(shiftedV, shiftedV.length);
        } while (shiftedV[0]=='0');

        int shiftedVal = Integer.valueOf(String.valueOf(shiftedV));

        if (shiftedVal == orig) {
            return 0;
        }

        if (shiftedVal >= A && shiftedVal <= B && shiftedVal > orig) {
            return 1 + calculateRecycled(shiftedVal, orig, A, B);
        } else {
            return calculateRecycled(shiftedVal, orig, A, B);
        }
    }
}
