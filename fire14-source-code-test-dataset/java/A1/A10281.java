
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
public class DancingWithGooglers {
    public static void main(String args[])throws IOException{
     FileReader reader = new FileReader("D:\\NetBeansProjects\\DBInteractionWithWS\\src\\java\\B-small-attempt7.in");
		BufferedReader br = new BufferedReader(reader);
		File file = new File("d:\\rloutput.txt");
		FileWriter fw = new FileWriter(file);
		int count = Integer.parseInt(br.readLine());
		for(int s=0;s<count;s++){
                    List list = new ArrayList();
                    String line = br.readLine();
                    //System.out.println(line);
                    int num = Integer.parseInt(line.split(" ")[0]);
                    int triplets =Integer.parseInt(line.split(" ")[1]);
                    int pendingtriplets = triplets;
                    int highest=Integer.parseInt(line.split(" ")[2]);
                    String splits[]=line.split(" ");
                    int resultCount=0;
                    int surpriseCount=0;
                    for(int i=3;i<num+3;i++){
                        
                     
                        int number =Integer.parseInt(splits[i]);
                        Bean be = new Bean();
                        if(number%3==0){
                        
                            
                            be.first =number/3;
                            be.second=number/3;
                            be.third = number/3;
                            if(be.first>=highest){
                                resultCount++;
                            }
                            
                        }else if(number%3==1){
                            
                            be.first= number/3;
                            be.second = number/3;
                            be.third = (number/3)+1;
                            if(be.third>=highest){
                                    resultCount++;
                                    
                                }
                        
                        }else if(number%3==2){
                            if((number/3)==9){
                                be.first=number/3;
                                be.second=be.first+1;
                                be.third=be.first+1;
                                if(be.second>=highest){
                                    resultCount++;
                                  
                                }
                            }else if(pendingtriplets==0){
                                be.first=number/3;
                                be.second=be.first+1;
                                be.third=be.first+1;
                                if(be.second>=highest){
                                    resultCount++;
                                  
                                }
                            }
                            else{
                                be.first=number/3;
                                be.second=(number/3)+2;
                                be.third=number/3;

                                if(be.second>=highest){
                                    resultCount++;
                                    surpriseCount++;
                                    pendingtriplets--;
                                }
                            }
                        }
                    list.add(be);
                    
                    
                    
                    
                    }
                    //System.out.println("triplets :"+triplets+", surprise "+surpriseCount);
                    
                    if(triplets>surpriseCount){
                         for(int cc=0;cc<list.size();cc++){
                             if(triplets>surpriseCount){
                                 //System.out.println("triplets :"+triplets+", surprise "+surpriseCount);
                             Bean be1 = (Bean)list.get(cc);
                           //  System.out.println(be1.first+","+be1.second+","+be1.third);
                             if(((be1.first==be1.second)&&(be1.second==be1.third))&&be1.first!=10&&be1.first!=0){
                             
                                 if((be1.first+1)>=highest){
                                 
                                     be1.first=be1.first-1;
                                     
                                     be1.third =be1.third+1;
                                     if(!(be1.second>=highest))
                                     resultCount++;
                                     surpriseCount++;
                                    
                                 }else if((be1.first-1)>=highest){
                                     be1.first=be1.first-1;
                                     be1.third =be1.third+1;
                                     if(!(be1.second>=highest))
                                     resultCount++;
                                     surpriseCount++;
                                    
                                 }
                             }
                             
                          //   list.add(cc,be1);
                         }
                         }
                    }
                    System.out.println("Case #"+(s+1)+": "+resultCount);
            }
        }
}
class Bean{
    int first;
    int second;
    int third;
}