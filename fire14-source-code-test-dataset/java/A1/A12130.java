import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class Dance {
	public static void main(String args[]){
				
		Dance t=new Dance();
		Scanner sc;
		int N;
		int S;
		int P;
		int T;
		List A;
		int div;
		int rem;
		int goo;
		int count = 0;
		try{
			sc = new Scanner(new FileReader("test.txt"));
			T = sc.nextInt();
			//in = new BufferedReader(new FileReader("test.txt"));
			PrintWriter pw = new PrintWriter(new FileWriter("Ans.txt"));

			while(T>0)
			{
				goo = 0;
				N = sc.nextInt();
				S = sc.nextInt();
				P = sc.nextInt();
				A = new ArrayList();
				for(int i=0; i<N; i++)
				{
					A.add(sc.nextInt());
					//System.out.println(A.get(i));
				}
				for(int j=0; j<A.size(); j++)
				{
					if((Integer)A.get(j)>=P){
					div = (Integer)A.get(j)/3;
					rem = (Integer)A.get(j) - (div*3);
					//System.out.println(div + " " + rem);
					if(div>=P)
					{
						goo++;
					}
					else
					{
						if((P-div) == 1)
						{
							if(rem > 0)	goo++;
							else if(S>0){
								goo++; S--;
							}
						}
						else if((P-div) == 2 && rem == 2 && S>0){
							goo++; S--;
						}

					}}
				}
				//System.out.println(goo);
				pw.println("Case #"+ ++count +": "+ goo);
				pw.flush();
				
				T--;
			}
			pw.close();
		}catch(Exception e){}

	}
}
