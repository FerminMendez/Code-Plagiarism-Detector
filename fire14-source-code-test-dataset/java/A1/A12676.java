import java.util.Scanner;

public class dance
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
int test = 1, i, j;
int[] arr = new int[100];
int[] arr1 = new int[100];
while (test <= n ) {
	int N_G = sc.nextInt();
	int N_S = sc.nextInt();
	int query = sc.nextInt();
	int count = 0;
	int surprize_count = 0;
	for(i = 0 ; i < N_G ; i++)
		arr[i] = sc.nextInt();
	int total = 0;
	int temp = query-1;
	int temp1 = query-2;
	for(i = 0 ; i < N_G ; i++){
		if(arr[i]/3 >= query || (arr[i]/3 == query-1 && arr[i]%3 > 0))
			total++;
		else if(N_S > 0 && ((arr[i]/3 == temp1 && arr[i]%3 == 2) || (arr[i]/3 == temp && temp != 0))){
			N_S--;
			total++;
			}
		}
	arr1[test-1] = total;
	test++;
	}
for(i = 1 ; i <= n ; i++)
	System.out.println("Case #" +i+": "+arr1[i-1]);
}
}
