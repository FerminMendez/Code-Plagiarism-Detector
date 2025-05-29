/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Venkatesh
 */
public class reversal {

    
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
       
        int currelement;
        int a,b,ind=1,temp,digits=0,temp1,temp2,count=0;
        boolean samedigits=true;
        boolean next=false;
        LinkedList list=new LinkedList();
        
       
        while(ind<=t)
        {
            samedigits=true;
            next=false;
            digits=0;
          
            a=s.nextInt();
           
            b=s.nextInt();
          
            if(b<10)
            {
                System.out.println("Case #"+ind+": 0");
                ind++;
                continue;
            }
            
            temp=a;
            
            while(temp!=0)
            {
                temp/=10;
                 digits++;
            }
          
            
            int arr[]=new int[digits];
            int barr[]=new int[digits];
            //int mainarray[]=new int[digits];
            
            temp2=b;
            for(int i=digits-1;i>=0;i--)
            {      
                barr[i]=temp2%10;
                temp2/=10;
             
            }
             
            temp=a;
            
            while(temp<=b)
            {
             //   if(temp==1113)
             //      System.exit(0);
               
            //  System.out.println("Examining "+temp);
                 temp1=temp;
                 samedigits=true;
              
            for(int i=digits-1;i>=0;i--)
            {      
                arr[i]=temp1%10;
                temp1/=10;
              // System.out.println(arr[i]);
                
                if(i<digits-1)
                    if(arr[i+1]!=arr[i])
                        samedigits=false;
            }

            if(samedigits)
            {
         //      System.out.println("Same digits");
                temp++;
                continue;
            }
            
          
            //not same start checking
           for(int j=1;j<digits;j++)
           {
        //       System.out.println("checking "+arr[j]);
               if(arr[j]==0)
               {
            //        System.out.println("skipping zero");
                   continue;
               }
               
               if(arr[j]<barr[0])
               {
                   
                   //check for digits of a 
                   if(arr[j] > arr[0])
                   {
                  // System.out.println("Success ");
                   
                       //if already present dont add
                       currelement=arraytoint(arr,j);
                       if(list.contains(currelement)==false)
                       {
                           count++;
                           list.add(currelement);
                       }
                   
                   continue;
                   }
                   else if(j!=0 && arr[j] == arr[0])
                   {
                     //     System.out.println("equal");
                       int g=j;
                       int h=0;
                       while(arr[(++g)%digits] == arr[(++h)%digits])
                       {
                          
                           if((h%digits)==0)
                               break;
                       }
                       
                       if(arr[g%digits]>arr[h%digits])
                       {
                              //System.out.println("Success ");//+arr[g%digits]);
                     //if already present dont add
                       currelement=arraytoint(arr,j);
                       if(list.contains(currelement)==false)
                       {
                           count++;
                           list.add(currelement);
                       }
                               continue;
                       }
                   }
               }
               else
                   if(arr[j]==barr[0])
                   { 
                       
                       int k=0;
                       int newind=j;
                     
                       ++newind;
                       ++k;
                       while(arr[(newind)%digits] ==  barr[(k)%digits])
                       {  
                       //    System.out.println("arr[(newind)%digits] "+newind%digits+" barr[(k)%digits] "+(k)%digits);
                           if((k)%digits==0)
                           {
                                newind=j;
                            //check for digits of a 
                             if(arr[newind%digits] > arr[0])
                             {
                              //System.out.println("Success ");//+arr[newind%digits]);
                             //if already present dont add
                       currelement=arraytoint(arr,j);
                       if(list.contains(currelement)==false)
                       {
                           count++;
                           list.add(currelement);
                       }
                              next=true;
                              break;
                             }
                             else if(newind%digits!=0 && arr[newind%digits] == arr[0])
                             {
                                 int g=newind%digits;
                                 int h=0;
                                while(arr[(++g)%digits] == arr[(++h)%digits])
                                 {
                                  if((h%digits)==0)
                                  break;
                                 }
                               if(arr[g%digits]>arr[h%digits])
                               {
                                  //System.out.println("Success ");//+arr[g%digits]);
                             
                                   //if already present dont add
                       currelement=arraytoint(arr,j);
                       if(list.contains(currelement)==false)
                       {
                           count++;
                           list.add(currelement);
                       }
                                      next=true;
                                    break;
                                }
                             }
                          //end of proc
                           }
                           newind++;
                           ++k;
                       }
                       
                        if(next)
                        {
                            next=false;
                            continue;
                        }
                       if(arr[newind%digits]< barr[k%digits])
                       {  
                    //         System.out.println("arr[newind%digits]< barr[k%digits] "+newind%digits+" "+ k%digits);
                              newind=j;
                             //check for digits of a 
                             if(arr[newind%digits] > arr[0])
                             {
                             //System.out.println("Success ");//+arr[newind%digits]);
                            //if already present dont add
                       currelement=arraytoint(arr,j);
                       if(list.contains(currelement)==false)
                       {
                           count++;
                           list.add(currelement);
                       }
                             }
                             else if(newind%digits!=0 && arr[newind%digits] == arr[0])
                             {
                                 int g=newind%digits;
                                 int h=0;
                                while(arr[(++g)%digits] == arr[(++h)%digits])
                                 {
                                  if((h%digits)==0)
                                  break;
                                 }
                               if(arr[g%digits]>arr[h%digits])
                               {
                                  //System.out.println("Success ");//+arr[g%digits]);
                                  //if already present dont add
                       currelement=arraytoint(arr,j);
                       if(list.contains(currelement)==false)
                       {
                           count++;
                           list.add(currelement);
                       }
                                }
                             }
                          //end of proc
                       }
                   }
                 }
           
                 temp++;
                 list.removeAll(list);
               }
            System.out.println("Case #"+ind+": "+count);
            ind++;
            count=0;
    }
        
  
}
    
        static int arraytoint(int[] b,int index)
        {
            int i=0,temp;
            int len=b.length;
            int a[]=new int [len];
            
            temp=a[index];
            for(int j=0;j<len;j++)
            {
                a[j]=b[(j+index)%len];
                
            }
           
            
           for(int ind=0;ind<len;ind++)
           {
               i+=a[ind]*Math.pow(10,len-ind-1);
           }
         
            return i;
        }
}