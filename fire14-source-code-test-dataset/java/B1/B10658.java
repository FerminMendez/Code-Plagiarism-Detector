import java.util.ArrayList;
import java.io.IOException;


public class exo2 {
	
	public static ArrayList<Integer> listeCouple = new ArrayList<Integer>() ;

	public static int T;
	public static int A ;
	public static int B ;
	public static int Result = 0 ;
	static int k ;
	static int l ;
	static int m ;
	static int n ;
	static int o ;
	static int p ;
	static int q ;
	
	public static void digit2(int A,int B,int D){
		k = D%10 ;
		l = (D-k)/10 ;
		if((k*10+l)>=A && (k*10+l)<=B && !listeCouple.contains(k*10+l)
				&& (k*10+l)>D){
			Result = Result + 1 ;
			listeCouple.add(k*10+l);
		}
	}
	public static void digit3(int A,int B,int D){
		k = D%10 ;
		l = ((D-k)%100) /10;
		m = (D-l*10-k ) /100;
		if ((k*100+m*10+l)>=A &&(k*100+m*10+l)<=B //&& !listeCouple.contains(k*100+m*10+l)
				&& (k*100+m*10+l)>D ) {
			Result = Result + 1 ;	
			//listeCouple.add(k*100+m*10+l);

		}
		if ((l*100+k*10+m)>=A &&(l*100+k*10+m)<=B //&& !listeCouple.contains(l*100+k*10+m)
				&&(l*100+k*10+m)>D ) {
			Result = Result + 1 ;
			//listeCouple.add(l*100+k*10+m);
		}
	}
	public static void digit4(int A,int B,int D){
		k = D%10 ;
		l = ((D-k)%100) /10;
		m = (D-l*10-k)%1000 /100 ;
		n = (D-m*100-l*10-k)/1000;
		if ((k*1000+n*100+m*10+l)>=A && (k*1000+n*100+m*10+l)<=B //&& !listeCouple.contains(l*1000+k*100+n*10+m) 
				&&(k*1000+n*100+m*10+l)>D ){
			Result = Result + 1 ;	
			//listeCouple.add(k*1000+n*100+m*10+l);
		}		
		if ((l*1000+k*100+n*10+m)>=A &&(l*1000+k*100+n*10+m)<=B //&& !listeCouple.contains(l*1000+k*100+n*10+m)
				&&(l*1000+k*100+n*10+m)>D ){
			Result = Result + 1 ;
			//listeCouple.add(l*1000+k*100+n*10+m);
		}
		if ((m*1000+l*100+k*10+n)>=A &&(m*1000+l*100+k*10+n)<=B //&& !listeCouple.contains(l*1000+k*100+n*10+m)
				&&(m*1000+l*100+k*10+n)>D ){
			Result = Result + 1 ;
			//listeCouple.add(m*1000+l*100+k*10+n);
		}
	}
	public static void digit5(int A,int B,int D){
		k = D%10 ;
		l = ((D-k)%100) /10;
		m = (D-l*10-k)%1000 /100 ;
		n = ((D-m*100-l*10-k)%10000) / 1000;
		o = (D-n*1000-m*100-l*10-k)/10000 ;
		if ((k*10000+o*1000+n*100+m*10+l)>=A && (k*10000+o*1000+n*100+m*10+l)<=B && !listeCouple.contains(k*10000+o*1000+n*100+m*10+l)) {
			Result = Result + 1 ;
			listeCouple.add(k*10000+o*1000+n*100+m*10+l);
		}
		if ((l*10000+k*1000+o*100+n*10+m)>=A && (l*10000+k*1000+o*100+n*10+m)<=B && !listeCouple.contains(l*10000+k*1000+o*100+n*10+m) ) {
			Result = Result + 1 ;
			listeCouple.add(l*10000+k*1000+o*100+n*10+m);	
		}
		if ((m*10000+l*1000*k*100+o*10+n)>=A && (m*10000+l*1000*k*100+o*10+n)<=B  && !listeCouple.contains(m*10000+l*1000*k*100+o*10+n)){
			Result = Result + 1 ;
			listeCouple.add(m*10000+l*1000*k*100+o*10+n);	
		}
		if ((n*10000+m*1000*l*100+k*10+o)>=A && (n*10000+m*1000*l*100+k*10+o)<=B  && !listeCouple.contains(n*10000+m*1000*l*100+k*10+o)){
			Result = Result + 1 ;
			listeCouple.add(m*10000+l*1000*k*100+o*10+n);	
		}
	}
	public static void digit6(int A,int B, int D){
		k = D%10 ;
		l = ((D-k)%100) /10;
		m = (D-l*10-k)%1000 /100 ;
		n = ((D-m*100-l*10-k)%10000) / 1000;
		o = ((D-n*1000-m*100-l*10-k)%100000) /10000;
		p = (D-o*10000-n*1000-m*100-l*10-k)/100000 ;
		if ((k*100000+p*10000+p*1000+n*100+m*10+l)>=A && (k*100000+p*10000+p*1000+n*100+m*10+l)<=B 
				&& !listeCouple.contains(k*100000+p*10000+p*1000+n*100+m*10+l)) {
			Result = Result + 1 ;
			listeCouple.add(k*100000+p*10000+p*1000+n*100+m*10+l);
		}
		if ((l*100000+k*10000+p*1000+o*100+n*10+m)>=A && (l*100000+k*10000+p*1000+o*100+n*10+m)<=B 
				&& !listeCouple.contains(l*100000+k*10000+p*1000+o*100+n*10+m) ) {
			Result = Result + 1 ;
			listeCouple.add(l*100000+k*10000+p*1000+o*100+n*10+m);	
		}
		if ((m*100000+l*10000*k*1000+p*100+o*10+n)>=A && (m*100000+l*10000*k*1000+p*100+o*10+n)<=B  
				&& !listeCouple.contains(m*100000+l*10000*k*1000+p*100+o*10+n)){
			Result = Result + 1 ;
			listeCouple.add(m*100000+l*10000*k*1000+p*100+o*10+n);	
		}
		if ((n*100000+m*10000*l*1000+k*100+p*10+o)>=A && (n*100000+m*10000*l*1000+k*100+p*10+o)<=B  
				&& !listeCouple.contains(n*100000+m*10000*l*1000+k*100+p*10+o)){
			Result = Result + 1 ;
			listeCouple.add(n*100000+m*10000*l*1000+k*100+p*10+o);	
		}
		if ((o*100000+n*10000+m*1000*l*100+k*10+p)>=A && (o*100000+n*10000+m*1000*l*100+k*10+p)<=B  
				&& !listeCouple.contains(o*100000+n*10000+m*1000*l*100+k*10+p)){
			Result = Result + 1 ;
			listeCouple.add(o*100000+n*10000+m*1000*l*100+k*10+p);	
		}
	}
	public static void digit7(int A,int B,int D){
		k = D%10 ;
		l = ((D-k)%100) /10;
		m = (D-l*10-k)%1000 /100 ;
		n = ((D-m*100-l*10-k)%10000) / 1000;
		o = ((D-n*1000-m*100-l*10-k)%100000) /10000;
		p = ((D-o*10000-n*1000-m*100-l*10-k)%1000000)/100000 ;
		q = (D-p*100000-o*10000-n*1000-m*100-l*10-k)/1000000 ;
		if ((k*1000000+q*100000+p*10000+o*1000+n*100+m*10+l)>=A && (k*1000000+q*100000+p*10000+o*1000+n*100+m*10+l)<=B 
				&& !listeCouple.contains(k*1000000+q*100000+p*10000+o*1000+n*100+m*10+l)) {
			Result = Result + 1 ;
			listeCouple.add(k*1000000+q*100000+p*10000+o*1000+n*100+m*10+l);
		}
		if ((l*1000000+k*100000+q*10000+p*1000+o*100+n*10+m)>=A && (l*1000000+k*100000+q*10000+p*1000+o*100+n*10+m)<=B 
				&& !listeCouple.contains(l*1000000+k*100000+q*10000+p*1000+o*100+n*10+m) ) {
			Result = Result + 1 ;
			listeCouple.add(l*1000000+k*100000+q*10000+p*1000+o*100+n*10+m);	
		}
		if ((m*1000000+l*100000+k*10000+q*1000+p*100+o*10+n)>=A && (m*1000000+l*100000+k*10000+q*1000+p*100+o*10+n)<=B  
				&& !listeCouple.contains(m*1000000+l*100000+k*10000+q*1000+p*100+o*10+n)){
			Result = Result + 1 ;
			listeCouple.add(m*1000000+l*100000+k*10000+q*1000+p*100+o*10+n);	
		}
		if ((n*1000000+m*100000+l*10000+k*1000+q*100+p*10+o)>=A && (n*1000000+m*100000+l*10000+k*1000+q*100+p*10+o)<=B  
				&& !listeCouple.contains(n*1000000+m*100000+l*10000+k*1000+q*100+p*10+o)){
			Result = Result + 1 ;
			listeCouple.add(n*1000000+m*100000+l*10000+k*1000+q*100+p*10+o);	
		}
		if ((o*1000000+n*100000+m*10000+l*1000+k*100+q*10+p)>=A && (o*1000000+n*100000+m*10000+l*1000+k*100+q*10+p)<=B  
				&& !listeCouple.contains(o*1000000+n*100000+m*10000+l*1000+k*100+q*10+p)){
			Result = Result + 1 ;
			listeCouple.add(o*1000000+n*100000+m*10000+l*1000+k*100+q*10+p);	
		}
		if ((p*1000000+o*100000+n*10000+m*1000+l*100+k*10+q)>=A && (p*1000000+o*100000+n*10000+m*1000+l*100+k*10+q)<=B  
				&& !listeCouple.contains(p*1000000+o*100000+n*10000+m*1000+l*100+k*10+q)){
			Result = Result + 1 ;
			listeCouple.add(p*1000000+o*100000+n*10000+m*1000+l*100+k*10+q);	
		}
	}

