package taskd;

import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;
import java.io.PrintWriter;

public class TaskD {
    
    
    private int sign(int a){
        if(a==0)
            return a;
        return a/Math.abs(a);
    }
    
    private void solve(Scanner in, PrintWriter out, int caseNum){
        int res = 0;
        int Hhalf = in.nextInt();
        int Whalf = in.nextInt();
        int Dhalf = in.nextInt();
        int H = (Hhalf-2)*2;
        int W = (Whalf-2)*2;
        int hX = 0;
        int wX = 0;
        in.next();
        for(int i = 1;i<Hhalf-1;i++){
            String s = in.next();
            int pos = s.indexOf('X');
            if(pos!=-1){
                hX = (i-1)*2 + 1;
                wX = (pos-1)*2 + 1;
            }
        }
        in.next();
        int hToX = H - hX;
        int wToX = W - wX;
        
        int D = Dhalf*2;
        ArrayList<Integer> hR = new ArrayList<Integer>();
        ArrayList<Integer> wR = new ArrayList<Integer>();
        int hCnt = D/H + 1;
        int wCnt = D/W + 1;
        int switcher = 1;
        hR.add(hX);
        wR.add(wX);
        for(int i = 0;i<hCnt;i++){
            int newH = (i+1)*H+switcher*hToX+(1-switcher)*hX;
            hR.add(newH);
            newH = - (i*H + switcher*hX + (1-switcher)*hToX);
            hR.add(newH);
            switcher = 1 - switcher;
        }
        switcher = 1;
        for(int i = 0;i<wCnt;i++){
            int newW = (i+1)*W+switcher*wToX+(1-switcher)*wX;
            wR.add(newW);
            newW = - (i*W + switcher*wX + (1-switcher)*wToX);
            wR.add(newW);
            switcher = 1 - switcher;
        }
        hCnt = hR.size();
        wCnt = wR.size();
        ArrayList<Integer> h = new ArrayList<Integer>();
        ArrayList<Integer> w = new ArrayList<Integer>();
        for(int i = 0;i<hCnt;i++){
            for(int j = 0;j<wCnt;j++){
                if(i+j==0)
                    continue;
                h.add(hR.get(i));
                w.add(wR.get(j));
            }
        }
        int cnt = h.size();
        boolean []used = new boolean[cnt];
        for(int i = 0;i<cnt;i++){
            if(used[i])
                continue;
            int hI = h.get(i);
            int wI = w.get(i);
            int signHI = sign(hI-hX);
            int signWI = sign(wI-wX);
            int minR1 = Integer.MAX_VALUE;
            int minR2 = Integer.MAX_VALUE;
            for(int j = 0;j<cnt;j++){
                int hJ = h.get(j);
                int wJ = w.get(j);
                int signHJ = sign(hJ-hX);
                int signWJ = sign(wJ-wX);
                if ((hX-hI)*wJ+(wI-wX)*hJ+wX*hI-wI*hX == 0 ){
                    used[j] = true;
                    if((signHI==signHJ)&&(signWI==signWJ))
                        minR1 = Math.min(minR1,(wJ-wX)*(wJ-wX)+(hJ-hX)*(hJ-hX));
                    else
                        minR2 = Math.min(minR2,(wJ-wX)*(wJ-wX)+(hJ-hX)*(hJ-hX));
                }
            }
            if(minR1 <=D*D){
                    res++;
            }
            if(minR2 <=D*D){
                    res++;
                }
        }
        out.format("Case #%d: %s\n", caseNum, res);
    }

    public TaskD(){
        
        try{
            Scanner in = new Scanner(new File("D-small-attempt0.in"));
            int T = in.nextInt();
            PrintWriter out = new PrintWriter("Dsmall.out");
            for(int i = 0;i<T;i++){
                solve(in,out,i+1);
            }
            out.close();
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        }
        
    }
    public static void main(String[] args) {
        TaskD instance = new TaskD();
    }
}
