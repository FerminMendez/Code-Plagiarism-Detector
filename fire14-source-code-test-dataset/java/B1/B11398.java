import java.util.Scanner;

public class Recycler {

    private Scanner input;

    private int numTests = 0;

    public static void main(String[] args) {
	Scanner inp = new Scanner(System.in);
	int numChar = 0;
	numChar = inp.nextInt();
	Recycler r = new Recycler(inp, numChar);
	r.recycle();
    }

    public Recycler(Scanner inp, int numChar) {
	this.input = inp;
	this.numTests = numChar;
    }

    public void recycle() {
	for (int i = 1; (i <= numTests) && input.hasNextLine(); i += 1) {
	    int base = input.nextInt();
	    int end = input.nextInt();
	    int cycles = this.countCycles(base, end);
	    System.out.println("Case #" + i + ": " + cycles);
	}
    }

    public int countCycles(int start, int end) {
	int total = 0;
	int order = order(start);
	for (int i = start; i < end; i += 1) {
	    for (int j = i + 1; j <= end; j += 1) {
		if (isRecycled(i, j, order)) {
		    total += 1;
		}
	    }
	}
	return total;
    }

    public static boolean isRecycled(int i, int j, int order) {
	int rot = (j / 10) + (order * (j - (10 * (j / 10))));
	while (rot != j) {
	    if (rot == i) {
		return true;
	    }
	    rot = (rot / 10) + (order * (rot - (10 * (rot / 10))));
	}
	return false;
    }

    public static int order(int i) {
	int order = 0;
	while (i > 0) {
	    i /= 10;
	    order += 1;
	}
	int result = 1;
	for (int j = 1; j < order; j += 1) {
	    result *= 10;
	}
	return result;
    }
}
	    
	