import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class QualificationRoundB {
    public static void main(String[] args) throws IOException {
        String inFile = args[0];
        String outFile = inFile.replaceAll("\\.in$", ".out");

        Scanner scanner = new Scanner(new FileInputStream(inFile));
        int cases = scanner.nextInt();

        FileWriter fileWriter = new FileWriter(outFile);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for(int c = 1; c <= cases; c++){
            bufferedWriter.write(String.format("Case #%d: ", c));
            int N = scanner.nextInt();
            int S = scanner.nextInt();
            int p = scanner.nextInt();
            int t[] = new int[N];
            for(int n = 0; n < N; n++)
                t[n] = scanner.nextInt();

            int count = 0;
            int midTop = 3*p - 3;
            int midBot = 3*p - 4;
            for(int n = 0; n < N; n++){
                switch(p){
                    case 0:
                    case 1:
                        if(t[n] >= p)
                            count++;
                        break;
                    default:
                        if(t[n] > midTop){
                            count++;
                        }
                        else if(t[n] >= midBot && S > 0){
                            S--;
                            count++;
                        }
                }
            }
            System.out.println(String.format("%d", count));
            bufferedWriter.write(String.format("%d\n", count));
        }
        bufferedWriter.close();
        fileWriter.close();
    }
}
