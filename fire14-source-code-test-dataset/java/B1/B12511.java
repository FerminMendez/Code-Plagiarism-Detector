import java.util.Scanner;


public class ProblemC {
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		int noTestCases = Integer.parseInt(scanner.nextLine());
		
		for(int i=0;i<noTestCases;i++){
			String inputString = scanner.nextLine();
			String[] temp;
			temp = inputString.split(" ");
			int A = Integer.parseInt(temp[0]);
			int B = Integer.parseInt(temp[1]);
			
			int count = 0;
			for(int n=A;n<B;n++){
				for(int m=n+1;m<=B;m++){
					//System.out.println("n="+n +"m="+m);
					String N = Integer.toString(n);
					String M = Integer.toString(m);
					StringBuffer NN = new StringBuffer(N);
					NN = NN.append(N);
					N = NN.toString();
					if(N.contains(M)){
						count++;
					}
					
				}
			}
			System.out.println("Case #"+(i+1)+": "+count);
			
		}
	}
}
