
import java.io.*;

public class B {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= T; i++) {
            String[] input = reader.readLine().split(" ");
            int result = 0;
            int N = Integer.parseInt(input[0]);
            int S = Integer.parseInt(input[1]);
            int p = Integer.parseInt(input[2]);
            for (int j = 3; j < input.length; j++) {
                int score = Integer.parseInt(input[j]);
				int temp = score/3;
                if(score % 3 ==0){
					if(temp>=p){
						++result;
					} else if (temp+1>=p && S>0 && temp>=1){
						++result;
						--S;
					}
				} else if(score % 3 ==1){
					if (temp+1>=p){
						++result;
					}
				} else {
					if (temp+1>=p){
						++result;
					} else if(temp+2>=p && S>0){
						++result;
						--S;
					}
				}
            }
            if (i < T) {
                System.out.println("Case #" + i + ": " + result);
            } else {
                System.out.print("Case #" + i + ": " + result);
            }
        }
    }
}