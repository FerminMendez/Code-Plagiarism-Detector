package gcjqrpb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class gcjqrpb {

    public static void main(String[] args) {
        //variables
        int T=0;
        ArrayList<Integer> N=new ArrayList<Integer>();
        ArrayList<Integer> S=new ArrayList<Integer>();
        ArrayList<Integer> p=new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> t=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> y=new ArrayList<Integer>();
        //Leo
        File archin=new File(args[0]);
        FileReader in=null;
        BufferedReader bin=null;
        try{
            in=new FileReader(archin);
            bin=new BufferedReader(in);
            T=Integer.parseInt(bin.readLine());
            for(int i=0;i<T;i++){
                StringTokenizer st=new StringTokenizer(bin.readLine());
                N.add(Integer.parseInt(st.nextToken()));
                S.add(Integer.parseInt(st.nextToken()));
                p.add(Integer.parseInt(st.nextToken()));
                t.add(new ArrayList<Integer>());
                for(int j=0;j<N.get(i);j++){
                    t.get(i).add(Integer.parseInt(st.nextToken()));
                }
                y.add(0);
            }
        }catch(Exception ex){
        }finally{
            try{
                bin.close();
            }catch(Exception ex){
            }
            try{
                in.close();
            }catch(Exception ex){
            }
        }
        //Proceso
        for(int i=0;i<T;i++){
            for(int j=0;j<N.get(i);j++){
                if(t.get(i).get(j)>=(3*p.get(i).intValue()-2)){
                    y.set(i,y.get(i)+1);
                }else{
                    if((S.get(i)>0)&&(t.get(i).get(j)>1)&&(t.get(i).get(j)>=(3*p.get(i).intValue()-4))){
                        y.set(i,y.get(i)+1);
                        S.set(i,S.get(i)-1);
                    }
                }
            }
        }
        //Escribo
        File archout=new File("out.txt");
        FileWriter out=null;
        BufferedWriter bout=null;
        try{
            out=new FileWriter(archout);
            bout=new BufferedWriter(out);
            for(int i=0;i<T;i++){
                if(i>0){
                    bout.newLine();
                }
                bout.write("Case #"+(i+1)+": "+y.get(i));
            }
        }catch(Exception ex){
        }finally{
            try{
                bout.close();
            }catch(Exception ex){
            }
            try{
                out.close();
            }catch(Exception ex){
            }
        }
    }
}
