package qualificationRound;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;


public class B {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int ncases = sc.nextInt();

		StringBuilder sb = new StringBuilder();
		for ( int ncase = 1; ncase <= ncases; ncase++ ) {
			int nGooglers = sc.nextInt();
			int nSuprising = sc.nextInt();
			int p = sc.nextInt();
			int surprises = 0;
			int count = 0;
			for (int i = 0; i < nGooglers; i++) {
				int s = sc.nextInt();
				int q = s/3;
				int rm = s%3;
				int pq = p-q;
				
				if ( s < p)
					continue;

				if ( q >= p  ) {
					count++;
				}
				else if ( pq <= 2 ){
					if ( rm == 0 ) {
						if ( pq == 1 && surprises < nSuprising ) {
							count++;
							surprises++;
						}
					}
					else {
						if ( pq == 1 )
							count++;
						else if ( rm == 2 && surprises < nSuprising ) {
							count++;
							surprises++;
						}
					}
				}
			}

			sb.append("Case #"+ ncase +": " + count +  "\n");
		}

		BufferedOutputStream bos = null;
		bos= new BufferedOutputStream(new FileOutputStream(new File("C:\\Users\\Christian\\workspaceCPDI\\CodeJam2012\\src\\qualificationRound\\res.txt")));
		bos.write(sb.toString().getBytes());
		bos.close();
	}
	
}