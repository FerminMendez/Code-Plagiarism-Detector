import java.util.Scanner;

class Recycle{
    static Scanner sc = new Scanner(System.in);
    static long[] pow={1,10,100,1000,10000,100000,1000000,10000000};
    public static void solve()
    {
	long A =sc.nextInt();
	long B =sc.nextInt();
	long sum=0;
	long j;
	String si,sj,sk;
	int tj,k;
	Boolean t2,t=false;
	int d,z='0';
	for(long i=A;i<=B;i++)
	    {if(i>9){
		    // t=(i%10==0);
		
	     	    // j=(i/10)+(i%10)*pow[(int)Math.round(Math.floor(Math.log(i)/Math.log(10)))];
		    si=""+i;
		    // tj=(int)(j%10);
		    // d=z+tj;
		    sj=si;
		    sk="";
		    sk=sk+sj.charAt(sj.length()-1);
		    for(k=1;k<sj.length();k++)
			sk=sk+sj.charAt(k-1);
		    // t2=t;
		    j=Integer.parseInt(sk);
		    
	     	    //System.out.println(i+" "+j);
		    while(!sk.equals(si))
			{
			    if(j>i && j<=B && j>=A && sk.charAt(0)!=0 && si.charAt(0)!=0)
				sum++;
			    sj=sk;
			    sk="";
			    sk=sk+sj.charAt(sj.length()-1);
			    for(k=1;k<sj.length();k++)
				sk=sk+sj.charAt(k-1);
			    j=Integer.parseInt(sk);
			    //System.out.println(i+" "+si+" "+j+" "+sk);
			    // if(!t2)
			    // 	j=(j/10)+(j%10)*pow[(int)Math.round(Math.floor(Math.log(j)/Math.log(10)))];	
			    // else
			    // 	j=(j/10)+(j%10)*pow[1+(int)Math.round(Math.floor(Math.log(j)/Math.log(10)))];
			    // t2=t;
			}
	     	}

	    }
	
	System.out.println(sum);
    }

    public static void main(String[] args)
    {
	int n=sc.nextInt();
	sc.nextLine();

	for(int i=0;i<n;i++)
	    {
		System.out.print("Case #"+(i+1)+": ");
		solve();
	    }
    }
    
}