import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("C-small-attempt0.in"));
			PrintWriter bw = new PrintWriter(new FileWriter("C-small-attempt0.out"));
			int num = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < num; i++) {
				String[] content=br.readLine().split("[ ]");
				int start=Integer.parseInt(content[0]);
				int end=Integer.parseInt(content[1]);
				int count=0;
				for (int j = start; j <end; j++) {
					int j_num=0;
					int temp=j;
					while(temp!=0)
					{
						temp/=10;
						j_num++;
					}
					int j2_end=end;
					int j_end=(int)Math.pow(10, j_num)-1;
					if(j_end<end)
						j2_end=j_end;
					String srcString=String.valueOf(j);
					//System.out.println("j"+srcString+","+j2_end);
//					char src[srcString.length()];
//					int length=srcString.length();
//					for (int k = 0; k < length; k++) {
//						src[i]=srcString.charAt(i);
//					}
					for (int j2 = j+1; j2 <=j2_end; j2++) {
						String desString=j2+"";
						int lengths=desString.length();
						char[] des = new char[lengths*2];
						for (int k = 0; k < lengths; k++) {
							des[k]=desString.charAt(k);
						}
						for (int l = 0; l < lengths; l++) {
							des[lengths+l]=des[l];
							String reString=new String(des, l+1, lengths);
							//System.out.println(reString+"l");
							if (reString.equals(srcString)) {
								count++;
								break;
							}
						}
					}
				}
				bw.println("Case #"+(i+1)+": "+count );
			}
			
			br.close();
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