	public static void traiter(int A,int B, int j) {
		int D = A ;
		if (B<10) {
			Result = 0 ;			
		}
		else if (B<=100){
			for (int i=0;i<(B-A);i++){
				digit2(A,B,D+i);
			}
		}
		else if(B<1000){
			for (int i=0;i<(B-A);i++){
				digit3(A,B,D+i);
			}
		}
		else if(B<10000){
			for (int i=0;i<(B-A);i++){
				digit4(A,B,D+i);
			}
		}
		else if(B<100000){
			for (int i=0;i<(B-A);i++){
				digit5(A,B,A+i);
			}
		}
		else if(B<1000000){
			for (int i=0;i<(B-A);i++){
				digit6(A,B,A+i);
			}
		}
		else if(B<10000000){
			for (int i=0;i<(B-A);i++){
				digit7(A,B,A+i);
			}
		}
		
	}
	public static void read(String arg)  throws java.io.IOException {
		java.util.Scanner lecteur ;		
		java.io.File fichier = new java.io.File(arg);
		lecteur = new java.util.Scanner(fichier);
	
		T = lecteur.nextInt() ;
		for (int i=0;i<=T;i++){
			if (lecteur.hasNextInt()){
				A = lecteur.nextInt();
				B = lecteur.nextInt() ;
				traiter(A,B,i);
				System.out.println("Case #"+(i+1)+": "+Result);
			}
			Result = 0 ;
			listeCouple.removeAll(listeCouple) ;
		}	
	}
	

	
	public static void main(String[] args) throws IOException{
		String arg = null;
		arg = "C-small-attempt2.in" ;
		read(arg) ;
	}
}