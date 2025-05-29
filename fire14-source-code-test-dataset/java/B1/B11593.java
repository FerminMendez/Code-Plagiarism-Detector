import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args){
		StringBuffer fileData = new StringBuffer(1000000);
        BufferedReader reader = null;
		try {
			reader = new BufferedReader(
			        new FileReader("C-small-attempt0.in"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        char[] buf = new char[1024];
        int numRead=0;
        try {
			while((numRead=reader.read(buf)) != -1){
			    String readData = String.valueOf(buf, 0, numRead);
			    fileData.append(readData);
			    buf = new char[1024];
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter("result.txt"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        String inputString=fileData.toString();
        StringTokenizer st=new StringTokenizer(inputString);
        int noOfcase=Integer.parseInt(st.nextToken());
        for(int i=1;i<=noOfcase;i++){
        	int A=Integer.parseInt(st.nextToken());
        	int B=Integer.parseInt(st.nextToken());
        	String B_string=String.valueOf(B);
			int B_length=B_string.length();
        	int max=0;
        	for(int n=A;n<B;n++){
        		String n_string=String.valueOf(n);
    			int n_length=n_string.length();
        		for(;n_length<=B_length;n_length++){
        			int local_max=0;
        			for(int k=1;k<n_length;k++){
        				String m_string=n_string.substring(n_length-k, n_length)+n_string.substring(0,n_length-k);
        				int m=Integer.parseInt(m_string);
        				if( m>n && m<=B){
        					local_max++;
        				}
        			}
        			if(local_max > 0 && n_length%2==0){
        				if(n_string.substring(0, n_length/2).equals(n_string.substring(n_length/2, n_length)))
        					local_max/=2;
        			}
        			max+=local_max;
        			n_string="0"+n_string;
        		}
        	}
			try {
	        	out.write("Case #"+i+": "+max);
	        	out.newLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
