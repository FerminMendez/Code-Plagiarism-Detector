/**
 * 
 * @author luoyuan
 *
 */
package codejam;

import java.util.ArrayList;
import static java.lang.Math.*;

public class Dancing {

	public static void bestResult(String inF,String outF) {
		InOutTool iot = new InOutTool(inF,outF);
		ArrayList<String> js = new ArrayList<String>();
		for(int i=1;i<iot.size();i++){
			String in = iot.get(i).trim();
			String[] num = in.split(" ");
			int n = Integer.parseInt(num[0]), s = Integer.parseInt(num[1]), p = Integer.parseInt(num[2]);
			int sup=0,count=0;
			for(int k=3;k<num.length;k++){
				int i_0=0,i_1=0,i_2=0;
				int temp = Integer.parseInt(num[k]);
				i_0 = temp/3;
				if(i_0>=p){
					count ++;
				}else{
					if(i_0<(p-2)||(temp-i_0)<p||(temp-i_0)>(2*p+2)||(temp-i_0)<(2*p-2)){
						//no case want
					}else{//maybe surprising cases
						i_1 = p; i_2 = temp - i_0 - i_1;
						count ++;
						if(abs(i_2-i_0)>1||abs(i_2-i_1)>1)sup ++;
					}
				}
			}
			if(sup>s)count -= (sup-s);
			js.add("Case #" + i + ": " + count);
		}
		iot.clear();iot.addAll(js);
		iot.outText();
	}
	public static void main(String...args){
		Dancing.bestResult("B-small-attempt0.in", "B-small-attempt0.out");
	}
}
