import java.util.Scanner;

class Main{

	public static void main(String[] args){
		Scanner S= new Scanner(System.in);
		int T= S.nextInt(),i,j; //Variables de Control
		int n,s,p,val; //Variables del Problema
		int score,aux;
		for(i=0;i<T;i++){
			n= S.nextInt();
			s= S.nextInt();
			p= S.nextInt();
			val=0;
			for(j=0;j<n;j++){
				score= S.nextInt();
				aux= (int)(Math.ceil(score/3.0));
				if(aux>=p){
					val++;
				}else if((score%3==2 || score%3==0) && score>1 && score<29 && s>0 && (aux+1)==p){
					val++;
					s--;
				}
			}
			System.out.println("Case #" + (i+1) + ": " + val);
		}
	}

}