import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		File fi = new File("D:\\B-small-attempt0.in");
		Scanner in=new Scanner(fi);
		int c=in.nextInt();
		int goo=0;
		int sup=0;
		int p=0;
		int ans=0;
		for(int co=1;co<=c;co++){
	   goo=in.nextInt();
	      sup=in.nextInt();
	      p=in.nextInt();
	      int base=0;
	      int score=0;
	      int z[] ={0,0,0};
		for(int i=0;i<goo;i++){
			score=in.nextInt();
			base=score/3;
			switch(score%3)
			{
			case 0: 
			{
			z[0]=base-1;
			z[1]=base;
			z[2]=base+1;
			
			if(base >=p){
				ans++;
				}
			else
			{
				if(sup>0 && base >0 && (base+1)>=p){
					ans++;
					sup--;
				}
				
			}					
			break;
			}
			case 1:
			{
			if(base >=p||(base+1)>=p){
			ans++;	
			}	
			else{
				if(sup>0&&(base+1)>=p){
					ans++;
					sup--;
				}
			}
			
			
				break;
			}
			case 2:{
				if ((base + 1) >= p|| base >= p){
					ans++;
				} else {
					if(sup>0&&(base+2)>=p){
						ans++;
						sup--;
					}
				}
				
			
			
					
			break;		
			
		}	}	
		}System.out.println("Case #"+co+": "+ans);
ans=0;
	}
	}
	}


