import java.lang.*;
import java.util.*;
class dancer{
int count,s,p;
int doneS;
int can;
void Counts(int i1){
                    int thrice=3*p;
					if(i1>=thrice){count++;
								  can++;}
					else{int diff=(thrice-i1);
					    if(diff>4){can++;}
					     else if((diff==1)||(diff==2)){
						                             if(p==1){count++;
													          }
													if(p>=2){count++;
													       can++;}		  
												      }
						 else{
						      if(p>=2){count++;
						       doneS++;
							   }
							   }
                         }
						 
							   }}
//===========================
class p1{
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
for(int i=0;i<n;i++){
dancer d1=new dancer();
int m=sc.nextInt();
d1.s=sc.nextInt();
d1.p=sc.nextInt();
for(int j=0;j<m;j++){
                      d1.Counts(sc.nextInt());  
   					   }
int sub=0;
if(d1.doneS==d1.s){}
else if(d1.doneS>d1.s){
                      sub=d1.doneS-d1.s;
					  }
else{sub=0;
	}					  
d1.count=d1.count-sub;;

System.out.println("Case #"+(i+1)+": "+d1.count);}
}}	