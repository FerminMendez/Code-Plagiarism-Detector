import java.util.*;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] s = new int[3][n];

		for (int i = 0; i < n; i++) {
			s[0][i] = sc.nextInt();
			s[1][i] = sc.nextInt();
			s[2][i] = 0;
		}

		for (int i = 0; i < n; i++) {
			List<Integer> past2 = new ArrayList<Integer>();
			List<Integer> past1 = new ArrayList<Integer>();
			if (s[0][i] < 10 && s[1][i] < 10) {
				s[2][i] = 0;
			} else {
				for (int j = s[0][i]; j < s[1][i]; j++) {
					String t1 = Integer.toString(j); // m을 문자열로 저장
					for (int k = 1; k < t1.length(); k++) {
						String t2 = t1.substring(k) + t1.substring(0, k); // n을 문자열로 저장
						if (t2.charAt(0) != '0') { // 첫자리가 0이 되어 자리수가 내려가는 경우 예외 처리
							if (Integer.parseInt(t2) <= s[1][i] && Integer.parseInt(t2) >= s[0][i]) { // B 범위를 초과하는 경우 예외 처리
								if (!t1.equals(t2)) { // n과 m이 같은 경우 예외 처리
									int same = 0;
									for(int p = 0; p < past2.size() ; p++) {
										if(past2.get(p) == Integer.parseInt(t1) && past1.get(p) == Integer.parseInt(t2)) {
											same = 1;
										}
									}
									if(same == 0) {
										s[2][i]++;
										past2.add(Integer.parseInt(t2));
										past1.add(Integer.parseInt(t1));
									}
									same = 0;
								}
							}
						}
					}
				}
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.println("Case #" + (i + 1) + ": " + s[2][i]);
		}

	}
}