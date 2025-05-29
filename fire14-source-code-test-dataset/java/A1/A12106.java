import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class GoogleDance {

    public static void main(String[] args) {
        File inputFile = new File("input.txt");        
        Scanner s;

        try {
            s = new Scanner(inputFile);
            int lineCount = s.nextInt();
            s.nextLine();
            
            int googlers, surprising, target, max;
            int score;
            
            for(int i = 1; i <= lineCount; i++) {
                max = 0;
                googlers = s.nextInt();
                surprising = s.nextInt();
                target = s.nextInt();
                
                for(int j = 0; j < googlers; j++) {
                    score = s.nextInt();
                    
                    if(score == 0 && target == 0) max++;
                    else if(score <= target) continue;
                    else if(score / 3 >= target) max++;
                    else {
                        score -= target;
                        if(score/2 >= target)
                            max++;
                        else if(Math.abs(score/2 - target) < 2)
                            max++;
                        else if(surprising > 0 && Math.abs(score/2 - target) < 3) {
                            max++;
                            surprising--;
                        }
                    }
                }
                
                System.out.println("Case #"+i+": "+max);
            }
            
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
