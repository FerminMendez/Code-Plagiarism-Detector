package t3;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class T2 {
    BufferedWriter out;
    ArrayList<String> list = new ArrayList<String>();
    int i = 1;
    
    
    T2(){
        try {
            out = new BufferedWriter(new FileWriter(new File("output.txt")));
        } catch (IOException ex) {}        
        start();
        try {
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(T2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        T2 t = new T2();
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
                Logger.getLogger(T2.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        
    private void start(){
        lerArquivo("input.txt");
        for(String str: list){
            int counter = 0;
            StringTokenizer st = new StringTokenizer(str);
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            for(int i = A; i < B-1; i++)
                for(int j = i+1; j <= B; j++){
                    if(verify(i, j)){
                            counter++;
                    }
                        
                }
            write(""+counter);                            
        }
    }
    
    private boolean verify(int A, int B){
        int k1 = A;
        int size;
        for(size = 1; size*10 < A; size*=10);
        
        for(int i = 10; i <= A; i*=10){
            k1 = A;
            int temp = k1%i;
            k1 = (k1-temp)/i;
            k1 = (((size*10)/i)*temp) + k1;
            if(k1 == B)
                return true;
        }
        
        
        
        return false;
    }
}
