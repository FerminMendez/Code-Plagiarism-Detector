import java.util.Scanner;
public class Rec {
static Scanner sc =new Scanner(System.in);
public  static void main (String [] args ) {
int n =sc.nextInt();

for (int m =1; m <= n; m++) handleCase(m);
}
public static int a,b;
static void handleCase(int num) {
int sum=0;
 a =sc.nextInt();
 b =sc.nextInt();
for (int i =a; i <=b;i++) {
for (int j =a; j <i;j++) {
if (i==j) continue;
sum +=perm(i, j);
}
}
System.out.println("Case #" +num +": "+sum);
}

static int perm(int j, int k) {
String s =new Integer(j).toString();
//boolean [][] f=new boolean[b-a][b-a];
String t =new Integer(k).toString();
int sum =0;
for (int div =1;div < s.length();div++) {
String r =s.substring(div) +s.substring(0,div);
if (r.equals(t)) {
//if (f [j-a][k-a]) System.out.println(s +"&"+t);
//System.out.println(t+"=" +s+"p"+div);
//f [j-a][k-a] =true;
//f [k-a][j-a] =true;
sum++;
break;
}
}
return sum;
}

}
