package codejam;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class QualificationC extends CodeJam {

	public QualificationC(String file) throws Exception {
		super(file);
	}
	
	@Override
	public Object processCase(int caseNumber) throws Exception {
		String readLine = readLine();
		String[] split = readLine.split(" ");
		int a = Integer.parseInt(split[0]);
		int b = Integer.parseInt(split[1]);
		
		Set<String> found = new HashSet<String>();
		
		for (int i = a; i <= b; i++) {
			char[] n = (i+"").toCharArray();
			
			int cN = i;
			String cM = i+"";
		      
			int len = n.length;
			for (int j = 0; j < len; j++) {
				cM = cM.substring(len-1) + cM.substring(0, len - 1);
				int intCm = Integer.parseInt(cM);
				if (intCm <= b && intCm > cN && intCm >= a) {
					found.add(cN+' '+cM);
		        }
			}
		}
		
		return found.size();
		
	}
	
	public static void main(String[] args) throws IOException,
			InterruptedException, Exception {
		
		new QualificationC("C-small-attempt0.in").start();

	}
	
	
}
