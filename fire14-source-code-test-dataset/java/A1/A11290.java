import java.util.Scanner;
import java.util.ArrayList;    

public class Dancing {
    public static String[] reader() {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            words.add(sc.nextLine());
        }
        String toreturn[] = new String[words.size()];
        words.toArray(toreturn);
        return toreturn;
    }
    
    public static void main(String[] args) {
        String[] input = Dancing.reader();
        for (int i = 0; i < input.length; i++) {
            String vals[] = input[i].split(" ");
            int surprise = Integer.parseInt(vals[1]);
            int min = Integer.parseInt(vals[2]);
            int counter = 0;
            int surprisecounter = 0;
            for (int j = 3; j < vals.length; j++) {
                int tocount = 0;
                int sup = 1;
                int madeit = 0;
                for (int k = min; k < 11; k++) {
                    //System.out.println(vals[j]);
                    int test = Integer.parseInt(vals[j]) - k;
                    int test2 = test/2;
                    //System.out.println("im " + k);
                    //System.out.println(test2);
                    if ((test2 - k) <= 2 && (test2 - k) >= -2 && test >= 0) {
                        if (test2 - k == 2 || k - test2 == 2) {
                            tocount = 1;
                            madeit = 1;
                            //System.out.println("surprise");
                        }
                        else {
                            tocount = 1;
                            sup = 0;
                            madeit = 1;
                            //System.out.println("no surprise");
                        }
                    }
                    //System.out.println(tocount + " " + sup);
                }
                if (tocount == 1) {
                    counter++;
                    if (sup == 1 && madeit == 1) surprisecounter++;
                }
                //System.out.println(surprisecounter);
                if (surprisecounter > surprise && sup == 1 && madeit == 1) {
                    counter--;
                    //System.out.println("WHYYY");
                    //break;
                }
            }
            System.out.println("Case #" + (i+1) + ": " + counter);
        }
    }
}
