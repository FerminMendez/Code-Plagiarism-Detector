import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;


public class Test{
   public static void main(String[] args)
        throws IOException {

        BufferedReader inputStream = null;
        PrintWriter outputStream   = null;
        //test();
        
        try {
            inputStream = 
                new BufferedReader(new FileReader("test.in"));
            outputStream = 
                new PrintWriter(new FileWriter("test.out"));

            String l;
            l = inputStream.readLine();
            int t = Integer.parseInt(l);
            int i = 1;
            while ((l = inputStream.readLine()) != null) {
                String result = "Case #"+(i++)+": "+getNum(l);
                outputStream.println(result);
                System.out.println(result);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
    
    /*public static void test(){
        int begin = 1111;
        int end   = 2222;
        int valueSize = 4;
        int testValue = begin;
        
        int a = 0;
        for(testValue = begin;testValue<=end;testValue++){
            
            for(int i=1;i<valueSize;i++){
                int tmp = getLeftValue(testValue,valueSize,i);
                if(tmp>testValue&&tmp<end){
                    a++;
                }
            }
        }
        
        System.out.println(a);
    }
    public static int getLeftValue(int testValue,int valueSize,int leftSize){
        
        
        
        if(valueSize==2){
            int a0 = testValue%10;
            int a1 = testValue/10;
            if(a0==0){
                return -1;
            }
            return a0*10+a1;
        }
        else if(valueSize==3){
            if(leftSize==1){
                int a0 = testValue%10;
                int a1 = testValue/10;
                if(a0==0){
                    return -1;
                }
                return a0*100+a1;
            }
            else if(leftSize==2){
                int a0 = testValue%100;
                int a1 = testValue/100;
                if(a0<10){
                    return -1;
                }
                return a0*10+a1;
            }
        }
        else if(valueSize==4){
            if(leftSize==1){
                int a0 = testValue%10;
                int a1 = testValue/10;
                if(a0==0){
                    return -1;
                }
                return a0*1000+a1;
            }
            else if(leftSize==2){
                int a0 = testValue%100;
                int a1 = testValue/100;
                if(a0<10){
                    return -1;
                }
                return a0*100+a1;
            }
            else if(leftSize==3){
                int a0 = testValue%1000;
                int a1 = testValue/1000;
                if(a0<100){
                    return -1;
                }
                return a0*10+a1;
            }
        }
        return 0;
    }*/
    
    public static int getNum(String l){
        
        int valueSize = l.length()/2;
        
        if(valueSize==1){return 0;}
        
        String[] strArray = l.split(" ");
        int begin = Integer.parseInt(strArray[0]);
        int end   = Integer.parseInt(strArray[1]);
        
        end++;
        int testValue = begin;
        int returnValue = 0;
        int i,tmp;
        
        
        while(testValue<end){
            
            for(i=1;i<valueSize;i++){
                tmp = getLeftValue(testValue,valueSize,i);
                if(tmp>testValue&&tmp<end){
                    
                    returnValue++;
                }
           
            }
            
            testValue++;
        }
        
        //for(i=0;i<288;i++){
            //    if(returnValueArray[i]==testValueArray[j]){
            //        if(returnValueArray[j]==testValueArray[i])
            //        System.out.println(testValueArray[i]+" -> "+returnValueArray[i]+"    ("+step[i]+")");
            //          +"       "+testValueArray[i]+" -> "+returnValueArray[i]);
            //    }
            //}
        //}
        
        return returnValue;
    }
    
    public static int getLeftValue(int testValue,int valueSize,int leftSize){
        
        int a0 = testValue%10;
        int a1 = (testValue%100)/10;
        int a2 = (testValue%1000)/100;
        int a3 = (testValue)/1000;
        
        if(valueSize==2){
            if(a0==0){
                return -1;
            }
            return a0*10+a1;
        }
        else if(valueSize==3){
            if(leftSize==1){
                if(a1==0){
                    return -1;
                }
                return a1*100+a0*10+a2;
            }
            else if(leftSize==2){
                if(a0==0){
                    return -1;
                }
                return a0*100+a2*10+a1;
            }
        }
        else if(valueSize==4){
            if(leftSize==1){
                if(a2==0){
                    return -1;
                }
                return a2*1000+a1*100+a0*10+a3;
            }
            else if(leftSize==2){
                if(a1==0){
                    return -1;
                }
                return a1*1000+a0*100+a3*10+a2;
            }
            else if(leftSize==3){
                if(a0==0){
                    return -1;
                }
                return a0*1000+a3*100+a2*10+a1;
            }
        }
        return 0;
    }
}