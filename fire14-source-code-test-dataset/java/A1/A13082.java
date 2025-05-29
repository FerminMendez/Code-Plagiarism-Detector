import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Dance {
	public static void main(String[] args) throws FileNotFoundException{
		
		Scanner scan = new Scanner (new File("C:\\Users\\kffong\\Desktop\\JAVA_workspace\\DanceGoogler\\input.txt"));
	//	Scanner scan = new Scanner(new File("C:\\Users\\kffong\\Desktop\\JAVA_workspace\\DanceGoogler\\input.txt"));
	//	System.out.print(scan.nextLine());
		int numberOfCase = scan.nextInt();
		scan.nextLine();
		
		for(int k=0 ; k<numberOfCase; k++){
			int N = scan.nextInt();
			int surprise = scan.nextInt();
			int p = scan.nextInt();
			int total[] = new int[N];
			int result = 0;
			int possibleIncrease = 0;
			
			for ( int i = 0 ; i < N ; i++){
				total[i]=scan.nextInt();
			}

			
			
			
			for(int i = 0 ; i<N ; i++){
				int best;
				if (total[i]%3==0){
					best=total[i]/3;
				}
				else{
					best=total[i]/3 + 1;
				}
				
				
				if(best>=p){
					result++;
				}
				else if(best==p-1 && total[i]%3!=1 &&total[i]!=0){
					possibleIncrease++;
				}
			
			}
		//	System.out.println("possibleIncrease="+possibleIncrease+" ;result="+result);
			
			
			if (possibleIncrease<=surprise){
				result = result+possibleIncrease;
			}
			else{
				result = result+surprise;
			}
			System.out.println("Case #"+(k+1)+": "+result);
			
			
			//System.out.println("====================");
			
			if(scan.hasNextLine()){
				scan.nextLine();
			}
			
		}

	}
}
