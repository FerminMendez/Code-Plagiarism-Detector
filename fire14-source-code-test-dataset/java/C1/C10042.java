package template;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;

public class TestCaseIO {

    public static ArrayList<TestCase> loadFromFile(String infile) {
        //inc checks on #lines, length of splits, etc.
        BufferedReader br = Utils.newBufferedReader(infile);
        ArrayList<TestCase> tcList = new ArrayList<>();

        //first line is N, the number of test cases
        Integer N = Utils.readInteger(br);

        //cycle through N test cases
        for (int x = 0; x < N; x++) {
            TestCase tc = new TestCase();
            tc.setRef(x + 1);

            ///////////////////////////////////////////////////////////
            //load properties - the bit to customise per problem
            ArrayList<Integer> l = Utils.readIntegerList(br, 3);
            tc.setInteger("H", l.get(0));
            tc.setInteger("W", l.get(1));
            tc.setInteger("D", l.get(2));
            tc.setStringList("rows", Utils.readMultipleStrings(br, l.get(0)));

            ///////////////////////////////////////////////////////////

            tcList.add(tc);
        }

        //confirm end of file
        if (Utils.readLn(br) != null) {
            Utils.die("Unexpected text at end of infile");
        }

        return tcList;
    }

    public static ArrayList<TestCase> mockUp() {

        ArrayList<TestCase> tcList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TestCase tc = new TestCase();
            tc.setRef(i);
            
            int[] xs = Utils.randomIntegerArray(100, -50, 50, i * 2);
            int[] ys = Utils.randomIntegerArray(100, -50, 50, i * 2 + 1);
            tc.setIntegerList("xs", Utils.arrayToArrayList(xs));
            tc.setIntegerList("ys", Utils.arrayToArrayList(ys));

            tcList.add(tc);
        }
        return tcList;
    }

    public static void writeSolutions(ArrayList<TestCase> tcList, String outfile) {

        BufferedWriter bw = Utils.newBufferedWriter(outfile, false);

        for (int i = 0; i < tcList.size(); i++) {
            TestCase tc = tcList.get(i);
            Object solution = tc.getSolution();
            String line = "Case #" + (i + 1) + ": " + solution.toString();
            Utils.writeLn(bw, line);
        }

        Utils.closeBw(bw);

    }
}
