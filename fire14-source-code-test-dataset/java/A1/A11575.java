import java.io.BufferedReader;
import java.io.File;
import java.util.StringTokenizer;
import java.io.FileReader;
public class B {

	/**
	 * @param args
	 */
	public static void main(String[] args)  throws Exception {
		BufferedReader reader = null;
		String fileName = "B-small-attempt0.in";
		String outputFileName=fileName.replace(".in", ".out");
		reader=new BufferedReader(new FileReader(fileName));
		File outFile=new File(outputFileName);
		outFile.createNewFile();
		int T = Integer.parseInt(reader.readLine());
		for (int i = 1; i <=T; i++) {
			StringTokenizer token=new StringTokenizer(reader.readLine()," ");
			int n=Integer.parseInt(token.nextToken());
			int s=Integer.parseInt(token.nextToken());
			int p=Integer.parseInt(token.nextToken());
			int[] t=new int[n];
			Score[] ns=new Score[n];//not surprising
			Score[] ss=new Score[n];//surprising
			for(int j=0;j<n;j++){
				t[j]=Integer.parseInt(token.nextToken());
				int avg=t[j]/3;
				int reminder=t[j]%3;
				if(reminder==0){
					Score ts1=new Score();
					Score ts2=new Score();
					ts1.s1=avg;
					ts1.s2=avg;
					ts1.s3=avg;
					ns[j]=ts1;
					if(avg==0){
						ss[j]=ns[j];
					}else{
						ts2.s1=avg-1;
						ts2.s2=avg;
						ts2.s3=avg+1;
						ss[j]=ts2;
					}
				}else if(reminder==1){
					Score ts1=new Score();
					Score ts2=new Score();
					ts1.s1=avg+1;
					ts1.s2=avg+1;
					ts1.s3=avg-1;
					ss[j]=ts1;
					ts2.s1=avg;
					ts2.s2=avg;
					ts2.s3=avg+1;
					ns[j]=ts2;
				} else if(reminder==2){
					Score ts1=new Score();
					Score ts2=new Score();
					ts1.s1=avg;
					ts1.s2=avg;
					ts1.s3=avg+2;
					ss[j]=ts1;
					ts2.s1=avg;
					ts2.s2=avg+1;
					ts2.s3=avg+1;
					ns[j]=ts2;
				} 
			}
			
//			System.out.println("Case #"+i+": "+(k+1)+" "+(m+1));
			count=0;
//			System.out.println("n="+n+" s="+s+" p="+p);
			execute(ns,ss,n,s,p);	
			System.out.println("Case #"+i+": "+count);
		}

	}
	static int count=0;
	private static void action(Score[] ns,Score[] ss,int p,int[] index){
		int count=0;
		boolean s[]=new boolean[ns.length];
		for(int i=0;i<index.length;i++){
			s[index[i]]=true;
		}
		for(int i=0;i<s.length;i++){
			Score so=null;
			if(s[i]){
				so=ss[i];
			}else{
				so=ns[i];
			}
			if(so.max()>=p){
				count++;
			}
//			System.out.println(so.toString());
		}
		B.count=Math.max(B.count, count);
	}
    public static void execute(Score[] ns,Score[] ss,int n,int r,int p) {   
    	if(r==0){
    		action(ns,ss,p,new int[0]);
    		return;
    	}
        int i = 0, j;   
        int[] a = new int[n];   
        a[i] = 0;   
        while (true) {   
            if ((a[i] - i) <= (n - r)) {   
                if (i == (r - 1)) {   
                    int[] index = new int[r];   
                    for (j = 0; j < r; j++) {   
                        index[j] = a[j];   
                    }   
                    action(ns,ss,p,index);   
                    a[i] = a[i] + 1;   
                    continue;   
                }   
                i++;   
                a[i] = a[i - 1] + 1;   
            } else {   
                if (i == 0) {   
                    break;   
                }   
                i--;   
                a[i]++;   
            }   
        }
    }   
	
}
class Score{
	int s1;
	int s2;
	int s3;
	int p;
	boolean isSurprising(){
		if(Math.abs(s1-s2)>=2 || Math.abs(s1-s3)>=2 || Math.abs(s2-s3)>=2){
			return true;
		}
		return false;
	}
	public String toString(){
		return s1+","+s2+","+s3;
	}
	public int max(){
		return Math.max(Math.max(s1, s2),s3);
	}
}