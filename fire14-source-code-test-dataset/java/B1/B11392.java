/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class Recycled {

    public static void main(String args[]) {
        int T;
        ArrayList a = reader("c:\\inp.in");
        ArrayList out = new ArrayList();
        String st = (String) a.get(0);
        T = Integer.parseInt(st);
        int ans;
        int i1, i2;
        for (int i = 0; i < T; i++) {
            st = (String) a.get(i + 1);
            Scanner sc = new Scanner(st);
            i1 = sc.nextInt();
            i2 = sc.nextInt();
            ans = findNoOfRecycle(i1, i2);
            out.add(ans);
        }
        writer("c:\\output.txt", out);
    }

    public static ArrayList reader(String filename) {
        FileInputStream fis = null;
        ArrayList a = new ArrayList();
        String line = "";
        try {
            fis = new FileInputStream(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            while ((line = br.readLine()) != null) {
                a.add(line);
            }
        } catch (IOException ex) {
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
            }
        }
        return a;
    }

    private static int findNoOfRecycle(int a, int b) {
        HashSet<Integer> done = new HashSet<Integer>();
        int noOfMatches = 0, l, localmatches = 0;
        String sb, sbs, sbe;
        sbs = Integer.toString(a);
        sbe = Integer.toString(b);
        for (int i = a; i <= b; i++) {
            if (!done.contains(i)) {
                sb = Integer.toString(i);
                localmatches = 0;
                l = sb.length();
                boolean flag = true;
                for (int k = 0; k < l - 1; k++) {
                    if (sb.charAt(k) != sb.charAt(k + 1)) {
                        flag = false;
                        k = l;
                    }
                }
                if (!flag) {
                    for (int j = 0; j < l - 1; j++) {
                        sb = sb.charAt(l - 1) + sb.substring(0, l - 1);
                        if(sb.charAt(0)!='0')
                        if (sb.compareTo(sbs) >= 0 && sb.compareTo(sbe) <= 0) {
                            done.add(Integer.parseInt(sb));
                            localmatches++;
                        }
                    }
                }
                noOfMatches = noOfMatches + (localmatches * (localmatches + 1)) / 2;
            }
        }
        return noOfMatches;
    }

    private static void writer(String file, ArrayList out) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            for (int i = 0; i < out.size(); i++) {
                try {
                    String output = "Case #" + Integer.toString(i + 1) + ": " + out.get(i) + "\n";
                    fos.write(output.getBytes());
                    System.out.print(output);
                } catch (IOException ex) {
                    Logger.getLogger(BotTrust.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (FileNotFoundException ex) {
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
            }
        }

    }
}
