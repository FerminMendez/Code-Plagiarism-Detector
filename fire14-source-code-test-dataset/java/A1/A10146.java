import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

class B {
	static public void main(String[] args) {
		try {
			PrintStream out = new PrintStream(new File("b.out"));
			System.setOut(out);
			Scanner theIn=new Scanner(new File("B-small-attempt0.in"));
			int t=theIn.nextInt();
			int n;
			int s;
			int p;
	
			for (int i=1; i<=t; i++) {
				System.out.print("Case #"+i+": ");
				n=theIn.nextInt();
				s=theIn.nextInt();
				p=theIn.nextInt();
				int numberP=0;
				int leftS=s;
				
				for (int j=1; j<=n; j++) {
					int current=theIn.nextInt();
					
					if (((current%3==0) && (current/3>=p)) ||((current%3!=0) && (current/3+1>=p)) ) numberP+=1; else {					
						if (leftS==0) continue;
						if (current<2) continue;
						if ((current%3==0) && ((current-3)/3+2>=p)) {
							numberP+=1;
							leftS-=1;
							continue;
						}
						if ((current%3==1) && ((current-4)/3+2>=p)) {
							numberP+=1;
							leftS-=1;
							continue;
						}
						if ((current%3==2) && ((current-2)/3+2>=p)) {
							numberP+=1;
							leftS-=1;
							continue;
						}
					}
					
				}
				System.out.println(numberP);
			}
			
			
		} catch (Exception e) {}
	}
}