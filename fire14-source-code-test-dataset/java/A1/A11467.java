import java.awt.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class Dancing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			BufferedReader bf=null;
			try {
				int T;
				bf = new BufferedReader(new FileReader("src/com/codejam/input/B-small-attempt2.in"));
				T = Integer.parseInt(bf.readLine());
				
				for(int i=0;i<T;i++){
					//Map<String,ArrayList<Triplet> > googlers = new HashMap<String, ArrayList<Triplet> >();
					ArrayList<Googler> googlers = new ArrayList<Googler>();
					
					String line = bf.readLine();
					String[] numbers = line.split(" ");
					int N = Integer.parseInt(numbers[0]);
					int S = Integer.parseInt(numbers[1]);
					int P = Integer.parseInt(numbers[2]);
					
					for(int index=3;index<numbers.length;index++){
						ArrayList<Triplet> triplets= getTripletList(numbers[index],P);
						
						if(triplets!=null)
							googlers.add(new Googler(numbers[index],triplets));
							//googlers.put(numbers[index],triplets);
					}
					
					
					
					
					int count = 0; 
					int surprising = 0;
					
					for(Googler g:googlers){
						boolean isNotSurprisingfound = false;
						for(Triplet tr:g.getTriplets()){
							if(tr.isSurprising()==false){
								isNotSurprisingfound = true;
								count++;
								break;
							}
								
						}
						if(!isNotSurprisingfound){
							surprising++;
						}
					}
					
					if(surprising<S) count+=surprising;
					else count+=S;
					
					System.out.println("Case #"+(i+1)+": "+count);
					
//					for(Googler g:googlers){
//						System.out.println(g.getTotal());
//						System.out.println("------");
//						for(Triplet tr:g.getTriplets()){
//							System.out.println(tr.getS1()+" "+tr.getS2()+" "+tr.getS3()+"   "+tr.isSurprising());
//						}
//						System.out.println("------");
//					}
									
				}
				
				
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} finally{
				bf.close();
			}
	
			
		}catch(IOException e){
			e.printStackTrace();
		}


	}
	
	public static ArrayList<Triplet> getTripletList(String total,int best){
		ArrayList<Triplet> triplets=null;
		
		for(int s1=0;s1<11;s1++){
			for(int s2=0;s2<11;s2++){
				for(int s3=0;s3<11;s3++){
					if( (s1+s2+s3)==Integer.parseInt(total) && Math.abs(s1-s2)<=2 && Math.abs(s1-s3)<=2 && Math.abs(s2-s3)<=2 ){
						
						Triplet tr = new Triplet(s1,s2,s3);
						if(tr.getMax()>=best){
							if(triplets==null)
								triplets=new ArrayList<Triplet>();
							
							triplets.add(tr);
						}
							
					}
				}
			}
		}
		
		if(triplets !=null)
			Collections.sort(triplets);
		
		return triplets;
	}

}


