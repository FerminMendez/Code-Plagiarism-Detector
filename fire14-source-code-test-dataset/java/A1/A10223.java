import java.io.*;

class code3
{
	public static void main(String args[]) throws Exception 
	{
		File ii = new File ("B-small-attempt0.in");
		FileInputStream fis = new FileInputStream(ii);
		BufferedReader  br = new BufferedReader(new InputStreamReader (fis));
		int cases = Integer.parseInt(br.readLine());
		FileOutputStream fout = new FileOutputStream ("output.txt");
		DataOutputStream dout = new DataOutputStream (fout);
		int total=0;
		for(int i=0;i<cases;i++){
			String temp=br.readLine();
		String parts[] = temp.split(" ");
		int no = Integer.parseInt(parts[0]);
		int sur = Integer.parseInt(parts[1]);
		int best = Integer.parseInt(parts[2]);
		for(int j=0;j<no;j++){
			int sum = Integer.parseInt(parts[3+j]);
			int first = sum/3;
			int second = (sum-first)/2;
			int third = sum-first-second;
			if(first>=best||second>=best||third>=best){total++;continue;}
			if(sum>=(3*best-4)&&sum<=(3*best+4)&&sur!=0&&sum!=0)
			{
				total++;sur--;
				
			}
			
		}dout.writeBytes("Case #"+(i+1)+ ": "+total+"\n");
		total=0;

		}
	}
}