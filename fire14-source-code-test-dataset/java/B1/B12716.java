import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class RecycledNum {

	/**
	 * @param args
	 */
	
	static int abc[]=new int[1000];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t=0,n = 0,len=0,k=0,l=0;
		int count[]=new int[100];
		int num1[]=new int[100];
		int num2[]=new int[100];
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try {
			n=Integer.parseInt(br.readLine());
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		while(t<n)
		{
			try {
				String s=br.readLine();
				int ind=0;
				String s1="";
				String s2="";
				ind=s.indexOf(' ');
				for(int i=0;i<ind;i++)
				{
					s1+=s.charAt(i);					
				}
				for(int i=ind+1;i<s.length();i++)
				{
					s2+=s.charAt(i);					
				}
				num1[t]=Integer.parseInt(s1);
				num2[t]=Integer.parseInt(s2);
				/*System.out.println(num1[t]);
				System.out.println(num2[t]);*/
				/*num1[t]=Integer.parseInt(br.readLine());
				num2[t]=Integer.parseInt(br.readLine());*/
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			t++;
		}
		
	
		
		t=0;
		while(t<n)
		{
			count[t]=0;
			len=0;
			
		int n1=num1[t];
		int n2=num2[t];
		/*System.out.println("n1:"+n1);
		System.out.println("n2:"+n2);*/
		for(int i=0;n1!=0;i++)
		{
			n1=n1/10;
			len++;
					
		}
		n1=num1[t];
		//System.out.println(len);

		/*System.out.println("n1:"+n1);
		System.out.println("n2:"+n2);*/
		for(int i=n1;i<=n2;i++)
		{
			k=i;
			l=0;
			for(int j=0;j<len-1;j++)
			{
				l=k;
				//System.out.println("l="+l);
				k=l%10;
				l=l/10;
				k*=Math.pow(10,len-1);
				k+=l;
		
				//System.out.println("k="+k);
				
				
				if(k>i && k<=n2)
				{
					count[t]++;
					//System.out.println(count[t]);
							
				}
				
			}
		}
	
		t++;
		/*System.out.println("n1:"+n1);
		System.out.println("n2:"+n2);*/
		}
		//System.out.println("t="+t);
		for(int i=0;i<n;i++)
		{
		System.out.println("Case #"+(i+1)+": "+count[i]);
		}
		
	}

}
