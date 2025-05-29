import java.io.BufferedReader;
import java.io.InputStreamReader;


public class B {

	void run() {
		try {
			BufferedReader bfd = new BufferedReader(new InputStreamReader(
					System.in));
			int tc = Integer.parseInt(bfd.readLine()), i, j, k, s, p, goo[], surp[],
					  res[], t, r, cnt;
			boolean[] taken;
			String[] sp;
			for(r=0; r<tc; ++r){
				sp = bfd.readLine().split(" +");
				s = Integer.parseInt(sp[1]);
				p = Integer.parseInt(sp[2]);
				goo = new int[sp.length-3];
				for(i=0; i<goo.length; ++i)
					goo[i] = Integer.parseInt(sp[i+3]);
				surp = new int[goo.length];
				res = new int[goo.length];
				int min;
				for(t=0; t<goo.length; ++t){
					min = (int)Math.floor(goo[t]/3)-1;
					if(min<0) min = 0;
					for(i=min; i<=goo[t]; ++i){
						for(j=i; j<=i+2; ++j){
							for(k=j; k<=j+2; ++k){
								if(k-i<=2)
								if(i+j+k==goo[t] && Math.max(Math.max(i, j), k)>=p){
									if(k-i==2){
										++surp[t];
									} else if(k-i < 2) {
										++res[t];
									} 
								}
							}
						}
					}
				}
				taken = new boolean[goo.length];
				cnt = 0;
				for(i=0; i<goo.length; ++i){
					if(s>0 && res[i]==0 && surp[i]==1){
						taken[i] = true;
						--s;
					}
				}
				for(i=0; i<goo.length; ++i)
					if(res[i]==1 && !taken[i])
						taken[i] = true;
				for(i=0; i<taken.length; ++i)
					if(taken[i]) ++cnt;
				System.out.print("Case #"+(r+1)+": "); 
				System.out.print(cnt);
				System.out.println();
			}

		} catch (Exception e) {
		}
	}
	public static void main(String[] args) {
		new B().run();
	}

}

