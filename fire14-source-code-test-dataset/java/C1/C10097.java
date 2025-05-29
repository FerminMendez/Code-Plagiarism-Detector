import java.io.*;
import java.util.*;

public class CodeJamD {
	public static void main (String[] args) throws IOException {
		int i, j, k,m,n;
		long startTime = System.currentTimeMillis();
		File inFile  = new File("D-small-attempt2.in");  // File to read from
		File outFile = new File("D-small.out");
		
		BufferedReader reader = new BufferedReader(new FileReader(inFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
	
		HashMap<Double, Integer> map = new HashMap<Double, Integer>();
		String line = null;
		line = reader.readLine();
		int cases = Integer.parseInt(line);
		int counter = 1;
		
        while ((line=reader.readLine()) != null) {
        	int H,W,D,Hh, Ww;
        	int h = 0;
        	int r=0,c=0;
        	int images = 0;        	
        	String[] node = line.split(" ");
        	H = Integer.parseInt(node[0]);
        	W = Integer.parseInt(node[1]);
        	D = Integer.parseInt(node[2]);
        	Hh = H-2;
        	Ww = W-2;
        	char[][] room = new char[H][W];
        	while(h < H) {
        		line = reader.readLine();
        		for(i = 0; i < line.length(); i++) {
        			room[h][i] = line.charAt(i);
        			if(line.charAt(i) == 'X') {
        				r = h-1; c = i-1;
        			}
        				
        		}
        		h++;
        		//System.out.println(room[h-1]);
        		
        	}
        	String[] space = new String[Hh];
        	for(i = 0; i < Hh; i++) {
        		space[i] = "";
        		for(j=1; j <= Ww; j++) {
        			space[i] += String.valueOf(room[i+1][j]);
        			//System.out.println(String.valueOf(room[i+1][j]));
        		}
        	}
        	//System.out.println("space :");
        	/*
        	for(String ss : space) 
        		System.out.println(ss);
        	*/
        	int rblocks = 2*(D/Hh +1 ) + 1;
        	int cblocks = 2*(D/Ww +1) + 1;
        	
        	//System.out.println(rblocks + " " + cblocks);
        	String[] grid = new String[rblocks*Hh];
        	int rdiv = rblocks/2;
        	int cdiv = cblocks/2;
        	if(rdiv % 2 == 0) {
	        	for(i = 0; i < rblocks; i++) {
	        		if(i % 2 == 0) {
		        		for(j = 0; j < Hh; j++) {
		        			grid[i*Hh+j] = "";
		        			if(cdiv % 2 == 0) {
			        			for(k = 0; k < cblocks; k++) {
			        				
			        				if(k % 2 == 0) {
			        					grid[i*Hh+j] += space[j];
			        				} else {
			        					grid[i*Hh+j] += new StringBuffer(space[j]).reverse().toString();
			        				}
			        			}
		        			} else {
		        				for(k = 0; k < cblocks; k++) {			        				
			        				if(k % 2 == 1) {
			        					grid[i*Hh+j] += space[j];
			        				} else {
			        					grid[i*Hh+j] += new StringBuffer(space[j]).reverse().toString();
			        				}
			        			}
		        			}
		        		}
	        		} else {
	        			for(j = 0, m = Hh-1; j < Hh; j++,m--) {
		        			grid[i*Hh+m] = "";
		        			if(cdiv % 2 == 0) {
		        					
			        			for(k = 0; k < cblocks; k++) {
			        				if(k % 2 == 0) {
			        					grid[i*Hh+m] += space[j];
			        				} else {
			        					grid[i*Hh+m] += new StringBuffer(space[j]).reverse().toString();
			        				}
			        					
			        			}
		        			} else {
		        				for(k = 0; k < cblocks; k++) {
			        				if(k % 2 == 1) {
			        					grid[i*Hh+m] += space[j];
			        				} else {
			        					grid[i*Hh+m] += new StringBuffer(space[j]).reverse().toString();
			        				}
			        					
			        			}
		        			}
		        		}
	        		}
	        	}
        	} else {
        		for(i = 0; i < rblocks; i++) {
	        		if(i % 2 == 1) {
		        		for(j = 0; j < Hh; j++) {
		        			grid[i*Hh+j] = "";
		        			if(cdiv % 2 == 0) {
			        			for(k = 0; k < cblocks; k++) {		        				
			        				if(k % 2 == 0) {
			        					grid[i*Hh+j] += space[j];
			        				} else {
			        					grid[i*Hh+j] += new StringBuffer(space[j]).reverse().toString();
			        				}
			        			}
		        			} else {
		        				for(k = 0; k < cblocks; k++) {		        				
			        				if(k % 2 == 1) {
			        					grid[i*Hh+j] += space[j];
			        				} else {
			        					grid[i*Hh+j] += new StringBuffer(space[j]).reverse().toString();
			        				}
			        			}
		        			}
		        		}
	        		} else {
	        			for(j = 0, m = Hh-1; j < Hh; j++,m--) {
		        			grid[i*Hh+m] = "";
		        			if(cdiv % 2 == 0) {
			        			for(k = 0; k < cblocks; k++) {
			        				if(k % 2 == 0) {
			        					grid[i*Hh+m] += space[j];
			        				} else {
			        					grid[i*Hh+m] += new StringBuffer(space[j]).reverse().toString();
			        				}
			        					
			        			}
		        			} else {
		        				for(k = 0; k < cblocks; k++) {
			        				if(k % 2 == 1) {
			        					grid[i*Hh+m] += space[j];
			        				} else {
			        					grid[i*Hh+m] += new StringBuffer(space[j]).reverse().toString();
			        				}
			        					
			        			}
		        			}
		        		}
	        		}
	        	}
        	}
        	/*
        	for (String ss : grid) 
        		System.out.println(ss);
        	*/
        	int xpos, ypos;
        	xpos = (rblocks/2)*Hh+r;
        	ypos = (cblocks/2)*Ww+c;
        	
        	System.out.println("xy: " + xpos + " " + ypos);
        	//System.out.println("D: " + D);
        	int clashCount = 0;
        	//calc no. of images
        	for(i = 0; i < rblocks*Hh; i++) {
        		if(i == xpos+1)
        			map.clear();
        		for(j = 0; j < grid[0].length(); j++ ) {
        			if(grid[i].charAt(j) == 'X') {
        				//if((i == xpos && (Math.abs(j-ypos) != Ww)) 
        					//	|| (j == ypos && (Math.abs(i-xpos) != Hh)) ) {
        				//	;
        				//} else {
	        				double dist = Math.sqrt(Math.pow(xpos-i, 2.0) +Math.pow(ypos-j, 2.0));
	        				//System.out.println(dist);
	        				if(dist <= D) {
	        					if(i - xpos != 0) {
		        					double slope = (double)(j - ypos) / (double)(i - xpos);
		        					//System.out.println("i:j:: "+i + ":"+j);
		        					//System.out.println("Slope: " + slope);
		        					if(!map.containsKey(slope)) {
		        						images++;
		        						map.put(slope, 1);
		        					} else {
		        						clashCount++;
		        						//System.out.println("clash");
		        					}
	        					}
	        				}
        				//}
        			}
        		}
        	}
        	if(((Ww - (c+1))*2 + 1) <= D) {
        		images++;
        	}
        	if(2*c+1 <= D) {
        		images++;
        	}
        	
        	//System.out.println("Case #"+counter+": "+images);
        	writer.write("Case #"+counter+": "+images);        	
        	writer.newLine();
        	counter++;        		
        	map.clear();
        }
        
        
        
        writer.close();       
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Total Time: " + totalTime);		
	}
 }
