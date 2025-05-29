import java.util.Scanner;


public class RecycledNum {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0; i<T; i++)
		{
			boolean [] unused = new boolean[2000001];
			int A = sc.nextInt();
			int B = sc.nextInt();
			int numPairs = 0;
			int rot = (int) Math.floor(Math.log10(A));
			int multiplier = (int) Math.pow(10, rot);
			for(int j=A; j<=B; j++)
				unused[j] = true;
			for(int j=A; j<=B; j++)
			{
				if(unused[j])
				{
					unused[j] = false;
					int num = j;
					int numRot = 1;
					for(int k=0; k<rot; k++)
					{
						// rotate
						int part2 = (num%10);
						int part1 = (num/10);
						num = (part2 * multiplier) + part1;
						if(unused[num])
						{
							numRot++;
							unused[num] = false;
						}
					}
					// if numRot >= 2 get numRot C 2
					if(numRot > 1) numPairs += (numRot - 1) * numRot / 2;
				}
			}
			System.out.println("Case #" + (i+1) + ": " + numPairs);

			
		}
	}
}
