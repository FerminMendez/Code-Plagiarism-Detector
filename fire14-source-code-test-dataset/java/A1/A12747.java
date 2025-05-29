import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class B {

	public void func(){
		
		Scanner in=null;
		try {
			in = new Scanner(new File("C:\\Users\\Suba\\workspace\\Codejam12\\src\\input.txt"));
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		}
		int no = in.nextInt();		
		for(int i=0;i<no;++i){
			int ng = in.nextInt();
			int sp = in.nextInt();
			int min = in.nextInt();
			int res = 0;
			int ss = 0;
			int k =3;
			int v = 0;
			int flag = 0;
			int[][] intArr = new int[ng][4]; 
			for(int j=0;j<ng;++j){
				int score = in.nextInt();
				flag = 0;
				v=0;
				k=3;
				while(v<3){
					intArr[j][v] = score/k;
					score -= intArr[j][v];
					if((intArr[j][v] >= min) && flag == 0){
						res++;
						intArr[j][3] = 1;
						++flag;
					}
					--k;
					++v;					
				}
				if(Math.abs((intArr[j][0]-intArr[j][1])) == 2 || Math.abs((intArr[j][1]-intArr[j][2])) == 2 || Math.abs((intArr[j][2]-intArr[j][0])) == 2 ){
					++ss;
				}
			}
			if((res <  ng) && (ss < sp)){
				for(int j=0;j<ng;++j){
					if(intArr[j][3] == 0 && (intArr[j][0]+intArr[j][1]+intArr[j][2] != 0)){
						if(Math.abs(intArr[j][0]-intArr[j][1]) < 1){
							if(j==ng-1){
								intArr[j][0]--;
								intArr[j][1]++;
								if(intArr[j][0] >= min || intArr[j][1]>= min) ++res;
								++ss;
							}else{
								if(intArr[j][0]-1 >= min || intArr[j][1]+1 >= min){
									intArr[j][0]--;
									intArr[j][1]++;
									++res;
									++ss;
								}
							}
							///continue;
						}else if(Math.abs(intArr[j][1]-intArr[j][2]) < 1){
							if(j==ng-1){
								intArr[j][1]--;
								intArr[j][2]++;
								if(intArr[j][1] >= min || intArr[j][2]>= min) ++res;
								++ss;
							}else{
								if(intArr[j][1]-1 >= min || intArr[j][2]+1 >= min){
									intArr[j][1]--;
									intArr[j][2]++;
									++res;
									++ss;
								}
							}
						}else if(Math.abs(intArr[j][2]-intArr[j][0]) < 1){
							if(j==ng-1){
								intArr[j][2]--;
								intArr[j][0]++;
								if(intArr[j][0] >= min || intArr[j][2]>=min) ++res;
								++ss;
							}else{
								if(intArr[j][2]-1 >= min || intArr[j][0]+1 >= min){
									intArr[j][2]--;
									intArr[j][0]++;
									++res;
									++ss;
								}
							}
						}
						if(ss>=sp){
							break;
						}
					}
				}
			}
			System.out.println("Case #"+(i+1)+": "+res);
		}
	}
	
	
	public static void main(String[] args) {
		B b = new B();
		b.func();
	}

}
