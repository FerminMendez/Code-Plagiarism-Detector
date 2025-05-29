import java.security.AlgorithmConstraints;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Numbers {

	static int count =0;
	static int max;
	static int surprise;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testCases = Integer.parseInt(sc.nextLine().trim());
		for(int i=1;i<=testCases;i++){
			String line = sc.nextLine();
			StringTokenizer st = new StringTokenizer(line);
			int persons = Integer.parseInt(st.nextToken());
			surprise = Integer.parseInt(st.nextToken());
			max = Integer.parseInt(st.nextToken());
			count =0;
			if(max == 0){
				System.out.println("Case #"+i+": "+persons);
			}else{
				for(int j=0;j<persons;j++){
					algorithm(Integer.parseInt(st.nextToken()));
				}
				System.out.println("Case #"+i+": "+count);
				}
		}

	}
	public static void algorithm(int current){
		if(current ==0){
			return;
		}
		int div = current/3;
		if(current%3==0){
			if(div >=max){
				count++;
			}else if(surprise>0 && (div+1) >=max){
				count++;
				surprise--;
			}
		}else if(current%3==1){
			if((div+1) >=max){
				count++;
			} 
		}else if(current%3==2){
			if((div+1) >=max) count++;
			else if(surprise>0 && (div+2)>=max){
				count++;
				surprise--;
			}
		}
	}

}
