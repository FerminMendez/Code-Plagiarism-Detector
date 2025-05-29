/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package google;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TOSHIBA
 */
public class NewClass1 {

    public NewClass1() {
        FileReader f = null;
        try {
            int n = 0;
            int m = 0;
            f = new FileReader("E:\\t.txt");
            BufferedReader br=new BufferedReader(f);
            String line;
            line = br.readLine();
int numebr=1;

             while ((line = br.readLine()) != null)   {
              // Print the content on the console
                 StringTokenizer st=new StringTokenizer(line);

                 int A=Integer.parseInt(st.nextToken());
                 int B=Integer.parseInt(st.nextToken());
                 
                 System.out.println("Case #"+numebr+": "+getNumberOfRecylecs(A, B));
                 numebr++;
              }






        } catch (Exception ex) {
            Logger.getLogger(NewClass1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private int getNumberOfRecylecs(int A, int B) {

        //A<=n
        //n<m
        //m<=B

        //int TotalNum=0;

        Vector nums=new Vector();
        //HashMap<Integer,Integer> aa=new HashMap<Integer, Integer>();

        for (int m = B; m > A ; m--) {

            Vector temp=rotateInteger(m);
            for (int i = 0; i < temp.size(); i++) {
                int tempInt=Integer.parseInt((String)temp.get(i));

                String ff=m+"";
                if ( tempInt<m && tempInt >= A && ff.length()==((String)temp.get(i)).length()) {

                //System.out.println("nnnnn= "+m+"    ttttt= "+tempInt);

                    //System.out.println(n);
                    //if (!aa.containsKey(n)) {
//                        aa.put(tempInt, 0);
//                        aa.put(n, 0);

                    //if (!nums.contains(tempInt)) {

                Vector vv=new Vector();

                        vv.add(m);
                        vv.add(tempInt);
                        nums.add(vv);
                    //}

                    
                        

                    //}
                    
                    
                }
                
            }

        }




        Vector newe=removeDublication(nums);

        //System.out.println(newe.size());

        return newe.size();
    }



    public static void main(String[] args) {
        new NewClass1();
    }

    private  Vector rotateInteger(int x) {
        String number=x+"";

        Vector v=new Vector();
        for (int i = 0; i < number.length()-1; i++) {
            String newNum=number.charAt(number.length()-1)+number.substring(0, number.length()-1);
            v.add(newNum);
            number=newNum;
        }


//        for (int i = 0; i < v.size(); i++) {
//            System.out.println(v.get(i));
//
//        }

        return v;

    }

    private Vector removeDublication(Vector nums) {

        Vector newData=new Vector();
        for (int i = 0; i < nums.size(); i++) {

            Vector temp=(Vector) nums.get(i);

            if (!isInVector(newData,temp)) {
                newData.add(temp);
            }



        }

        return newData;

    }

    private boolean isInVector(Vector newData, Vector temp) {

        for (int i = 0; i < newData.size(); i++) {

            Vector tempNewData=(Vector) newData.get(i);
            if ((tempNewData.get(0)== temp.get(1)) &&(tempNewData.get(1)== temp.get(0))) {
                return true;
            }

        }
        return false;


    }



}
