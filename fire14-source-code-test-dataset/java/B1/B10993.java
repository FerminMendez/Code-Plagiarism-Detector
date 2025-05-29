import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Recycled {

	public static String shift(String x){
		return (x.substring(x.length() - 1) + x.substring(0, x.length() - 1));
	}
	
	public static void main(String[] args) {
		
		int t, x = 1;
		String a, b, s;
		Scanner scan = new Scanner(System.in);
		
		t = scan.nextInt();
		
		for(int i=0; i<t; i++){
			
			a = scan.next();
			b = scan.next();
			
			ArrayList<String> al = new ArrayList<String>();
			
			int n = Integer.parseInt(a);
			
			while(n <= Integer.parseInt(b)){
				
				s = "" + n;
				String orig = ""+n;
				
				for(int j=0; j<a.length() - 1; j++){
					
					s = shift(s);
					if(s.equals(orig)) break;
					
					//System.out.println(s);
					
					if(Integer.parseInt(s) >= Integer.parseInt(orig) && Integer.parseInt(s) <= Integer.parseInt(b) && !al.contains(s)){
						al.add(orig+"-"+s);
					}
				}
				
				n++;
			}
			
	//		for(int j=0; j<al.size(); j++)
	//			System.out.println(al.get(j));
			
			System.out.println("Case #" + x + ": " + al.size());
			x++;
		}
		
	}

}
