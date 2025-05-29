package qualification;

import java.io.*;

public class Bsmall {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("./src/qualification/B-small-attempt1.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("./src/qualification/B-small-attempt1.out"));
		int[][] inputs = new int[100][103];
		int casenumber = 0;
		String input = null;
		int total = 0;
		while((input=br.readLine()) != null)
		{
			if(casenumber==0)
			{
				total = Integer.parseInt(input);
			}else{
				String[] array = input.split(" ");
				// N
				inputs[casenumber-1][0] = Integer.parseInt(array[0]);
				// S
				inputs[casenumber-1][1] = Integer.parseInt(array[1]);
				// p
				inputs[casenumber-1][2] = Integer.parseInt(array[2]);
				// N integers ti.
				for(int i=3;i<array.length;i++)
				{
					inputs[casenumber-1][i] = Integer.parseInt(array[i]);
				}
			}
			casenumber++;
		}
		casenumber=1;
		while(casenumber <= total)
		{
			//System.out.println("Case #" + casenumber + ": " + String.valueOf(surprisingTriplets(inputs[casenumber-1], bw)));
			bw.write("Case #" + casenumber + ": " + String.valueOf(surprisingTriplets(inputs[casenumber-1], bw)));
			bw.newLine();
			casenumber++;
		}
		bw.close();
	}
	
	public static int surprisingTriplets(int[] inputs, BufferedWriter bw) throws IOException
	{
		int n = inputs[0];
		int s = inputs[1];
		int p = inputs[2];
		
		int sum=0;
		int count=0;
		int used=0;
		int i = 0;
		while(i<n)
		{
			sum=inputs[i+3];
			if(sum==0 && p==0){
				count++;
			}else if(sum!=0){
				int[] triplets = new int[3];
				triplets[0]=sum/3;
				triplets[1]=sum/3;
				triplets[2]=sum/3;
				if(triplets[0]>=p)
				{
					count++;
				}else if(sum%3==2)
				{
					if(triplets[0]==(p-2) && (s-used>0))
					{
						triplets[0]+=2;
						used++;
						count++;
					}else{
						triplets[0]++;
						triplets[1]++;
						if(triplets[0]>=p)
						{
							count++;
						}
						
					}
				}else if(sum%3==1)
				{
					triplets[0]++;
					if(triplets[0]>=p)
					{
						count++;
					}
				}else if(sum%3==0)
				{
					if(s-used>0 && triplets[0]==p-1)
					{
						triplets[0]++;
						triplets[2]--;
						used++;
						count++;
					}
				}
			}
			i++;
		}
		return count;
	}
}
