import java.io.*;
import java.util.*;

public class RecycledNumbers{

	public static void main(String[] args){

		String [] parse = new String[100];
		int T;
		String s = "";
		String a = "";
		int counter = 0;
		int count = 0;
		int pair = 0;
		int length = 0;
		int k = 0;
		int l = 0;
		int index = 0;
		int flag = 0;
		int [][] pairArry = new int [10000][2];
		File inFile = new File("C-small-attempt1.in");
		File outFile = new File("C-small-attempt1.txt");


		try{
			BufferedReader in = new BufferedReader(new FileReader(inFile));
			PrintWriter out = new PrintWriter(new FileWriter(outFile));

			T = Integer.parseInt(in.readLine());

			for(int i=0;i<T;i++){

				s = in.readLine();
				StringTokenizer st = new StringTokenizer(s, " ");
				while(st.hasMoreTokens()) {
					parse[counter++] = st.nextToken();
				}

				int min = Integer.parseInt(parse[0]);
				int max = Integer.parseInt(parse[1]);

				if((Integer.toString(max)).length() >= 2){

					for(int j=min; j<=max; j++){

						length = (Integer.toString(j)).length();

						s = Integer.toString(j);

						//out.println(s);

						a = "";

						for(k=0;k<length;k++){
							l = k;
							while(count < length){
								if(l >= length){
									l = l - length;
									a = a + Character.toString(s.charAt(l));
									l++;
								}else{
									a = a + Character.toString(s.charAt(l));
									l++;
								}

								count++;
							}
							//out.println(a);
							count = 0;

							if((j < Integer.parseInt(a)) && (Integer.parseInt(a) <= max)){
								pairArry[index][0] = j;
								pairArry[index][1] = Integer.parseInt(a);
								index++;
								pair++;
							}
							//count = 0;
							a = "";
						}
						//out.println();
					}
				}

				for(int m=0;m<index;m++){
					for(int n=m+1;n<index;n++){
						if(pairArry[m][0] == pairArry[n][0]){
							if(pairArry[m][1] == pairArry[n][1]){
								pair--;
							}
						}

						if(pairArry[m][0] == pairArry[n][1]){
							if(pairArry[m][1] == pairArry[n][0]){
								pair--;
							}
						}
					}
				}
				out.println("Case #" + (i+1) + ": " + pair);
				pairArry = new int [10000][2];
				pair = 0;
				counter = 0;
				index = 0;



			}

			in.close();
			out.close();
		}catch(IOException e){

			e.printStackTrace();
		}
	}
}


