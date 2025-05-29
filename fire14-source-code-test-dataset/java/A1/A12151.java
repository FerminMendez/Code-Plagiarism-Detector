import java.io.*;

public class Prof2ProB {
    public static void main(String args[]) {
        try {
            BufferedReader breader = new BufferedReader(new FileReader("F:\\test.txt"));
            int noo;
            noo= Integer.parseInt(breader.readLine());

            int casen=0;
            int noofgglrs;
            int specialcases;
            int maxnumber,i;
            String tempstr;
            String outp;
            outp="";
            String nos[];
            int tmp;
            int count;

            while( casen < noo ) {
                tempstr = breader.readLine();
                nos = tempstr.split(" ");
                outp += "Case #"+(casen+1)+": ";

                noofgglrs = Integer.parseInt(nos[0]);
                specialcases = Integer.parseInt(nos[1]);
                maxnumber = Integer.parseInt(nos[2]);

                count = 0;

                for(i=0;i<noofgglrs;i++) {
                    tmp = Integer.parseInt(nos[i+3]);

                    if( tmp / 3 >= maxnumber )
                        count++;
                    else if( tmp%3 == 1 && (tmp/3)+(tmp%3) >= maxnumber) {
                        System.out.println("here2:" + tmp);
                        count++;
                    }
                    else if( tmp%3 == 2 && specialcases > 0 && (tmp%3)+(tmp/3) >= maxnumber ) {
                        System.out.println("here: " + tmp);
                        count++;
                        specialcases--;
                    }
                    else if( tmp%3 == 2 && ((tmp/3)+((tmp/3)+1)*2) == tmp && (tmp/3)+1>=maxnumber ) {
                        System.out.println("here3: " + tmp);
                        count++;
                    }
                    else if( tmp!=0 && tmp%3 == 0 && specialcases > 0 && (tmp/3)+1 >= maxnumber ) {
                        System.out.println("here1: " + tmp);
                        count++;
                        specialcases--;
                    }
                }
                outp += count;
                if( casen != noo-1 )
                    outp += "\n";
                casen++;
            }
            System.out.println(outp);

            BufferedWriter bwrtr = new BufferedWriter( new FileWriter("F:\\result.txt"));
            bwrtr.write(outp);
            bwrtr.close();
            breader.close();
        }
        catch( Exception e ) {
            e.printStackTrace();
        }
    }
}
