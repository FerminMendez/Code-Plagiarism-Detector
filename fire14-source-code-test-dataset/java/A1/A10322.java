import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Dancing {

	public static void main(String[] args) {
		try{
			FileInputStream fstream = new FileInputStream("in.txt");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			FileWriter ostream = new FileWriter("out.txt");
			BufferedWriter out = new BufferedWriter(ostream); 
			int count = Integer.parseInt(br.readLine());
			for(int i=0;i<count;++i) {
				StringTokenizer strLine = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(strLine.nextToken());
				int s = Integer.parseInt(strLine.nextToken());
				int p = Integer.parseInt(strLine.nextToken());
				int ccc = 0;
				for(int j=0;j<n;++j) {
					int d = Integer.parseInt(strLine.nextToken());
					int c = d / 3;
					int r = d - c*3;
					if(c >= p) {
						++ccc;
					}
					
					else {
						if(p-c == 1) {
							if(r > 0)
								++ccc;
							else {
								if(s > 0 && (c-1 >=0)) {
									++ccc;
									--s;
								}
							}
						}
						if(p - c == 2) {
							if(s > 0) {
								if(r == 2) {	
									++ccc;
									--s;
								}
							}
						}
					}
				}
				out.write("Case #"+(i+1)+": " + ccc);
				out.write("\r\n");
				System.out.println("Case #"+(i+1)+": " + ccc);
			}
			//Close the input stream
			in.close();
			out.close();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}	
	}

}
