
   import java.util.*;

   public class c{
   
      public static void main(String a[]){
      
         Scanner s = new Scanner(System.in);
         
         int n = s.nextInt();
         int array[] = new int[10];
         s.nextLine();
      	
         for(int N=0 ; N<n ; N++){
         
            int from = s.nextInt();
            int to = s.nextInt();
         
            int  numDigits = (from + "").toCharArray().length;
            int propCount = 0;
         
            for(int i = from ; i < to ; i++){
            	
               int j = 10;
               int dFrom = i; 
               int count = 1; 
               int arrayCount = 0;
            	
               while(dFrom/j > 0){
               
                  int rem = dFrom%j;
                  dFrom = dFrom/j;
                  rem *= Math.pow(10, numDigits - count);
                  dFrom += rem;
                  
                  if(dFrom > i && dFrom <=to) {
                     array[arrayCount++] = dFrom;
                  }
                  
                  ++count;
                  dFrom = i;
                  j *= 10;
               }
               
               Arrays.sort(array,0,arrayCount);
            	
            	outer:
               for(int w=0 ; w< arrayCount; w++){
                  for(int x=w + 1 ; x < arrayCount ; x++){
                    
                     if(array[w] == array[x])
                        continue outer;
                  
                  }
                  
                  ++propCount;
               }
            }   
         	  
            System.out.printf("Case #%d: %d\n", N + 1, propCount);
         }
      }
   }