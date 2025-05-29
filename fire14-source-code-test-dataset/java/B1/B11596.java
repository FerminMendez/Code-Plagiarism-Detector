
import java.io.*;
import java.util.*;

public class codejam2 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File("C-small-attempt0.in");
        FileReader fr = new FileReader(file);
        Scanner ob = new Scanner(fr);
        File outFile = new File("outFile2.txt");
        FileWriter outFilew = new FileWriter(outFile);
        int t,r=1;
        t = ob.nextInt();
        while (t != 0) {
            int a, b;
            a = ob.nextInt();
            b = ob.nextInt();
            int i, j, k, count = 0;
            for (i = a; i < b; i++) {
                j = i;
                int h[]=new int[8];
                int c=0;
                String no = Integer.toString(j);
                for (k = no.length()-1; k>=0;k--) {
                    String temp = "";
                    temp=no.substring(k)+no.substring(0,k);
                    int s = Integer.parseInt(temp);
                    if (s > j && s <= b ) {
                        int flag=0;
                        for(int m=0;m<c;m++){
                            if(h[m]==s)
                                flag=1;
                        }
                        if(flag==0){
                        count++;
                        h[c++]=s;
                        //System.out.println(i+", "+s);
                        }
                    }
                }
            }
            //System.out.println("Case #"+r+": "+count);
            outFilew.append("Case #"+r+": "+count+"\n");
            t--;
            r++;
        }
        outFilew.close();
    }

}
