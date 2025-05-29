package google2012;


import java.io.*;
import java.util.*;

public class RecycledNumbers {

    private Map<Character, Character> dic = new HashMap<>();

    protected BufferedReader reader;
    protected BufferedWriter writer;
    protected Scanner in;

    public static BufferedReader openReader(String inputFile) throws IOException {
        FileInputStream fis = new FileInputStream(new File(inputFile).getAbsoluteFile());
        return new BufferedReader(
                new InputStreamReader(fis, "UTF-8")
        );
    }

    public static BufferedWriter openWriter(String outputFile) throws IOException {
        File file = new File(outputFile);

        FileOutputStream fos = new FileOutputStream(file.getAbsoluteFile());
        return new BufferedWriter(
                new OutputStreamWriter(fos, "UTF-8")
        );
    }

    public RecycledNumbers(String fileName) throws IOException {
        init(fileName);
    }

    protected void init(String fileName) throws IOException {
        String in = fileName;
        String out = in.replace(".in", ".out");
        reader = openReader(in);
        this.in = new Scanner(reader);
        writer = openWriter(out);
    }

    public void close() {

        try {
            in.close();
        } catch (Exception e) {
            // ignore
        }

        try {
            if (reader != null) {
                reader.close();
            }
        } catch (IOException e) {
            //ignore
        }
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            //ignore
        }
    }


    public void write(int caseNumber) throws IOException {
        write("Case #" + caseNumber + ":");
    }

    public void write(int caseNumber, String val) throws IOException {
        write("Case #" + caseNumber + ": " + val);
    }

    public void write(String val) throws IOException {
        writer.write(val + "\n");
        writer.flush();
    }

    public void execute() {
        try {

            long startProblem = System.currentTimeMillis();
            int T = in.nextInt();
            System.out.println("Tests:" + T);
            for (int i = 1; i <= T; i++) {
                long startCase = System.currentTimeMillis();
                String result = calculate(in.nextInt(), in.nextInt());
                System.out.println("case:" + i + " took: " + (System.currentTimeMillis() - startCase) + ", ms");
                write(i, "" + result);
            }
            System.out.println("Took: " + (System.currentTimeMillis() - startProblem) + ", ms");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            close();
        }
    }


    private String calculate(int A, int B) {
        long count = 0;
        for (int i = A; i <= B; i++) {
            String s = Integer.toString(i);
            Set<Integer> set = new HashSet<>();
            for (int k = 1; k < s.length(); k++) {
                String newStr = s.substring(k) + s.substring(0, k);
                int val = Integer.parseInt(newStr);
                if (val > i && val <= B) {
                    set.add(val);
                }
            }
            count += set.size();
        }
        return "" + count;
    }


    public static void main(String[] args) throws Exception {
//        String fileName = "test.in";
//        String fileName = "B-small-attempt2.in";
//        String fileName = "B-large.in";
        String fileName = "C-small-attempt0.in";
        RecycledNumbers problem = new RecycledNumbers(fileName);
        problem.execute();
    }
}
