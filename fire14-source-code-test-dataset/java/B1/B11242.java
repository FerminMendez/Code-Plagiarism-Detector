import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int count = 0;
		try {
			count = Integer.parseInt(input.readLine());
		} catch (Exception e) {
			System.out.println(e.toString());
			System.exit(1);
		}
		DataModel[] dm = new DataModel[count];
		for(int i = 1; i<=count; i++) {
			try {
				dm[i-1] = new DataModel(input.readLine(),i);
				dm[i-1].run();
			} catch (IOException e) {
				System.out.println(e.toString());
				System.exit(1);
			}
		}
		for(int i = 1; i<=count;i++) {
			while(!dm[i-1].isDone()) {}
			dm[i-1].getOutput();
		}
	}
}
