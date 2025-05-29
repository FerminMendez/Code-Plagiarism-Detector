package codejam.qualification;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Dancing {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		String file = "input2small";
		Scanner in = new Scanner(new File(file));
		int tot = Integer.parseInt(in.nextLine());
//		System.out.println(tot);
		for(int i=0;i<tot;i++) {
			String line = in.nextLine();
			String[] data = line.split(" ");
			int N = Integer.parseInt(data[0]);
			int S = Integer.parseInt(data[1]);
			int p = Integer.parseInt(data[2]);
			
			int output = 0;
			switch(p) {
			case 0:
				output = N;
				break;
			case 1:
				for(int j=0; j<N; j++) {
					int t = Integer.parseInt(data[3+j]);
					if(t > 0) output++;
				}
				break;
			default:
				int temp = 0;
				for(int j=0; j<N; j++) {
					int t = Integer.parseInt(data[3+j]);
					if(t >= 3*p-2)
						output++;
					else
						if(t >= 3*p-4)
							temp++;
				}
				if(temp <= S)
					output += temp;
				else
					output += S;
			}
			
			System.out.println("Case #"+(i+1)+": "+output);
		}
		
	}

}
