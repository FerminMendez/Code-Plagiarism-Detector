package t2;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class T1 {
    BufferedWriter out;
    ArrayList<String> list = new ArrayList<String>();
    int i = 1;
    
    
    T1(){
        try {
            out = new BufferedWriter(new FileWriter(new File("output.txt")));
        } catch (IOException ex) {}        
        start();
        try {
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(T1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        T1 t = new T1();
    }

    private void lerArquivo(String input) {
        File f = new File(input);  
        if(!f.exists())  
        {  
            System.exit(-1);  
        }  
        try {  
            BufferedReader in = new BufferedReader(new FileReader(f));  
            String line;  
            int lineCount = 0;  
            in.readLine();
            while((line = in.readLine())!=null)  
            {  
                list.add(line);
            }  
        } catch (Exception e) {}  
    }
    
    private void write(String str){
        str = "Case #"+i+": "+ str + "\n";
            try {
                out.write(str, 0, str.length());
                i++;
            } catch (IOException ex) {
                Logger.getLogger(T1.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        
    private void start(){
        lerArquivo("input.txt");
        for(String str: list){
            int counter = 0;
            StringTokenizer st = new StringTokenizer(str);
            int googlers = Integer.parseInt(st.nextToken());
            int surprising = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            for(int i = 0; i < googlers; i++){
                int score = Integer.parseInt(st.nextToken());
                int base = score / 3;
                if(base >=p)
                    counter++;
                else if(base == 0){
                    if(score >= p && score == 1){
                        counter++;
                    }else if (score >= p && score == 2 && surprising > 0){
                        counter++;
                        surprising--;
                    }                        
                }else if(score%3 == 0){
                    if(base+1 >= p && surprising > 0){
                        surprising--;
                        counter++;
                    }
                }else if((score % 3) == 1){
                    if(base+1 >= p)
                        counter++;                    
                }else if((score%3) == 2){
                    if(base+1 >= p){
                        counter++;
                    }else if(base+2 >= p && surprising > 0){
                        counter++;
                        surprising--;
                    }
                }
            }
            write(""+counter);                    
        }
    }
}
