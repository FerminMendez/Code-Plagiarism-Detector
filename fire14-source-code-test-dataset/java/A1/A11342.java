import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class DancingGooglers {
	
	
	
	public DancingGooglers() {
		
		Integer maxInputs;
		String line;
		Integer output;
		Integer N, S, p;	
		try {
			BufferedReader read = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("input")));
			BufferedWriter write = new BufferedWriter(new FileWriter("output"));
			maxInputs = new Integer(read.readLine());
			for(int i = 1 ; i <= maxInputs ; i++)
			{
				int success = 0, surprise = 0;
				line = read.readLine();
				String[] numbers = line.split(" ");
				N = new Integer(numbers[0]);
				S = new Integer(numbers[1]);
				p = new Integer(numbers[2]);
				
				for( int j = 3; j < N+3; j++)
				{
					//Do calculations for each number
					Integer t = new Integer(numbers[j]);
					switch(check(t,p))
					{
					case 0:
						success++;
						break;
					case 1:
						if(surprise < S)
						{
							surprise++;
							success++;
						}
						break;
					}
				}
				
				output = new Integer(success);
				write.write("Case #"+i+": ");
				write.write(output.toString());
				write.write("\n");
			}
			write.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		long startTime = System.nanoTime();
		new DancingGooglers();
		long endTime = System.nanoTime();;
		System.out.println("Took "+(endTime - startTime) + " ns");
	}
	
	int check(int t, int p)
	{
		if(p == 0)
			return 0;
		int minNorm = 3*p - 2;
		int minVal = 3*p - 4;
		if(minVal < 0)
			minVal = 1;
		if( t >= minNorm)
			return 0;
		if( t < minVal )
			return 2;
		return 1;
	}

}
