package template;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Utils {

    static String logfile = "";

    public static BufferedWriter newBufferedWriter(String filename, boolean append) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(filename, append));
        } catch (IOException ex) {
            die("Exception in newBufferedWriter");
        }
        return bw;
    }

    public static void writeLn(BufferedWriter bw, String line) {
        try {
            bw.write(line);
            bw.newLine();
        } catch (IOException ex) {
            die("Exception in writeLn");
        }
    }

    public static void closeBw(BufferedWriter bw) {
        try {
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            die("Exception in closeBw");
        }

    }

    public static BufferedReader newBufferedReader(String filename) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filename));
        } catch (IOException ex) {
            die("Exception in newBufferedReader");
        }
        return br;
    }

    public static String readLn(BufferedReader br) {
        String s = null;
        try {
            s = br.readLine();
        } catch (IOException ex) {
            die("Exception in readLn");
        }
        return s;
    }

    public static Integer readInteger(BufferedReader br) {
        return new Integer(readLn(br));
    }

    public static ArrayList<Integer> readIntegerList(BufferedReader br) {
        return readIntegerList(br, null);
    }

    public static ArrayList<Integer> readIntegerList(BufferedReader br, Integer expectedLength) {
        String[] s = readLn(br).split(" ");
        ArrayList<Integer> l = new ArrayList<>();
        for (int x = 0; x < s.length; x++) {
            l.add(new Integer(s[x]));
        }
        if (expectedLength != null) {
            if (l.size() != expectedLength.intValue()) {
                die("Incorrect length in readIntegerList");
            }
        }
        return l;
    }

    public static ArrayList<Integer> readMultipleIntegers(BufferedReader br, Integer rows) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int x = 0; x < rows; x++) {
            String s = readLn(br);
            l.add(new Integer(s));
        }
        return l;
    }

    public static ArrayList<ArrayList<Integer>> readIntegerMatrix(BufferedReader br, Integer rows) {
        return readIntegerMatrix(br, rows, null);
    }

    public static ArrayList<ArrayList<Integer>> readIntegerMatrix(BufferedReader br, Integer rows, Integer expectedLength) {
        ArrayList<ArrayList<Integer>> l = new ArrayList<>();
        for (int x = 0; x < rows.intValue(); x++) {
            l.add(readIntegerList(br, expectedLength));
        }
        return l;
    }

    public static Double readDouble(BufferedReader br) {
        return new Double(readLn(br));
    }

    public static ArrayList<Double> readDoubleList(BufferedReader br) {
        return readDoubleList(br, null);
    }

    public static ArrayList<Double> readDoubleList(BufferedReader br, Integer expectedLength) {
        String[] s = readLn(br).split(" ");
        ArrayList<Double> l = new ArrayList<>();
        for (int x = 0; x < s.length; x++) {
            l.add(new Double(s[x]));
        }
        if (expectedLength != null) {
            if (l.size() != expectedLength.intValue()) {
                die("Incorrect length in readDoubleList");
            }
        }
        return l;
    }

    public static ArrayList<Double> readMultipleDoubles(BufferedReader br, Integer rows) {
        ArrayList<Double> l = new ArrayList<>();
        for (int x = 0; x < rows; x++) {
            String s = readLn(br);
            l.add(new Double(s));
        }
        return l;
    }

    public static ArrayList<ArrayList<Double>> readDoubleMatrix(BufferedReader br, Integer rows) {
        return readDoubleMatrix(br, rows, null);
    }

    public static ArrayList<ArrayList<Double>> readDoubleMatrix(BufferedReader br, Integer rows, Integer expectedLength) {
        ArrayList<ArrayList<Double>> l = new ArrayList<>();
        for (int x = 0; x < rows.intValue(); x++) {
            l.add(readDoubleList(br, expectedLength));
        }
        return l;
    }

    public static Long readLong(BufferedReader br) {
        return new Long(readLn(br));
    }

    public static ArrayList<Long> readLongList(BufferedReader br) {
        return readLongList(br, null);
    }

    public static ArrayList<Long> readLongList(BufferedReader br, Integer expectedLength) {
        String[] s = readLn(br).split(" ");
        ArrayList<Long> l = new ArrayList<>();
        for (int x = 0; x < s.length; x++) {
            l.add(new Long(s[x]));
        }
        if (expectedLength != null) {
            if (l.size() != expectedLength.intValue()) {
                die("Incorrect length in readLongList");
            }
        }
        return l;
    }

    public static ArrayList<Long> readMultipleLongs(BufferedReader br, Integer rows) {
        ArrayList<Long> l = new ArrayList<>();
        for (int x = 0; x < rows; x++) {
            String s = readLn(br);
            l.add(new Long(s));
        }
        return l;
    }

    public static ArrayList<ArrayList<Long>> readLongMatrix(BufferedReader br, Integer rows) {
        return readLongMatrix(br, rows, null);
    }

    public static ArrayList<ArrayList<Long>> readLongMatrix(BufferedReader br, Integer rows, Integer expectedLength) {
        ArrayList<ArrayList<Long>> l = new ArrayList<>();
        for (int x = 0; x < rows.intValue(); x++) {
            l.add(readLongList(br, expectedLength));
        }
        return l;
    }

    public static String readString(BufferedReader br) {
        return new String(readLn(br));
    }

    public static ArrayList<String> readStringList(BufferedReader br) {
        return readStringList(br, null);
    }

    public static ArrayList<String> readStringList(BufferedReader br, Integer expectedLength) {
        String[] s = readLn(br).split(" ");
        ArrayList<String> l = new ArrayList<>();
        for (int x = 0; x < s.length; x++) {
            l.add(new String(s[x]));
        }
        if (expectedLength != null) {
            if (l.size() != expectedLength.intValue()) {
                die("Incorrect length in readStringList");
            }
        }
        return l;
    }

    public static ArrayList<String> readMultipleStrings(BufferedReader br, Integer rows) {
        ArrayList<String> l = new ArrayList<>();
        for (int x = 0; x < rows; x++) {
            String s = readLn(br);
            l.add(new String(s));
        }
        return l;
    }

    public static ArrayList<ArrayList<String>> readStringMatrix(BufferedReader br, Integer rows) {
        return readStringMatrix(br, rows, null);
    }

    public static ArrayList<ArrayList<String>> readStringMatrix(BufferedReader br, Integer rows, Integer expectedLength) {
        ArrayList<ArrayList<String>> l = new ArrayList<>();
        for (int x = 0; x < rows.intValue(); x++) {
            l.add(readStringList(br, expectedLength));
        }
        return l;
    }

    public static Boolean readBoolean(BufferedReader br) {
        return new Boolean(readLn(br));
    }

    public static ArrayList<Boolean> readBooleanList(BufferedReader br) {
        return readBooleanList(br, null);
    }

    public static ArrayList<Boolean> readBooleanList(BufferedReader br, Integer expectedLength) {
        String[] s = readLn(br).split(" ");
        ArrayList<Boolean> l = new ArrayList<>();
        for (int x = 0; x < s.length; x++) {
            l.add(new Boolean(s[x]));
        }
        if (expectedLength != null) {
            if (l.size() != expectedLength.intValue()) {
                die("Incorrect length in readBooleanList");
            }
        }
        return l;
    }

    public static ArrayList<Boolean> readMultipleBooleans(BufferedReader br, Integer rows) {
        ArrayList<Boolean> l = new ArrayList<>();
        for (int x = 0; x < rows; x++) {
            String s = readLn(br);
            l.add(new Boolean(s));
        }
        return l;
    }

    public static ArrayList<ArrayList<Boolean>> readBooleanMatrix(BufferedReader br, Integer rows) {
        return readBooleanMatrix(br, rows, null);
    }

    public static ArrayList<ArrayList<Boolean>> readBooleanMatrix(BufferedReader br, Integer rows, Integer expectedLength) {
        ArrayList<ArrayList<Boolean>> l = new ArrayList<>();
        for (int x = 0; x < rows.intValue(); x++) {
            l.add(readBooleanList(br, expectedLength));
        }
        return l;
    }

    public static void closeBr(BufferedReader br) {
        try {
            br.close();
        } catch (IOException ex) {
            die("Exception in closeBr");
        }

    }

    public static void die(String reason) {
        sout("Die: " + reason);
        System.exit(0);
    }

    public static void sout(String s) {
        System.out.println(s);
    }

    public static void sout(int i) {
        System.out.println(i);
    }

    public static void sout(Object o) {
        System.out.println(o);
    }

    public static void log(String line) {
        BufferedWriter bw = newBufferedWriter(logfile, true);
        writeLn(bw, line);
        closeBw(bw);
    }

    public static void clearFile(String filename) {
        BufferedWriter bw = newBufferedWriter(filename, false);
        closeBw(bw);
    }

    public static int minInt(ArrayList<Integer> l) {
        int i = l.get(0).intValue();
        for (Integer j : l) {
            if (j.intValue() < i) {
                i = j.intValue();
            }
        }
        return i;
    }

    public static int maxInt(ArrayList<Integer> l) {
        int i = l.get(0).intValue();
        for (Integer j : l) {
            if (j.intValue() > i) {
                i = j.intValue();
            }
        }
        return i;
    }

    public static String joinArray(ArrayList l, String delim) {
        String s = "";
        for (int i = 0; i < l.size(); i++) {
            s += l.get(i).toString();
            if (i < (l.size() - 1)) {
                s += delim;
            }
        }
        return s;
    }

    public static ArrayList<String> splitToChars(String source) {
        ArrayList<String> chars = new ArrayList<>();
        for (int i = 0; i < source.length(); i++) {
            chars.add(source.substring(i, i + 1));
        }
        return chars;
    }

    public static ArrayList<ArrayList<Integer>> allPairs(int lower1, int upper1, int lower2, int upper2, int style) {
        //Style:
        //0 all pairs
        //1 (1) <= (2)
        //2 (1) < (2)

        ArrayList<ArrayList<Integer>> out = new ArrayList<>();

        for (int index1 = lower1; index1 <= upper1; index1++) {
            for (int index2 = lower2; index2 <= upper2; index2++) {
                ArrayList<Integer> thisPair = new ArrayList<>();
                thisPair.add(new Integer(index1));
                thisPair.add(new Integer(index2));

                switch (style) {
                    case 0:
                        out.add(thisPair);
                        break;
                    case 1:
                        if (index1 <= index2) {
                            out.add(thisPair);
                        }
                        break;
                    case 2:
                        if (index1 < index2) {
                            out.add(thisPair);
                        }
                        break;
                    default:
                        die("Unrecognised case in allPairs");
                }


            }
        }

        return out;
    }

    public static ArrayList<ArrayList<Integer>> cloneALALI(ArrayList<ArrayList<Integer>> in) {
        ArrayList<ArrayList<Integer>> out = new ArrayList<>();
        for (ArrayList<Integer> inALI : in) {
            ArrayList<Integer> outALI = new ArrayList<>(inALI);
            out.add(outALI);
        }
        return out;
    }
    
    public static int[][] cloneInt2D(int[][] in) {
        if (in.length == 0) {return new int[0][0];}
        
        int[][] out = new int[in.length][];
        for (int i = 0; i < in.length; i++) {
            out[i] = new int[in[i].length];
            System.arraycopy(in[i], 0, out[i], 0, in[i].length);
        }
        return out;
    }
    
    public static double[][] cloneDouble2D(double[][] in) {
        if (in.length == 0) {return new double[0][0];}
        
        double[][] out = new double[in.length][];
        for (int i = 0; i < in.length; i++) {
            out[i] = new double[in[i].length];
            System.arraycopy(in[i], 0, out[i], 0, in[i].length);
        }
        return out;
    }

    public static ArrayList<ArrayList<Integer>> allPerms(int n) {
        //returns an arraylist of arraylists of integers
        //showing all permutations of Integers 0 to n-1
        //works realistically up to n=10
        if (n == 0) {
            return new ArrayList<ArrayList<Integer>>();
        }
        return allPerms_recurse(n, n);
    }

    public static ArrayList<ArrayList<Integer>> allPerms_recurse(int level, int n) {
        if (level == 1) {
            ArrayList<Integer> single = new ArrayList<>();
            single.add(new Integer(n - level));
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            list.add(single);
            return list;
        }

        ArrayList<ArrayList<Integer>> prev = allPerms_recurse(level - 1, n);
        ArrayList<ArrayList<Integer>> out = new ArrayList<>();


        for (int placeAt = 0; placeAt < level; placeAt++) {
            //clone prev
            ArrayList<ArrayList<Integer>> prevClone = cloneALALI(prev);

            //insert
            for (ArrayList<Integer> prevItem : prevClone) {
                prevItem.add(placeAt, new Integer(n - level));
            }

            //append to out
            out.addAll(prevClone);
        }
        return out;
    }

    public static ArrayList<ArrayList<Integer>> allCombs(int n) {
        //returns an arraylist of arraylists of integers
        //showing all combinations of Integers 0 to n-1
        //works realistically up to n=7
        if (n == 0) {
            return new ArrayList<ArrayList<Integer>>();
        }
        return allCombs_recurse(n, n);
    }

    public static ArrayList<ArrayList<Integer>> nCombs(int count, int n) {
        //returns an arraylist of arraylists of integers
        //showing all combinations of Integers 0 to n-1 --- of length "count"
        //i.e. base "n" counting up to (n^count - 1).  In order.
        if (count == 0) {
            return new ArrayList<ArrayList<Integer>>();
        }
        return allCombs_recurse(count, n);
    }

    public static ArrayList<ArrayList<Integer>> allCombs_recurse(int level, int n) {
        if (level == 1) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> single = new ArrayList<>();
                single.add(new Integer(i));
                list.add(single);
            }
            return list;
        }

        ArrayList<ArrayList<Integer>> prev = allCombs_recurse(level - 1, n);
        ArrayList<ArrayList<Integer>> out = new ArrayList<>();


        for (int initial = 0; initial < n; initial++) {
            //clone prev
            ArrayList<ArrayList<Integer>> prevClone = cloneALALI(prev);

            //insert
            for (ArrayList<Integer> prevItem : prevClone) {
                prevItem.add(0, new Integer(initial));
            }

            //append to out
            out.addAll(prevClone);
        }
        return out;
    }

    public static ArrayList<String> grepFull(ArrayList<String> inList, String pattern) {
        //pattern must match full text
        ArrayList<String> outList = new ArrayList<>();
        for (String s : inList) {
            if (s.matches(pattern)) {
                outList.add(new String(s));
            }
        }

        return outList;
    }

    public static int[] randomIntegerArray(int count, int low, int high, long seed) {
        //a list of "count" ints from low to high inclusive.
        Random rng = new Random();
        if (seed != -1) {
            rng.setSeed(seed);
        }
        int[] out = new int[count];
        for (int x = 0; x < count; x++) {
            out[x] = rng.nextInt(high - low + 1) + low;
        }
        return out;
    }

    public static double[] randomDoubleArray(int count, double low, double high, long seed) {
        //a list of "count" ints from low inclusive to high exclusive.
        Random rng = new Random();
        if (seed != -1) {
            rng.setSeed(seed);
        }
        double[] out = new double[count];
        for (int x = 0; x < count; x++) {
            out[x] = rng.nextDouble() * (high - low) + low;
        }
        return out;
    }

    public static int[] randomPermutation(int count, long seed) {
        //random permutation of the array 0..(count-1).
        Random rng = new Random();
        if (seed != -1) {
            rng.setSeed(seed);
        }

        int[] out = new int[count];
        for (int x = 0; x < count; x++) {
            out[x] = x;
        }
        for (int x = 0; x < count - 1; x++) {
            int takeFrom = rng.nextInt(count - x) + x;
            int tmp = out[takeFrom];
            out[takeFrom] = out[x];
            out[x] = tmp;
        }
        return out;
    }

    public static ArrayList randomiseArray(ArrayList in, long seed) {
        //alternatively, Collections.shuffle(in, new Random(seed))
        ArrayList out = new ArrayList();
        int[] r = randomPermutation(in.size(), seed);
        for (int i : r) {
            out.add(in.get(i));
        }
        return out;
    }

    public static ArrayList<Integer> arrayToArrayList(int[] in) {
        ArrayList<Integer> out = new ArrayList<>();
        for (int i : in) {
            out.add(i);
        }
        return out;
    }

    public static ArrayList<Double> arrayToArrayList(double[] in) {
        ArrayList<Double> out = new ArrayList<>();
        for (double d : in) {
            out.add(d);
        }
        return out;
    }

    public static int[] arrayListToArrayInt(ArrayList<Integer> in) {
        int[] out = new int[in.size()];
        int x = 0;
        for (Integer i : in) {
            out[x] = i.intValue();
            x++;
        }
        return out;
    }

    public static double[] arrayListToArrayDouble(ArrayList<Double> in) {
        double[] out = new double[in.size()];
        int x = 0;
        for (Double d : in) {
            out[x] = d.doubleValue();
            x++;
        }
        return out;
    }

    public static String toString(int[] in) {
        if (in.length == 0) {
            return "[]";
        }
        String s = "[";
        for (int x = 0; x < in.length - 1; x++) {
            s += in[x] + ", ";
        }
        s += in[in.length - 1] + "]";
        return s;
    }

    public static String toString(double[] in) {
        if (in.length == 0) {
            return "[]";
        }
        String s = "[";
        for (int x = 0; x < in.length - 1; x++) {
            s += in[x] + ", ";
        }
        s += in[in.length - 1] + "]";
        return s;
    }

    public static String toString(int[][] in) {
        if (in.length == 0) {
            return "[]";
        }
        String s = "[";
        for (int x = 0; x < in.length - 1; x++) {
            s += toString(in[x]) + ", ";
        }
        s += toString(in[in.length - 1]) + "]";
        return s;
    }

    public static String toString(double[][] in) {
        if (in.length == 0) {
            return "[]";
        }
        String s = "[";
        for (int x = 0; x < in.length - 1; x++) {
            s += toString(in[x]) + ", ";
        }
        s += toString(in[in.length - 1]) + "]";
        return s;
    }
}
