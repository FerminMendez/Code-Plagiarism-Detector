import java.util.*;
import java.io.*;

class MyPair<A, B> {
    private A first;
    private B second;

    public MyPair(A first, B second) {
        super();
        this.first = first;
        this.second = second;
    }

    public int hashCode() {
        int hashFirst = first != null ? first.hashCode() : 0;
        int hashSecond = second != null ? second.hashCode() : 0;

        return (hashFirst + hashSecond) * hashSecond + hashFirst;
    }

    public boolean equals(Object other) {
        if (other instanceof MyPair) { //applying instanceof on a null reference variable returns false
                MyPair otherPair = (MyPair) other;
                return 
                ((  this.first == otherPair.first ||
                        ( this.first != null && otherPair.first != null &&
                          this.first.equals(otherPair.first))) &&
                 (      this.second == otherPair.second ||
                        ( this.second != null && otherPair.second != null &&
                          this.second.equals(otherPair.second))) );
        }

        return false;
    }

    public String toString()
    { 
    	return "(" + first + ", " + second + ")"; 
    }

    public A getFirst() {
        return first;
    }

    public void setFirst(A first) {
        this.first = first;
    }

    public B getSecond() {
        return second;
    }

    public void setSecond(B second) {
        this.second = second;
    }
}



public class RecycledNumbers{
  public static void main(String[] args){
    try{
      FileReader fin = new FileReader(args[0]);
      BufferedReader txtFile = new BufferedReader(fin);
    
      //FileWriter fout = new FileWriter(args[1]);
      //BufferedWriter out = new BufferedWriter(fout);
			
      String line = null;     
      line = txtFile.readLine();
      int T = Integer.parseInt(line);
      for(int i = 0; i < T; i ++){
        line = txtFile.readLine();
        StringTokenizer st = new StringTokenizer(line, " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());     
        //ArrayList<Integer> procedNums = new ArrayList<Integer>();
        ArrayList<MyPair<Integer,Integer>> pairs = new ArrayList<MyPair<Integer,Integer>>();
        
        int result = 0;
        for(int n = A; n <= B; n ++){
            int k = 0; int[] digits = new int[8];
            int oldNum = n; int num = n;
            while(num > 0){
                digits[k++] = num % 10;
                num = num / 10;
            }//while            
            if(k == 1) continue;
            int i1;
            for(i1 = 1; i1 < k; i1 ++)
                if(digits[i1] != digits[0]) break;
            if(i1 == k) continue; //all digits are equal
            
            /*for(int i2 = k-1; i2 >= 0; i2 --)
                System.out.print(digits[i2]+" ");
            System.out.println();*/
            
            for(i1 = 1; i1 <= k-1; i1 ++){ //shuffle k-1 times
                int digit = digits[0]; 
                for(int i2 = 1; i2 < k; i2 ++){
                    digits[i2-1] = digits[i2];
                }
                digits[k-1] = digit;
                if(digit == 0) continue;
                
                /*for(int i2 = k-1; i2 >= 0; i2 --)
                    System.out.print(digits[i2]+" ");
                System.out.println();*/
                
                int newNum = digits[k-1];
                for(int i2 = k-2; i2 >= 0; i2 --)
                    newNum = 10*newNum + digits[i2];
                    
                if(newNum > oldNum && newNum <= B){
                    MyPair<Integer,Integer> p = new MyPair<Integer,Integer>(oldNum,newNum);
                    if(pairs.contains(p))
                        continue;
                    pairs.add(p);
                    //System.out.println(oldNum+" "+newNum);
                    result ++;
                }
            }//for           
        }//for
        
        System.out.println("Case #"+Integer.toString(i+1)+": "+Integer.toString(result));
        
        
      }//for(int i = 0; i < T; i ++)
    }//try
    catch(IOException e) {
	e.printStackTrace();
    }
    
    
  }
}

