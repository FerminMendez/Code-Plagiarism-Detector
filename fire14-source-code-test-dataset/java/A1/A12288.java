import java.io.*;

public class Dance {
	public static void main(String[] args) {
		try {
			InputStreamReader inReader = new InputStreamReader(new FileInputStream("input.txt"));
			BufferedReader br = new BufferedReader(inReader);
			
			File out = new File("output.txt");
			Writer output = new BufferedWriter(new FileWriter(out));
			
			int amount = Integer.parseInt(br.readLine());
			
			for (int i=0; i < amount; i++) {
				output.write("Case #" + (i+1) + ": ");
				String line = br.readLine();
				String[] values = line.split(" ");
				
				int dancers		= Integer.parseInt(values[0]);
				int surprise	= Integer.parseInt(values[1]);
				int minPoints	= Integer.parseInt(values[2]);
				
				int minResultSur 	= (minPoints-2)*2 + minPoints;
				int minResult		= (minPoints-1)*2 + minPoints;
				int endResult		= 0;
				
				minResultSur = (minResultSur < 0) ? minPoints : minResultSur;
				minResult	 = (minResult < 0) ? minPoints : minResult;
				
				for (int j=0; j < dancers; j++) {
					int tmpResult = Integer.parseInt(values[3+j]);
					if (tmpResult >= minResult)
						endResult++;
					else if (tmpResult >= minResultSur && surprise > 0) {
						surprise--;
						endResult++;
					}
				}
				
				output.write(endResult + "\n");
			}
			
			output.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}