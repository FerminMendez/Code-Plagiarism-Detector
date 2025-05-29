import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class Small_C {

	/**
	 * @param args
	 */
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File inf;
		File outf;

		try{
			inf= new File("C-small-attempt0.in");
			FileReader inputFil = new FileReader(inf);
			BufferedReader in = new BufferedReader(inputFil);
//			System.out.println("hiiiiiiii");
			
			FileWriter fstream = new FileWriter("output3.txt");
			  BufferedWriter out = new BufferedWriter(fstream);
			  
			  
			  
			
			int T= Integer.parseInt(in.readLine());
	
			
			
			
			for (int i=0;i<T;i++)
			{
				String op1="Case #" + (i + 1) + ": ";
				out.write(op1);

				String inputs=in.readLine();
				System.out.println(inputs);
				String[] dat= inputs.split(" ");
			
				int A = Integer.parseInt(dat[0]);
				int B = Integer.parseInt(dat[1]);

				int ans = 0;
				
				int n,n1,n2,n3;
				if(A<10 && A>=1)
				{
					ans=0;
				}
				
				else if(A<100 && A>=10)
				{
					for(int j=A;j<=B;j++)
					{
						n=j;
						
						n1=(n%10)*10+(n/10);
						
						for(int k=j;k<=B;k++)
						{
							if(k!=j && k==n1)
								ans++;
						}
						
					}
					
				}
				else if(A<1000 && A>=100)
				{
					for(int j=A;j<=B;j++)
					{
						n=j;
						
						n1=(n%10)*100+(n/10);
						n2=(n%100)*10+(n/100);
						
						for(int k=j;k<=B;k++)
						{
							if(k!=j && k==n1)
								ans++;
							if(k!=j && k==n2)
								ans++;
						}
						
					}

					
				}
				else if(A==1000)
				{
					ans=0;
				}
						
				
				out.write(ans+"");
				out.newLine();
				
			}
			
			out.close();			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}


	}


