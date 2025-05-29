package ejera;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        String Lista1="abcdefghijklmnopqrstuvwxyz";
        String Lista2="yhesocvxduiglbkrztnwjpfmaq";
        char[] SourceList=Lista1.toCharArray();
        Arrays.sort(SourceList);
        
        File f = new File( "e:/Input/C-small-attempt0.in" );
        BufferedReader entrada;
        entrada = new BufferedReader( new FileReader( f ) );
        int T = Integer.parseInt(entrada.readLine());

        for(int i=0;i<T;i++){
            String[] Datos=entrada.readLine().split(" ");
            int A=Integer.parseInt(Datos[0]);
            int B=Integer.parseInt(Datos[1]);
            int contador=0;

            Set listan=new HashSet();

            for(int n=A;n<=B;n++){
                int lenn=String.valueOf(n).length();
                for(int m=n+1;m<=B;m++){
                    if(lenn!=String.valueOf(m).length()) break;
                    
                    String Cadn=String.valueOf(n);
                    String Cadm=String.valueOf(m);

                    if(Cadn.length()!=Cadm.length()) continue;

                    for(int r=0;r<Cadn.length();r++){
                        String CadRes=Cadn.substring(r)+Cadn.substring(0,r);
                        if(Integer.parseInt(CadRes)==Integer.parseInt(Cadm)){
                            listan.add(Cadn+"/"+Cadm);
                            contador++;
                        }
                    }
                }
            }
            System.out.println("Case #"+(i+1)+": "+listan.size());
        }
    }

}
