import java.io.*;
import java.util.*;

public class GCJ2012QualC{
    void solve(){
        Scanner sc = new Scanner(System.in);
				//				sc.useDelimiter("\n");
        int T = sc.nextInt();
				for(int testCase = 1; testCase <= T; testCase++){
						int first = sc.nextInt();
						int last = sc.nextInt();
						//						str = Translate(str);
						//System.out.println(first + " " + last);
						System.out.println("Case #" + testCase + ": " + Test2(first, last));
				}
    }

		private int Test2(int first, int last){
				int tmp = 0;
				int[][] map = new int[last + 1][last + 1];
				for(int i = 0; i < last + 1; i++){
						for(int j = 0; j < last + 1; j++){
								map[i][j] = 0;
						}
				}

				for(int i = 0; i < last - first; i++){
						String firstStr = String.valueOf(first + i);
						for(int j = 0; j < firstStr.length(); j++){
								
								String tmp1 = firstStr.substring(j, firstStr.length());
								
								String tmp2 = firstStr.substring(0, j);
												//												System.out.println("Tmp2: " + tmp2);
								int tmpI1 = Integer.parseInt(tmp1 + tmp2);
								//										System.out.println("Tmp1: " + tmpI1 + "Tmp2: " + tmpI2);
								if(tmpI1 > first + i && tmpI1 <= last ){
										//					System.out.println(first + i + " -> " + tmpI1);
										if(map[first + i][tmpI1] == 0){
												tmp++;
												map[first + i][tmpI1] = 1;
										}
								}
								/*
									if(tmpI2 > first + i && tmpI2 < last){
									tmp++;
									System.out.println(first + i + " -> " + tmpI2);
									}
								*/
								
						}
				}
				
				return tmp;
		}

		private int Test(int first, int last){
				int tmp = 0;
				for(int i = 0; i < (first + last) / 2; i++){
						if((first + i) % 11 != 0){
								String firstStr = String.valueOf(first + i);
								for(int j = 0; j < firstStr.length(); j++){
										for(int k = j + 1; k < firstStr.length(); k++){
												String tmp1 = firstStr.substring(j, k);

												String tmp2 = firstStr.substring(0, j) + firstStr.substring(k, firstStr.length());
												//												System.out.println("Tmp2: " + tmp2);
												int tmpI1 = Integer.parseInt(tmp1 + tmp2);
												int tmpI2 = Integer.parseInt(tmp2 + tmp1);
												System.out.println("Tmp1: " + tmpI1 + "Tmp2: " + tmpI2);
												if(tmpI1 > first + i && tmpI1 < last){
														System.out.println(first + i + " -> " + tmpI1);
														tmp++;
												}
												if(tmpI2 > first + i && tmpI2 < last){
														tmp++;
														System.out.println(first + i + " -> " + tmpI2);
												}
										}

								}
						}
				}

				/*
				String tmpStr = "12345";
				System.out.println(tmpStr.substring(2,4));
				System.out.println(tmpStr.substring(0,2));
				System.out.println(tmpStr.substring(4,5));
				*/
				return tmp;
		}

		private String Translate(String input){
				char[] tmpStr = input.toCharArray();
				for(int i = 0; i < input.length(); i++){
						switch(input.charAt(i)){
						case 'y':	tmpStr[i] = 'a';break;
						case 'n':	tmpStr[i] = 'b';break;
						case 'f': tmpStr[i] = 'c';break;
						case 'i': tmpStr[i] = 'd';break;
						case 'c': tmpStr[i] = 'e';break;
						case 'w': tmpStr[i] = 'f';break;
						case 'l': tmpStr[i] = 'g';break;
						case 'b': tmpStr[i] = 'h';break;
						case 'k': tmpStr[i] = 'i';break;
						case 'u': tmpStr[i] = 'j';break;
						case 'o': tmpStr[i] = 'k';break;
						case 'm': tmpStr[i] = 'l';break;
						case 'x': tmpStr[i] = 'm';break;
						case 's': tmpStr[i] = 'n';break;
						case 'e': tmpStr[i] = 'o';break;
						case 'v': tmpStr[i] = 'p';break;
						case 'z': tmpStr[i] = 'q';break;
						case 'p': tmpStr[i] = 'r';break;
						case 'd': tmpStr[i] = 's';break;
						case 'r': tmpStr[i] = 't';break;
						case 'j': tmpStr[i] = 'u';break;
						case 'g': tmpStr[i] = 'v';break;
						case 't': tmpStr[i] = 'w';break;
						case 'h': tmpStr[i] = 'x';break;
						case 'a': tmpStr[i] = 'y';break;
						case 'q': tmpStr[i] = 'z';break;
						default : break;
						}
				}
				
				return String.valueOf(tmpStr);

		}

    public static void main(String args[]){
        new GCJ2012QualC().solve();
    }
}