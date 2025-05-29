package dg.gcj.bdancing;

import java.io.*;


/**
 * Created by IntelliJ IDEA.
 * User: Dmitry
 * Date: 14.04.12
 * Time: 23:28
 * To change this template use File | Settings | File Templates.
 */
public class DancingEntryPoint
{
    public static void main(String[] args) throws IOException {
//        String inputFileName = "test.txt";
        String inputFileName = "B-small-attempt0.in";
//        String inputFileName = "B-large-practice.in";

        final RandomAccessFile ra = new RandomAccessFile(inputFileName,"r");

        String line = ra.readLine();
        final int testsCount = Integer.parseInt(line.trim());

        Parser testParser = new Parser();
        Solver solver = new Solver();

        final File resultFile = new File(inputFileName + ".out.txt");
        resultFile.delete();
        resultFile.createNewFile();
        final OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(resultFile), "UTF-8");

        for(int i = 0; i < testsCount; ++ i)
        {
            String testLine = ra.readLine();

            final World world = testParser.parse(testLine);

            int result = solver.solve(world);

            StringBuilder formattedResult = new StringBuilder();
            formattedResult.append("Case #").append(i + 1).append(": ");
            formattedResult.append(result);
            formattedResult.append("\r\n");

            writer.write(formattedResult.toString(), 0, formattedResult.length());

            System.out.print(formattedResult);
        }
        writer.close();
        ra.close();
    }
}
