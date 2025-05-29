import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

/**
 *
 * @author virginia
 *
 */
public class RecycledNumbers {
	public static int countn(int v)
	{
		int count=0;
		while (v> 0 && count<10 )
			{
				   int r = v % 10;
					count++;
				   v = v / 10;
	        }
	        return count;
		}
 public static void main(String[] args) {

 try {
   BufferedReader br = new BufferedReader(new FileReader("C-small-attempt1.in"));
   BufferedWriter output=new BufferedWriter(new FileWriter("Output.txt"));
  PrintWriter pw = new PrintWriter(output);

int n = Integer.parseInt(br.readLine());
 int[][] result = new int[n][2];

 String line;
 int a= 0;
 while ((line = br.readLine()) != null) {
  String[] tokens = line.split("\\s");

  for (int j = 0; j <2; j++) {
   result[a][j] = Integer.parseInt(tokens[j]);
  }

  a++;
 }
    int index = 0;

   for(int i =0; i < n; i++)
   {
	    int found=0;
								index++;
							   int A=result[i][0];
							   int B=result[i][1];
							   for(int j=A;j<=B;j++)
							   {
											  int cnt=0;
											  int num=j;
											  int rev=0;
												while (num> 0 && cnt<10 )
												{
													   int r = num % 10;
														cnt++;
													   num = num / 10;

												}
												int num1=j;
												int num2=j;
												int p=cnt-1;
												int r=0;
												do
												{
													cnt--;
													int s=(num1)%10;
													num2=num2/10;
													num1=(int)(s*Math.pow(10,(p)))+(num2);

													num2=num1;

													if(RecycledNumbers.countn(j)==RecycledNumbers.countn(num1))
													{
													if((A<=j)&&(j<num1)&&(num1<=B))
													{


														 found++;
												}}
												 }while(cnt>0);
								  }
   pw.print("Case #" + index + ": ");
   pw.println(found);
   System.out.print("Case #" + index + ": ");
   System.out.println(found);
   }
   output.close();
  } catch (FileNotFoundException e) {
   e.printStackTrace();
  } catch (IOException e) {
   e.printStackTrace();
  }
 }
}
