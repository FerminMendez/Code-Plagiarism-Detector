import java.util.Scanner;


public class Two {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner (System.in);
		int cases=s.nextInt();
		for(int i=0;i<cases;i++){
			int total=0;
			int num=s.nextInt();
			int suprising=s.nextInt();
			int cutoff=s.nextInt();
			for(int j=0;j<num;j++){
				int par=s.nextInt();
				if(par>=cutoff+(cutoff-1)*2){
					total++;
				}
				else if(suprising>0 && par>=cutoff+Math.max(0, (cutoff-2)*2)){
					total++;
					suprising--;
					
				}
				else if(par<cutoff+(cutoff-2)*2)
					;
				
			}
			System.out.println("Case #"+(i+1)+": "+total);
		}
	}

}
