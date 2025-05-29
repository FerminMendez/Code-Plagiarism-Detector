
import java.util.*;
import java.io.*;



public class c {
	public static void main(String arg[]){
		int T;
		Scanner cin=new Scanner(System.in);
		T=cin.nextInt();
		for(int t=0;t<T;t++){
			int n=cin.nextInt();
			int m=cin.nextInt();
			int ans=0;
			for(int i=n;i<m;i++){
////				if(i>150)
//					break;
				int size=1;
				int num=0;
				while (true){
					num++;
					if(i>=size && i<size*10)
						break;
					else size*=10;
				}
				int copy=i;
		//		String sc=((Integer)i).toString();
				ArrayList<Integer> now= new ArrayList();
				for(int j=0;j<num-1;j++){
		//			sc=new String(sc.substring(1)+sc.substring(0,1));
		//			int tmp=Integer.parseInt(sc);
					copy=10*(copy%size)+copy/size;

		//			if(copy!=tmp){
		//				System.out.println("ERR----------");
		//			}
			//		System.out.println(i + " " +copy);
					if(copy>i && copy <=m && now.indexOf(copy)==-1){
						ans++;
					//	System.out.println(" " + i + " " +copy);
						now.add(copy);
					}
				}
			}
			System.out.println( "Case #" +( t+1 )+ ": " + ans );
		}
	}
}
