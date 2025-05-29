package com.ozan.jam.qr2012;

import com.ozan.jam.JamBase;

import java.io.IOException;
import java.util.Scanner;

/**
 * TODO: Describe type
 */
public class B extends JamBase {

    protected B() throws IOException {
        super("qr2012", "B", "small");
    }

    public static void main(String[] args) throws IOException {
        new B().run();
    }

    @Override
    protected String handleTestCase(Scanner in) {
        int n = in.nextInt();
        int surprises = in.nextInt();
        int p = in.nextInt();

        int count = 0;

        for (int i = 0; i < n; i++) {
            int score = in.nextInt();
            if ((score + 2) / 3 >= p) {
                count++;
            } else if (score >= 2 && (score + 4) / 3 >= p && surprises > 0) {
                count++;
                surprises--;
            }
        }

        in.nextLine();
        return Integer.toString(count);
    }

}
