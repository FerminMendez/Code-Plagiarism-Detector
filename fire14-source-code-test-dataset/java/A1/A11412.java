import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader fileIN=new BufferedReader(new FileReader(new File("B-small-attempt0.in")));
		BufferedWriter fileOUT=new BufferedWriter(new FileWriter("B-smallOUT.txt"));
		String Line;
		String[] splitted;
		int T, N, S, p, G, difference;
		int[] ratings;
		int[][] scores;
		
		T=Integer.parseInt(fileIN.readLine());
		for(int c=1; c<T+1; c++){
			G=0;
			Line=fileIN.readLine();
			splitted=Line.split(" ");
			N=Integer.parseInt(splitted[0]);
			S=Integer.parseInt(splitted[1]);
			p=Integer.parseInt(splitted[2]);
			if(S>0)
				difference=2;
			else
				difference=1;
			//maximo1
			int minimmum=p+2*(p-2);
			//maximo1
			ratings = new int[N];
			for(int i=3; i<splitted.length; i++)
				ratings[i-3]=Integer.parseInt(splitted[i]);
			//maximo2
			ratings=changeOrder(ratings, minimmum);
			//maximo2
			scores = new int[N][3];
			for(int n=0; n<N; n++){
				int[] triplet=findTriplet(ratings[n], difference);
				scores[n][0]=triplet[0];
				scores[n][1]=triplet[1];
				scores[n][2]=triplet[2];
				if(scores[n][0]>=p || scores[n][1]>=p || scores[n][2]>=p)
					G++;
				if(findMaximmumDifference(triplet)==2)
					S--;
				if(S==0)
					difference=1;
			}
			String output="Case #"+c+": "+G+"\n";
			fileOUT.write(output);
			System.out.print(output);
			
		}
		fileIN.close();
		fileOUT.close();
	}
	
	private static int[] findTriplet(int rating, int difference){
		int[] triplet = new int[3];
		int r1, r2, r3=r2=r1=10;
		for(; r1>=0; r1--)
			for(r2=r1+difference; r2>=r1-difference; r2--)
				if(r2>=0 && r2<=10)
					for(r3=r1+difference; r3>=r1-difference; r3--)
						if(r3>=0 && r3<=10 && r3<r2+2*difference && r3>r2-2*difference)
							if(r1+r2+r3 == rating){
								triplet[0]=r1;
								triplet[1]=r2;
								triplet[2]=r3;
								r1=r2=r3=-1;
							}
		return triplet;
	}
	
	private static int findMaximmumDifference(int[] triplet){
		int a1=triplet[0]-triplet[1];
		int a2=triplet[0]-triplet[2];
		int a3=triplet[1]-triplet[2];
		if(a1<0)
			a1=-a1;
		if(a2<0)
			a2=-a2;
		if(a3<0)
			a3=-a3;
		if(a1==2 || a2==2 || a3==2)
			return 2;
		else return 1;
	}
	
	private static int[] changeOrder(int[] rating, int minimmum){
		int times=0;
		for(int i=0; i<rating.length;)
			if(rating[i]<minimmum){
				int aux=rating[i];
				for(int j=i;j<rating.length-1; j++)
					rating[j]=rating[j+1];
				rating[rating.length-1]=aux;
				times++;
				if(times==rating.length*rating.length)
					i=rating.length;
			}
			else i++;
		int last=-1, first, lower;
		for(int i=0; i<rating.length; i++)
			if(rating[i]<minimmum){
				last=i;
				i=rating.length;
			}
		if(last==-1)
			last=rating.length;
		for(int i=0; i<last; i++){
			lower=i;
			first=i;
			for(int j=i; j<last; j++)
				if(rating[j]<rating[lower])
					lower=j;
			int aux=rating[first];
			rating[first]=rating[lower];
			rating[lower]=aux;
		}
		return rating;
	}
}
