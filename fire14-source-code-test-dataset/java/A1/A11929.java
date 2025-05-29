import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class results {
	public int numgooglers,numsurprising,p,counter = 0;
	public int[] scores;
	HashMap<Integer,Integer> maxifnotsurprising, maxifsurprising;

	results(int numgooglers, int numsurprising, int p,HashMap<Integer,Integer> maxifnotsurprising, HashMap<Integer,Integer> maxifsurprising) {
		this.numgooglers = numgooglers;
		this.numsurprising = numsurprising;
		this.p = p;
		scores = new int[numgooglers];
		this.maxifnotsurprising = maxifnotsurprising;
		this.maxifsurprising = maxifsurprising;
	}
	public void addscore(int i) {
		scores[counter] = i;
		counter++;
	}
	public int maxgreaterthanp() {
		int max = 0;
		int remainingsurprising = numsurprising;
		for (int i=0;i<numgooglers;i++) {
			if (maxifnotsurprising.get(scores[i])>=p) max++;
			else if (remainingsurprising>0 && scores[i] > 1 ) { //If it's surprising, minimum score is 2
				if (maxifsurprising.get(scores[i])>=p) {
					max++;
					remainingsurprising--;
				}
			}
		}


		return max;
	}

}

public class DancingWithGooglers {

	final static String inputfile = "B-small-attempt0.in",outfile = "output.txt";
	static HashMap<Integer,Integer> maxifnotsurprising,maxifsurprising;


	public static void main(String[] args) {
		maxifnotsurprising = new HashMap<Integer,Integer>(); 
		maxifsurprising = new HashMap<Integer,Integer>(); 

		for(int i=0;i<11;i++) {				//Smallest
			for (int j=i;j<i+3;j++){		//Middle
				for (int k=j;k<i+3;k++) {
					//System.out.println(i+","+j+","+k);
					int sum = i+j+k;
					if (k-i == 2) { 	   //Is surprising
						if (!maxifsurprising.containsKey(sum)) maxifsurprising.put(sum, k);
						else if (maxifsurprising.get(sum)<k) maxifsurprising.put(sum, k);
					}
					else {
						if (!maxifnotsurprising.containsKey(sum)) maxifnotsurprising.put(sum, k);
						else if (maxifnotsurprising.get(sum)<k) maxifnotsurprising.put(sum, k);
					}
				}
			}
		}
		ArrayList<results> cases = new ArrayList<results>();
		Scanner sc = null;
		try {
			sc = new Scanner(new File(inputfile));
		} catch (FileNotFoundException e) {
			System.err.println("OHONEZ");
		}
		int numtestcases = sc.nextInt();
		for (int i=0;i<numtestcases;i++) {
			results temp = new results(sc.nextInt(), sc.nextInt(), sc.nextInt(),maxifnotsurprising,maxifsurprising);
			for (int j=0;j<temp.numgooglers;j++) temp.addscore(sc.nextInt());
			cases.add(temp);
		}
		FileWriter fstream = null;
		try {
			fstream = new FileWriter(outfile);
			BufferedWriter out = new BufferedWriter(fstream);
			for (int i=0;i<cases.size();i++) {
				System.out.println("Case #"+(i+1)+": "+cases.get(i).maxgreaterthanp());
				out.write("Case #"+(i+1)+": "+cases.get(i).maxgreaterthanp()+"\n");
			}
			out.close();
		} catch (IOException e) {}

	}

}
