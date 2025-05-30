import java.io.*;
import java.util.*;

class GooglersDance {
    public static void main(String[] args) 
	throws Exception {
	new GooglersDance().start();
    }

    void start() 
	throws Exception {
	InputStreamReader is =
            new InputStreamReader(
                                  new FileInputStream("Input"));
        BufferedReader br = new BufferedReader(is);
	OutputStreamWriter os =
	    new OutputStreamWriter(
				   new FileOutputStream("Output"));
	BufferedWriter bw = new BufferedWriter(os);
	String line;
	int[] inputs;
	int test = 1;
	line = br.readLine();
	while ((line = br.readLine()) != null) {
	    String[] inp = line.split(" ");
	    inputs = new int[inp.length];
	    int i = 0;
	    for (String s :  inp) {
		inputs[i++] = Integer.parseInt(s);
	    }
	    int surp = inputs[1];
	    int t = inputs[2];
	    Arrays.sort(inputs, 3, inputs.length);
	    System.out.print("Case #" + test + ": ");
	    String toWrite = "Case #" + test++ + ": ";
	    bw.write(toWrite, 0, toWrite.length());
	    for (i = 3; i < inputs.length; i++) {
		//System.out.print(inputs[i] + " ");
	    }
	    int result = 0;
	    for (i = inputs.length - 1; i > 2; i--) {
		int tot = inputs[i];
		if (tot >= (t * 3)) {
		    result++;
		    continue;
		}
		if (tot <= t) {
		    break;
		}
		tot -= t;
		int val = t - (tot / 2);
		//System.out.print(" val = " + val + " ");
		if (val == 1) {
		    result++;
		    continue;
		}
		else if (val == 2) {
		    if (--surp >= 0) {
			result ++;
			continue;
		    }
		    else {
			break;
		    }
		}
		else {
		    break;
		}
	    }
	    System.out.println(result);
	    String res = Integer.toString(result);
	    bw.write(res, 0, res.length());
	    bw.newLine();
	}
	br.close();
	bw.close();
    }
}