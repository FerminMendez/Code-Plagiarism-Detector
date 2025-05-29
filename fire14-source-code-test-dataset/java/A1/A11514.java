//import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class jammo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			Scanner scanner = new Scanner(new File("input.txt"));
			//FileWriter fstream = new FileWriter("output.txt");
			//BufferedWriter out = new BufferedWriter(fstream);
			PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
			int inputSet,partC,surpC,minDM,curTot,noSurp,surpCo,total;
			inputSet = scanner.nextInt();
        
			for(int i=1; i<=inputSet; i++) 
            {	
				partC = scanner.nextInt();
				surpC = scanner.nextInt();
				minDM = scanner.nextInt();
				noSurp = 0;
				surpCo = 0;
                
				for(int j=0; j<partC; j++)
                {
					curTot = scanner.nextInt();
					if(minDM==1 && curTot>=1)
							noSurp++;
					else if(curTot>=3*minDM-2)
						noSurp++;
					else if(curTot>=3*minDM-4)
						surpCo++;
				}
                
				total = noSurp + Math.min(surpC,surpCo);
				out.println("Case #"+i+": "+total);
				System.out.print("Case #"+i+": "+total+"\n");
			}
        
			out.close();
			return;
		}
}
