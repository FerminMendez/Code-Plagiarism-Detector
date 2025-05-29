import java.io.File;
import java.util.*;


public class Googlers {
	public static void main(String[] args) throws Throwable{
		Scanner scan = new Scanner(new File("in_b"));
		scan.nextLine();
		
		int l = 1;
		while(scan.hasNextLine()){
			String[] line = scan.nextLine().split(" ");
			int surprise = Integer.valueOf(line[1]);
			int p = Integer.valueOf(line[2]);
			int min = (p * 3) - 2;
			int sup = min - 2;
			
			int ok = 0;
			for(int i = 3; i < line.length ; i++){
				int score = Integer.valueOf(line[i]);
				if(p == 1){
					if(score == 0){
						continue;
					}
				}
				if(score >= min){
					ok++;
					continue;
				}
				if(score >= sup){
					if(surprise > 0){
						ok++;
						surprise--;
					}
				}
			
			}
			System.out.println("Case #" + l + ": " + ok);
			l++;
 		}
	}
}
