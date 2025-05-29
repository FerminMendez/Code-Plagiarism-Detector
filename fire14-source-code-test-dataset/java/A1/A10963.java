import java.awt.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Test{
	public static void main(String[] args) {
	try{
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		String T = buff.readLine();
		for(int q=0;q<Integer.parseInt(T);q++){
			String inp = buff.readLine();
			String arr[] = inp.split(" ");
			int N = Integer.parseInt(arr[0]);
			String S = arr[1];
			int s_int = Integer.parseInt(S);
			int p = Integer.parseInt(arr[2]);
			int inp_arr[] = new int[N];
			for(int l=0;l<N;l++)
				inp_arr[l] = Integer.parseInt(arr[l+3]);
			Vector<data> list = new Vector<data>();
			for(int a:inp_arr){
				if(a%3 == 0){
					int special_arr[] = new int[3];
					special_arr[0] = a/3-1;
					special_arr[1] = a/3;
					special_arr[2] = a/3+1;
					int normal_arr[] = new int[3];
					normal_arr[0] = a/3;
					normal_arr[1] = a/3;
					normal_arr[2] = a/3;
					data d = new data();
					d.set_normal_arr(normal_arr);
					d.set_special_arr(special_arr);
					list.add(d);
					
				}
				else if(a%3 == 1){
					int special_arr[] = new int[3];
					special_arr[0] = a/3-1;
					special_arr[1] = a/3+1;
					special_arr[2] = a/3+1;
					int normal_arr[] = new int[3];
					normal_arr[0] = a/3;
					normal_arr[1] = a/3;
					normal_arr[2] = a/3+1;
					data d = new data();
					d.set_normal_arr(normal_arr);
					d.set_special_arr(special_arr);
					list.add(d);
					
				}
				else{
					int special_arr[] = new int[3];
					special_arr[0] = a/3;
					special_arr[1] = a/3;
					special_arr[2] = a/3+2;
					int normal_arr[] = new int[3];
					normal_arr[0] = a/3;
					normal_arr[1] = a/3+1;
					normal_arr[2] = a/3+1;
					data d = new data();
					d.set_normal_arr(normal_arr);
					d.set_special_arr(special_arr);
					list.add(d);
					
				}
			}
			Iterator iter = list.iterator();
			int count =0;
			while(iter.hasNext()){
				data d = (data)iter.next();
				//System.out.println("p:" + p+"s:"+s_int+" " + d.normal_arr[0] + " " +d.normal_arr[1] + " " + d.normal_arr[2] + " " +d.special_arr[0] + " " +d.special_arr[1] + " " +d.special_arr[2]);
				if(p <= d.get_largest_normal()){
					//TODO  count++
					count++;
				}
				else{
					if(s_int!=0){
						if(p <= d.get_largest_special()){
							//TODO count++ and s_int--
							count++;
							s_int--;
						}
						else{
							//System.out.println("Untrue for both special as well as normal");
						}
					}
				}
			}
		System.out.println(" Case #" + (q+1) + ": " + count);
		}
	}catch(Exception e){System.out.println(e);}
	}
}
class data{
	int special_arr[];
	int normal_arr[];
	void set_special_arr(int arr[]){special_arr = arr;}
	void set_normal_arr(int arr[]){normal_arr = arr;}
	int[] get_special_arr(){return special_arr;}
	int[] get_normal_arr(){return normal_arr;}
	
	int get_largest_special(){if(special_arr[0] < 0 || special_arr[2]>10)return -1;return special_arr[2];}
	
	int get_largest_normal(){if(normal_arr[0] < 0 || normal_arr[2]>10)return -1;return normal_arr[2];}
	
}