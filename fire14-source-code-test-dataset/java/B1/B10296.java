package qualifs;

import gcj.Gcj;

import java.util.HashSet;
import java.util.Set;

public class C {
	
	final private String file;
	
	C (String f) {
		file = f;
	}
	
	public void run() {

		Gcj gcj = new Gcj(file);
		
		gcj.readLine();
		int ncase = gcj.iToken();
		
		for (int cas=1 ; cas <= ncase ; cas++) {
			
			gcj.readLine();
			String A = gcj.sToken();
			String B = gcj.sToken();
			int a = Integer.parseInt(A);
			int b = Integer.parseInt(B);
			int[] aa = gcj.breakdownNumber(A);
			int[] mm = gcj.breakdownNumber(A);
			int[] bb = gcj.breakdownNumber(B);
			
			int n = aa.length;
			int count = b-a;
			int rp = 0;

			Set<String> dejavu = new HashSet<String>();
			
			if (n >= 2) while (count-- > 0) {

				for (int c=1 ; c<n ; c++) {
					boolean rok=false,bok=false;
					
					for (int i=0 ; i<n ; i++) {
						int p = (i+c) % n;

						if ( ! rok) {
							if (mm[p] < mm[i])    break;
							if (mm[p] > mm[i])    rok = true;
						}
						if ( ! bok) {
							if (mm[p] > bb[i])    break;
							if (mm[p] < bb[i] || i == n-1) bok = true;
						}
					}
					
					// dejavu
					if (rok && bok) {
						String u="",v="";
						for (int i=0 ; i<n ; i++) {
							int p = (i+c) % n;
							u+=Integer.toString(mm[i]);
							v+=Integer.toString(mm[p]);
						}
						String s = u+","+v;
						if ( ! dejavu.contains(s)) {
							dejavu.add(s);
							rp++;
						}
					}
				}
				
				// inc
				for (int i=n-1 ; i>=0 ; i--) {
					if (mm[i] == 9) mm[i] = 0;
					else {
						mm[i]++;
						break;
					}
				}
				
			}
			
			Gcj.outcase(cas, false);
			System.out.println(rp);
		}
		
		gcj.terminate();
		
	}
	
}
