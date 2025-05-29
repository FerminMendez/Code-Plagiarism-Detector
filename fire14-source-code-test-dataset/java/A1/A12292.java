import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;


public class GoogleDancers {

	/**
	 * @param args
	 */
	static ArrayList<int[]> comb;
	static int dancers;
	static int posScores[];
	static int S, p;
	static int ld;
	static int r1,r2;
	static int points[];
	static int max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String hm="";
		int n =Integer.valueOf(in.readLine()), m=1;
		for(m=1;m<=n;m++){
			max=0; ld=1;
			String line[]=in.readLine().split(" ");
			dancers=Integer.valueOf(line[0]);
			posScores=new int[dancers+1];
			S=Integer.valueOf(line[1]);
			p=Integer.valueOf(line[2]);
			points= new int[dancers];
			comb=new ArrayList<int[]>();
			for(int rd=0;rd<dancers;rd++)
				points[rd]=Integer.valueOf(line[2+rd+1]);
			for(int dancer=1;dancer<=dancers;dancer++){
				r1=points[dancer-1]/3-1;r2=(int)Math.floor(points[dancer-1]/3.0+2);
				//System.out.println(dancer+" "+r1+" "+r2);
				if(r2>10) r2=10; if(r1<0) r1=0;  
				for(int i=r1;i<=r2;i++)
					for(int j=i;j<=r2;j++)
						for(int k=j;k<=r2;k++)
								if((i+j+k)==points[dancer-1]){
									int temp[]={dancer,i,j,k};
									if(good(temp)){
										if(ld!=dancer){
											ld=dancer;
											posScores[dancer]+=posScores[dancer-1];
										}
										posScores[dancer]++;
										comb.add(temp);
									}
								}
			}
	
			//check possible combinations
			rec(new int[0]);
			hm+="Case #"+m+": "+max+"\n";
		}
		System.out.println(hm);
		
	}
	
	public static boolean good(int[] aux){
		if(Math.abs(aux[1]-aux[2])>2) return false;
		if(Math.abs(aux[1]-aux[3])>2) return false;
		if(Math.abs(aux[2]-aux[3])>2) return false;
		return true;
	}
	
	public static void rec(int[] chos){
		if(chos.length==dancers){
			//evaluate
			String hm="";
			int aux[];
			int num=0, surp=0, lmax = 0;
			for(int i=0;i<chos.length;i++){
				num=0;
				aux=comb.get(chos[i]);
				if(Math.abs(aux[1]-aux[2])==2) num++;
				if(Math.abs(aux[1]-aux[3])==2) num++;
				if(Math.abs(aux[2]-aux[3])==2) num++;
				if(num>=1) 
					surp++;
				
				for(int j=1;j<=3;j++){
					if(aux[j]>=p){
						lmax++;
						break;
					}
				}
				hm+=chos[i]+" ";
			}
			// 0 1 4 6 8 9  SURP1
			//System.out.print(" SURP "+surp);
			if(surp==S && lmax>max){
				max=lmax;
			//	System.out.println("asd"+hm+" "+max);
			}
			
		}else{
			int[] newChos=new int[chos.length+1];
			for(int j=0;j<chos.length;j++)
				newChos[j]=chos[j];
			for(int i=posScores[chos.length];i<posScores[chos.length+1];i++){
				newChos[chos.length]=i;		
				rec(newChos);
			}
		}
			
	}
	
	public static void printComb(ArrayList<int[]> comb){
		for(int i=0;i<comb.size();i++){
			for(int j=0;j<comb.get(i).length;j++)
				System.out.print(((int[])comb.get(i))[j]+",");
			System.out.println();
		}
	}
	
	public static int[] sort(int dancer, int i,int j, int k){
		
		if(i>=j && i>=k){
			if(j>=k){
				int []r={dancer, i,j,k};
				return r;
			}else{
				int []r={dancer, i,k,j};
				return r;
			}
		}else if(j>=i && j>=k){
			if(i>=k){
				int []r={dancer, j,i,k};
				return r;
			}else{
				int []r={dancer, j,k,i};
				return r;
			}
		}else{
			if(i>=j){
				int []r={dancer, k,i,j};
				return r;
			}else{
				int []r={dancer, k,j,i};
				return r;
			}
		}
			
		//return (new int[3]);
	}

}
