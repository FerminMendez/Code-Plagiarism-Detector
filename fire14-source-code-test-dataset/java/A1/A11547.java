import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class dancers {
	


	
	public static void main(String[] args) throws FileNotFoundException {
		
        File myFile = new File ("E:/GoogleIn.txt");
        Scanner inFile = new Scanner (myFile);
        PrintWriter outputStream = null;
        outputStream = new PrintWriter("E:/GoogleOut.txt");

		String line = inFile.nextLine();
		System.out.println("line "+line);
		int cases = Integer.parseInt(line);
		System.out.println("cases "+cases);
		for (int t=0; t < cases; t++){

			int numdancing = inFile.nextInt();
			System.out.println("numdancing "+numdancing);
			int outlier = inFile.nextInt();
			System.out.println("outlier "+outlier);
			int p = inFile.nextInt();
			System.out.println("p "+p);
			int p3 = p*3;
			int cnt =0;
			int totalScores[] = new int[numdancing];
			for (int index = 0; index < numdancing; index++){
				totalScores[index] = inFile.nextInt();
			}
			for ( int i = 0; i < numdancing; i++){
				if(p ==0){
					cnt++;
					continue;
				}else if(p ==1){
					if (totalScores[i]>0)
						cnt++;
					continue;
						
				}
				
				if (totalScores[i]>= p3-2){
					cnt++;
				}
				else if(totalScores[i]>= p3-4){
					if (outlier>0){
						outlier--;
						cnt++;
					}
				}
				
			}
	        outputStream.println("Case #"+(t+1)+": "+cnt);
		}
		outputStream.flush();
	}

}
