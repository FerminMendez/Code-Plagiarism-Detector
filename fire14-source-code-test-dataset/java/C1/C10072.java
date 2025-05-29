import java.io.*;
import java.util.Set;
import java.util.HashSet;

//csak tükrözni kell:
// hány rácspont van D-nél közelebb

public class hallsmall {
	public static int myX,myY;
	public static int H,W,D;
	
	public static int lnko(int a, int b){
		a = Math.abs(a); b = Math.abs(b);
		if(a == 0) return b;
		while(b !=0){
			int c = a%b;
			a = b;
			b = c;
		}
		return a;
	}
	
	public static int solve(){
		int DB=0;
		int minX,maxX,minY,maxY;
		int x,y;
		
		minX = -1;
		while(-D <= W*minX) minX--;
		maxX = 1;
		while(D+W >= W*maxX) maxX++;
		minY = -1;
		while(-D <= H*minY) minY--;
		maxY = 1;
		while(D+H >= H*maxY) maxY++;
		
		Set volt = new HashSet();
		for(int aktx = minX; aktx <= maxX; aktx++)
			for(int akty = minY; akty <= maxY; akty++){
				if(aktx%2==0)
					x = W*aktx+myX;
				else
					x = W*(aktx+1)-1-myX;
				
				if(akty%2==0)
					y = H*akty+myY;
				else
					y = H*(akty+1)-1-myY;
				
				//System.out.println("["+x+","+y+"]");
				
				int dx = x-myX;
				int dy = y-myY;
				
				int ddx=0,ddy=0;
				if(!(dx==0&&dy==0)){
					ddx = dx / lnko(dx,dy);
					ddy = dy / lnko(dx,dy);
				}
				if(!(0==dx && 0==dy) 
					&& (dx*dx+dy*dy<=D*D)
					&& !volt.contains(10000*ddx+ddy)) {
						//System.out.println("[[["+x+","+y+"]]]");
						
						volt.add(10000*ddx+ddy);
						DB++;
					}
				}
		return DB;
	}
	
	public static void main (String args[]) throws IOException{
		
		
		BufferedReader be = new BufferedReader(new FileReader("D-small.in"));
		int T = Integer.parseInt(be.readLine());
		for(int i=1; i<=T; i++){
			String s = be.readLine();
			H = Integer.parseInt(s.split(" ")[0])-2;
			W = Integer.parseInt(s.split(" ")[1])-2;
			D = Integer.parseInt(s.split(" ")[2]);
			s = be.readLine(); // felső fal
			
			//System.out.println(W+" "+H);
			for(int y = 0; y < H; y++){
				s = be.readLine();
				for(int x = 0; x < W; x++)
					if(s.charAt(x+1)=='X'){
						myX = x;
						myY = y;
						//System.out.println(myX+" "+myY);
					}
			}
			s = be.readLine(); // alsó fal
			
			
			System.out.println("Case #"+i+": "+solve());
		}
		be.close();
	}
}

