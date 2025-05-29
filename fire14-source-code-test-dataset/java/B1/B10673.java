package C;
import java.io.*;

import java.util.ArrayList;
public class Main {


    public static void main(String[] args) {
        new Main().go();
    }


    public void go() {
        BufferedReader in = null;
        BufferedWriter out = null;
        try{
            in = new BufferedReader(new FileReader("C-small-attempt0.in"));
            out = new BufferedWriter(new FileWriter("C-small-attempt0.out"));
            int T = Integer.parseInt(in.readLine());
            System.out.println("T="+T);

            for(int i=0;i<T;i++){

                String[] line = in.readLine().split(" ");
                int A = Integer.parseInt(line[0]);
                int B = Integer.parseInt(line[1]);

                int win = 0;

                for(int x=A;x<B;x++){
                    int n=x;
                    if(n<10){
                        continue;
                    }
                    String N = Integer.toString(n);
                    int len = N.length();
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    for(int k=1;k<len;k++){
                        String M = "";
                        for(int y=0;y<len;y++){
                             M = M + N.charAt((k+y)%len);
                        }
                        int m = Integer.parseInt(M);
                        if(m<=B&&m>n) {
                            boolean iswin = true;
                            for(int y=0;y<list.size();y++){
                                if(m==list.get(y)){
                                    iswin = false;
                                    break;
                                }
                            }
                            if(iswin){
                                win++;
                                list.add(m);
                            }
                        }
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

