import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;


public class GCJC {

	static HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

	public static void main(String[] args) {
		try {
			FileReader in = new FileReader("C-small-attempt1.in");
			BufferedReader br = new BufferedReader(in);

			File file = new File("./smallC.txt");
			FileWriter fw = new FileWriter(file);

			String line;
			int num = Integer.valueOf(br.readLine());
			int caseNum = 1;

			while ((line = br.readLine()) != null) {

				map = new HashMap<Integer,Integer>();
				StringBuilder sb = new StringBuilder();
				sb.append("Case #" + caseNum + ": ");
				caseNum++;

				int res = 0;
				int a = Integer.valueOf(line.split(" ")[0]);
				int b = Integer.valueOf(line.split(" ")[1]);


				for(int i = a; i <= b ; i++){
					for(int j = 10; j <= i ; j*=10){
						int digit = (int)Math.log10(i) + 1;
						int top = i/j;
						int back = i%j;
						int cycle = (int) (back * Math.pow(10, (digit - (int)Math.log10(j))) + top);
						if(map.get(i) != null && map.get(i) == cycle) continue;
						if(cycle <= b && i < cycle){
							map.put(i, cycle);
							res++;
						}
					}
				}

				sb.append(res);
				fw.write(new String(sb));
				fw.write("\n");
			}

			br.close();
			in.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
