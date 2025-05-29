import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Problem3_C {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner scanner = new Scanner(new File("C-small-attempt0.in"));
		int num = scanner.nextInt();
		for(int count = 1 ; count <= num ; count++){
//			Set<String> set = new HashSet<String>();
//			Set<String> alreadyDone = new HashSet<String>();
			int ii = scanner.nextInt();
			int jj = scanner.nextInt();
			int counter = 0;
			for(int i = ii; i <= jj ; i++) {
				for(int j = i ; j <= jj ; j++) {
					String s1 = ""+i ;
					String s2 = ""+j ;
					for(int k = 0 ; k <= s2.length() ; k++) {
						if(i != j){
							String a = s2.substring(0, k);
							String b = s2.substring(k, s2.length());
							if((b+a).equals(s1) /*&& !alreadyDone.contains(alreadyDone.add(s1+"_"+s2))
									&& !alreadyDone.contains(alreadyDone.add(s2+"_"+s1))*/) {
								counter++;
//								alreadyDone.add(s1+"_"+s2);
//								alreadyDone.add(s2+"_"+s1);
//								System.out.println(s1 + "  --  "+ s2+ "  --  "  + (b+a));
							}
						}
					}				
				}
			}
			System.out.println("Case #"+count+": "+counter);
		}


	}

}
