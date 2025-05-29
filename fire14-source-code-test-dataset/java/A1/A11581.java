package dancewithgooglers;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	private static final String OUTPUT_TEMPLATE = "Case #";

	
	
	public static void main(String[] args) {

		if (args.length < 1) {
			System.out.println("feed me a parameter");
			return;
		}
		try {
			// Open the file that is the first
			// command line parameter
			FileInputStream fstream = new FileInputStream(args[0]);
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			// Read File Line By Line
			strLine = br.readLine();
			StringBuilder sb = new StringBuilder();
			int case_no = 1;
			while ((strLine = br.readLine()) != null) {
				String[] raw_data = strLine.split(" ");
				int googlers_number = Integer.parseInt(raw_data[0]);
				int surprise_number = Integer.parseInt(raw_data[1]);
				int cutoff_point = Integer.parseInt(raw_data[2]);
				int[] total_points = new int[googlers_number];
				for(int temp = 0; temp<total_points.length;temp++){
					total_points[temp] = Integer.parseInt(raw_data[temp+3]);
				}
				Arrays.sort(total_points);
				
				int count = 0;
				int comfort_cutoff = (cutoff_point*3)-2;
				int special_cutoff = comfort_cutoff-2;
				
				if(comfort_cutoff<0)// happen when expect 0 to be max (all)
					comfort_cutoff = 0;
				
				
				
				for(int i = total_points.length-1;i>-1;i--){
					
					if(total_points[i]>=comfort_cutoff){
						count++;
					}
					else if(total_points[i]>=special_cutoff){
						if(special_cutoff == -1 && total_points[i]==0)
							break;
						else if(surprise_number>0){
							count++;
							surprise_number--;
						}
						else
							break;
					}
				}
				sb.append(OUTPUT_TEMPLATE).append(case_no++).append(": ").append(count).append("\n");
				count = 0;
			}
			// Close the input stream
			System.out.println(sb.toString());
			in.close();
			
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}


}
