package codejam;

import java.util.ArrayList;

public class RecycledNumbers {

	public static void recycled(String in,String out){
		InOutTool iot = new InOutTool(in,out);
		ArrayList<String> js = new ArrayList<String>();
		for(int i=1;i<iot.size();i++){
			int count = 0;
			String s = iot.get(i).trim();
			String[] num = s.split(" ");
			int f = Integer.parseInt(num[0]);int l = Integer.parseInt(num[1]);
			int n = f+1;
			while(n<=l){
				String ns = String.valueOf(n);
				if(ns.length()>1){
					ArrayList<String> list = new ArrayList<String>();
					for(int k=ns.length()-1;k>0;k--){
						String temp = ns.substring(k) + ns.substring(0, k);//move
						if(!temp.startsWith("0")){
							int t = Integer.parseInt(temp);
							if(t<n&&t>=f&&(String.valueOf(t).length()==ns.length())&&(!list.contains(String.valueOf(t)))){
									list.add(String.valueOf(t));
									count ++;
							}
						}
					}
				}
				n++;
			}
			js.add("Case #" + i + ": " + count);
		}
		iot.clear();iot.addAll(js);
		System.out.println(iot.outText());
	}
	
	public static void main(String...args){
		RecycledNumbers.recycled("C-small-attempt0.in", "C-small-attempt0.out");
	}
}
