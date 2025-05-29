import java.util.Scanner;


public class Problem3 {
	public Problem3(){
		Scanner in = new Scanner(System.in);
		int inputs = in.nextInt();
		for(int i=0; i<inputs; i++){
			int A = in.nextInt();
			int B = in.nextInt();
			int pairs = calc(A,B);
			System.out.println("Case #"+(i+1)+": "+pairs);
		}
	}
	
	public int calc(int low, int high){
		int pairs = 0;
		for(int i=low; i<=high; i++){
			for(int j=i+1; j<=high; j++){
				boolean same = true;
				String num1 = ""+i;
				String num2 = ""+j;
				if(num1.length() == num2.length()){
					for(int k=0; k<num1.length(); k++){
						if(!(num2.contains(""+num1.charAt(k)))){
							same = false;
						}
					}
					for(int k=0; k<num2.length(); k++){
						if(!(num1.contains(""+num2.charAt(k)))){
							same = false;
						}
					}
					if(same){
						same = false;
						String prev = "";
						for(int k=num1.length()-1; k>=0; k--){
							String remain = "";
							if(num2.startsWith(prev+num1.charAt(k))){
								same = true;
								prev = prev+num1.charAt(k);
							}
							for(int l=0; l<k; l++){
								remain = remain+num1.charAt(l);
							}
							if(!(num2.contains(remain))){
								same = false;
							}
						}
					}
					if(same==true){
						pairs++;
					}
				}
			}
		}
		return pairs;
	}
	
	public static void main(String[] args){
		new Problem3();
	}
}
