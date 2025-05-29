
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class QC {
    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(new File("C-small-attempt0.in"));    
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("output.out"))); 
            int t = sc.nextInt();
            for(int i=0;i<t;i++){
                int a = sc.nextInt();              
                int b = sc.nextInt();
                int r = 0;
                if(a>=100 && a<1000){
                    for(int p=1;p<10;p++){
                        for(int q=0;q<10;q++){
                            if(p==q)continue;
                            int e = 0,m = 0;
                            m = 100*q+10*p+p; if(m>=a && m<=b) e++;
                            m = 100*p+10*q+p; if(m>=a && m<=b) e++;
                            m = 100*p+10*p+q; if(m>=a && m<=b) e++;
                            if(e==3) r += 3;
                            else if(e==2) r += 1;
                        }
                    }
                    for(int p=0;p<10;p++){
                        for(int q=p+1;q<10;q++){
                            for(int s=q+1;s<10;s++){
                                int e = 0,m = 0;
                                m = 100*p+10*q+s; if(m>=a && m<=b) e++;
                                m = 100*q+10*s+p; if(m>=a && m<=b) e++;
                                m = 100*s+10*p+q; if(m>=a && m<=b) e++;
                                if(e==3) r += 3;
                                else if(e==2) r += 1;
                                
                                e = 0;
                                m = 100*p+10*s+q; if(m>=a && m<=b) e++;
                                m = 100*s+10*q+p; if(m>=a && m<=b) e++;
                                m = 100*q+10*p+s; if(m>=a && m<=b) e++;
                                if(e==3) r += 3;
                                else if(e==2) r += 1;
                            }
                        }
                    }
                }
                else if(a>=10){
                    for(int p=1;p<10;p++){
                        for(int q=p+1;q<10;q++){
                            if(p*10+q>=a && p*10+q<=b && q*10+p>=a && q*10+p<=b) r++;
                        }
                    }
                }
                bw.write("Case #"+String.valueOf(i+1)+": ");
                bw.write(String.valueOf(r));
                bw.newLine();
                bw.flush();
            }
            bw.close();

        } catch (Exception ex) {
            Logger.getLogger(QA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
