import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleIn = new BufferedReader(new InputStreamReader(System.in));
        String line = consoleIn.readLine();
        int T = Integer.valueOf(line);
        for(int i = 0; i < T; i++){
            line = consoleIn.readLine();
            Scanner sc = new Scanner(line);
            int N = sc.nextInt();
            int S = sc.nextInt();
            int P = sc.nextInt();

            int[] scores = new int[N];
            for(int j = 0; j < N; j++){
                scores[j] = sc.nextInt();
            }

            int[] supMax = new int[N];
            int[] norMax = new int[N];
            for(int j = 0; j < N; j++){
                int score = scores[j];
                int res = score % 3;

                supMax[j] = (score - res) / 3 + 1;
                if(res == 2){
                    supMax[j]++;
                }

                norMax[j] = (score - res) / 3 + 1;
                if(res == 0){
                    norMax[j]--;
                }

                if(score == 0 || score == 1 || score == 30 || score == 29 || score == 28){
                    supMax[j] = norMax[j];
                }
            }

            int needSup = 0;
            int nor = 0;
            for(int j = 0; j < N; j++){
                if(norMax[j] >= P){
                    nor++;
                } else if(supMax[j] >= P){
                    needSup++;
                }
            }

            int result;
            if(needSup <= S){
                result = nor + needSup;
            } else {
                result = nor + S;
            }

            StringBuilder sb = new StringBuilder();

            System.out.printf("Case #%d: %d", i+1, result);
            System.out.println(sb.toString());
        }
    }
}
