import java.util.ArrayList;
import java.util.Arrays;


public class ProbB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> in=Utils.readFile("B-small-attempt0.in.in");
		ArrayList<String> out =new ArrayList<String>();
		for (int i = 1; i < in.size(); i++) {
			String[] str=in.get(i).split(" ");
			int n= Integer.parseInt(str[0]);
			int surprise=Integer.parseInt(str[1]);
			int p=Integer.parseInt(str[2]);
			int[] elem=new int[n];
			for (int j = 0; j < n; j++) {
				elem[j]=Integer.parseInt(str[j+3]);				
			}
			Arrays.sort(elem);
			int count=0;
			for (int j = elem.length-1; j >=0 ; j--) {
				if(elem[j]>=(3*p-2)){
					count++;
				}else if(elem[j]>=(3*p-4)){
					if(surprise==0||p==1){
						break;
					}else{
						count++;
						surprise--;
					}
				}else{
					break;
				}
			}
			out.add("Case #"+i+": "+count);
			Utils.writeFile(out, "B-small-attempt0");
		}
		

	}

}
