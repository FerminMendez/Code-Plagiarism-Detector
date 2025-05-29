import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		int casos=1, a, b, n, m, cont;
		while(t!=0){
			a=sc.nextInt();
			b=sc.nextInt();
			if(a>b){
				int aux=a;
				a=b;
				b=aux;
			}
			System.out.printf("Case #%d: ",casos++);
			if(a==b){
				System.out.printf("%d\n",0);
			}else{
				cont=0;
				for(n=a;n<b;n++){					
					for(m=n+1;m<=b;m++){					
						if(isRecycled(n,m)) cont++;
					}
				}
				System.out.printf("%d\n",cont);
			}
			t--;
		}		
	}
	public static boolean isRecycled(int n1, int n2){
		String s1, s2, aux;
		s1 =  String.valueOf( n1 );
		s2 =  String.valueOf( n2 );		
		boolean r = false;		
		for(int i=0;i<s1.length();i++){
			aux="";
			aux=s1.substring(i,s1.length())+s1.substring(0,i);
//			System.out.println(aux);
			if(aux.equals(s2)){
				r=true;
				break;
			}
		}		
		return r;
	}
}
