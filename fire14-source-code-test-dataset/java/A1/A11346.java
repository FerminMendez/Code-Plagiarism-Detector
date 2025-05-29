package com.nithin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SubThread implements Runnable {
	Thread t;
	int c=0,n=0,s=0,p=0;
	int[] sc;
	int res=0;
	String a="";
	SubThread(int i,int a,int b,int e,int[] d) {
		c=(i+1);
		n=a;
		s=b;
		p=e;
		sc=d;
		t = new Thread(this);
		t.run();
	}

	public void run() {
		float avg=0;
		for(int i=0;i<n;++i)
		{
			avg=(float)sc[i]/3;
			if(avg==0 && p!=0)
			{
				sc[i]=99;
			}
			if((p-avg)>=1.5)
			{
				sc[i]=99;
			}
			else
			{
				if(avg>=p)
				{
					++res;
					a=a+sc[i]+" ";
					sc[i]=99;
				}
				if( (p-avg)<1 && (p-avg)>0 ) 
				{
					++res;
					a=a+sc[i]+" ";
					sc[i]=99;
				}
			}
		}
		int i=0;
		while(s>0 && i<n)
		{
			avg=(float)sc[i]/3;
			if( (p-avg)==1)
			{
				++res;
				--s;
				a=a+sc[i]+" ";
				sc[i]=99;
			}
			if( (p-avg)>1 && (p-avg)<1.5 )
			{
				++res;
				--s;
				a=a+sc[i]+" ";
				sc[i]=99;
			}
			++i;
		}
		
	}
	public void print()
	{
		System.out.println("Case #"+c+": "+res);
		//System.out.println(a);
		
	}

}

public class Solution {
	public static void main(String[] args) throws Exception {
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		SubThread[] subthread=new SubThread[t];
		for(int i=0;i<t;++i)
		{
			st=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());//number of Googlers
			int s=Integer.parseInt(st.nextToken());//number of surprising triplets of scores
			int p=Integer.parseInt(st.nextToken());//maximum number result of at least p
			int[] sc=new int[n];
			for(int j=0;j<n;++j)
			{
				sc[j]=Integer.parseInt(st.nextToken());
			}
			subthread[i]=new SubThread(i,n,s,p,sc);
		}

		for(int i=0;i<t;++i)
		{
			subthread[i].t.join();
			subthread[i].print();
		}
		
		
	}
}

