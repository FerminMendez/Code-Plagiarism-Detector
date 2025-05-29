/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.io.*;
import java.math.*;
import java.util.*;

public class Dance {

    public static final String INPUT = "dance";

    @SuppressWarnings("unchecked")
    private static void solve() throws IOException {
        int T = 0;

        T = nextInt();
        int googlers = 0;
        int suprise = 0;
        int prog = 0;
        int wynik = 0;
        int triplet = 0;

        int licznik = 0;
        System.out.println("START");
        try {
            for (int t = 0; t < T; t++) {
                wynik = 0;
                googlers = nextInt();
                suprise = nextInt();
                prog = nextInt();
                System.out.println("googlers = " + googlers);
                System.out.println("suprise = " + suprise);
                System.out.println("prog = " + prog);

                if (prog > 0) {
                    System.out.println("prog >0");
                    for (int i = 0; i < googlers; i++) {
                        triplet = nextInt();
                        System.out.println("TRIPLET = " + triplet);
                        if (triplet > 2) {
                            if (triplet % 3 == 0) {
                                if (triplet / 3 >= prog) {
                                    System.out.println("triplet / 3 >= prog");
                                    wynik++;
                                } else if (((triplet / 3) + 1 == prog) && (suprise > 0)) {
                                    System.out.println("((triplet / 3) + 1 == prog) && (suprise > 0)");
                                    wynik++;
                                    suprise--;
                                }
                            } else if (triplet % 3 == 1) {
                                if ((triplet + 2) / 3 >= prog) {
                                    System.out.println("((triplet + 2) / 3 >= prog");
                                    wynik++;
                                }
                            } else {
                                if ((triplet + 1) / 3 >= prog) {
                                    System.out.println("(triplet + 1) / 3 >= prog");
                                    wynik++;
                                } else {
                                    if ((suprise > 0) && (triplet < 27)) {
                                        System.out.println("(suprise > 0) && (triplet < 27)");
                                        if ((triplet + 4) / 3 >= prog) {
                                            System.out.println("((triplet + 4) / 3 >= prog)");
                                            wynik++;
                                            suprise--;
                                        }
                                    }
                                }
                            }
                        } else if (((triplet == 2) || (triplet == 1)) && (prog == 1)) {
                            wynik++;
                        } else if ((triplet == 2) && (prog == 2) && (suprise > 0)) {
                            wynik++;
                        }
                    }
                } else if (prog == 0) {
                    for (int i = 0; i < googlers; i++) {
                        triplet = nextInt();
                        System.out.println("(prog == 0)");
                        wynik = googlers;
                    }
                }

                //   if (suprise < 0) {
                //       wynik = wynik + suprise;
                //   }
                licznik = t + 1;
                System.out.println("Case #" + licznik + " " + wynik);
                out.println("Case #" + licznik + ": " + wynik);
            }

            System.out.println("STOP");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String zmienLitere(String znak) {
        String nowyZnak = "";
        HashMap hashMap = new HashMap();
        hashMap.put("a", "y");
        hashMap.put("b", "h");
        hashMap.put("c", "e");
        hashMap.put("d", "s");
        hashMap.put("e", "o");
        hashMap.put("f", "c");
        hashMap.put("g", "v");
        hashMap.put("h", "x");
        hashMap.put("i", "d");
        hashMap.put("j", "u");
        hashMap.put("k", "i");
        hashMap.put("l", "g");
        hashMap.put("m", "l");
        hashMap.put("n", "b");
        hashMap.put("o", "k");
        hashMap.put("p", "r");
        hashMap.put("q", "z");
        hashMap.put("r", "t");
        hashMap.put("s", "n");
        hashMap.put("t", "w");
        hashMap.put("u", "j");
        hashMap.put("v", "p");
        hashMap.put("w", "f");
        hashMap.put("x", "m");
        hashMap.put("y", "a");
        hashMap.put("z", "q");


        nowyZnak = (String) hashMap.get(znak);


        //      if ("a".equals(znak)) {
        //          nowyZnak = "y";
        //      } else {
        //          nowyZnak = znak;
        //      }

        return nowyZnak;
    }

    private static long dajSume(ArrayList<String> cuksy) {
        long lewa = 0;
        long prawa = 0;
        long lewaSum = 0;
        long prawaSum = 0;
        long max = 0;
        for (int i = 1; i < cuksy.size() - 1; i++) {
            lewaSum = 0;
            prawaSum = 0;
            for (int j = 0; j < i; j++) {
                lewa = lewa ^ Long.parseLong(cuksy.get(j));
                lewaSum = lewaSum + Long.parseLong(cuksy.get(j));
            }
            for (int k = i; k < cuksy.size(); k++) {
                prawa = prawa ^ Long.parseLong(cuksy.get(k));
                prawaSum = prawaSum + Long.parseLong(cuksy.get(k));
            }
            if (prawa == lewa) {
                // System.out
                // .println(i + " lewa " + lewaSum + " prwa " + prawaSum);
                if ((prawaSum > max) && (prawaSum > lewaSum)) {
                    // System.out.println(i);
                    max = prawaSum;
                } else if ((lewaSum > max) && (prawaSum < lewaSum)) {
                    // System.out.println(i);
                    max = lewaSum;
                }

            }
        }
        //System.out.println(" max " + max);
        return max;
    }
    // -----------------------------------------------
    private static BufferedReader br;
    private static StringTokenizer _st;
    private static PrintWriter out;

    private static String next() throws IOException {
        while (_st == null || !_st.hasMoreTokens()) {
            String s = br.readLine();
            if (s == null) {
                return s;
            }
            _st = new StringTokenizer(s);
        }
        return _st.nextToken();
    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    private static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    private static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    private static String nextLine() throws IOException {
        _st = null;
        return br.readLine();
    }

    public static void run() {
        long startTime = System.nanoTime();
        try {
            br = new BufferedReader(new FileReader(
                    "c:/software/Projects/" + INPUT + ".in"));
            out = new PrintWriter("c:/software/Projects/" + INPUT + ".output");
            try {
                solve();
            } finally {
                out.close();
            }
        } catch (IOException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
        long finishTime = System.nanoTime();
        System.err.printf("%.3f\n", (finishTime - startTime) / 1e9);
    }

    public static void main(String[] args) {
        run();
    }
}
