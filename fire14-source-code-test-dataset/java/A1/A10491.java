import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class QuestionB {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		File fileread = new File("B-small-attempt2.in.txt");
		File filewrite = new File(QuestionB.class.getName() + "output4.txt");
		GCIFileReader fr = new GCIFileReader(fileread);
		GCIFileWriter fw = new GCIFileWriter(filewrite);
		GCIResult res = new GCIResult();
		String s = fr.getLine();
		int n = Integer.parseInt(s);
		for (int i=0; i < n ; i++)
		{
			String l = fr.getLine();
			Scanner sc = new Scanner(l);
			int con = sc.nextInt();
			int spe = sc.nextInt();
			int p   = sc.nextInt();
			int countOk = 0;
			int countOKSpe = 0;
			for (int j = 0 ; j < con ; j++)
			{
				int acon = sc.nextInt();
				if (acon >= p) {
					if ((acon / 3.0) >= (p))
					{
						countOk++;
						continue;
					}
					if (Double.compare((acon / 3.0),(Math.abs(p - 0.7))) >= 0)
					{
						countOk++;
						continue;
					}
					if (Double.compare((acon / 3.0),(Math.abs(p - 2 + 0.5 ))) >=0 )
					{
						countOKSpe++;
						continue;
					}
				}
			}	
			int finalOkSpe = countOKSpe > spe ? spe : countOKSpe;
			int tres = countOk + finalOkSpe;
			res.addCase(String.valueOf(tres));
		}
		fw.writeResult(res);
	}

}
