import java.io.File;
import java.util.Scanner;
import java.util.Vector;

class C {
    static int count=0;
    public static void main(String[] args) {
        if(args.length==100){
            System.out.println("Error	::  Please provide input file name as first command line argument");
	    System.out.println("Usage	::  java Main <file_name>");
	    System.out.println("Example	::  java Main A-small-practice.in");
        }
   	else{
            try{
                Scanner input=new Scanner(new File("C-small-attempt2 (1).in"));
                //Scanner input=new Scanner(new File("input.txt"));
                //System.out.println("Reading Input from "+ args[0]+" file");
                int no=input.nextInt();

                int lim[][]=new int[no][2];

                for(int i=0;i<no;i++){
                    lim[i][0]=input.nextInt();
                    lim[i][1]=input.nextInt();
                }

               /*//Display
               for(int i=0;i<no;i++){
                   System.out.println(lim[i][0]+" "+lim[i][1]);
               }*/

               //Alogrithm
               for(int i=0;i<no;i++){
                   for(int j=lim[i][0];j<=lim[i][1];j++){
                       findIt(new Integer(j).toString(),lim[i][1]);
                   }
                   System.out.println("Case #"+(i+1)+": "+ count);
                   count=0;
               }
            }catch(Exception e){
                e.printStackTrace();
             }
        }
   }
   private static void findIt(String s,int limit) {
       Vector old=new Vector();
       if(s.length()!=1)
       for(int i=0,j=s.length()-1;j>0;j--){
           String newS=s.substring(j, s.length())+s.substring(i, j);
           if(!newS.startsWith("0")&&!s.equals(newS)&&new Integer(newS).intValue()>new Integer(s).intValue()&&new Integer(newS).intValue()<=limit){
               if(!old.contains(newS)){
                old.add(newS);
                //System.out.println(newS);
                count++;
               }
           }
       }
   }
}