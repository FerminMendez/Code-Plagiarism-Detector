import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Numbers {
	
	private static int [][] input;
	private static int [] output;
	
	public static void main(String [] args) throws NumberFormatException, IOException{
		
		readData();
		output = new int [input.length];
		
		for (int i=0 ; i< input.length ; i++){
			output[i] = numberOfPairs(input[i][0], input[i][1]);
		}
		
		writeData();
	}

	public static int numberOfPairs(int a, int b){
		int r=0;
		for (int i=a ; i<=b;i++ ){
			int f = flip(i);
			if ( i<f && a<=f && f<=b ){
				r++;
				}
			if (i>100){
				int f2 = flip2(i);
				if (( i<f2 && a<=f2 && f2<=b )){
					r++;
				}
			}
			
		}
		return r;
		
	}
	
	public static int flip(int i){
		
		String A = Integer.toString( i );
		String ans = A.substring( 1)+ A.substring( 0, 1 );
		return Integer.parseInt( ans );
	
	}
	public static int flip2(int i){
	
	String A = Integer.toString( i );
	String ans = A.substring( 2)+ A.substring( 0, 2 );
	return Integer.parseInt( ans );

	}
	
	public static void readData() throws NumberFormatException, IOException{
		FileReader fr = new FileReader("Input.txt");
		BufferedReader br = new BufferedReader(fr);
		int numberOfInputs = Integer.parseInt( br.readLine() );
		input = new int [numberOfInputs][2];
		for (int i = 0; i<numberOfInputs ; i++  ){
			String [] numbers = ((String)(br.readLine())).split( " " );   
			for (int j = 0 ; j<2 ;j++){
				input [i][j] =  Integer.parseInt(numbers [j]);
			}
		}
		br.close();
	}
	
	public static void writeData() throws IOException{
		FileWriter fw = new FileWriter("Output.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		for (int i = 0; i< output.length ; i++ ){
			String out = "Case #" +(i+1) +": "+ output[i];
			bw.write( out );
			bw.newLine();
		}
		bw.close();
	}
}
