/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rotatematrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author FARHAN
 */
public class Combination {
int count =0;
int num =10;
int size=0;
    int Tranverse(int A,int B){
    count=0;
    num = 1;
    size =0;
    while(A/num!=0){
    num = num*10;
    size++;
    }
    num = num/10;
        for (int m = B; m >0 ; m--) {
            for(int n = A;n<m;n++){
            if(isFoundFast(n,m)){
             //   System.out.println("Found");
            }
            }
        }
       
        return count;
    }

  boolean isFoundFast(int n,int m){
  for(int i=0;i<size&&n>9;i++){
  int rem = n%num;
  int x = n/num;
  rem *= 10;
  rem += x;
  if(rem==m){
      //sSystem.out.println("found"+rem+" "+m);
      count++;
  }
  n = rem;
  }
  return false;
  }
   boolean isFound(int n,int m){
       String n_Str = Integer.toString(n);
       n_Str = n_Str.replaceAll("^0*", "");
       String m_Str = Integer.toString(m);
       m_Str = m_Str.replaceAll("^0*", "");
       int size = n_Str.length();
//       for(int i=0;i<size;i++){
//       String result = n_Str;
//       result = result.replaceAll("^0*", "");
//       if(result.compareTo(m_Str)==0){
//         //  System.out.println(result+"=="+m_Str);
//           count++;
//       }
//       // System.out.println(n_Str+"=="+m_Str);
//       ArrayList list = getMyList(n_Str);
//       char c= n_Str.charAt(0);
//       list.remove(0);
//       list.add(c);
//        n_Str = list.toString();
//        n_Str = n_Str.replace("[","");
//        n_Str = n_Str.replace("]", "");
//        n_Str = n_Str.replace(",", "");
//        n_Str = n_Str.replace(" ", "");
//
//       }
       return false;
   }


 ArrayList getMyList(String x){
     ArrayList list= new ArrayList();
     for (int i = 0; i < x.length(); i++) {
         list.add(x.charAt(i));
     }
     return list;
 }
}
