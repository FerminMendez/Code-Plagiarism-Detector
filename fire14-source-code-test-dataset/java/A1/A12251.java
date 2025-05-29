package year2012.qualification.b;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class DancingWithTheGooglers {
	public static void main(String[] args) throws Exception{
		//GCJÂÖ±ÈÄö
		String filename = "src/year2012/qualification/b/B-small-attempt5";
		PrintWriter out = new PrintWriter(new File(filename + ".out"));
		Scanner scan = new Scanner(new File(filename + ".in"));
		
		final int T = scan.nextInt();
		
		for(int i=0;i<T;i++){
			int N = scan.nextInt();
			int S = scan.nextInt();
			int p = scan.nextInt();
			int[] t = new int[N];
			int ans = 0;
			for(int j=0;j<N;j++){
				t[j] = scan.nextInt();
			}

			//surprising„ÅÆÂÄôË£ú
			List<Integer> probableSurprising = new ArrayList<Integer>();
			
			//30„Å®29„Å®28„ÅØ‰æãÂ§ñ
			for(int j=0;j<N;j++){
				if(t[j] == 30 || t[j] == 29 || t[j] == 28){
					ans++;
				}else if(t[j] == 0){
					if(p==0)
						ans++;
				}else if(t[j] == 1){
					if(p==1)
						ans++;
				}else{
					if((int) Math.ceil((double)t[j] / 3.0) < p){
						probableSurprising.add(t[j]);
					}else{
						ans++;
					}
				}
				
			}
			//„Äåsurprising„Åã„ÇÇ„Åó„Çå„Å™„ÅÑÊï∞„Äç„ÇíË¶ã„Å¶„ÇÜ„Åè„ÄÇ
			Collections.sort(probableSurprising, new Comparator<Integer>(){
			      public int compare(Integer t1, Integer t2) {
			        return t2 - t1;
			      }
			    });
			for(int j=0;j<probableSurprising.size();j++){
				int best=-1;
				//ÊúÄÂàù„ÅÆSÂÄã„ÅØsurprising
				if(j<S){
					int mod =probableSurprising.get(j) %3;
					if(mod == 1){
						best = (probableSurprising.get(j) + 2) / 3;
					}else if(mod == 2){
						best = (probableSurprising.get(j) + 4) / 3;
					}else if(mod == 0){
						best = (probableSurprising.get(j) + 3) / 3;
					}
				}else{
					//surprising„Åß„ÅØ„Å™„ÅÑÊï∞„ÄÇ3„ÅßÂâ≤„Å£„Å¶Âàá„Çä‰∏ä„Åí„Çå„Å∞best„ÅÆÁÇπ„ÅåÂá∫„Çã
					best =(int) Math.ceil((double)probableSurprising.get(j) / 3.0);	
				}
				if(best >= p){
					ans++;
				}
				
			}
			System.out.println("Case #"+(i+1)+": "+ ans);
			out.printf("Case #%d: %s\n", i+1, ans);
		}
		out.flush();
	}
}
