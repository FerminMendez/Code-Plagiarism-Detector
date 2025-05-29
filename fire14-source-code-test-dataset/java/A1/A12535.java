import java.io.*;
import java.util.*;

public class Googlers{

	public static int t;
	public int T;
	public int S;
	public int P;
	public int [] ti;
	public int y = 0;
	public int [] v = new int[3];
	public int check = 0;
	public int checkS = 0;

	public static void main(String[] args){

		String [] parse = new String[100];
		int counter = 0;
		int i;

		File inFile = new File("B-small-attempt0.in");
		File outFile = new File("B-small-attempt0.txt");



		try{

			BufferedReader in = new BufferedReader(new FileReader(inFile));
			PrintWriter out = new PrintWriter(new FileWriter(outFile));

			int t = Integer.parseInt(in.readLine());

			Googlers [] testCase = new Googlers[t];

			for(i=0;i<t;i++){

				testCase[i] = new Googlers();

				String s = in.readLine();
				StringTokenizer st = new StringTokenizer(s, " ");
				while(st.hasMoreTokens()) {
					parse[counter++] = st.nextToken();
				}

				testCase[i].T = Integer.parseInt(parse[0]);
				testCase[i].S = Integer.parseInt(parse[1]);
				testCase[i].P = Integer.parseInt(parse[2]);

				testCase[i].ti = new int [testCase[i].T];

				for(int j=3; j<counter;j++){
					testCase[i].ti[j-3] = Integer.parseInt(parse[j]);
				}
				counter = 0;
			}

			for(i=0;i<t;i++){
				for(int j=0; j<testCase[i].ti.length;j++){

					int total = testCase[i].ti[j];

					int fraction = getFraction(total);

					if(fraction>5){
						testCase[i].v[0] = total / 3;
						testCase[i].v[0] = testCase[i].v[0] + 1;
						testCase[i].v[1] = testCase[i].v[0];
						testCase[i].v[2] = total - testCase[i].v[1] - testCase[i].v[0];
					}else{
						testCase[i].v[0] = total / 3;
						testCase[i].v[1] = testCase[i].v[0];
						testCase[i].v[2] = total - testCase[i].v[1] - testCase[i].v[0];
					}

					if(testCase[i].v[0] >= testCase[i].P || testCase[i].v[1] >= testCase[i].P || testCase[i].v[2] >= testCase[i].P){
						testCase[i].y = testCase[i].y + 1;
					}else{
						if(testCase[i].S != 0){
							if(testCase[i].checkS < testCase[i].S){
								testCase[i].v[0] = testCase[i].P;
								testCase[i].v[1] = testCase[i].P - 2;
								testCase[i].v[2] = total - testCase[i].v[1] - testCase[i].v[0];

								if(testCase[i].v[0] < total){
									if((testCase[i].v[0] >= 0 || testCase[i].v[1] >= 0 || testCase[i].v[2] >= 0) && (testCase[i].v[0] <= 10 || testCase[i].v[1] <= 10 || testCase[i].v[2] <= 0)){
										if(testCase[i].v[0] > testCase[i].v[2]){
											if(testCase[i].v[0] - testCase[i].v[2]<=2){
												testCase[i].y = testCase[i].y + 1;
												testCase[i].checkS = testCase[i].checkS + 1;
											}
										}else{
											if(testCase[i].v[2] - testCase[i].v[0]<=2){
												testCase[i].y = testCase[i].y + 1;
												testCase[i].checkS = testCase[i].checkS + 1;
											}
										}
									}
								}
							}
						}

					}
				}

				out.println("Case #" + (i+1) + ": " + testCase[i].y);
			}

			in.close();
			out.close();
		}catch(IOException e){
			e.printStackTrace();
		}

	}

	public static void calTriplets(int a){

			int total = a;

			int fraction = getFraction(total);

			if(fraction>5){

				int v1 = total / 3;

				v1 = v1 + 1;

				int v2 = v1;

				int v3 = total - v1 - v2;

			}else{

				int v1 = total / 3;

				int v2 = v1;

				int v3 = total - v1 - v2;

			}

	}

	public static int getFraction(int value){

		double a = (double) value / 3;

		String b = Double.toString(a);

		int c = b.indexOf(".");

		Character d = new Character(b.charAt(c+1));

		String e = d.toString();

		int f = Integer.parseInt(e);

		//System.out.println(f);

		return f;
	}

}