
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author home
 */
public class RecycledNumbers {
      public static void main(String args[])throws IOException{
        FileReader reader = new FileReader("D:\\NetBeansProjects\\DBInteractionWithWS\\src\\java\\C-small-attempt0.in");
		BufferedReader br = new BufferedReader(reader);
		File file = new File("rloutput.txt");
		FileWriter fw = new FileWriter(file);
		int count = Integer.parseInt(br.readLine());
		for(int s=0;s<count;s++){
                   int recycledNumbers=0;
                   String str = br.readLine();
                   //System.out.println(str);
                   int start = Integer.parseInt(str.split(" ")[0]);
                   int end  = Integer.parseInt(str.split(" ")[1]);
                     for(int i=start;i<end;i++){
                         List<String> list = new ArrayList();
                         if(end<=10)
                             break;
                         else{
                         
                             if(i<=10)
                                 continue;
                             String temp1 = i+"";
                             for(int j=1;j<temp1.length();j++){
                                 
                                 String subString=temp1.substring(temp1.length()-j)+temp1.substring(0,temp1.length()-j);
                                 
                                if(!subString.startsWith("0"))
                                 if(!temp1.equals(subString)){
                                     
                                     if((i<Integer.parseInt(subString))&&(Integer.parseInt(subString)<=end)){
                       
                                          if(list.isEmpty()){
                                                                 //System.out.println(temp1+" : "+subString);
                                              list.add(subString);
                                              recycledNumbers++;
                                          }
                                          else if(!available(subString,list)) {
                                                                 //System.out.println(temp1+" : "+subString);
                                              list.add(subString);
                                              
                                            recycledNumbers++;
                                          }
                                     }
                                 }
                             }
                     
                        }
                     }
                     System.out.println("Case #"+(s+1)+": "+recycledNumbers);
                     
                     
                }
      }
      public static boolean available(String str, List list){
          
          for(int i=0;i<list.size();i++){
              
                 //System.out.println((String)list.get(i));
              
              if(((String)list.get(i)).equals(str)){
                  
                  return true;
              }
          }
          
          return false;
      }
}
