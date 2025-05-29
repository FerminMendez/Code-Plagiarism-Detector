package codejam;

import java.util.*;
import java.text.*;
import java.lang.*;

public class Recycle extends CodeJam {
	
	ArrayList<Pair> pairNumber;
	
	static public void main(String[] args) {
		Recycle codeCycle = new Recycle();

		codeCycle.init("D:\\work\\dev\\codejam\\bin\\codejam\\Recycle\\small.in", "D:\\work\\dev\\codejam\\bin\\codejam\\Recycle\\small.out");
		codeCycle.run();
		
	}
	
	public Recycle() {
		pairNumber = new ArrayList<Pair>();

	}
	
	
	public String getAnswer(String in) {
		pairNumber.clear();
		System.out.format("getAnswer:%s%n", in);
		String ret;
		StringTokenizer st = new StringTokenizer(in," ");
		Long start=0L, end=0L;
		if(st.hasMoreTokens()) {
				start = Long.parseLong(st.nextToken());
				end = Long.parseLong(st.nextToken());
			} 
		ret = String.format("%d", getCount(start,end));
//		int result = board.getBoardRow(yearMonth,monthDay,weekDay);
		return ret;
	}
	
	public long getCount(Long start, Long end) {
		long ret=0;
		long source=0, target=0;
		int loopCount = String.format("%d", start).length();
		Pair pair;
		for(source=start;source<end;source++) {
			target = source;
			for(int j=1;j<loopCount;j++) {
				target = rotate(target,loopCount);
				if(target>=start && target <= end && target != source) {
					pair = new Pair(target, source);
					int index=-1;
					for(int i=0;i<pairNumber.size();i++) {						
						if(pairNumber.get(i).equals(pair)){
							index = i;
							break;
						}						
					}
//					if(pairNumber.contains(pair)) {
					if(index>=0) {
						continue;		
					} else {
						ret++;
						pairNumber.add(pair);
					}
				}
			}
		}


		return ret;
	}
	
	
	public Long rotate(Long in,int strlen) {
		Long ret;
		String tmp;
		char[] zeros = new char[strlen];
	    Arrays.fill(zeros, '0');
	    // format number as String
	    DecimalFormat df = new DecimalFormat(String.valueOf(zeros));	    
		tmp = df.format(in);
		ret = Long.parseLong(String.format("%s%s", tmp.substring(1),tmp.substring(0, 1)));
//		System.out.format("%d->%d%n",in,ret);
		return ret;
	}
}

