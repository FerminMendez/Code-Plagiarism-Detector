

package b;
import java.io.*;

public class Main {


    public static void main(String[] args) {
        new Main().go();
    }


    public void go() {
        BufferedReader in = null;
        BufferedWriter out = null;
        try{
            in = new BufferedReader(new FileReader("B-small-attempt0.in"));
            out = new BufferedWriter(new FileWriter("B-small-attempt0.out"));
            int T = Integer.parseInt(in.readLine());
            System.out.println("T="+T);

            for(int i=0;i<T;i++){
                String[] line = in.readLine().split(" ");
                int n = Integer.parseInt(line[0]);
                int s = Integer.parseInt(line[1]);
                int p = Integer.parseInt(line[2]);

                int []t = new int[n];
                for(int a=0;a<n;a++){
                    t[a] = Integer.parseInt(line[3+a]);
                }

                int win = 0;

                for(int b=0;b<n;b++){
                    int ok = t[b]/3;
                    int etr = t[b]%3;

                    switch(etr){
                        case 2:
                            if(ok+1>=p){
                                win++;
                            } else {
                                if(ok+2>=p && s>0){
                                    s--;
                                    win++;
                                }
                            }
                            break;

                        case 1:
                            if(ok+1>=p){
                                win++;
                            }
                            break;

                        case 0:
                            if(ok>=p){
                                win++;
                            } else {
                                if(ok>0 && s>0 && (ok+1)>=p){
                                    s--;
                                    win++;
                                }
                            }
                            break;
                    }

                }


                out.write("Case #"+(i+1)+": "+win+"\n");
                System.out.print("Case #"+(i+1)+": "+win+"\n");
            }
            in.close();
            out.close();
        }catch(Exception e){
            e.printStackTrace();
            try{
                in.close();
                out.close();
            }catch(Exception e1){
                e1.printStackTrace();
            }
        }
        System.out.print("DONE\n");
    }
}
