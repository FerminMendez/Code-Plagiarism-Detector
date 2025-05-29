import static java.lang.System.in;
import static java.lang.System.out;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Dancing {

	
	public static void main(String[] args) throws IOException {
		Scanner asdf = new Scanner(in);
		Scanner file = new Scanner(new File("B-small.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("B-small.out")));
		int t = file.nextInt();
		
		for(int r=1; r<=t; r++){
			run(r, file, out, asdf);
		}
		
		out.close();
	}
	
	public static void run(int r, Scanner file, PrintWriter out, Scanner asdf){
		
		int n = file.nextInt();
		int s = file.nextInt();
		int p = file.nextInt();
		int count = 0;
		int[] ds = new int[n];
		//int sc[] = new int[3];
		
		for(int a=0; a<n; a++)
			ds[a] = file.nextInt();
		
		for(int i:ds){
			if(p==0){
				count = n;
				break;
			}
			
			int goal = p*3-2;
			if(p==1 && i!=0){
				count++;
			}
			else if(i>=goal)
				count++;
			else if(s>0 && i>=2 && (i+2)>=goal){
				count++;
				s--;
			}
			
		}

		//System.out.println(count);
		//System.out.println();
		
		out.println("Case #"+r+": "+count);
	}
	
	/*public static void run(int r, Scanner file, PrintWriter out, Scanner asdf){
		
		int n = file.nextInt(); //3 # googlers
		int s = file.nextInt(); //3 # surprises
		int p = file.nextInt(); //10 score search
		int count = 0;
		
		int[] ds = new int[n];
		for(int a=0; a<n; a++)
			ds[a] = file.nextInt();

		for(int i:ds){
			//if(i==0 && p!=0)
				//break;
			int[] sc = new int[3];
			sc[0] = i/3;
			sc[1] = i/3;
			sc[2] = i-sc[0]-sc[1];

			if(sc[2]>10){
				sc[1] += sc[2]-10;
				sc[2] = 10;
			}
			if(sc[2]<p && (sc[2]-sc[0]+1<2) && sc[0]!=0){
				sc[2]++;
				sc[0]--;
			}
			if(s==0 && sc[2]-sc[0]==2 && sc[2]!=0){
				sc[2]--;
				sc[0]++;
			}
			if(s==0 && sc[2]-sc[1]==2 && sc[2]!=0){
				sc[2]--;
				sc[1]++;
			}
			
			if(sc[2]>=p){
				if(s>0 && (sc[2]-sc[1]==2 || sc[2]-sc[0]==2)){
					s--;
					count++;
				}
				else if(sc[2]-sc[1]<2 && sc[2]-sc[1]<2)
					count++;
			}
			else if(s>0 && sc[2]-sc[1]<=1 && sc[2]-sc[0]<=1 && (sc[0]!=0 && sc[1]!=0 && sc[2]!=0)){
				sc[2]++;
					if(sc[2]==p){
						s--;
						count++;
					}
			}
			//if(sc[0]==-1 && p!=0)
				//count--;
			
			System.out.println(sc[0]+" "+sc[1]+" "+sc[2]+" "+s+" "+count);
		}
		System.out.println(r+" "+n+" "+p);
		System.out.println();
		//out.println("Case #"+r+": "+count);
	}*/

}







/*for(int i:ds){
sc[0] = i/3;
sc[1] = i/3;
sc[2] = i-sc[0]-sc[1];

if(sc[2]>10){
	sc[1] += sc[2]-10;
	sc[2] = 10;
}
		
if(sc[2]>=p){
	if(sc[2]-sc[1]<=1)
		count++;
	else if(s>0){
		s--;
		count++;
	}
	break;
}
}*/