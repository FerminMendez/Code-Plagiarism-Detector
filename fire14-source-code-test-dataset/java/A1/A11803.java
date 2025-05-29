package qualification_round;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class A_sl_Dansing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner inp = new Scanner(new FileInputStream("A_s_input.txt"));
			int i=0,j=0,k=0,tc=0;
			int T = inp.nextInt();
			inp.nextLine();
			for(tc=0;tc<T;tc++){
				int N = inp.nextInt();
				int S = inp.nextInt();
				int P = inp.nextInt();
				int arr[] = new int[N];
				
				for(i=0;i<N;i++){
					arr[i] = inp.nextInt();
				}
				
				inp.nextLine();
				
				int arr1[] = new int[N];
				int arr2[] = new int[N];
				
				for(i=0;i<N;i++){
					arr1[i] = arr[i]/3;
					arr2[i] = arr[i] % 3;
				}
				
				int result = 0;
				for(i=0;i<N;i++){
					if(arr2[i] == 0){
						if(arr1[i] >= P){
							result++;
						}
						else if(arr1[i]+1 == P && arr1[i] != 0 && S>0){
							S--;
							result++;
						}
					}
					else if(arr2[i] == 1 && arr1[i]+1 >= P){
						result++;
					}
					else if(arr2[i] == 2){
						if(arr1[i]+1 >= P){
							result++;
						}
						else if(arr1[i]+2 == P && S>0){
							result++;
							S--;
						}
					}
				}
				
				k=tc+1;
				System.out.println("Case #" + k +": "+result);
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
