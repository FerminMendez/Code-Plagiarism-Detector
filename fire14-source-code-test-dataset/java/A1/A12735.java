package main;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestClass {

	public static void main (String[] args) throws IOException, InterruptedException {
		BufferedReader reader = new BufferedReader(new FileReader("C:\\in.txt"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\out.txt"));
		MyTest myTest = new MyTest();
		myTest.getTranslation();

		int caseNum = Integer.parseInt(reader.readLine());
		for(int i=0; i<caseNum; i++) {
			String line = reader.readLine();
			String[] numbers = line.split(" ");
			List<Integer> points = new ArrayList<Integer>();

			int N = Integer.parseInt(numbers[0]);
			int S = Integer.parseInt(numbers[1]);
			int p = Integer.parseInt(numbers[2]);

			for(int j=0; j<N; j++) {
				points.add(Integer.parseInt(numbers[3+j]));
			}

			writer.write("Case #" + (i+1) + ": " + myTest.getNumOfGoogler(S, p, points) + "\n");
			points.clear();

			writer.flush();
		}
	}
}
