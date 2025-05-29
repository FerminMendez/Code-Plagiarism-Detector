import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class JamProblem {

    int caseCount;
    int lastLine;

    abstract String solveCase(JamCase jamCase);
    abstract JamCase parseCase(List<String> file, int line);
    List<String> loadFile() throws IOException {
        FileReader inputStream = new FileReader("C:\\projekt\\codejam\\src\\input.txt");
        BufferedReader reader = new BufferedReader(inputStream);
        List<String> list = new ArrayList<String>();
        while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }
            list.add(line);
        }
        return list;
    }

    void go() throws IOException {
        List<String> file = loadFile();


        parseFirstLine(file);
        FileWriter writer = new FileWriter("C:\\projekt\\codejam\\src\\otput.txt");
        for (int c=0; c< caseCount; c++) {
            JamCase casee= parseCase(file, lastLine);
            lastLine += casee.lineCount;
            String s = solveCase(casee);
            writer.write("Case #" + (c+1) +": " + s + "\n");
        }
        writer.close();
    }

    void parseFirstLine(List<String> file) {
        int[] firstLine = JamUtil.parseIntList(file.get(0), 1);
        this.caseCount = firstLine[0];
        lastLine = 1;
    }
}
