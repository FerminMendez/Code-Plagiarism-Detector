package ru.guredd.codejam;

import java.util.StringTokenizer;

public class Qualification2012B {
    public void solve() {
        int count = Integer.valueOf(Main.inputData.get(0));
        for (int i = 0; i < count; i++) {
            int result = 0;

            String data = Main.inputData.get(i + 1);

            StringTokenizer st = new StringTokenizer(data, " ");
            int N = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            for (int j = 0; j < N; j++) {
                int tScore = Integer.parseInt(st.nextToken());

                if (tScore == 0) {
                    if(P == 0) result++;
                } else {
                    int d = tScore / 3;
                    if (d + 1 == P && tScore % 3 == 0 && S > 0) {
                        S--;
                        result++;
                    } else if (d + 1 >= P && !(d + 1 == P && tScore % 3 == 0)) {
                        result++;
                    } else if (d + 2 == P && tScore % 3 == 2 && S > 0) {
                        S--;
                        result++;
                    }
                }
            }
            Main.outputData.add("Case #" + (i + 1) + ": " + result);
        }
    }
}
