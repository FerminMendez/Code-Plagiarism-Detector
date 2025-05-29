import java.util.* ;

public class RecycledNumbers {
	 public static void main(String args[]) throws Exception
	 {
	
	String inFileName = "C:\\Documents and Settings\\kumarxnx.BKNG\\Desktop\\CodeJam\\3\\in"; 
	 String outFileName = "C:\\Documents and Settings\\kumarxnx.BKNG\\Desktop\\CodeJam\\3\\out";

	
	
	 
	 FileReaderWriter fri = new FileReaderWriter(inFileName,FileReaderWriter.READ_MODE) ; 
	 FileReaderWriter fro = new FileReaderWriter(outFileName,FileReaderWriter.WRITE_MODE) ;
	 
	 int inputs = fri.readInt() ;
	 ArrayList <Long> nums ;
	 HashMap map ;
	 long low  ;
	 long high ;
	 
	 for(long i=0 ; i<inputs ; i++)
	 {
		nums =fri.readLongList();
		map = new HashMap() ;
		low = nums.get(0) ;
		high = nums.get(1) ;
	    
		for(long j=low;j<=high;j++)
		{
			getCombination(map,j,low,high) ;	
		}
		
		fro.writeLine("Case #"+(i+1)+": "+map.size()) ;
		
	 }
	 
	 
	 fri.close() ; 
	 fro.close() ;
	 
	 }
	 
	 public static void getCombination(HashMap map , long num , long low , long high)
	 {
		 String str = ""+num ;
		 char [] arr = str.toCharArray() ;
		 int len = arr.length ;
		 
		 long newNum ; 
		 for(int i=1 ; i<=len ; i++)
		 {
			 arr  = shiftByOne(arr) ;
			 if(arr[0]!='0')
			 {
			 newNum = Long.parseLong(new String(arr)) ;
			 if(newNum!=num && newNum>=low && newNum<=high)
		 	    {
				   if ( !
						   ( 
						       map.containsKey(""+num+","+newNum)  || 
						       map.containsKey(""+newNum+","+num)					        
					      )
					   )   
				      {
					   
					   
					   map.put(""+num+","+newNum,null) ;
					   
					
				   }
		    	 }
			 }
		 }
	 }
	 
	 public static char[] shiftByOne(char[] arr) 
	 {
		char c = arr[arr.length - 1] ;
		char cnew [] = new char[arr.length] ;
		 		 
		for(int i=1;i<cnew.length ; i++)
		{
			cnew[i] = arr[i-1] ; 
		}
		cnew[0] = c ;
		return cnew ;
	 }
	 
	
}
