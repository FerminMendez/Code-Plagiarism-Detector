import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;

public class C_Small {

    public static void main(String[] args) {
	try {
	    FileWriter writer = new FileWriter("C-small-attempt.out");
	    BufferedWriter out = new BufferedWriter(writer);
	    String current, result;
	    result = "";
	    Scanner sc = new Scanner(new File("C-small-attempt0.in"));
	    int l = Integer.parseInt(sc.nextLine());
	    for (int k = 0; k < l; k++) {
		result = "Case #" + (k+1) + ": ";
		current = sc.nextLine();
		int count = 0;
		String[] bounds = current.split(" ");
		int a = Integer.parseInt(bounds[0]);
		int b = Integer.parseInt(bounds[1]);
		for (int x = a; x < b; x++) {
		    String num = "" + x;
		    for (int i = 1; i < num.length(); i++) {
			String num2 = num.substring(i) + num.substring(0, i);
			int z = Integer.parseInt(num2);
			if (z <= b && z >= a && z > x) {
			    count++;
			}
		    }
		}
		result += count;
		out.write(result);
		out.newLine();
	    }
	    out.close();
	} catch (Exception e) {
	    System.out.println("error");
	}
    }

}
