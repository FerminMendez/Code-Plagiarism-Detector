/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cj2012;

/**
 *
 * @author aaron
 */
public class ACj2012 {

    public static void main(String[] args) {
    //System.out.println(recyclePairs("1111 2222"));
    	dataOut(processData(getData("C-small-attempt0.in")));
    }
    public static int dataOut(String data){
    	java.io.BufferedWriter dst;
    	 try{
            dst = new java.io.BufferedWriter( new java.io.FileWriter("cj.out"));
            dst.write(data);
            dst.close();
            System.out.println("");
        } catch (java.io.IOException e2) {
            System.out.println(e2.getMessage());
        }
    	return 0;
    }
    static boolean isDistinct(String str1, String str2,String strlong){
    	String[] pairs = strlong.split(";");
    		for (int i = 0 ; i < pairs.length; i++){
    		if (pairs[i].equals(str1 + "," + str2)){
    			return false;
    		}
    		else	if  (pairs[i].equals(str2 + "," + str1)){
    				return false;
    		}
    	}
    	return true;
    }
    static int recyclePairs(String data){
    	int num1 = Integer.valueOf(data.split(" ")[0]);
    	int num2 = Integer.valueOf(data.split(" ")[1]);
    	String distinct = "";
    	int c = 0;
    	if (num1 >= 10){
    		for (int i = num1; i <= num2; i++){
    			for (int j = num1; j <= num2 ; j++){
    				if (i!=j){
    					if (isPair(Integer.toString(i),Integer.toString(j))){
    						if (isDistinct(Integer.toString(i),Integer.toString(j),distinct)){
    							c++;
    							distinct += Integer.toString(i) + "," + Integer.toString(j) + ";" ;

    						}
    					}
    				}
    			}
    		}
    	}
    	return c;
    }
    static boolean isPair(String str1, String str2){
    	String strT = str2;
	    	for (int i = 0; i < str1.length() ; i++){
    			strT = strT.substring(strT.length() -1,strT.length())+strT.substring(0,strT.length()-1);
    			if (strT.substring(0,1).equals("0")){
    				return false;
    			} else if (str1.equals(strT)) {
    				return true;
    			}
    		}
    		return false;
    }
    public static String[] getData( String filename){
        java.io.BufferedReader src;
       	String str = "";
       	String[] in = new String[1];
       	int lines = 0;
        try{
            src = new java.io.BufferedReader(new java.io.FileReader(filename));
            str = src.readLine();
            lines = Integer.parseInt(str);
            in = new String[lines];
            for (int i = 0; i<lines; i++){
            	str = src.readLine();
            	in[i] = str;
            }
        } catch (java.io.IOException e2) {
           System.out.println(e2.getMessage());
        }
        return in;
    }
    static String processData(String[] data){
    	String str = "";
    	for(int i = 0; i < data.length;i++){
    		str += "Case #" + (i+1) + ": " + recyclePairs(data[i]) + "\n";
    	}
    	return str.substring(0,str.length() - 1);

    }
}
