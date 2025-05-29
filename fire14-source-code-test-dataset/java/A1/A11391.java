import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;


/*
 * constraints 
 * input: 
 * testcases 1<= T <= 100
 * surprising triplets 0<=S<=N
 * desired at least result p 0<=p<=10
 * total points for each googler 0<=ti<= 30
 * 
 * small 
 * N is between 1 and 3
 * large
 * N is between 1 and 100
 */
public class DancingScores {

	public int numTestCases = -1;
	public ArrayList<Googler> contestants=null;
	public int numGooglers = -1;
	public int surpriseTrips = -1;
	public int p=-1;
	public  ArrayList<Googler> answer;
	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		 StopWatch s = new StopWatch();
		 s.start();
		 
		 DancingScores ds = new DancingScores();
		 ds.parse("B-small-attempt4.in");
//		 ds.parse("data.txt");

		 s.stop();
	     System.out.println("elapsed time in milliseconds: " + s.getElapsedTime());

	}
	
	public void parse(String filename) throws IOException{
		FileReader inputStream = null;
		FileWriter outputStream = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		try{
			inputStream = new FileReader(filename);
			outputStream = new FileWriter("result.txt");
			br = new BufferedReader(inputStream);
			pw = new PrintWriter(outputStream);
			numTestCases = Integer.parseInt(br.readLine());			
			
			for(int i=1;i<=numTestCases;i++){
				String inputLine = br.readLine();
				pw.println("Case #"+i+": "+solve(inputLine));
//				pw.println(inputLine);
//				
//				for(Googler g: contestants){
//					pw.print(g.score1>=p);
//					pw.print(" ");
//					pw.print(g);
//				}
//				
//				pw.println();
			}
		}
		finally{
			if(inputStream != null){
				inputStream.close();
			}
			if(outputStream != null){
				outputStream.close();
			}
		}
	}
	
	public int solve(String inputLine){
		String[] tokens = inputLine.split("[ ]+");
		
		numGooglers = Integer.parseInt(tokens[0]);
		surpriseTrips = Integer.parseInt(tokens[1]);
		p = Integer.parseInt(tokens[2]);
		contestants = new ArrayList<Googler>(numGooglers);
		
		for(int j=3;j<tokens.length;j++){
			Googler goog = new Googler(j-3,Integer.parseInt(tokens[j]));
			contestants.add(goog);
			System.out.println();
		}
		
//		for(Googler goog:contestants){
//			if(goog.checkState())
//				System.out.println("true");
//			else
//				System.out.println("false");
//		}
		
		
//		for(String token:tokens){
//			i++;
//			//System.out.println("token is "+token);
//		}
		
		//System.out.println("stop "+i+" tokens");
		
		ArrayList<Googler> pass = new ArrayList<Googler>();
		PriorityQueue<Googler> fail = new PriorityQueue<Googler>();
		
		//separate those that already pass
		for(Googler person: contestants){
			if(person.passes(p))
				pass.add(person);
			else
				fail.offer(person);
		}
		
		//sort failed based on their best result (want highest to add)
		//use remaining surprises to try and make them match
			System.out.println(surpriseTrips);
			while(fail.peek()!=null && surpriseTrips>0){
				Googler next = fail.peek();
				next.modify();
				if(next.passes(p)){
						pass.add(next);
						
				}
				surpriseTrips--;
				fail.remove();					
			}
			
//		for(Googler goog: pass){
//			//System.out.println(goog);
//		}
//		for(Googler goog:contestants){
//			if(goog.checkState())
//				System.out.println("true");
//			else
//				System.out.println("false");
//		}
//		answer = pass;
		return pass.size();
	}

}
