import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class C {


	public static void main (String[] args)
	{


		try {
			//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/C-small-attempt0.in"))));
			PrintWriter pw = new PrintWriter(System.out);
			int cases = Integer.parseInt(in.readLine());	
			for (int i = 0; i < cases; i++) {
				String[] nums = in.readLine().split(" ");
				int A = Integer.parseInt(nums[0]);
				int B = Integer.parseInt(nums[1]);
				int cont = 0;
				if(A!=1000 && A>=10)
				{
					if(A<100)
					{
						for (int j = A; j < B; j++) {
							if(j/10<j%10 && 10*(j%10)+j/10<=B)
								cont++;
						}
					}
					if(A>=100)
					{
						for (int j = A; j < B; j++) {
							int lef = j/100;
							int mid = (j-j/100*100)/10;
							int rig = j%10;
							
							if(lef==mid && lef==rig)
								continue;
							boolean a = lef<mid || (lef==mid && lef<rig);
							boolean b = lef<rig || (lef==rig && mid<lef);
							if(a && mid*100 + rig*10 + lef <=B)
								cont++;
							if(b && rig*100 + lef*10 + mid <=B)
								cont++;
							if(mid*100 + rig*10 + lef == rig*100 + lef*10 + mid )
								cont--;
							
						}

					}
				}
				
				System.out.println("Case #"+(i+1)+": "+cont);
				}

				
			pw.flush();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
