
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QD {
    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(new File("D-small-attempt0.in"));    
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("output.out"))); 

            int t = sc.nextInt();
            for(int i=0;i<t;i++){
                int h = sc.nextInt();              
                int w = sc.nextInt();
                int d = sc.nextInt()*2;
                int x=0,y=0;
                for(int j=0;j<h;j++){
                    String s = sc.next();
                    for(int k=0;k<w;k++){
                        if(s.charAt(k)=='X'){
                            x = 2*k-1;
                            y = 2*j-1;
                        }
                    }
                }
                h = (h-2)*2;
                w = (w-2)*2;
                int r = 0;
                if(2*x<=d) r++; if(2*(w-x)<=d) r++; if(2*y<=d) r++; if(2*(h-y)<=d) r++;
                if(2*x==w) r += 2*getR(x,y,h,w,d);
                else r += getR(x,y,h,w,d)+getR(w-x,y,h,w,d);
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
    static int getR(int x, int y, int h, int w, int d){
       // System.out.println(x+" "+y+" "+h+" "+w+" "+d);
        int res = 0;
        int[] xv = new int[60];
        int xi = 2;
        xv[0] = 2*x;
        for(;;xi+=2){
            xv[xi-1] = xi*w;
            xv[xi] = xv[xi-1]+2*x;
            if(xv[xi]>d) break;
        }
        boolean[] tr = new boolean[xv[xi]+1];
       // for(int i=0;i<xv.length;i++) System.out.print(xv[i]+" ");
        //System.out.println("");
     F: for(int i=0;i<=xi;i++){
   C:   for(int j=1;;j++){
                int yd = 2*h*(j/2)+2*y*(j%2);// System.out.println(xv[i]+" "+yd);
                if(xv[i]*xv[i]+yd*yd>d*d){
                    if(j==1)break F;
                    else break;
                }
                int part = 0;
                for(int i1=0;i1<j/2;i1++){
                    part += 2*y*xv[i];
                    if(part%yd==0 && tr[part/yd]) continue C;
                    part += 2*(h-y)*xv[i];
                    if(part%yd==0 && tr[part/yd]) continue C;
                }
                //System.out.println(xv[i]+" "+j);
                res++;
            }
        tr[xv[i]] = true;
        } 
        //System.out.println("r= "+res);
        if(2*y==h) return 2*res;
        
        tr = new boolean[xv[xi]+1];
     F: for(int i=0;i<=xi;i++){
   C:   for(int j=1;;j++){
                int yd = 2*h*(j/2)+2*(h-y)*(j%2);
                if(xv[i]*xv[i]+yd*yd>d*d){
                    if(j==1)break F;
                    else break;
                }
                int part = 0;
                for(int i1=0;i1<j/2;i1++){
                    part += 2*(h-y)*xv[i];
                    if(part%yd==0 && tr[part/yd]) continue C;
                    part += 2*y*xv[i];
                    if(part%yd==0 && tr[part/yd]) continue C;
                }
                //System.out.println(xv[i]+" "+j);
                res++;
            }
            tr[xv[i]] = true;
        }     
        //System.out.println("r= "+res);
        return res;
    }
}
