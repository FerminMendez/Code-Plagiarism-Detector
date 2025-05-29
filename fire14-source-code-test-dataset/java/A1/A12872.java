package google2012;


import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DancingGooglers {

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

    public DancingGooglers(String fileName) throws IOException {
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
                String result = calculate(in.nextInt(), in.nextInt(), in.nextInt());
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


    private String calculate(int N, int S, int p) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            int t = in.nextInt();
            if (t == 0) {
                if (p == 0) {
                    count++;
                }
                continue;
            }

            int avg = t / 3;
            if (avg * 3 == t) {
                if (avg >= p) {
                    count++;
                } else if (avg + 1 >= p) {
                    if (S > 0) {
                        count++;
                        S--;
                    }
                }
            } else {
                if (avg + 1 >= p) {
                    count++;
                } else if (avg + 2 >= p && t != 1) {
                    if (S > 0) {
                        count++;
                        S--;
                    }
                }
            }
        }
        return "" + count;
    }


    public static void main(String[] args) throws Exception {
//        String fileName = "test.in";
        String fileName = "B-small-attempt2.in";
        DancingGooglers problem = new DancingGooglers(fileName);
        problem.execute();
    }
}
