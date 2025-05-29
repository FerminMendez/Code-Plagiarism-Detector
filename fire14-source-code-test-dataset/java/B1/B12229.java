import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        String filename = "C:\\Users\\irene\\Desktop\\input.txt";
        List<String> inputLines = readInput(filename);
        int i = 0;
        for (String line : inputLines) {
            String[] limits = line.split("\\s+");
            RecycledNumbers rn = new RecycledNumbers(Integer.parseInt(limits[0]), Integer.parseInt(limits[1]));
            int result = rn.getDistinctPairsCount();
            System.out.print("Case #" + (i + 1) + ": " + result);
            System.out.println();
            i++;
        }
    }

    private static List<String> readInput(String filename) throws IOException {
        BufferedReader in
                = new BufferedReader(new FileReader(filename));

        Integer totalLines = Integer.parseInt(in.readLine());
        ArrayList<String> lines = new ArrayList<String>(totalLines);
        for (int i = 0; i < totalLines; i++) {
            lines.add(in.readLine());
        }
        return lines;
    }
}
