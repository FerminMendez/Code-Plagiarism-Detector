import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		new A().run();
	}

	private void run() {		
		Scanner s;
		try {
			s = new Scanner(new File("A.in"));
			
			int t = s.nextInt();
			s.nextLine();
			for (int i = 0; i < t; i++) {
				HashMap<String, Boolean> map = new HashMap<String, Boolean>();
				int count = 0;
				int a = s.nextInt();
				int b = s.nextInt();
				for(int j=a;j<=b;j++){
					String str = ""+j;
					String tmp = str;
					for (int k = 0; k < str.length()-1; k++) {
						tmp = tmp.charAt(tmp.length()-1) + tmp.substring(0, tmp.length()-1);
						int m = Integer.parseInt(tmp);
						if(Integer.parseInt(tmp) > j && m <=b ){
							if(!map.containsKey(j+"_"+m)){
								map.put(j+"_"+m, true);
								count++;
							}
						}
					}
				}
				System.out.println("Case #"+(i+1)+": "+count);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
