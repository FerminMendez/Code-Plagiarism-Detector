import java.util.Scanner;


public class Start {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int cases=in.nextInt();
		
		for (int x=1;x<=cases;x++){
			int c=0;
			int num=in.nextInt();
			int surp=in.nextInt();
			int best=in.nextInt();
		//	int[] dancer=new int[num];
			for (int y=0;y<num;y++){
				int dummy=in.nextInt();
				int point=dummy/3;
				int rest=dummy%3;
				if(point>=best)c++;
				else if (point+1>=best &&rest>=1)c++;
				else if (point+2>=best&&surp>0&&rest==2){
					c++;
					surp--;
				}
				else if (point+1>=best && surp>0 && point>0){
					c++;
					surp--;
				}
			}
			System.out.println("Case #"+x+": "+c);
		}

	}

}
