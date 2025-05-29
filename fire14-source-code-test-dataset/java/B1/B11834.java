import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;


public class Solution {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
	    int T = scan.nextInt();
	    int[] counts = new int[T];
	    int max =2000001;
	    boolean[] used = new boolean[max];
	    for(int i=0;i<T;i++){
	    	int A = scan.nextInt();
	    	int B = scan.nextInt();
	    	counts[i]=count(A,B,used);	    	
	    }	
	    
	    for(int i=0;i<T;i++){
			System.out.println("Case #"+(i+1)+": "+counts[i]);
		}
	}
	
	public static int count(int A,int B,boolean[] used){
		int result=0;
		
		int num=0;
		int temp=A;
		
		int total=1;
		
		while(temp>0){
			temp=temp/10;
			num++;
			total*=10;
		}
		
		
		HashSet<Integer> set = new HashSet<Integer>();
		int rotato=0;
		int size =0;
		for(int i=A;i<=B;i++){
			if(!used[i]){
				set.clear();
				set.add(i);
				temp=i;
				int exp =1;
				
				for(int j=1;j<num;j++){
					exp*=10;
					rotato = (i%exp)*(total/exp)+i/exp;
				
					if(rotato>=A && rotato<=B){
						set.add(rotato);
						used[rotato]=true;
					}					
				}
				//System.out.println(size);
				size = set.size();
				if(size>1){
					result+=size*(size-1)/2;
				}				
			}
		}
		Arrays.fill(used, A,B,false);
		
		return result;
		
	}	
	
}
