package me.mevrad.codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SolutionB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readFile("B-small-attempt13.in");
		processData();
		writeFile();
	}

	public static void readFile(String filename) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = in.readLine()) != null) {
				// System.out.println(line);
				processLine(line);
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static int counter = 0;
	static ArrayList<DataTemplate> data = new ArrayList<DataTemplate>();
	static ArrayList<String> finalText = new ArrayList<String>();
	public static void processLine(String line) {
		if (counter == 0) {
			counter++;
			return;
		}
		String[] splited = line.split(" ");
		DataTemplate dt = new DataTemplate();
		int c = 0;
		for (String s : splited) {
			if (c == 0)
				dt.numberOfGooglers = Integer.parseInt(s);
			else if (c == 1)
				dt.surprisingScores = Integer.parseInt(s);
			else if (c == 2)
				dt.p = Integer.parseInt(s);
			else {
				dt.scores.add(Integer.parseInt(s));
			}
			c++;
			System.out.println(s);
		}
		data.add(dt);
		counter++;
		System.out.println("Next line");
	}

	public static void processData() {
		counter = 0;
		System.out.println("processData data size:"+ data.size());
		for (DataTemplate dt : data) {
			counter++;
			int c = 0;
			for (int i = 0; i < dt.scores.size(); i++) {
				boolean visited = false;
				int temp = dt.scores.get(i) / 3;
				if(dt.p> dt.scores.get(i))
					continue;
				if(temp < 0 && Math.ceil(temp) >= dt.p){
					c++;
					continue;
				}
				if(temp >= dt.p){
					c++;
					continue;
				}
				int temp1 = (dt.scores.get(i)-dt.p)/2;
				if(dt.p-temp1<2){
					c++;
					continue;
				}
				if((dt.p - temp1 == 2) && dt.surprisingScores >0){
					dt.surprisingScores--;
					c++;
					continue;
				}
				//System.out.println("temp: " + temp);
//				if(temp < 0 && Math.ceil(temp) >= dt.p){
//					c++;
//					dt.scores.remove(i);
//					i--;
//					visited = true;
//				}
//				if (temp >= dt.p && !visited) {
//					c++;
//					dt.scores.remove(i);
//					i--;
//					visited = true;
//				} 
//				else if(temp >= 1 && temp%1>0 && Math.floor(temp)+1 >= dt.p && !visited){
//					c++;
//					//System.out.println("temp1: " + Math.ceil(temp)+1);
//					dt.scores.remove(i);
//					i--;
//					visited = true;
//				}
//				else if (dt.surprisingScores > 0 && !visited  && temp > 0.5 && (temp%1 > 0.5 || temp%1 == 0)) {
//					temp += 2;
//					//System.out.println("temp2: " + temp);
//					if (temp >= dt.p) {
//						c++;
//						dt.scores.remove(i);
//						i--;
//						dt.surprisingScores--;
//					}
//				}
			}
			System.out.println(counter+ ": Score: " + c);
			String s = "";
			s += "Case #"+counter+": "+c; 
			finalText.add(s);
		}
		
	}
	
	public static void writeFile(){
		try {
			FileWriter fstream = new FileWriter("out13.out");
			BufferedWriter out = new BufferedWriter(fstream);
			for(String s : finalText){
				out.write(s);
				out.write("\n");
			}
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
