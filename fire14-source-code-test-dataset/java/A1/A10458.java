import java.util.Scanner;


public class SolutionDancingWithGooglers {

	static int[] notes;
	static int surprising;
	
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int cases = sc.nextInt();
		
		for(int i = 0; i < cases; i++){
			
			int googlers = sc.nextInt();
			
			surprising = sc.nextInt();
			
			int p = sc.nextInt();
			
			int counter = 0;
			
			for(int j = 0; j < googlers; j++){
				int triplet = sc.nextInt();
				int[] scores = new int[3];
				
				scores[0] = triplet/3;
				triplet = triplet - triplet/3;
				scores[1] = triplet/2;
				triplet = triplet - triplet/2;
				scores[2] = triplet;
				
				counter = counter + verify(scores, surprising, p);
			}
			
			System.out.println("Case #" + (i+1) + ": " + counter);
			
		}
			
			
			
	}
		
	public static int verify(int[] v, int count, int comp){
		//System.out.println("count: "+count);
		if(good(v, comp)){
			 return 1;
		}else if(count != 0  && (v[0] > 0 && v[2] < 10)){
			if(v[0] != v[1] || v[2] != v[1] + 1){
			v = mod(v);
			if(possible(v) && good(v, comp)){ 
				surprising = count - 1;
				return 1;
			}else return 0;
			}else return 0;
		}else return 0;
		
	}
	
	public static boolean good(int[] v, int comp){
		
		for(int i = 0; i < v.length; i++){
			if(v[i] >= comp){ 
				return true;
			}
		}
		return false;
		
	}
	
	public static boolean possible(int[] v){
		
		if(Math.abs(v[0] - v[1]) > 2) return false;
		else if(Math.abs(v[1] - v[2]) > 2) return false;
		else if(Math.abs(v[2] - v[0]) > 2) return false;
		else return true;
		
	}
	
	public static int[] mod(int[] v){
		
		
		if(v[0] == v[1] && v[1] == v[2]){
			v[0] = v[0] - 1;
			v[2] = v[2] + 1;
			
			return v;
		}else{
			v[1] = v[1] - 1;
			v[2] = v[2] + 1;
			return v;
		}
		
	}
	
	

}
