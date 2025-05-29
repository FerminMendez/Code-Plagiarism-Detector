
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Dance {
    private String strLine;
    private BufferedReader f;
    private PrintWriter out;
    private ArrayList<Integer> hasil;
    
    public Dance() {
        strLine = new String();
	try {
		f = new BufferedReader(new FileReader("b0.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("dance.out")));
	} catch(IOException i) {
	}
	hasil = new ArrayList<Integer>();
    }
    
    public void find(int N, int S, int p, ArrayList<Integer> save) {
        int temp;
        int count = 0;
        int sTemp = S;
        System.out.println("ha = " + N + "|" + S + "|" + p);
        for (int i = 0; i < N; i++) {
            temp = save.get(i);
            if ((temp % 3) == 1) {
                if (temp / 3 + 1 >= p) {
                    System.out.println("a" + i);
                    count++;
                }
            } else if ((temp % 3) == 2) {
                if (sTemp == 0) {
                    if (temp / 3 + 1 >= p) {
                        System.out.println("b" + i);
                        count++;
                    }
                } else {
                    if (temp / 3 + 1 < p) {
                        sTemp--;
                        if (temp /3 + 2 >= p && temp /3 + 2 <= 10) {
                            System.out.println("c" + i);
                            count++;
                        } else {
                            sTemp++;
                        }
                    } else {
                        if (temp / 3 - 1 >= 0) {
                            System.out.println("d" + i);
                            count++;
                        }
                    }
                }
            } else {
                if (sTemp > 0) {
                    if (temp / 3 >= p) {
                        System.out.println("f" + i);
                        count++;
                    } else if (temp / 3 + 1 >= p) {
                        if (temp / 3 - 1 <= 0) {
                            
                        } else if (temp / 3 + 1 >= 10) { 
                        
                        } else {
                            System.out.println("e" + i);
                            count++;
                            sTemp--;
                        }
                    }
                } else {
                    if (temp / 3 >= p) {
                        System.out.println("g" + i);
                        count++;
                    }
                }
            }
        }
        hasil.add(count);
    }
    
    public static void main(String[] args) throws IOException {
        Dance dance = new Dance();
	int N;
        int S;
        int T;
        int p;
	StringTokenizer st;
        ArrayList<Integer> save;
	
	T = Integer.parseInt(dance.f.readLine());
        System.out.println("T = " + T);
	if (T > 100 || T < 1) {
            System.out.println("Error");
	} else {
            for (int i = 0; i < T; i++) {
                if ((dance.strLine = dance.f.readLine()) != null) {
                    System.out.println("dance = " + dance.strLine);
                    st = new StringTokenizer(dance.strLine);
                    N = Integer.parseInt(st.nextToken());
                    S = Integer.parseInt(st.nextToken());
                    p = Integer.parseInt(st.nextToken());
                    save = new ArrayList<Integer>();
                    for (int j = 0; j < N; j++) {
                        save.add(Integer.parseInt(st.nextToken()));
                    }
                    dance.find(N,S,p,save);
                }
            }
//		while ((dance.giver = dance.f.readLine()) != null) {
//			if (dance.giver.length() > 100) {
//				System.out.println("Error");
//				isError = true;
//				break;
//			} else {
//				for (int l = 0; l < dance.giver.length(); l++) {
//                                    if (dance.giver.charAt(l) != ' ')
//                                        s = s + dance.member.get(dance.giver.charAt(l));
//                                    else
//                                        s = s + dance.giver.charAt(l);
//                                }
//                                dance.hasil.add(s);
//                                s = "";
//			}
//		}
                for (int x = 0; x < dance.hasil.size(); x++) {
                        dance.out.println("Case #" + (x + 1)+ ": " +dance.hasil.get(x));
                }
		dance.out.close();                                  // close the output file
		System.exit(0);
	}
    }
}
