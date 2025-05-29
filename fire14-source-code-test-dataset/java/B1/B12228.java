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
	
        try {
 
            Scanner scanner = new Scanner(file);
 	    n = Integer.parseInt((String)scanner.nextLine());
 	    
            while (scanner.hasNextLine()) {
            	A = "";
            	B = "";
                String line = scanner.nextLine();
                while(line.charAt(j) != ' '){
			A = A + line.charAt(j);
			j++;
                }
                j++;
                while(j < line.length()){
			B = B + line.charAt(j);
			j++;
                }
		j = 0;
                answer = aa.solve(A,B);
			if(i < n)
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
