package y2012.Qualification;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DancingWithGooglers extends IOStream {

	List<Triplet> completeEntries = new ArrayList<Triplet>();
	List<Triplet> aboveList = new ArrayList<Triplet>();
	List<Triplet> belowList = new ArrayList<Triplet>();
	List<Triplet> considerableList = new ArrayList<Triplet>();
	static int P_bestResult = 0;
	int N = 0;
	int surprisingTriplets = 0;

	public DancingWithGooglers(String fileName) {
		super(fileName);
	}

	private int runThisTestCase() throws IOException {

		completeEntries = new ArrayList<Triplet>();
		aboveList = new ArrayList<Triplet>();
		belowList = new ArrayList<Triplet>();
		considerableList = new ArrayList<Triplet>();

		int[] intValues = splitString2Int(bufferedReader.readLine().trim().split(" "));
		N = intValues[0];
		surprisingTriplets = intValues[1];
		P_bestResult = intValues[2];
		createTriplets(intValues);
		int max = (surprisingTriplets > considerableList.size()) ? considerableList.size() : surprisingTriplets;
		System.out.println(aboveList.size() + max );

		return aboveList.size() + max;
	}



	private void createTriplets(int[] intValues) {

		for(int i=3; i<intValues.length; i++){
			Triplet triplet = new Triplet(intValues[i]);
			completeEntries.add(triplet);
			distingushTriplet(triplet);
		}

	}

	private void distingushTriplet(Triplet triplet) {
		int sum = triplet.getSum();
		int normalMax = sum/3 + ((sum%3 == 0)? 0 : 1);
		int atMax = sum/3 + ((sum%3 == 2)? 2 : 1);
		if(sum == 0){
			normalMax = atMax = 0;
		}
		if(P_bestResult <= normalMax)
			aboveList.add(triplet);
		else if(P_bestResult > atMax)
			belowList.add(triplet);
		else
			considerableList.add(triplet);
	}

	public static void main(String[] args) {

		DancingWithGooglers obj = new DancingWithGooglers("/net/10.0.0.60/Users/454083/Desktop/Moshin/CodeJam/DancingGooglers");
		try {
			obj.getReader();
			obj.getWriter();
			int testcases = Integer.parseInt(bufferedReader.readLine().trim());
			for(int testcase=1; testcase<=testcases; testcase++){
				int value = obj.runThisTestCase();
				System.out.println("Case #" + testcase + ": " + value);
				bufferedWriter.write("Case #" + testcase + ": " + value + "\n");
			}
			obj.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}




}

class Triplet {
	int sum = 0;
	int reminder = 0;
	boolean suprise = false;
	int maxScore = 0;

	public Triplet(int sum) {
		this.sum = sum;
		if ((reminder = sum % 3) == 1)
			maxScore = (int) (sum / 3) + 1;
	}

	public boolean isSuprise() {
		return suprise;
	}

	public void setSuprise(boolean suprise) {
		this.suprise = suprise;
	}

	public int getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}

	public int getSum() {
		return sum;
	}

	public int getReminder() {
		return reminder;
	}

}

class IOStream {

	static public BufferedReader bufferedReader = null;
	static public BufferedWriter bufferedWriter = null;

	String fileName = "";

	public IOStream(String fileName) {
		this.fileName = fileName;
	}

	protected void getReader() throws IOException {
		bufferedReader = new BufferedReader(new FileReader(new File(fileName + ".in")));
	}

	protected void getWriter() throws IOException {
		bufferedWriter = new BufferedWriter(new FileWriter(new File(fileName + ".out")));
	}

	protected void close() throws IOException {
		if (bufferedReader != null)
			bufferedReader.close();
		if (bufferedWriter != null) {
			bufferedWriter.flush();
			bufferedWriter.close();
		}
	}
	
	protected int[] splitString2Int(String[] words){
		int[] ints = new int[words.length];
		int i=0;
		for(String str: words){
			ints[i] = Integer.parseInt(str);
			i++;
		}
			
		return ints;
	}
}
