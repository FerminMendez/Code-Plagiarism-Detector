import java.util.ArrayList;


public class ClassificationRecycledNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		System.out.println("Count:"+countRecycledPair("1","200000"));
		Integer[][] input = {
				{110,956},
				{177,933},
				{170,923},
				{120,932},
				{143,979},
				{173,988},
				{181,938},
				{100,101},
				{132,934},
				{187,931},
				{6,9},
				{107,959},
				{121,991},
				{744,744},
				{100,999},
				{104,947},
				{100,999},
				{178,938},
				{112,948},
				{150,917},
				{281,493},
				{463,900},
				{111,973},
				{449,916},
				{118,927},
				{143,932},
				{146,956},
				{175,997},
				{172,917},
				{183,939},
				{159,937},
				{50,92},
				{155,935},
				{113,927},
				{130,992},
				{357,357},
				{34,37},
				{132,925},
				{188,923},
				{139,923},
				{145,942},
				{189,973},
				{162,995},
				{166,996},
				{10,10},
				{183,938},
				{135,941},
				{148,944},
				{175,997},
				{174,982}
		
		};
		for (int i=0;i<input.length;i++){
			System.out.println("Case #"+(i+1)+ ": "+countRecycledPair(input[i][0].toString(), input[i][1].toString()));
		}

	}
	
	
	public static int countRecycledPair(String a,  String b){
		if(a==null || b==null){
			return 0;
		}
		int total=0;
		Integer A =Integer.parseInt(a);
		Integer B =Integer.parseInt(b);
		for(Integer n=A;n<B;n++){
			for (Integer m=n+1;m<=B&&m.toString().length()==n.toString().length();m++){
				if (isRecycledPair(n.toString(),m.toString())){
					total++;
				}
			}
		}
		
		
		return total;
		
	}


	private static boolean isRecycledPair(String n, String m) {
		for (int i =0;i<n.length();i++){
			 if (i==0) i++;
				String nSufix=n.substring(n.length()-i);
				String nPrefix=n.substring(0,n.length()-i);
				if(m.startsWith(nSufix)){
					if(m.endsWith(nPrefix)){
//					System.out.println("Found Pair:"+n+","+m);
						return true;
					}
				}
			}
		return false;
	}
	
}


class CountRecycledPairNB extends Thread{
	Integer n;
	Integer B;
	Integer total=0;
	boolean finished=false;
	

	
	CountRecycledPairNB(Integer n, Integer B){
		this.n=n;
		this.B=B;
	}
	
	public void run() {
	
			ThreadGroup irps = new ThreadGroup("irps_"+n);
			ArrayList<IsRecycledPair> irpsArray =new ArrayList<IsRecycledPair>();
			for (Integer m=n+1;m<=B&&m.toString().length()==n.toString().length();m++){
				IsRecycledPair irp = new IsRecycledPair(n.toString(),m.toString());
				irp.start();
				irpsArray.add(irp);
				
			}

			boolean running=true;
			while(running){
				running=false;
				for (IsRecycledPair irp:irpsArray){
					if(irp.finished){
						if (irp.isRecycledPair){
							total++;
							irp.interrupt();
							irp=null;
							Runtime r = Runtime.getRuntime();
							r.gc();
						}
					}else{
//					System.out.println("running");
						running=true;
						break;
					}
				}	
			}
			finished=true;	
			irps=null;
			irpsArray=null;
			Runtime r = Runtime.getRuntime();
			r.gc();

	}
}

class IsRecycledPair extends Thread{
	String n;
	String m;
	boolean finished=false;
	boolean isRecycledPair=false;
	
	public void run() {
		 try {
			for (int i =0;i<n.length();i++){
				 if (i==0) i++;
					String nSufix=n.substring(n.length()-i);
					String nPrefix=n.substring(0,n.length()-i);
					if(m.startsWith(nSufix)){
						if(m.endsWith(nPrefix)){
//						System.out.println("Found Pair:"+n+","+m);
							this.isRecycledPair = true;
							finished=true;
							break;
						}
					}
				}	
			 finished=true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }

	 	IsRecycledPair(String n,String m) {
	 		super();
	 		this.n=n;
	        this.m=m;
	        
	    }
	
}