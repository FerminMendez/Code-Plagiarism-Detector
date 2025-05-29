import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class google_2 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fstream = new FileInputStream("D:/Rilsikane/Google2/src/B-small-attempt7.in");
		 DataInputStream in = new DataInputStream(fstream);
		  BufferedReader br = new BufferedReader(new InputStreamReader(in));
		  String strLine;
		  String s="";
		  while ((strLine = br.readLine()) != null)   {
			   s+=(strLine);
			   s+="\n";
		  }
		String x ="2 1 1 8 0";  
		compute(s);
	}
	
	
	public static void compute(String x) throws IOException{
		String temp[] = x.split("\n");
		
		int size = Integer.parseInt(temp[0]);
		FileWriter fstream = new FileWriter("D:/Rilsikane/Google2/src/B-small-attempt7_output.txt");
		  BufferedWriter out = new BufferedWriter(fstream);	
		for(int k=1;k<=size;k++){			
		int result = 0;
		int n  = 0;
		int s = 0;
		int p = 0;
		int[] score = new int[10];
		for(int j=0;j<temp[k].length();j++){
			
			String temp2[] =temp[k].split(" ");
			 n  = Integer.parseInt(temp2[0]);
			 s = Integer.parseInt(temp2[1]);
			 p = Integer.parseInt(temp2[2]);
			 score = new int[n];
		for(int i =0;i<n;i++){
			score[i]=Integer.parseInt(temp2[3+i]);
		}
		
			//System.out.println("Case #"+k+":" +result);
		}	
		System.out.println("Case #"+k+": "+calculate(n, s, p, score)+"\n");
		out.write("Case #"+k+": "+calculate(n, s, p, score)+"\n");
		
	}
		 out.close();
	}
	public static int calculate(int n, int s, int p,
			   int[] scores) {
			  int result = 0;

			  int index = 0;
			  for (int score : scores) {
			   int base = score / 3;
			   switch (score % 3) {
			   case 0:


			    if (base >= p) {
			     result++;
			    } else {
			     if (s > 0 && base > 0 && (base + 1) >= p) {
			      s--;
			      result++;
			     }
			    }
			    break;
			   case 1:

			    if (base >= p || base + 1 >= p) {
			     result++;
			    } else {
			     if (p > 0 && (base + 1) >= p) {
			      s--;
			      result++;
			     }
			    }

			    break;
			   case 2:

			    if (base >= p || base + 1 >= p) {
			     result++;
			    } else {
			     if (s > 0 && (base + 2) >= p) {
			      s--;
			      result++;
			     }
			    }
			    break;
			   }
			   index++;
			  }
//			  System.out.println("Result: " + result);

			  return result;
			 }

}
