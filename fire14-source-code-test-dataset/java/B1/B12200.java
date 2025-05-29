
import java.io.*;
import java.util.*;

public class Q3 {
    public static void main(String[] args) {
        Q3 q = new Q3();
        //System.out.println(q.calculate(10, 2000000));
        //q.test();
        q.answerSmall();
        //q.answerLarge();
    }
    
    public void answerSmall(){
        read("C-small-attempt0.IN", "Q3_small_output.txt");
    }
    
    public void answerLarge(){
        read("C-large.IN", "Q3_large_output.txt");
    }
    
    public void test(){
        read("Test3_input.txt", "Test3_output.txt");
    }
    
    public void read(String readFrom, String writeTo){
        try{
            Scanner in = new Scanner(new File(readFrom));
            File f = new File(writeTo);
            FileWriter fw = new FileWriter(f);
            int T = Integer.parseInt(in.nextLine());
            int A, B;
            String[] input;
            String answer;
            
            for(int i = 1; i <= T; i++) {
                input = in.nextLine().split(" ");
                A = Integer.parseInt(input[0]);
                B = Integer.parseInt(input[1]);
                
                answer = "" + calculate(A, B);
                if(i + 1 <= T)
                    answer += "\r\n";
                fw.write("Case #" + i + ": " + answer);
                
            }
            
            
            fw.close();
        }catch(Exception ex) {
            System.out.println(ex);
        }
    }
    
    public int calculate(int A, int B) {
        int num = 0, m;
        String hold;
        ArrayList<Integer> distinct = new ArrayList<Integer>();
        for(int n = A; n <= B; n++) {
            if(n > 10) {
                hold = "" + n;
                distinct.clear();
                for(int i = 1; i < hold.length(); i++) {
                    m = Integer.parseInt((hold.substring(i) + hold.substring(0,i)));
                    if(m <= B && n < m && !distinct.contains(m)) {
                        distinct.add(m);
                        num++;
                    }
                }
            }
        }
        return num;
    }
}
