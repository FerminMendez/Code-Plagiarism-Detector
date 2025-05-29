import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;


public class QuestionB {

	//final static String FNAME = "C:\\CodeJam\\GoogleDancers";
	final static String FNAME = "C:\\CodeJam\\B-small-attempt0";
	//final static String FNAME = "C:\\CodeJam\\A-large-practice";
    public static Scanner in;
    public static PrintWriter out;
    
    public static List<Integer> listA = new ArrayList<Integer>(3);
    public static List<Integer> listB = new ArrayList<Integer>(3);

    static void open() throws IOException {
        Locale.setDefault( Locale.US );
        in = new Scanner( new File( FNAME + ".in" ) );
        out = new PrintWriter( new File( FNAME + ".out" ) );
    }

    static void close() throws IOException {
        out.close();
    }

    static class Triplet implements Comparable<Triplet>{
    	
    	int a, b, c;   	
    	
    	public Triplet(int a, int b, int c){
    		this.a = a;
    		this.b = b;
    		this.c = c;
    	}
    	public int getBestScore(){
    		int best = 0;
    		if(a >= b && a >= c)
    			best = a;
    		else if(b >= a && b >= c)
    			best = b;
    		else if(c >= a && c >= b)
    			best = c;
    		return best;
    	}
    	
    	public boolean isBest(int bestVal){
    		if(getBestScore()>=bestVal)
    			return true;
    		return false;
    	}
    	
    	public boolean isSuprise(){
    		int difAB = this.a - this.b;
    		int difBC = this.b - this.c;
    		int difAC = this.a - this.c;
    		if ( (Math.abs(difAB)==2) || 
    				(Math.abs(difBC)==2) || 
    				(Math.abs(difAC)==2) )
    			return true;
    		return false;
    	}
    	
		@Override
		public int compareTo(Triplet arg0) {
			if(this.equals(arg0))
				return 0;
			return 1;
		}
		
		@Override
		public int hashCode(){
			return a + b + c;
		}
    	
		@Override
		public boolean equals(Object obj){
			listA.clear();
			listB.clear();
			listA.add(this.a);listA.add(this.b);listA.add(this.c);
			Triplet t = (Triplet)obj;
			listB.add(t.a);listB.add(t.b);listB.add(t.c);
			Collections.sort(listA);
			Collections.sort(listB);
			if(listA.get(0).equals(listB.get(0)) && 
					listA.get(1).equals(listB.get(1)) && 
					listA.get(2).equals(listB.get(2)))
				return true;
			return false;
		}
    	
    }
    
