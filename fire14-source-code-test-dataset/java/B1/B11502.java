import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class problem {

	public static void main(String[] args)  throws IOException{
		final String filein = "C:\\Users\\BYTE\\Downloads\\C-small-attempt0.in";
		//final String filein = "C:\\Users\\byte\\Downloads\\NewFolder\\C-small-attempt6.txt";
	    BufferedReader in = new BufferedReader(new FileReader(filein));
	    
	    
		int tests=Integer.parseInt(in.readLine());
		
		int a=0,b=0,num=0;
		
		for(int i=0;i<tests;i++)
		{
			String s1[]=in.readLine().split(" ");
						
			a=Integer.parseInt(s1[0]);
			b=Integer.parseInt(s1[1]);
			
			//char [] arr=s1[0].toCharArray(); 
			
			for(int j=a; j<b;j++)
			{
				char [] arr=Integer.toString(j).toCharArray();
				for(int k=arr.length-1;k>0;k--)
				{
					if(arr[k]== '0')
						continue;
					else
					{
						
						String s = new String(arr);
						int z= Integer.parseInt(s.substring(k,arr.length)+s.substring(0,k));
						if(z >= a && z<=b  && z!=j && !(z<j)  )
							num++;
					}
				}
				
			}
			
			System.out.println("Case #"+(i+1)+": "+num);
			num=0;
			
		}
	}

}
