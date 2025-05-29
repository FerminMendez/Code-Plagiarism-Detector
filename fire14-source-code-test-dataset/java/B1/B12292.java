import java.io.*;
import java.util.Scanner;

public class C {

public static void main(String[] args) throws FileNotFoundException, IOException {
     Scanner sc = new Scanner(new FileReader("input.txt"));
     PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));

        int noOfCases = sc.nextInt();

for (int caseNum = 0; caseNum < noOfCases; caseNum++){
	int A = sc.nextInt();
	int B = sc.nextInt();
	int result =0;
	
	if(A<10){
     pw.print("Case #" + (caseNum + 1) + ": 0");
	}
	else if(A<100){
		for (int i = A; i <= B; i++) {
			if(A<=shift2(i) && shift2(i)<=B  && i != shift2(i)){
				result++;
			}
		}
		pw.print("Case #" + (caseNum + 1) + ": "+ result/2);
	}
	else if(A<1000){
		for (int i = A; i <= B; i++) {
			if(A<=shift3(i) && shift3(i)<=B && i != shift3(i)){
				result++;
			}
		}
		pw.print("Case #" + (caseNum + 1) + ": "+ result);
	}
	
	if(caseNum < noOfCases-1)
     	pw.println("");
}
     

     pw.flush();
     pw.close();
     sc.close();
}

public static int shift3(int number){
	int r = number % 10;
	number = number/10;
	number = number + r*100;
	return number;	
}

public static int shift2(int number){
	int r = number % 10;
	number = number/10;
	number = number + r*10;
	return number;	
}
}
