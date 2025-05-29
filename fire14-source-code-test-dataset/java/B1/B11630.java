import java.util.ArrayList;
import java.util.Scanner;


public class DancingWithTheGooglers {
	public static void main(String[] args){		
		Scanner keyin=new Scanner(System.in);
		int T=keyin.nextInt();
		keyin.nextLine();
		int caseCount=0;
		while ((T--)!=0){
			int A=keyin.nextInt();
			int B=keyin.nextInt();
			int count=0;
			caseCount++;
			ArrayList<String> result=new ArrayList<String>();
			for (int n=A; n<=B; n++){
				for (int m=n+1; m<=B; m++){
					String strN=Integer.toString(n);
					String strM=Integer.toString(m);
					for (int i=1; i<strN.length(); i++){
						String temp="";
						temp=strN.substring(i)+""+strN.substring(0,i);
						if (strM.equals(temp) && Integer.parseInt(strN)<Integer.parseInt(strM)){
							boolean isDuplicate=false;
							if (result!=null){
								for (int arrayIndex=0; arrayIndex<result.size(); arrayIndex++){
									if (result.get(arrayIndex).equals("("+strN+", "+strM+")")){
										isDuplicate=true;
									}
								}
							}
							if (isDuplicate==false){
								//System.out.println("("+strN+", "+strM+")");
								result.add("("+strN+", "+strM+")");
								count++;
							}
						}
					}
				}
			}
			System.out.println("Case #"+caseCount+": "+count);
		}
	}
}
