   import java.util.*;
   import java.io.*;
   public class CodeJamQualC
   {
      public static void main(String[] args)
      {
         try{
            BufferedReader fin = new BufferedReader(new FileReader("input.txt"));
            FileWriter fstream = new FileWriter("output.txt");
            BufferedWriter out = new BufferedWriter(fstream); 
            Scanner src = new Scanner(fin);
            int j = 0;
            while (fin.ready()) {
               if( j > 1)
               {
                  out.write("\n");
               }
               String text = fin.readLine();
               Scanner scanner = new Scanner(text);
               int[] inputs = {0,0};
               int count = 0;
               while(scanner.hasNext())
               {
                  inputs[count] = scanner.nextInt();
                  count++;
               }
               if( j >0)
               {
               	
                  out.write("Case #" + j + ": " + numPairs(inputs[0],inputs[1]));
                  ;
               }
               j++;
            }
            out.close();
         }
            catch(FileNotFoundException e)
            {
               System.out.println("Error");
            }
            catch(IOException e)
            {
               System.out.println("Error");
            }
      
      }
   
   
      public static int numPairs(int input1, int input2)
      {
         int totalnum=0;
         int count = 0;
         
         if(input2 < input1)
            input2 = input1;
         ArrayList[] usedValues = new ArrayList[input2+1];
         for(int i = 0; i <= input2; i++)
         {
            usedValues[i] =  new ArrayList<Integer>();
         }
         int numDigits = (int)Math.floor(Math.log10((double)input1)+ 1);
         for(int i = input1; i <= input2; i++)
         {
         	
            int val = i;
            for(int j = 0; j < numDigits; j++)
            {
               int lastDigit = val % 10;
               val = val / 10;
               val += Math.pow(10,numDigits-1) * lastDigit;
               if(input1 <= val && input2 >= val && val != i && !usedValues[i].contains(val))
               {
                  usedValues[i].add(val);
                  usedValues[val].add(i);
                  count++;
               }
            } 
         }
         //System.out.println(totalnum);
         return count;
      }
   
   }