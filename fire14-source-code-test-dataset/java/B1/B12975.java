/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Madu
 */
import java.io.*;

public class Ex3 {

    public static void main(String[] args) {

        try {

            FileInputStream fstream = new FileInputStream("C:/Users/Madu/Documents/NetBeansProjects/CodeJamR1Ex1/input/A-small-attempt0.in");
            FileOutputStream fout = new FileOutputStream("C:/Users/Madu/Documents/NetBeansProjects/CodeJamR1Ex1/output/out.txt");
            PrintStream printStream = new PrintStream(fout);
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String inputIlne;
            br.readLine();
            //printStream.println ("Output");
            //Read File Line By Line
            int lineNum = 1;
            while ((inputIlne = br.readLine()) != null) {
                // Print the content on the console

                //##########

                String[] AandB = inputIlne.split(" ");
                int A = Integer.parseInt(AandB[0]);
                int B = Integer.parseInt(AandB[1]);
                int ans = 0;

                int num = A;
                System.out.println(B);
                while (num <= B) {


                    if (num < 10) {                       
                        num++;
                        
                    } else if (num < 100) {
                        
                        int xo = num/10;
                        int recycle1 = (num % 10) * 10 + xo;
                        if (A <= num && num < recycle1 && recycle1 <= B) {
                            ans++;
                        }
                        num++;
                        
                    } else if (num < 1000) {


                        int xoo = num / 100;
                        int recycle1 = (num % 100) * 10 + xoo;
                        if (A <= num && num < recycle1 && recycle1 <= B) {
                            ans++;
                        }

                        int xxo = num / 10;
                        int recycle2 = (num % 10) * 100 + xxo;
                        if (A <= num && num < recycle2 && recycle2 <= B) {
                            ans++;
                        }

                        num++;

                    }

                } //System.out.println(ans);
                    printStream.print("Case #" + lineNum + ": " + ans);
                    lineNum++;
                    printStream.println("");
                
            }


        } catch (Exception e) {
            System.out.println(e.toString());
        }



//        else if(test.length()==4){
//        
//            ans=0;
//            A = Integer.parseInt(test);
//            
//            int num =A;
//            while(num<=B){
//                
//             if(num==1212){num++;continue;}   
//             
//            int xooo = num/1000;    
//            int recycle3 = (num%1000)*10+xooo;
//            if(A<=num&&num<recycle3&&recycle3<=B){
//                ans++;
//            }   
//            
//            int xxoo = num/100;
//            int recycle1 = (num%100)*100+xxoo;
//            if(A<=num&&num<recycle1&&recycle1<=B){
//                ans++;
//            }
//            
//            int xxxo = num/10;
//            int recycle2 = (num%10)*1000+xxxo;
//            if(A<=num&&num<recycle2&&recycle2<=B){
//                ans++;
//            }            
//            
//            num++;
//            
//            }        
//            
//            System.out.println(ans);
//        
//        }

    }
}
