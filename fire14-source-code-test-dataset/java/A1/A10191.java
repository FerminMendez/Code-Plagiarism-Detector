package com.webcumo.tasks.b;

/**
 * @author Cumo
 */
public class Worker {

    public static String translateFromGooglereseToEnglish(String googlersString) {
        int count;
        int surprises;
        int p;
        String[] items = googlersString.split(" ");
        count = Integer.parseInt(items[0]);
        surprises = Integer.parseInt(items[1]);
        p = Integer.parseInt(items[2]);

        int pReal = p * 3 - 2;
        int pPossible = p * 3 - 4;

        int result = 0;

        for (int i = 3 ; i < count + 3 ; i++) {
            int num = Integer.parseInt(items[i]);
            if (num >= pReal)
                result ++;
            else if (num >= pPossible && surprises > 0 && num > p) {
                result ++;
                surprises --;
            }
        }

        return "" + result;
    }

}
