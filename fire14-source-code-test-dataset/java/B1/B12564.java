import java.util.Scanner;

public class CodeC{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int tcase;
		int a, b;
		int numDigit;
		int num;
		
		tcase=sc.nextInt();
		for(int q=1;q<=tcase;q++){
			a=sc.nextInt();
			b=sc.nextInt();
			num=0;
			for(int i=a;i<=b;i++){
				numDigit=(i+"").length();
				int j=i+1;
				int limit=10*j;
				if(limit>b){
					limit=b;
				}
				//System.out.println("DIGIT "+numDigit+" LIMIT "+j+" - "+limit);
				for(;j<=limit;j++){
					String bil=i+"";
					for(int k=0;k<numDigit-1;k++){
						char kanan=bil.charAt(bil.length()-1);
						//System.out.println("AWAL "+bil+"\nKANAN "+kanan);
						bil=kanan+bil.substring(0,bil.length()-1);
						//System.out.println("UBAH "+bil);
						//System.out.println("A "+i+" B "+j+" "+bil.equals(j+""));
						if(bil.equals(j+"")){
							//System.out.println("A "+i+" B "+j);
							num++;
							break;
						}
					}
				}
			}
			System.out.println("Case #"+q+": "+num);
		}
	}
}