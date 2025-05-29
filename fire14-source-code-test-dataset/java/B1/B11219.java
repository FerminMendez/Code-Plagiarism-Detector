import java.io.*;
import java.util.*;

public class ProblemC {

    public static int recycles(int a, int min, int max) {
	HashSet<Integer> history = new HashSet<Integer>();
	int count = 0;
	int size = ("" + a).length();
	int power = (int)Math.pow(10, size - 1);
	int value = a;
	history.add(a);
	for (int i = 0; i < size; i++) {
	    int digit = value % 10;
	    int next = value / 10 + digit * power;
	    if (history.contains(next)) {
		break;
	    } else if (digit != 0 && next > a && next >= min && next <= max) {
		count++;
	    }
	    value = next;
	    history.add(next);
	}
	return count;
    }

    public static void main(String[] args) throws Exception {
	Scanner input = new Scanner(System.in);
	int lines = Integer.parseInt(input.nextLine().trim());
	for (int i = 0; i < lines; i++) {
	    String[] tokens = input.nextLine().split(" ");
	    int A = Integer.parseInt(tokens[0].trim());
	    int B = Integer.parseInt(tokens[1].trim());
	    int total = 0;
	    for (int j = A; j <= B; j++) {
		total += recycles(j, A, B);
	    }
	    System.out.println("Case #" + (i+1) + ": " + total);
	}
    }

}