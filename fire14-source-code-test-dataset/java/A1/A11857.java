import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class GCJB {
	public static void main(String[] args) {
		try {
			FileReader in = new FileReader("./B-small-attempt1.in");
			BufferedReader br = new BufferedReader(in);

			File file = new File("./smallB.txt");
			FileWriter fw = new FileWriter(file);

			String line;
			int num = Integer.valueOf(br.readLine());
			int caseNum = 1;

			while ((line = br.readLine()) != null) {

				StringBuilder sb = new StringBuilder();
				sb.append("Case #" + caseNum + ": ");
				caseNum++;

				String[] lineArray = line.split(" ");
				int n = Integer.valueOf(lineArray[0]);
				int s = Integer.valueOf(lineArray[1]);
				int p = Integer.valueOf(lineArray[2]);
				int res = 0;

				for(int i = 3; i < lineArray.length ; i++){
					if(Integer.valueOf(lineArray[i]) == 0){
						if(p == 0) res++;
						continue;
					}

					int m = Integer.valueOf(lineArray[i])%3;
					int d = Integer.valueOf(lineArray[i])/3;

					if(d >= p) res++;
					else if(m == 0){
						if(d >= (p-1) && s != 0){
							res++;
							s--;
						}
					} else if(m == 1){
						if(d >= (p-1))res++;
					} else if(m == 2){
						if(d >= (p-1))res++;
						else if(d >= (p-2) && s != 0){
							res++;
							s--;
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
