
import java.util.Scanner;

public class Dancing_with_the_googlers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        for (int i = 1; i <= input; i++){
            int googlers = sc.nextInt();
            int surprises = sc.nextInt();
            int min = sc.nextInt();
            int results = 0;
            for (int j = 0; j < googlers; j++){
                int googler = sc.nextInt();
                int avg = googler / 3;
                int mod = googler % 3;
                if (avg >= min || ((avg + 1 == min) && mod > 0)){
                    results++;
                }else if (surprises > 0 && (avg + 1 == min) && avg != 0){
                    results++;
                    surprises--;
                }else if (surprises > 0 && (avg + 2 == min) && mod > 1) {
                    results++;
                    surprises--;
                }
            }
            System.out.println("Case #"+i+": "+results);
            
        }
    }
}
