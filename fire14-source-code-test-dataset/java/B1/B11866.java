package codejam.codejam_2012;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: csrazvan
 * Date: 14.04.2012
 * Time: 13:44
 * To change this template use File | Settings | File Templates.
 */
public class RecycledNumbers {
    public int formNumber(ArrayList<Integer> rotation) {
        int nr = 0;
        for (Integer i : rotation) {
            nr = nr * 10 + i;
        }
        return nr;

    }

    public ArrayList<Integer> getRotations(int nr) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<Integer> rotation = new ArrayList<Integer>();
        int digits = 0;
        while (nr > 0) {
            rotation.add(0, nr % 10);
            digits++;
            nr = nr / 10;
        }
        for (int i = 0; i < digits - 1; i++) {
            rotation.add(rotation.get(0));
            rotation.remove(0);
            result.add(formNumber(rotation));
        }


        return result;
    }

    public void solve(File f) throws Exception {
        Scanner scanner = new Scanner(f);
        File w = new File("recycled.out");
        BufferedWriter bw = new BufferedWriter(new FileWriter(w));
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int count = 0;
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

            for (int startValue = a; startValue <= b; startValue++) {
                ArrayList<Integer> rotations = getRotations(startValue);
                for (int rotation : rotations) {
                    if (rotation >= a && rotation <= b && startValue < rotation) {
                        if (map.containsKey(startValue) && map.get(startValue) == rotation) {
                        } else if (map.containsKey(rotation) && map.get(rotation) == startValue) {
                        } else {
                            map.put(startValue, rotation);
                            count++;
                        }

                    }
                }

            }
            bw.write(String.format("Case #%s: %s\n",i,count));
        }
        bw.close();
    }

    public static void main(String[] args) {
        try {
            new RecycledNumbers().solve(new File("recycled.in"));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
