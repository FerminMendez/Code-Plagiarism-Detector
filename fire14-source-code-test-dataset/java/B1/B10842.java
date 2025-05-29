import java.util.Scanner;


public class CC {

	
	public static void main(String[] argv){
		Scanner in = new Scanner ( System.in );
		int T=in.nextInt();
		
		for(int i=0; i<T; i++){
			
			int A=in.nextInt(); int B=in.nextInt();
			//boolean[] have=new boolean[B+1];  
			int Rep=0;
			
			for(int x=A; x<B; x++){
				for(int y=x+1; y<=B; y++){
					if((""+x).length()==1 ||(""+y).length()==1 || (""+y).length()!=(""+x).length()) continue;
					
					if(areCycl(x,y))
						Rep++;
				}
			}
			System.out.println("Case #"+(i+1)+": "+Rep);
		}
	}

	private static boolean areCycl(int x, int y) {
		String s=""+x;
		for(int p=1; p<=s.length(); p++){
			String s1=s.substring(0,p);
			String s2=s.substring(p);
			String ss=s2+s1;
			int xx=Integer.parseInt(ss);
			if(xx==y)
				return true;
		}
		return false;
	}
}