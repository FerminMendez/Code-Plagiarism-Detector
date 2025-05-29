package atm;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
/**
 *
 * @author Antonio Lievano
 */
public class Googlers {
    public static void main (String[]Args) throws FileNotFoundException {
    FileReader reader = new FileReader("C:\\Users\\Antonio Lievano\\Desktop\\B-small-attempt4.in");
    Scanner in = new Scanner(reader);
    int cases = Integer.parseInt(in.nextLine());
    for (int i = 0; i<cases; i++) {
    System.out.print("Case #" + (i+1) + ": ");
    String line = in.nextLine();
    String [] temp = line.split(" ");
    int n = Integer.parseInt(temp[0]);
    int s = Integer.parseInt(temp[1]);
    int p = Integer.parseInt(temp[2]);
    int answer = 0;
    int counter = 0;
    int [] points = new int [temp.length-3];
    for (int x = 0; x<temp.length-3; x++){
        points[x] = Integer.parseInt(temp[x+3]);
    }
    for (int j = 0; j<points.length; j++) {
        if (points[j]>((p*3)-3)) {
            points[j] = -9999;
            answer++;
        }
    }
        for (int k = 0; k<points.length; k++){
            if (counter==s)
                break;
            if (((p*3)-5)<0)
                break;
            if (points[k]>((p*3)-5)){
                points[k] = -9999;
                answer++;
                counter++;
            }
    }
    System.out.print(answer);
    System.out.println();
    }
}
}