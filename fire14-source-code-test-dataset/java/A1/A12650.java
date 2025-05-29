import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Dancing {


	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner read = new Scanner(new InputStreamReader(System.in));
		int cases = Integer.parseInt(read.next());
		int counter =1;
		while(cases>0){
			int n = Integer.parseInt(read.next());
			int s = Integer.parseInt(read.next());
			int p = Integer.parseInt(read.next());
			int bests = 0;
			int p2 =0;
			int googler;
			for(int i=0; i<n; i++){
				 googler = Integer.parseInt(read.next());
				 int x = googler/3;
				 if(googler == 1 || googler ==2 || googler == 0 ){
					 if(googler == 1 && 1>=p)
						 bests++;
					 else if(googler == 2){
						 if(1>=p)
							 bests++;
						 else if(2 >= p && p2<s){
							 bests++;
							 p2++;
						 }
					 }else if( googler == 0 && 0>=p)
						 bests++;
				 }else{
					 if((x*3) == googler){
						 if(x>=p)
							 bests++;
						 else if((x+1)>= p && p2<s){
							 bests++;
							 p2++;
						 }
						 
					 }else if((x+x+x+1)== googler){
						 if((x+1) >= p )
							 bests++;
					 }else if((x+x+x+2) == googler){
						 if((x+1)>=p)
							 bests++;
						 else if((x+2)>=p && p2<s){
							 bests++;
							 p2++;
						 }
					 }
				 }
			}
			System.out.println("Case #"+counter+": "+bests);
			cases--;
			counter++;
		}
		

	}

}
