import java.util.Scanner;

class ProbC{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++){
			//boolean flag[] = new boolean[2000001];
			int A, B;
			A = sc.nextInt();
			B = sc.nextInt();
			int count = 0;
			for(int j=A;j<=B;j++){
				//if(!flag[j]){	// kalo J blm crossed, check
					String check = j+"";
					int ndigit = check.length();
					boolean ada = false;
					int nomnom = 0;
					boolean flag[] = new boolean[2000001];
					for(int k=1;k<=ndigit-1;k++){
						if(check.charAt(check.length()-k) != '0'){
							int depan = Integer.parseInt(check.substring(0,check.length()-k));
							int belakang = Integer.parseInt(check.substring(check.length()-k));
							int hasil = (int)((Math.pow(10,ndigit-k)*belakang)+depan);
							//System.out.println("dari "+j+" hasil "+hasil);
							if(hasil != j && hasil >= A && hasil <= B){
//								System.out.println("Recycle "+hasil+" from "+j);
								if(j < hasil){
									//System.out.println("Recycle "+hasil+" "+j);
									if(!flag[hasil]){
										flag[hasil] = true;
										//ada = true;
										count++;
									}									
								}
							}
						}
					}
				//}
			}
			int kount = 0;
			/*for(int j=A;j<=B;j++){
				if(flag[j]){
					//System.out.println("recycle "+j);
					kount++;
				}
			}*/
			System.out.println("Case #"+(i+1)+": "+count);
		}
	}
}