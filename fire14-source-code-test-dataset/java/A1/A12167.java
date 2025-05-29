
import java.io.*;
import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        Q2 q = new Q2();
        //q.test();
        q.answerSmall();
        //q.answerLarge();
    }
    
    public void answerSmall(){
        read("B-small-attempt0.IN", "Q2_small_output.txt");
    }
    
    public void answerLarge(){
        read("B-large-attempt0.IN", "Q2_large_output.txt");
    }
    
    public void test(){
        read("Test2_input.txt", "Test2_output.txt");
    }
    
    public void read(String readFrom, String writeTo){
        try{
            Scanner in = new Scanner(new File(readFrom));
            File f = new File(writeTo);
            FileWriter fw = new FileWriter(f);
            int T = Integer.parseInt(in.nextLine());
            int N,S,p, max, average, remainder, score;
            String[] scores;
            String answer;
            
            for(int i = 1; i <= T; i++) {
                scores = in.nextLine().split(" ");
                N = Integer.parseInt(scores[0]);
                S = Integer.parseInt(scores[1]);
                p = Integer.parseInt(scores[2]);
                max = 0;
                for(int a = 3; a < N + 3; a++) {
                    score = Integer.parseInt(scores[a]);
                    average = score / 3;
                    remainder = score % 3;
                    
                    if(average >= p) {
                        max++;
                    }else if(remainder >= 1 && average + 1 >= p) {
                        max++;
                    }else if(remainder == 2 && average + 2 >= p){
                        if(S > 0){
                            S--;
                            max++;
                        }
                    }else if(remainder == 0 && average - 1 >= 0 && average + 1 >= p) {
                        if(S > 0){
                            S--;
                            max++;
                        }
                    }
                }
                answer = "" + max;
                if(i + 1 <= T)
                    answer += "\r\n";
                fw.write("Case #" + i + ": " + answer);
                
            }
            
            
            fw.close();
        }catch(Exception ex) {
            System.out.println(ex);
        }
    }
}
