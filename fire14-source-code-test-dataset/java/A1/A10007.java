import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class QB {
	public static int cal(Scanner sc){
		int result = 0;
		
		int N = sc.nextInt();
		int S = sc.nextInt();
		int p = sc.nextInt();
	
		if(p > 1){
			for(int i=0; i<N; i++){
				int t = sc.nextInt();
				if(t >= p*3-2){
					result++;
				} else if(t >= p*3-4 && S > 0){
					S--;
					result++;
				}
			}
		} else if(p == 1){
			for(int i=0; i<N; i++){
				int t = sc.nextInt();
				if(t != 0){
					result++;
				}
			}
		} else if(p == 0){
			for(int i=0; i<N; i++){
				int t = sc.nextInt();
				result++;
			}
		}
		
		return result;
	}
	public static void main ( String [] args ) throws IOException
	{
		Scanner sc = new Scanner(new File("B-small-attempt0.in"));
		Path file = FileSystems.getDefault().getPath(".", "B-small-practice.out");
		BufferedWriter writer = Files.newBufferedWriter(file, StandardCharsets.US_ASCII, StandardOpenOption.CREATE);
		
		int t = sc.nextInt();
		for(int i=0; i<t; i++){
			String output = String.format("Case #%d: %d\n", i+1, cal(sc));
			writer.write(output);
		}
		sc.close();
		
		writer.flush();
		writer.close();
	}
}