import java.util.StringTokenizer;


public class B {

	public int solve(String input){
		int result=0;
		StringTokenizer st=new StringTokenizer(input, " \n");
		int n=Integer.parseInt(st.nextToken());
		int s=Integer.parseInt(st.nextToken());
		int p=Integer.parseInt(st.nextToken());
		int maxThres=0;
		int minThres=0;
		if(p>1){		
		 maxThres=(p-1)*3+1;
		 minThres=(p-2)*3+2;
		}else{
			maxThres=p;
			minThres=p;
		}
		while(st.hasMoreTokens()){
			int num=Integer.parseInt(st.nextToken());
			if(num>=maxThres){
				result++;
				continue;
			}
			if(num>=minThres && num<maxThres && s>0){
				result++;
				s--;
			}
		}
		
		return result;
	}
	public static void main(String[] args) {
		IOHelper io=new IOHelper("C:\\skill\\workspace\\cj2012\\src\\B-small-attempt1.in",
		"C:\\skill\\workspace\\cj2012\\src\\B-small-attempt1.out");
		int countOfTest=Integer.parseInt(io.readLine());
		B b=new B();
		for(int i=0;i<countOfTest;i++){
			String s=io.readLine();
			int solution= b.solve(s);
			String output="Case #"+(i+1)+": "+solution;
			io.writeLine(output);
		}
		

	}

}
