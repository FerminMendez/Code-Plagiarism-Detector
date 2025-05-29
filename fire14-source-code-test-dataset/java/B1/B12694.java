import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;


public class Recycle {

	
	public static int Search(String a, String b){
		if(a.length() != b.length())
			return 0;
		else{
			ArrayList<String> chk = new ArrayList<String>();
			int counter=0;
			for(int i=0; i<a.length(); i++){
				if((!chk.contains(a))&& a.equals(b))
					counter++;
				chk.add(a);
				a = a.substring(1)+a.charAt(0);
			}
			return counter;
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(new InputStreamReader(System.in));
		int cases = Integer.parseInt(scan.next());
		int count=1;
		while(cases >0){
			int a = Integer.parseInt(scan.next());
			int b = Integer.parseInt(scan.next());
			int tmp = a;
			int noOfRec=0;
			while(tmp< b){
				for(int b2=b; b2>tmp; b2--){
					int no = Search(""+tmp, ""+b2);
					noOfRec += no;
				}
				tmp++;
			}
			System.out.println("Case #"+count+": "+noOfRec);
			count++;
			cases--;
		}

	}

}
