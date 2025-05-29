
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class DancingWithGooglers1 extends Thread{

	//private static int rating[] = {0,0,0,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,9,9,9,10,10,10};
	private static int totalJudge = 3;
	/**
	 * @param args
	 */
	public static void main(String[] args)  throws Exception{
		new DancingWithGooglers1().parseFile();
		
		
		
	}
	
	public void parseFile() throws Exception
	{
		File file = null;
		FileReader reader = null;
		BufferedReader br  = null;
		
		File outFile = null;
		PrintWriter prntWriter = null;
		try {
			file = new File("B-small-attempt2.in");
			reader = new FileReader(file);
			br = new BufferedReader(reader);
			
			outFile = new File("B-small-attempt2.out");
			prntWriter =  new PrintWriter(outFile);
			
			
			String str = "";
			int liTotalCases = 0;
			if((str = br.readLine())!=null)
			{
				liTotalCases = Integer.parseInt(str);
				//System.out.println('liTotalCases::: '+liTotalCases);
				for(int i=0;i<liTotalCases;i++)
				{
					//System.out.println('---------------------Start--------------------------------');
					int noOfGooglerWithBest = 0;
					String line = br.readLine();
					String[] strArr = line.split(" ");
					int totalGooglers = Integer.valueOf(strArr[0]);
					int totalSurprise = Integer.valueOf(strArr[1]);
					int bestResult = Integer.valueOf(strArr[2]);
					List<List<RatingSet>> finalRat = new ArrayList<List<RatingSet>>();
					for(int j=3;j<totalGooglers+3;j++) {
//						System.out.print(strArr[j]+" ");
						List<RatingSet> rsSet = isGooglerWithBestResult(Integer.valueOf(strArr[j]), bestResult,totalSurprise);
						System.out.println(rsSet);
						finalRat.add(rsSet);
						
					}
					System.out.println("final: "+finalRat);
					
					List<List<RatingSet>> orderedSet = new ArrayList<List<RatingSet>>();
					
					for(List<RatingSet> res:finalRat){
						if(totalMax(res, bestResult)==res.size()) {
							noOfGooglerWithBest++;
						}
						else {
							orderedSet.add(res);
						}
					}
					System.out.println("orderedSet:: "+orderedSet);
					for(List<RatingSet> remainingSet:orderedSet){
						for(RatingSet rs:remainingSet){
							if(totalSurprise>0 && rs.isSurprisingCondition() && rs.isHavingBestScore(bestResult)) {
								noOfGooglerWithBest++;
								totalSurprise--;
								break;
							} else {
								
							}
						}
					}
					
					System.out.println("Case #"+ (i+1) + ": "+ noOfGooglerWithBest);
					prntWriter.write("Case #"+ (i+1) + ": "+ noOfGooglerWithBest +"\n");
					prntWriter.flush();
					//System.out.println('-------------------End----------------------------------');
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			if(reader!=null)
				reader.close();
			if(br!=null)
				br.close();
			
			if(prntWriter!=null)
				prntWriter.close();
		}
	}
	
	
	private int totalMax(List<RatingSet> res,int bestScore){
		int totalBest = 0;
		for(RatingSet r:res) {
			if(r.isHavingBestScore(bestScore)){
				totalBest++;
			}
		}
		System.out.println(totalBest);
		return totalBest;
		
	}
	
	public List<RatingSet>  isGooglerWithBestResult(int totalScore, int bestResult,int totalSurprise) {
		System.out.println("totalScore: "+totalScore);
		
			int n = totalScore/totalJudge;
			ArrayList<Integer> set = new ArrayList<Integer>();
		       for(int i=-2;i<=2;i++){
		    	   if(n-i>=0 && n-i<=10)
		    		   set.add(n-i);
		       }
		       
			List<RatingSet> rsSet = findPosibleSubSets(set, bestResult, totalScore, totalSurprise);
			
		
		return rsSet;
	}
	
	private List<RatingSet> findPosibleSubSets(ArrayList<Integer> set,int bestResult,int totalScore,int totalSurprise){
		List<RatingSet> allSetList = new ArrayList<RatingSet>();
		
		List<RatingSet> rattingSet = getListOfRatingSet(set);
		
		for(RatingSet rs:rattingSet) {
			if(rs.getTotal()==totalScore && rs.isValidRating()){
				allSetList.add(rs);
			}
		}
		
		return allSetList;
	}
	
	private List<RatingSet> getListOfRatingSet(ArrayList<Integer> set){
		List<RatingSet> rattingSet= new ArrayList<RatingSet>();
		
		for(int i=0;i<set.size();i++){
			for(int j=i;j<set.size();j++) {
				for(int k=j;k<set.size();k++) {
					rattingSet.add(new RatingSet(set.get(i), set.get(j), set.get(k)));
				}
			}
		}
		
		
		return rattingSet;
	}
	
}

class RatingSet {
	int r1;
	int r2;
	int r3;
	
	public RatingSet(int r1,int r2,int r3) {
		this.r1 = r1;
		this.r2 = r2;
		this.r3 = r3;
	}
	
	public int getTotal(){
		return r1+r2+r3;
	}
	public boolean isHavingBestScore(int bestScore){
		if(r1>=bestScore) {
			return true;
		}
		else if(r2>=bestScore) {
			return true;
		}
		else if(r3>=bestScore) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isSurprisingCondition() {
		if(maxRating()-minRating()==2){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "{" + r1 + "," + r2 + "," + r3 + "}";
	}
	
	public int minRating(){
		int min = r1;
		if(r2<min) {
			min = r2;
		}
		if(r3<min){
			min = r3;
		}
		return min;
	}
	
	public int maxRating(){
		int max = r1;
		if(r2>max) {
			max = r2;
		}
		if(r3>max){
			max = r3;
		}
		return max;
	}
	
	public boolean isValidRating(){
		return (maxRating()-minRating()<=2)?true:false;
	}
}

