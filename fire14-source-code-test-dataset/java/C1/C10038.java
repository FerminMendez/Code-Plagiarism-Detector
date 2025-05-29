/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package problem.d.hall.of.mirrors;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author Park
 */
public class ProblemDHallOfMirrors {

    static int fixD;
    static int count = 0;
    static int s_X=0;static int s_Y=0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        PrintStream out = new PrintStream(new File("/Users/Park/Desktop/output.txt"));
        Scanner in = new Scanner(new File("/Users/Park/Desktop/D-small-attempt1.in"));
        int testCase = Integer.parseInt(in.next());
        for (int n = 0; n < testCase; n++) {
            int memCount = 0;
            int H = Integer.parseInt(in.next());
            int W = Integer.parseInt(in.next());
            int D = Integer.parseInt(in.next());
            int fixH = (2 * H - 3);
            int fixW = (2 * W - 3);
            fixD = 2 * D;
            int h0 = 0;
            int w0 = 0;
            search:
            for (int i = 0; i < H; i++) {
                String subMap = in.next();
                for (int j = 0; j < W; j++) {
                    String X = subMap.substring(j, j + 1);
                    if (X.equals("X")) {
                        h0 = 2 * i - 1;
                        w0 = 2 * j - 1;
                    }
                }
            }
           int d_Left = w0;
           int d_Right = fixW - w0-1;
           int d_Up = h0;
           int d_Down = fixH - h0-1;
            double[] chkM = new double[250000];
            count=0;
            //Right
            calculate(2*d_Right,0,d_Right,d_Up,d_Left,d_Down,chkM);
            memCount+=count;
            count=0;
            //Up
            calculate(2*d_Up,0,d_Up,d_Left,d_Down,d_Right,chkM);
            memCount+=count;
            count=0;
            //Left
            calculate(2*d_Left,0,d_Left,d_Down,d_Right,d_Up,chkM);
            memCount+=count;
            count=0;
            //Down
            calculate(2*d_Down,0,d_Down,d_Right,d_Up,d_Left,chkM);
            memCount+=count;
            count=0;
            
            //

            //
            out.println("Case #" + (n + 1) + ": " + memCount);
            System.out.println("Case #" + (n + 1) + ": " + memCount);
        }
        in.close();
        out.close();
    }

    public static void calculate(int s_X,int s_Y, int tempx,int dy,int dx,int tempy, double[] chkM) {
        boolean chk =true;
        for(int i=0;i<count;i++){
            if(chkM[i]==((double)s_Y)/((double)s_X)){
                chk= false;
                break;
            }
        }
        if (s_X * s_X + s_Y * s_Y > fixD * fixD) {
            return;
        }else if(chk){
            chkM[count]=((double)s_Y)/((double)s_X);
            count++;
            
        }else{
            return;
        }
        calculate(s_X+2 * dx,s_Y,dx,dy,tempx,tempy,chkM);
        calculate(s_X,s_Y+2 * dy,tempx,tempy,dx,dy,chkM);

    }
}
