import java.io.*;

class Googlers
{
	public static void main(String args[]) throws IOException
	{
		FileInputStream fstream = new FileInputStream("B-small-attempt0.in");
		DataInputStream dstream = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(dstream));
		FileWriter fw = new FileWriter("output.txt");
		BufferedWriter out = new BufferedWriter(fw);
		int lines = Integer.parseInt(br.readLine());		//lines LINES OF INPUT TO FOLLOW
		for(int j=0;j<lines;j++)                        //EACH LINE FROM SECOND LINE
		{
			int googlers,S,P,result=0,number;
			String strLine;
			if ((strLine = br.readLine()) != null)
			{
				
				out.write("Case #"+(j+1)+": ");
				String str[] = strLine.split(" ");
				googlers=Integer.parseInt(str[0]);
				S=Integer.parseInt(str[1]);
				P=Integer.parseInt(str[2]);
				for(int i=3;i<(googlers+3);i++)
				{
					number = Integer.parseInt(str[i]);
					int divider = number/3;
					int remainder = number%3;
					if((remainder==0) && ((number!=0) || (P==0)))
					{
						if(divider>=P)
							result++;
						else if((P==(divider+1)) && (S!=0))
						{
							result++;
							S--;
						}
					}
					else if(remainder==1)
					{
						if(divider+1>=P)
							result++;
					}
					else if(remainder==2)
					{
						if(divider+1>=P)
							result++;
						else if((P==(divider+2)) && (S!=0))
						{
							result++;
							S--;
						}
					}
					
				}
				out.write(""+result);
		    }
			out.newLine();
		}
		dstream.close();
		out.close();
	}
}