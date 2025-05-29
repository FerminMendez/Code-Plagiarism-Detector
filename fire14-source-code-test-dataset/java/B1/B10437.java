
package problemc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        BufferedReader input = null;
        try {
            input = new BufferedReader(new FileReader("input.txt"));
            FileOutputStream output = new FileOutputStream("output.txt");
            
            int N = Integer.parseInt(input.readLine());
            for(int i=0; i<N; i++){
                String[] line = input.readLine().split("\\ ");
                int a = Integer.parseInt(line[0]);
                int b = Integer.parseInt(line[1]);
                
                boolean[] check = new boolean[b-a+1];
                for(int j=0; j<b-a+1; j++){
                    check[j]=true;
                }
                int n = 0;
                for(int k=a; k<=b; k++){
                    String r = Integer.toString(k);
                    int l = r.length();
                    if(check[k-a]){
                        int nn = 0;
                        int[] numbers = new int[l];
                        for(int s=1; s<l; s++){
                            int num = Integer.parseInt(r.substring(l-s, l)+r.substring(0, l-s));
                            if(num>=a && num<=b && num!=k){
                                boolean found = false;
                                for(int j=1; j<l; j++){
                                    if(numbers[j]==num){
                                        found=true;
                                    }
                                }
                                if(!found){
                                    nn++;
                                    numbers[s]=num;
                                    check[num-a]=false;
                                    
                                }
                            }else{
                                numbers[s]=0;
                                
                            }
                        }
                        n+=nn*(nn+1)/2;
                        
                    }
                }
                output.write(("Case #"+(i+1)+": "+n+"\n").getBytes());
            }
            
            input.close();
            output.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
