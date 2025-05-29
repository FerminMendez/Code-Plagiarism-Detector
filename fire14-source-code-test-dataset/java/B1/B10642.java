import java.util.ArrayList;
import java.util.Scanner;


public class RecycledNumbers {

	private Integer a;
	private Integer b;
	private Integer caseNumber;
	private Integer numberOfDigits;
	
	public RecycledNumbers(int caseNumber,String data) {
		// TODO Auto-generated constructor stub
		Scanner s=new Scanner(data);
		this.a=s.nextInt();
		this.b=s.nextInt();
		this.caseNumber=caseNumber;
		this.numberOfDigits=a.toString().length();
				
	}
	
	public void process() {
		int count=0;
		
		
		for(Integer i=a;i<b;i++){
			
			//ArrayList<Integer> temp=new ArrayList<Integer>();
			
			for(int j=1;j<numberOfDigits;j++){
				
				String temp=i.toString();
				temp= temp.substring(j).concat(temp.substring(0, j));
				Integer temp1=Integer.parseInt(temp);
				
				if(temp1<=b && temp1>i){
					count++;
					//System.out.println(i+" "+temp1);
				}
				
			}
			
		}
		
		System.out.println("Case #"+caseNumber+": "+count);
	}
	
	
}
