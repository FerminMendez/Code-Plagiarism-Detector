import java.io.*;
import java.util.*;
public class dancing {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("dancing.in"));
        PrintWriter out = new PrintWriter(new File("dancing.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cases = Integer.parseInt(st.nextToken());
        int answer;

        for (int i = 0; i < cases; i++){
        	answer = 0;
        	StringTokenizer data = new StringTokenizer(br.readLine());
        	int[] googlers = new int[Integer.parseInt(data.nextToken())];
        	int surprising = Integer.parseInt(data.nextToken());
        	int threshold = Integer.parseInt(data.nextToken());
        	for (int a = 0; a < googlers.length; a++){
        		googlers[a] = Integer.parseInt(data.nextToken());
        	}
        	Arrays.sort(googlers);
        	for (int z = googlers.length-1; z >= 0; z--){
        		if (googlers[z] == 0 && (threshold * 3) > 0){
        		} else if (googlers[z] >= ((threshold * 3) - 2)){
        			answer++;
        		} else if (surprising > 0 && ((googlers[z] <= ((threshold * 3) - 2)) && (googlers[z] >= ((threshold * 3) - 4)))){
        			surprising--;
        			answer++;
        		}
        	}
        	out.println("Case #" + (i + 1) + ": " + answer);
        }
        out.close();
    }
}