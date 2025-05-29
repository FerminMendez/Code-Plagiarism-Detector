import java.util.Scanner;

public class Googlers {
	public static void main(String a[]){
		Scanner in = new Scanner(System.in);
		final int T = in.nextInt();
		int[] n = new int[T];
		
		int N, S, P, sum;
		for(int i = 0; i < T; i++){
			N = in.nextInt();
			S = in.nextInt();
			P = in.nextInt();
			
			for(int j = 0; j < N; j++){
				sum = in.nextInt();
				//System.out.println(sum);
				//System.out.println("S " + sum + " P " + P);
				/*
				if(sum <= P){
					n[i]+= 0;
					//System.out.println(sum + "cero");
				}*/
				//else {
					//System.out.println("aasdfas");
					//int resta = sum - P;
					if(sum == 0 &&  P == 0){
						n[i]++;
					}
					else if(sum == 0 && P > 0){
						n[i]+=0;
					}
					else if(sum >= (P + (P-1) + P)){
						//System.out.println("aasdf");
						//System.out.println("1");
						n[i]++;
					}
					else if(sum >= P + P + P){
						n[i]++;
						//System.out.println("2");
					}
					else if(sum >= P + 1 + P + 1 + P + 1){
						n[i]++;
						//System.out.println("3");
					}
					else if(sum >= P + 2 + P + 2 + P + 2){
						n[i]++;
						//System.out.println("4");
					}
					else if(sum >= (P-1) + (P-1) + P){
						n[i]++;
						//System.out.println("5");
					}
					else if(sum >= (P+1) + (P+1) + P){
						n[i]++;
						//System.out.println("6");
					}
					else if(sum >= (P+1) + P + P){
						n[i]++;
						//System.out.println("7");
					}
					else if((sum >= (P+1) + (P-1) + P) && S > 0){
						n[i]++;
						S--;
						//System.out.println("8");
					}
					else if((sum >= (P + (P-1) + (P-2))) && S > 0){
						n[i]++;
						S--;
						//System.out.println("9");
					}
					else if((sum >= (P + (P-2) + (P-2))) && S > 0){
						n[i]++;
						S--;
						//System.out.println("10");
					}
					else if((sum >= (P + (P+1) + (P-1))) && S > 0){
						n[i]++;
						S--;
						//System.out.println("11");
					}
					else if((sum >= (P + (P+2) + (P+2))) && S > 0){
						n[i]++;
						S--;
						//System.out.println("12");
					}
					else if((sum >= (P + (P+2) + P)) && S > 0){
						n[i]++;
						S--;
						//System.out.println("13");
					}
					else if((sum >= (P + (P+1) + (P+2))) && S > 0){
						n[i]++;
						S--;
						//System.out.println("14");
					}
					
					/*
					else if(Math.abs((resta / 2) -  P) == 2){
						if(S > 0){
							S--;
							n[i]++;
							//System.out.println("s");
						}
					}
					else if((resta / 2) - P == 0 || Math.abs(resta / 2 - P) ==1){
						n[i]++;
						//System.out.println("parejo");
					}*/
				}
			}
		//}
		for(int i = 0; i < T; i++){
			System.out.println("Case #" + (i+1) + ": " + n[i]);
		}
	}
}
