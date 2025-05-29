
import java.util.Scanner;


public class code13 {
    
    public static boolean recheck(int n, int m){
    int length= String.valueOf(m).length();
    boolean answer=false;
  
    for(int j=0;j<length;j++){  int r=(int)Math.pow(10,j);
    int e=(int) Math.pow(10,length-j); int p=n/r; int k=n%r;
    int x= k*e; int y= x+p;
    if(y==m){answer = true; break;}else{}}
    return answer;}
    
    public static int sol(int a, int b){
    int ans=0;
    for(int o=a;o<b;o++){
    for(int p=b;p>o;p--){
    if(recheck(o,p)){ans++;}else{}}}
    return ans;}
    public static void main(String[] args) {
       Scanner c = new Scanner(System.in);
     int times=c.nextInt();
     for(int p=0;p<times;p++){
     int s= sol(c.nextInt(),c.nextInt());
      System.out.println("Case #"+(p+1)+":  "+s);
     }
  }
}
