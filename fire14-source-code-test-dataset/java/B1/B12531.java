import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class Google2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
        FileInputStream fstream = new FileInputStream("/tmp/input.txt");
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        
        int cases = Integer.parseInt(br.readLine());
     
        for(int mCas=0; mCas<cases; mCas++){
            
        	String l = br.readLine();
            String pair[] = l.split(" ");
            int a = Integer.parseInt(pair[0]);
            int b = Integer.parseInt(pair[1]);

        
        	//int a=45;
        	//int b=72;
			int c=0;
			
			for(int i=a; i<b; i++){
				for(int j=i+1; j<=b; j++){
					if(test(i,j)){
						c++;
					}
				}
			}		
			System.out.println("Case #"+(mCas+1)+": "+c);
        }
		//test();
	}
	
	static boolean test(int a, int b){
		String as = Integer.toString(a);
		String bs = Integer.toString(b);		
		for(int i=bs.length(); i >1; i-- ){
			String n="";
			int j=i;
			do{				
				n+=bs.charAt(j-1);
				if(j==bs.length())
					j=0;
				j++;
			}while(j!=i);
							
			if(n.equals(as)){
//				System.out.println("("+a+", "+b+") "+n);
				return true;
			}						
		}		
		return false;	
	}

}
