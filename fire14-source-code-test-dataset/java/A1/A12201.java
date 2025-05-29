import java.io.*;
import java.util.*;
 
public class test {

    public static void main(String[] args) throws IOException {
 
        // Location of file to read

	functions aa = new functions();
        File file = new File("input.txt");
	Writer output = new BufferedWriter(new FileWriter("output.txt"));
	int i = 1;
	int answer = 0;
	String A = "";
	String B = "";
	int j = 0;
	int n = 0;
	int N = 0;
	int[] numbers = new int[100];
	int l = 0,p = 0,s=0,k=0;;
        try {
 
            Scanner scanner = new Scanner(file);
 	    N = Integer.parseInt((String)scanner.nextLine());
 	    
            while (scanner.hasNextLine()) {
            	A = "";
            	B = "";
		j = 0;
		l = 0;
		p = 0;
		s = 0;
		n = 0;

                String line = scanner.nextLine();
	        while(line.charAt(j) != ' '){
			A = A + line.charAt(j);
			j++;
	        }
	        n = Integer.parseInt(A);
	        j++;
	        A = "";
                for(k = 1; k <= n+1;k++){
		        while(line.charAt(j) != ' '){
				A = A + line.charAt(j);
				j++;
		        }
		        if(k == 1) s = Integer.parseInt(A);
		        else if(k == 2) p = Integer.parseInt(A);
		        else numbers[l++] = Integer.parseInt(A);
                j++;
                A = "";
                }
                while(j < line.length()){
			B = B + line.charAt(j);
			j++;
                }
                numbers[l++] = Integer.parseInt(B);
		
		answer = aa.solve(numbers,p,s,n);

		if(i < N)
			output.write("Case #" + i +": "+ answer +"\n");
		else
			output.write("Case #" + i +": "+ answer);

		i++;
            }
            scanner.close();
            output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
       }
      }
