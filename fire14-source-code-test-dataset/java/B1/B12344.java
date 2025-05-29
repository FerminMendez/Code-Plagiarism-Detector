import java.io.*;

public class recycled {
	private boolean compare(String s1, String s2){
		String s3 = s2+s2;
		boolean result = s3.contains(s1);
		return result;
	}
	private void go() throws Exception {
		File infile = new File("C-small-attempt1.in");
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(infile)));
		int num_of_cases = Integer.parseInt(br.readLine());
		for (int i = 1; i <= num_of_cases; i++) {
			String[] case_str = br.readLine().split(" ");
			int begin_num = Integer.parseInt(case_str[0]);
			int end_num = Integer.parseInt(case_str[1]);
			int satisifed = 0;
			for(int k=begin_num;k<end_num;k++){
				if(k/10==0)continue;
				String cur_num_str = new Integer(k).toString();
				for(int j=k+1;j<=end_num;j++){
					if(compare(cur_num_str,new Integer(j).toString()))
							satisifed++;
				}
			}
			System.out.println("Case #"+i+": "+satisifed);
		}
	}
	public static void main(String[] args){
		try {
			new recycled().go();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
