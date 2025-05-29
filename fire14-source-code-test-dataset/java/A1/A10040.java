import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Dance {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("B-small-attempt1.in"));
		FileWriter fw = new FileWriter("dance.txt");
		int k=0;
		int n = Integer.parseInt(sc.nextLine());
		for(int j = 0; j<n; j++){
			k++;
			String ln = sc.nextLine();
			fw.write("Case #"+k+": ");
			String arr[] = ln.split(" ");
			//int num = Integer.parseInt(arr[0]);
			int s = Integer.parseInt(arr[1]);
			int p = Integer.parseInt(arr[2]);
			int count = 0;
			for(int i=3; i<arr.length; i++){
				int t = Integer.parseInt(arr[i]);
				if(t>=p){
					if(Math.max(0, 3*p-2) <= t)
						count++;
					else if (Math.max(0, 3*p-4) <= t && s>0){
						count++;
						s--;
					}
				}
			}
			fw.write(count+"\n");

		}
		sc.close();
		fw.close();
	}

}
