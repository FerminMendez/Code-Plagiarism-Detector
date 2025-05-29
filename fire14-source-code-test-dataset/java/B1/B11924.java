package net.jbirch.gcj12qual;

import java.io.FileNotFoundException;
import java.util.Scanner;
import net.jbirch.gcj12qual.util.FileLoader;

/**
 *
 * @author Birch
 */
public class C implements Runnable {

    protected FileLoader inFile;
    protected Scanner in;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        (new C()).run();
    }

    public C() {
        inFile = new FileLoader("src\\main\\resources\\C.txt");
    }

    public void run() {
        try {
            in = inFile.getScanner();
            solve();
        } catch (FileNotFoundException fnfe) {
            System.out.println("File not found. Exiting.");
            System.out.println(fnfe);
        }
    }

    //Commence overall magic
    protected void solve() {
        int cases = Integer.valueOf(in.nextLine());
        for (int i = 0; i < cases; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            solve(in.nextInt(), in.nextInt());
        }
    }

    protected void solve(int low, int high) {
        int digits = (int) Math.log10(low);
        int count=0;

        for (int i = low; i <= high; i++) {
            int[] rotatedThisRound = new int[digits]; // for cases like 1212 - 2121 being counted twice. Sly.
            for (int j = 1; j <= digits; j++) {
                    int rotated = this.rotateInt(i, j);
                    if (rotated < low || rotated > high || i >= rotated || this.contains(rotatedThisRound, rotated)) continue;
                    rotatedThisRound[j - 1] = rotated;
                    count++;
            }
        }

        System.out.println(count);
    }

    protected int rotateInt(int i, int turns) {
        String theGuy = String.valueOf(i);
        String guyThe = theGuy.substring(turns) + theGuy.substring(0, turns);

        if (guyThe.startsWith("0")) return 0; // Force a fail case - rotated number has leading 0 and thus is of different length

        return Integer.valueOf(guyThe);
    }

    protected boolean contains(int[] a, int i) {
        for (int j : a) {
            if (j == i) return true;
        }
        return false;
    }
}
