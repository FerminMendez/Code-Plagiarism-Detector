
import java.io.IOException;
import java.util.Scanner;


public class code12 {
    public static int nosurprise(int n){
    int p= (n/3);
     if(n%3==0){return p;}else{return (p+1);}}
    public static int surprise(int n){
    int p=(n/3);
    if(n%3==2){return (p+2);}else{
        if(n%3==1){return (p+1);}
        else{if(p-1>0){return (p+1);}else{return p;}}}} 
    
    public static int solution(int x, int[] p,int s){
    int sur=s; int ans=0;
    for(int k=0;k<p.length;k++){
    if(nosurprise(p[k])>=x){ans++;}
    else{
    if(sur>0){if(surprise(p[k])>=x){
    ans++;sur--;}else{}}else{}}
    }
    return ans;}
     public static void main(String[] args) throws IOException{
       Scanner c = new Scanner(System.in);
     int times=c.nextInt();
     for(int p=0;p<times;p++){
     int n=c.nextInt(); int surprise=c.nextInt(); int val=c.nextInt();
     int[] ci=new int[n];
     for(int g=0; g<n;g++){
     ci[g]=c.nextInt();}
     int answer= solution(val,ci,surprise);
     System.out.println("Case #"+(p+1)+":  "+answer);}
     }
}
