import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class B {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new FileReader(args[0]));
		BufferedWriter bw= new BufferedWriter(new FileWriter(args[0]+".out"));
		String line= br.readLine();
		int cases= Integer.parseInt(line);
		for (int i= 0; i != cases; i++) {
			line= br.readLine();
			Scanner sc= new Scanner(line);
			List<Integer> list= new ArrayList<Integer>();
			while (sc.hasNextInt()) {
				int a= sc.nextInt();
				list.add(a);
			}
			int[] params= new int[list.size()];
			for (int j= 0; j != params.length; j++) {
				params[j]= list.get(j).intValue();
			}
			bw.write("Case #"+(i+1)+": "+max(params)+"\n");
		}
		br.close();
		bw.close();
	}
	
	public static int max(int[] params) {
		int n= params[0];
		int s= params[1];
		int p= params[2];
		
		int normal= 0;
		int surprising= 0;
		
		for (int i= 0; i != n; i++) {
			if ((params[3+i]+2)/3 >= p) normal++;
			else if ((params[3+i]+4)/3 >= p && params[3+i] >= 2) surprising++;
		}
		
		System.out.println(n+" "+s+" "+p);
		System.out.println(normal+" "+surprising);
		
		return normal + Math.min(surprising, s);
	}

}
