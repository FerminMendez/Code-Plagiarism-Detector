import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class DancingWithGooglers_1B_QualGCJ12 {
	public static void main(String[] args) {
		try{
			BufferedReader br = new BufferedReader(new FileReader("E:\\Code\\Algorithmz\\src\\myFiles\\B-small-attempt0.in"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\Code\\Algorithmz\\src\\myFiles\\B-small-attempt0.out"));
			int T=Integer.parseInt(br.readLine());
			for(int currTest=1;currTest<=T;currTest++){
				String currentTestCase[] = br.readLine().split(" ");
				int N=Integer.parseInt(currentTestCase[0]);
				int S=Integer.parseInt(currentTestCase[1]);
				int p=Integer.parseInt(currentTestCase[2]);
				int possibleCount=0;
				for(int currentDancer=3,totalDancers=currentTestCase.length;currentDancer<totalDancers;currentDancer++){
					int currentTotal=Integer.parseInt(currentTestCase[currentDancer]);
					if(currentTotal<p)
						continue;
					if(currentTotal>=(3*p - 2))
						possibleCount++;
					else if (currentTotal>=(3*p -4) && --S>=0)
						possibleCount++;
				}
				bw.write("Case #"+(currTest)+": " +  possibleCount+"\n");
			}
			bw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.err.println("Done");
	}

}
