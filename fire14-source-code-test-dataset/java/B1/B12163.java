import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class C {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("C-small-attempt1.in"));
		FileWriter fw = new FileWriter("C-small.out");
		/*BufferedReader in = new BufferedReader(new FileReader("C-large.in"));
		FileWriter fw = new FileWriter("C-large.out");*/
                StringTokenizer stn = new StringTokenizer(in.readLine());
                int N = new Integer(stn.nextToken());
                
                for(int i=0;i<N;i++){
                    StringTokenizer st = new StringTokenizer(in.readLine());
                    int A = new Integer(st.nextToken());
                    int B = new Integer(st.nextToken());
                    int cant = 0;
                    for(int j=A;j<B;j++){
                        Vector<Integer> all = new Vector<Integer>();
                        String num = ""+j;
                        for(int x=num.length()-2;x>=0;x--){
                            String poss = num.substring(x+1,num.length())+num.substring(0,x+1);
                            int val = Integer.parseInt(poss);
                            if (val <= B && val > j) {
                            //if (val <= B && val >= A) {
                                /*Boolean found = true;
                                char first = poss.charAt(0);
                                for(int z=1;z<poss.length();z++){
                                    if(first!=poss.charAt(z)){
                                        found = false;
                                        break;
                                    }
                                }
                                if(!found){
                                    //System.out.print(" "+val+" ");
                                    cant++;
                                }*/
                                
                                Boolean found = false;
                                for(int z=0;z<all.size();z++){
                                    int valX = all.elementAt(z);
                                    if(valX == val){
                                       found = true;
                                       break;
                                    }
                                }
                                if(!found){
                                    //System.out.print(val+"\t");
                                    //all.add(new Integer(val));
                                    all.add(new Integer(val));
                                    cant++;
                                }
                                
                                
                                
                                //System.out.print(val+"\t");
                                //cant++;
                            }
                        }
                    }
                    //System.out.println("");
                    //System.out.println(""+(cant));
                    
                    fw.write("Case #" + (i+1) + ": " + cant + "\n");
                }
                

		fw.flush();
		fw.close();
	}

}


