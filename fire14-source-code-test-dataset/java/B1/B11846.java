package info.m3o.gcj2012.recyclednumber;

import java.util.HashMap;

public class MyNumberStringPair implements Comparable<MyNumberStringPair> {

	protected String s1;
	protected String s2;
		
	public MyNumberStringPair(String str1, String str2){
/*		assert (str1.compareTo(str2) != 0) : "Identical Strings cannot be paired.";
		if (str1.compareTo(str2) != 0){
			return;
		}
*/
		if (str1.compareTo(str2) < 0 ){
			s1 = new String(str1);
			s2 = new String(str2);
		}
		else{
			s1 = new String(str2);
			s2 = new String(str1);
		}
	}

	public String getS1() {
		return s1;
	}


	public void setS1(String s1) {
		this.s1 = s1;
	}


	public String getS2() {
		return s2;
	}


	public void setS2(String s2) {
		this.s2 = s2;
	}


	@Override
	public int compareTo(MyNumberStringPair o) {
		// TODO Auto-generated method stub
		int c1, c2;
		c1 =this.s1.compareTo(o.s1);
		c2 = this.s2.compareTo(o.s2);

		if ((c1 == 0 ) && (c2 ==0))	
			return 0;

		if ( c1 != 0 ){
			return c1;
		}
		return c2;


	}


	

}
