import java.io.*;
import java.util.Scanner;
 
public class functions {
	int mod(int a){
	 int b = 0;
	 if(a > 0) b = a; else b = -a;
	 
	 return b;
	}
	int solve(int[] a, int p, int s, int n){
		int result = 0;
		int i = 0;
		int x = 0;
		int onlyS = 0;
		int onlyNotS = 0;
		int both = 0;
		int none = 0;
		for ( i = 0;i < n; i++){
			x = a[i]/3;
			if(a[i]%3 ==0){

				if(a[i] == 30){
					onlyNotS++;

				}
				else if(p==x+1 && a[i]!=0){
					onlyS++;

				}
				else if ( p<=x ){
					both++;

				}
				else{

					none++;
				}
			}
			else if(a[i]%3 ==1){

				if(a[i]==1 && p<=1){
					onlyNotS++;
				}
				else if(p <= x+1){
					both++;
				}
				else none++;
			}
			else{

				if(a[i] == 29){

					onlyNotS++;
				}
				else if(p == x+2){

					onlyS++;
				}		
				else if(p <= x+1){

					both++;
				}
				else {
				none++;

				}				
			}
			
		}
		
		
		if(onlyS <= s){
			result = both+onlyNotS+onlyS;
		}
		else{
			result = s+both+onlyNotS;
		}
		
		return result;
	}
}
