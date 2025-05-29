package dancingwiththegooglers;

import inout.In;
import inout.Out;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws Exception {
        String[] strings = In.read("B-small-attempt3.in", 1);
        int cont = 1;
        for (String str : strings) {
            String[] split = str.split(" ");
            int number = Integer.parseInt(split[0]);
            int surprises = Integer.parseInt(split[1]);
            int atLeast = Integer.parseInt(split[2]);
            ArrayList<Integer> scores = new ArrayList<Integer>(number);
            for (int i = 0; i < number; i++) {
                scores.add(Integer.parseInt(split[i + 3]));
            }
            Collections.sort(scores);
            int maxGooglers = 0;
            int newSurprises = 0;
            boolean mores = surprises == 0 ? false : true;
            for (int i = 0; i < number; i++) {
                int score = scores.get(i);
                int result = score / 3;
                int rest = score % 3;
                if (rest != 0) {
                    if (result + rest <= 10 && (mores || rest != 2)) {
                        if (result + rest >= atLeast) {
                            maxGooglers++;
                        }
                        if (rest == 2) {
                            newSurprises++;
                        }
                    } else {
                        if (result + 1 >= atLeast) {
                            maxGooglers++;
                        }
                        if (result + 1 == 2) {
                            newSurprises++;
                        }
                    }
                } else {
                    if (result > 0 && result < 10 && mores) {
                        if (result + 1 >= atLeast) {
                            maxGooglers++;
                        }
                        newSurprises++;
                    } else {
                        if (result >= atLeast) {
                            maxGooglers++;
                        }
                    }
                }
                if (newSurprises == surprises) {
                    mores = false;
                }
            }
            Out.write("output.txt", cont++, maxGooglers + "");
        }
    }
}