	public static void main(String[] args)throws IOException {
		open();
        int T = in.nextInt();//Number of test cases
        
        /*    -------- Main code ----------  */
        List<Integer> scores = new ArrayList<Integer>();
        List<List<Triplet>> tripletGridList = new ArrayList<List<Triplet>>();
        int[] digit1 = new int[3];
        int[] digit3 = new int[3];
        int[] digit2 = new int[3];
        for(int i = 0 ; i < T ; i++){
        	//Read Data
        	int numberOfGooglers = in.nextInt();
        	int surprises = in.nextInt();
        	final int minBestScore = in.nextInt();
        	scores.clear();
        	for(int j = 0 ; j<numberOfGooglers ; j++){
        		scores.add(in.nextInt());
        	}
        	
        	//Process
        	tripletGridList.clear();
        	int possibleSurpriseCount = 0;
        	for(Integer score : scores){
        		Set<Triplet> set = new HashSet<Triplet>();
        		//generate triplets
        		for(int a = 0, b = 1, c = 2 ; c <=10 ; a++, b++, c++){
        			if(c*3 < score)
        				continue;
        			digit1[0]=a;digit1[1]=b;digit1[2]=c;
        			digit2[0]=a;digit2[1]=b;digit2[2]=c;
        			digit3[0]=a;digit3[1]=b;digit3[2]=c;
        			for(int m : digit1){
        				for(int n : digit2){
        					for(int o : digit3){
        						if(m+n+o == score){
        							Triplet t =new Triplet(m,n,o); 
        							if(set.add(t)){
        								if(t.isSuprise())
        		        					possibleSurpriseCount++;
        		        				//if(t.getBestScore() >= minBestScore)
        		        					//possibleBestScores++;
        		        				//System.out.println(t.a + ":" + t.b + ":" + t.c);
        							}
        						}
        					}
        				}
        			}
        		}
        		//triplet generation done
        		//Convert Set to list and sort list with triplets that are best and surprising appearing first
        		ArrayList<Triplet> tList = new ArrayList<QuestionB.Triplet>(set);
        		/*Collections.sort(tList, new Comparator<Triplet>(){

					@Override
					public int compare(Triplet t1, Triplet t2) {
						if(t1.isBest(minBestScore) && t1.isSuprise())
							return -1;
						else if(t2.isBest(minBestScore) && t2.isSuprise())
							return -1;
						else if (t1.isBest(minBestScore))
							return -1;
						else if (t2.isBest(minBestScore))
							return -1;
						else if (t1.isSuprise())
							return -1;
						else if (t2.isSuprise())
							return -1;
						return 1;
					}	
        			
        		});*/
        		tripletGridList.add(tList);
        		//System.out.println("Set contents for Score :: "+ score);=        	
        	}
        	//System.out.println("Possible number of surprises : "+ possibleSurpriseCount);
        	//System.out.println("Possible number of ALL BEstScores : "+ possibleBestScores);
        	
        	        	
        	Collections.sort(tripletGridList, new Comparator<List<Triplet>>(){
				@Override
				public int compare(List<Triplet> set1, List<Triplet> set2) {
					if(set1.size() > set2.size())
						return -1;
					else if(set1.size() < set2.size())
						return 1;
					else 
						return 0;
				}
        		
        	});
        	
        	
        	if(possibleSurpriseCount == surprises){
        		int maxPosGooglers = 0;
        		for(List<Triplet> list : tripletGridList){        			
        			for(Triplet t : list){
        				if(t.isBest(minBestScore)){
        					maxPosGooglers++;
        					break;
        				}
        			}
        		}
        		//System.out.println("Case #" + (i+1) + ": "+maxPosGooglers);
        		out.println("Case #" + (i+1) + ": "+maxPosGooglers);
        	}else{        		
        		int maxPosGooglers = generateGroups(tripletGridList,0, new ArrayList<Triplet>(), minBestScore, surprises );
        		//System.out.println("Case #" + (i+1) + ": "+maxPosGooglers);
        		out.println("Case #" + (i+1) + ": "+maxPosGooglers);
        	}
        	
        	
        		
        	
        	       	
        	
        	
	    	//Print to file	
        	//System.out.println( "Case #" + (i+1) + ": "+count);
	        //out.println( "Case #" + (i+1) + ": "+"");	
        }
        
        close();

	}
	
	public static int generateGroups(List<List<Triplet>> tripletGridList, int gridIndexToProcess, List<Triplet> group, int minBestScore, int surprises){
		if(gridIndexToProcess > tripletGridList.size()-1){
			int groupSurprises = 0;
			int bestScores = 0;
			for(Triplet t : group){
				if(t.isBest(minBestScore))
					bestScores++;
				if(t.isSuprise())
					groupSurprises++;
			}
			if(groupSurprises!=surprises)
				return 0;
			else
				return bestScores;
		}
			
		List<Triplet> tlist = tripletGridList.get(gridIndexToProcess);
		int max = 0;
		for(Triplet t : tlist){
			group.add(t);
			int retMax = generateGroups(tripletGridList, gridIndexToProcess+1, group, minBestScore, surprises);
			group.remove(t);
			max = (max > retMax) ? max : retMax ;
		}
		return max;
	}

}
