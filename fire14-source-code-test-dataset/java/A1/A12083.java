import java.util.Scanner;

class Dancing{
    static Scanner sc = new Scanner(System.in);
    
    public static void solve()
    {
	int sum,X;
	int n =sc.nextInt();
	int sur =sc.nextInt();
	int k =sc.nextInt();
	int max=0;
	for(int i=0;i<n;i++)
	    {
		sum=sc.nextInt();
		X=sum/3;
		if(X==0)
		    {
			if(k==0)
			    {
				max++;
			    }
			if(k==1 && (sum==1 || sum==2))
			    {
				max++;
			    }
			if(k==2 && sum==2 && sur>0)
			    {
				sur--;
				max++;
			    }
		    }
		else
		    if(k<=X)
			max++;
		    else
			if(k==X+1)
			    {
				if(sum%3!=0)
				    max++;
				else
				    if(sur>0)
					{
					    max++;
					    sur--;
					}
			    }
			else
			    if(k==X+2 && sum%3==2 && sur>0)
				{
				    max++;
				    sur--;
				}
	    }
	System.out.println(max);
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