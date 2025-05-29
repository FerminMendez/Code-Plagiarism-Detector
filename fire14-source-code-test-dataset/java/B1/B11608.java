import java.io.BufferedReader;
import java.io.File;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.io.FileReader;
public class C {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception  {
		BufferedReader reader = null;
		String fileName = "C-small-attempt2.in";
		String outputFileName=fileName.replace(".in", ".out");
		reader=new BufferedReader(new FileReader(fileName));
		File outFile=new File(outputFileName);
		outFile.createNewFile();
		int T = Integer.parseInt(reader.readLine());
		for (int i = 1; i <=T; i++) {
			StringTokenizer t=new StringTokenizer(reader.readLine()," ");
			int start=Integer.parseInt(t.nextToken());
			int end=Integer.parseInt(t.nextToken());
			int count=0;
			HashMap<String,String> map=new HashMap<String,String>();
			for(int j=start;j<end;j++){
				String s=j+"";
				for(int k=1;k<s.length();k++){
					String ss=s.substring(s.length()-k);
					String es=s.substring(0,s.length()-k);
					if(ss.startsWith("0"))continue;
					int num=Integer.parseInt(ss+""+es);
					if(num<=end && num>=start && num>j){
						String key=j+"_"+num;
						if(map.get(key)==null){
							map.put(key, key);
							count++;
						}
					}
				}
			}
			System.out.println("Case #"+i+": "+count);
		
		}

	}

}
