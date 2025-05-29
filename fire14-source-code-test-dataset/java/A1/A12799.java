import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EN2012QB {
	public static void main(String[] args) {
		File inputFile = new File("c:/tmp/B-small-attempt0.in");
		File outputFile = new File("c:/tmp/B-small-attempt0.out");

		char map[] = new char[256];
		boolean mapped[] = new boolean[256];

		FileReader filereader = null;
		BufferedReader br = null;
		FileWriter filewriter = null;
		BufferedWriter bw = null;

		try {
			// 入力
			filereader = new FileReader(inputFile);
			br = new BufferedReader(filereader);

			// 出力
			filewriter = new FileWriter(outputFile);
			bw = new BufferedWriter(filewriter);

			/**************************************************************************************
			// 全体パラメータの読み込み
			**************************************************************************************/
			int T;

			// テストケースの個数
			String lineStr = br.readLine();
			T = Integer.parseInt(lineStr);
			System.out.println("T = " + T + "\n");

			/**************************************************************************************
			// Caseを1つづつ処理
			**************************************************************************************/
			long caseIndex = 1;
			while ((lineStr = br.readLine()) != null) {
				/**************************************************************************************
				// Caseを処理
				 **************************************************************************************/

				String E[] = lineStr.split(" ");
				System.out.println(lineStr);
				int N = Integer.parseInt(E[0]);
				System.out.println("N = " + N);

				int S = Integer.parseInt(E[1]);
				System.out.println("S = " + S);

				int p = Integer.parseInt(E[2]);
				System.out.println("p = " + p);

				int totalPoints[] = new int[N];

				for(int i=0; i<N; i++){
					totalPoints[i] = Integer.parseInt(E[3 + i]);
					System.out.println("totalPoints[" + i + "] = " + totalPoints[i]);
				}

				// surprisingでなくてもクリアできている組の場合は、p + (p-1) + (p-1) 以上であればよい
				int notSurprisingThreshold = 3 * p - 2;

				// surprisingでないとクリアできない組の場合は、p + (p-2) + (p-2) 以上であればよい
				int SurprisingThreshold = 3 * p - 4;

				int notSurprisingCount = 0;
				int SurprisingCount = 0;

				for(int i=0; i<N; i++){
					// 少なくとも1つはp以上であるため、大前提として合計値はpより大きくないといけない
					if(totalPoints[i] >= p
							&& totalPoints[i] >= notSurprisingThreshold){
						notSurprisingCount++;
					}

					// 少なくとも1つはp以上であるため、大前提として合計値はpより大きくないといけない
					// 最大のスコアと最小のスコアの差分が2であるから、合計は28以下となる
					if(totalPoints[i] >= p
							&& totalPoints[i] <= 28
							&& totalPoints[i] >= SurprisingThreshold
							&& totalPoints[i] < notSurprisingThreshold){
						SurprisingCount++;
					}
				}

				System.out.println("Not Surprising = " + notSurprisingCount + ", Surprising = " + SurprisingCount);

				// surprisingでないとクリアできていない組は、SurprisingCount 組ある。
				// このうち、実際はS組が surprisingである
				int caseAnser = notSurprisingCount + Math.min(S, SurprisingCount);

				/**************************************************************************************
					// Caseを出力
				 **************************************************************************************/
				String output = "Case #" + caseIndex + ": " + caseAnser;
				caseIndex++;
				System.out.println(output);
				bw.write(output);
				bw.newLine();
			}
			/**************************************************************************************
				// 次のCaseの読み込み
			 **************************************************************************************/
			lineStr = br.readLine();
			System.out.println();

			bw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				if (filereader != null) {
					filereader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				if (filewriter != null) {
					filewriter.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 文字列からマッチする文字列数を求める
	 */
	private static int countChar(String str, int ch){
		int count = 0;
		int i = 0;
		while ((i = str.indexOf(ch, i)) != -1) {
			count++;
			i++;
		}
		return count;
	}
}
