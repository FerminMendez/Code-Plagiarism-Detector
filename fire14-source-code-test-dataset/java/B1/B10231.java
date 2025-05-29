import java.io.*;

class code1
{
	public static void main(String args[]) throws Exception 
	{
		File ii = new File ("C-small-attempt1.in");
		FileInputStream fis = new FileInputStream(ii);
		BufferedReader  br = new BufferedReader(new InputStreamReader (fis));
		int cases = Integer.parseInt(br.readLine());
		FileOutputStream fout = new FileOutputStream ("output.txt");
		DataOutputStream dout = new DataOutputStream (fout);
		int total=0;
		for(int i=0;i<cases;i++){
		String temp = br.readLine();
		String parts [] = temp.split(" ");
		int lower = Integer.parseInt(parts[0]);
		int upper = Integer.parseInt(parts[1]);
		System.out.println(lower+" "+upper);
		
		for(int j=lower;j<=upper;j++)
		{
			int abc = j;int length=0;
			if(j<10)continue;
			while (abc!=0){abc/=10;length++;}
			abc=j;
			for(int m=0;m<length-1;m++){
				int shift = abc%10;
				abc=abc/10;
				System.out.println("hi "+j);
				abc=abc+shift*power(10,length-1);
				if(abc<=upper&&shift!=0&&abc>j)total++;
				System.out.println(total);
			}
		}
 		dout.writeBytes("Case #"+(i+1)+ ": "+total+"\n");
 		total=0;
		}//for close
		
	}

	private static int power(int i, int j) {
		int no=1;
		for(int a=0;a<j;a++){no=10*no;}
		return no;
	}
}