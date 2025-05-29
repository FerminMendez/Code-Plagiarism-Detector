package qualifs;

import gcj.Gcj;

import java.util.List;

public class B {
	
	final String file;
	
	B (String f) {
		file = f;
	}
	
	public void run() {

		Gcj gcj = new Gcj(file);
		
		gcj.readLine();
		int ncase = gcj.iToken();
		
		for (int cas=1 ; cas <= ncase ; cas++) {
			
			gcj.readLine();
			int N = gcj.iToken();
			int S = gcj.iToken();
			int p = gcj.iToken();
			int[] t = gcj.iBunch();
			
			int up = 0;
			
			for (int i=0 ; i<N ; i++) {
				int x = t[i];
				
				if (x >= 28) {
					if (10 >= p) up++;
				}
				else if (x == 0) {
					if (0 >= p) up++;
				}
				else {
					int u = x / 3;
					int m = x % 3;
					if (m > 0) u++;
					if (u >= p) up++;
					else {
						if (S > 0 && m != 1) {
							u++;
							if (u >= p) {
								S--;
								up++;
							}
						}
					}
				}
			}

			Gcj.outcase(cas, false);
			System.out.println(up);
		}
		
		gcj.terminate();
		
	}
	
}
