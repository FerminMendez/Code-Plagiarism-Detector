
package Qualification;
import Practice.*;
import java.util.*;
import java.io.*;

public class C {
    
    public void ejecutar() throws Exception {
        Scanner sc = new Scanner(new FileReader("/home/gomezluisj/Descargas/C.in"));
	PrintWriter pw = new PrintWriter(new FileWriter("/home/gomezluisj/Descargas/C.out"));
	int caseCnt = sc.nextInt();
        for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
            pw.print("Case #" + (caseNum + 1) + ": ");
            int ini=sc.nextInt();
            int fin=sc.nextInt();
            int res=0;
            for (int i = ini; i < fin; i++) {
                String number=Integer.toString(i);
                List<Integer> lista=new ArrayList<Integer>();
                for (int j = 1; j < number.length(); j++) {
                    String compare=number.substring(j)+number.substring(0, j);
                    
                    int num=Integer.parseInt(compare);
                    if(num>i&&num<=fin){
                        Iterator iter=lista.iterator();
                        int flag=0;
                        while(iter.hasNext()){
                            if((Integer)iter.next()==num){
                                flag=1;
                            }
                        }
                        if (flag==0){
                            res=res+1;
                            lista.add(num);
                        }
                        
//                        System.out.println(""+i+" "+num);
                    }
                }
            }
            pw.println(res);
        }	
        pw.flush();
        pw.close();
        sc.close();
    }
    
    
    public static void main(String[] args) throws Exception {
		new C().ejecutar();
	}
}
