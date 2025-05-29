import java.util.*;
import java.io.*;

public class Dance {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int surprise, count, cases, m, n, lines, s, p, y, score1, score2, score3;
		cases = 0;
		lines = scan.nextInt();
		while((scan.hasNextInt()) && lines > 0 && lines <= 100){
			count = surprise = 0;
			y = 0;
			m = scan.nextInt();
			s = scan.nextInt();
			p = scan.nextInt();
			score1 = scan.nextInt();
			switch(m){
				case 1: cases++;
						if(p == 0 && score1 == 0){
							y++;
						}else if(score1 > 0 && ((p*3 <= score1) || ((p*3 - 1) == score1) || ((p*3 + 1) == score1) || ((p*3 - 2) == score1) || ((p*3 + 2) == score1))){
							y++;
						}else if(score1 > 0 && (surprise != s) && (((p*3 - 3) == score1) || ((p*3 + 3) == score1) || ((p*3 - 4) == score1) || ((p*3 + 4) == score1))){
							y++;
							surprise++;
						}
						System.out.println("Case #" + cases + ": " + y);
						lines--;
						break;
				case 2: cases++;
						score2 = scan.nextInt();
						if(p == 0 && score1 == 0){
							y++;
						}else if(score1 > 0 && (p*3 <= score1 || ((p*3 - 1) == score1) || ((p*3 + 1) == score1) || ((p*3 - 2) == score1) || ((p*3 + 2) == score1))){
							y++;
						}else if(score1 > 0 && (surprise != s) && (((p*3 - 3) == score1) || ((p*3 + 3) == score1) || ((p*3 - 4) == score1) || ((p*3 + 4) == score1))){
							y++;
							surprise++;
						}
						if(p == 0 && score2 == 0){
							y++;
						}else if(score2 > 0 && (p*3 <= score2 || ((p*3 - 1) == score2) || ((p*3 + 1) == score2) || ((p*3 - 2) == score2) || ((p*3 + 2) == score2))){
							y++;
						}else if(score2 > 0 && (surprise != s) && (((p*3 - 3) == score2) || ((p*3 + 3) == score2) || ((p*3 - 4) == score2) || ((p*3 + 4) == score2))){
							y++;
							surprise++;
						}

						System.out.println("Case #" + cases + ": " + y);
						lines--;
						break;
				case 3: cases++;
						score2 = scan.nextInt();
						score3 = scan.nextInt();
						if(p == 0 && score1 == 0){
							y++;
						}else if(score1 > 0 && (p*3 <= score1 || ((p*3 - 1) == score1) || ((p*3 + 1) == score1) || ((p*3 - 2) == score1) || ((p*3 + 2) == score1))){
							y++;
						}else if(score1 > 0 && (surprise != s) && (((p*3 - 3) == score1) || ((p*3 + 3) == score1) || ((p*3 - 4) == score1) || ((p*3 + 4) == score1))){
							y++;
							surprise++;
						}
						
						if(p == 0 && score2 == 0){
							y++;
						}else if(score2 > 0 && (p*3 <= score2 || ((p*3 - 1) == score2) || ((p*3 + 1) == score2) || ((p*3 - 2) == score2) || ((p*3 + 2) == score2))){
							y++;
						}else if(score2 > 0 && (surprise != s) && (((p*3 - 3) == score2) || ((p*3 + 3) == score2) || ((p*3 - 4) == score2) || ((p*3 + 4) == score2))){
							y++;
							surprise++;
						}
						if(p == 0 && score3 == 0){
							y++;
						}else if(score3 > 0 && ((p*3 <= score3) || ((p*3 - 1) == score3) || ((p*3 + 1) == score3) || ((p*3 - 2) == score3) || ((p*3 + 2) == score3))){
							y++;
						}else if(score3 > 0 && (surprise != s) && (((p*3 - 3) == score3) || ((p*3 + 3) == score3) || ((p*3 - 4) == score3) || ((p*3 + 4) == score3))){
							y++;
							surprise++;
						}

						System.out.println("Case #" + cases + ": " + y);
						lines--;
						break;
			}
		}
	}
}
