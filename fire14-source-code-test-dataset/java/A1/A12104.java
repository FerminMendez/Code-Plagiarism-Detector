import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class DancingWithTheGooglers {
	public static void main(String[] args) {
		 try {
	            // ファイルオブジェクトを生成する
	            FileInputStream fileInputStream =
	                new FileInputStream("B-small-attempt0.in");
	            InputStreamReader inputStreamReader =
	                new InputStreamReader(fileInputStream);
	            BufferedReader bufferedReader =
	                new BufferedReader(inputStreamReader);
	            // ファイルから一行読み取る
	            String lines = bufferedReader.readLine();
	            int len = Integer.parseInt(lines);
	            String[] str = new String[len];
	            for(int i = 0; i < len; i++){
	            	str[i] = bufferedReader.readLine();
	            }

	            // ファイルオブジェクトを破棄する
	            bufferedReader.close();
	            inputStreamReader.close();
	            fileInputStream.close();


	            FileOutputStream fileOutputStream =
	                new FileOutputStream("answerDWG.txt");
	            OutputStreamWriter outputStreamWriter =
	                new OutputStreamWriter(fileOutputStream);
	            BufferedWriter bufferedWriter =
	                new BufferedWriter(outputStreamWriter);
	            //メソッド初期化
	            DancingWithTheGooglers dwg = new DancingWithTheGooglers();
	            for(int i = 0; i < len; i++){
	            	bufferedWriter.write("Case #" + (i+1) + ": " + dwg.keisan(str[i]) + "\n");
	            	// ファイルに内容を書き込む
	            }
	            // ファイルオブジェクトを破棄する
	            bufferedWriter.close();
	            outputStreamWriter.close();
	            fileOutputStream.close();


	        // 一連のファイル処理はIOExceptionが発生する
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	}
	
	private int keisan(String str){
		String[] inp = str.split(" ",-1);
		int i;
		int N = Integer.parseInt(inp[0])+3;
		int S = Integer.parseInt(inp[1]);
		int p = Integer.parseInt(inp[2]);
		int cnt = 0;
		int s_cnt = 0;
		for(i=3;i<N;i++){
			int ttl = Integer.parseInt(inp[i]);
			int a = ttl/3;
			int b = ttl%3;
			if(a >= p){
				cnt++;
			} else if(a == p-1){
				if(b > 0){
					cnt++;
				} else {
					if(a > 0 && s_cnt < S){
						cnt++;
						s_cnt++;
					}
				}
			} else if(a == p-2){
				if(b == 2 && s_cnt < S){
					cnt++;
					s_cnt++;
				}
			}
		}
		return cnt;	
	}

}
