import java.util.Scanner;

class Main{
	public static void main(String[] args){
		Scanner S= new Scanner(System.in);
		int T=S.nextInt(), i, j, a, b;
		int val,n,n2,size;
		String aux;
		for(i=0;i<T;i++){
			a=S.nextInt();
			b=S.nextInt();
			val=0;
			if(b>=12){
				for(n=a>12?a:12;n<=b;n++){
					aux= ""+n;
					size=aux.length();
					for(j=1;j<size;j++){
						if(aux.charAt(0)<=aux.charAt(j)){
							n2= Integer.parseInt(aux.substring(j)+aux.substring(0,j));
							if(n2<=b && n2>n) val++;
						}
					}
				}
			}
			System.out.println("Case #" + (i+1) + ": " + val);
		}
	}
}