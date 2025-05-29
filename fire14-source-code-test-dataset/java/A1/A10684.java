
package codejam;

import java.io.*;

public class DancingWithTheGooglers {

    private BufferedReader br;
    private BufferedWriter wr;
    
    public DancingWithTheGooglers(String filein,String fileout){
        try{
            br = new BufferedReader(new 
                    InputStreamReader(new FileInputStream(filein)));
            wr = new BufferedWriter(new FileWriter(fileout));
            
            int num = 0;
            num = Integer.parseInt(br.readLine());
            
            for (int i = 1;i<=num;i++){
                String buf = br.readLine();
                String[] bufarray = buf.split(" ");
                int n = Integer.parseInt(bufarray[0]);
                int s = Integer.parseInt(bufarray[1]);
                int p = Integer.parseInt(bufarray[2]);
                int numgood = 0;
                for (int j = 3;j<bufarray.length;j++){
                    int now = Integer.parseInt(bufarray[j]);
                    
                    int div = now/3;
                    int mod = now%3;
                    
                    switch(mod){
                        case 0:
                            if (div >= p){
                                numgood++;
                            }else if (s > 0 && div > 0 && div+1 >= p){
                                numgood++;
                                s--;
                            }
                            break;
                        case 1:
                            if (div >= p || div+1 >= p){
                                numgood++;
                            }
                            break;
                        case 2:
                            if (div >= p || div+1 >= p){
                                numgood++;
                            }else if (s > 0 && div+2 >= p){
                                numgood++;
                                s--;
                            }
                            break;
                    }
                }
                String out = "Case #"+i+": "+numgood;
                wr.write(out);
                if (i != num)
                    wr.newLine();
            }
            
            br.close();
            wr.close();
        }catch (IOException e){
            System.out.println("IO failure");
        }
    }
    
    public static void main(String[] args) {
        DancingWithTheGooglers sp = new DancingWithTheGooglers("B-small-attempt2.in","B-small-attempt2.out");
    }
}
