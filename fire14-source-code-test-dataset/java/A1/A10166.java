import java.io.File;
import java.util.Scanner;

class B{

	public static void main(String[] args) {

	if(args.length==0){
		System.out.println("Error	::  Please provide input file name as first command line argument");
		System.out.println("Usage	::  java Main <file_name>");
		System.out.println("Example	::  java Main A-small-practice.in");
 	}
   	else{
            try{
                Scanner input=new Scanner(new File("B-small-attempt0 (1).in"));
		//Scanner input=new Scanner(new File("input.txt"));
		//System.out.println("Reading Input from "+ args[0]+" file");

                int no=input.nextInt();
                int in[][]=new int[no][100];

                for(int i=0;i<no;i++){
                    in[i][0]=input.nextInt();
                    in[i][1]=input.nextInt();
                    in[i][2]=input.nextInt();
                    for(int j=3;j<in[i][0]+3;j++){
                        in[i][j]=input.nextInt();
                    }
                }

                /*//display
                for(int i=0;i<no;i++){
                    System.out.print(in[i][0]+" ");
                    System.out.print(in[i][1]+" ");
                    System.out.print(in[i][2]+" ");
                    for(int j=3;j<in[i][0]+3;j++){
                        System.out.print(in[i][j]+" ");
                    }
                    System.out.println();
                }*/

                int mat[][]=new int[179][4];
                int count=0;
                for(int i=10;i>=0;i--){
                    for(int j=10;j>=0;j--){
                        for(int k=10;k>=0;k--){
                            if(Math.abs(i-j)<=2&&Math.abs(j-k)<=2&&Math.abs(k-i)<=2){
                                if(Math.abs(i-j)==2||Math.abs(j-k)==2||Math.abs(k-i)==2){
                                    mat[count][0]=i;
                                    mat[count][1]=j;
                                    mat[count][2]=k;
                                    mat[count++][3]=-1;
                                }

                                else{
                                    mat[count][0]=i;
                                    mat[count][1]=j;
                                    mat[count++][2]=k;
                                }
                            }
                        }
                    }
                }

                /*for(int i=0;i<179;i++){
                    System.out.print(mat[i][0]+" ");
                    System.out.print(mat[i][1]+" ");
                    System.out.print(mat[i][2]+" ");
                    System.out.print(mat[i][3]+" ");
                    System.out.println();
                }*/

                //Algorithm
                for(int i=0;i<no;i++){
                    int flags[][]=new int[in[i][0]][2];
                    for(int j=3,k=0;j<in[i][0]+3;j++,k++){
                        for(int a=0;a<179;a++){
                            if((mat[a][0]+mat[a][1]+mat[a][2]==in[i][j])&&(mat[a][0]>=in[i][2]||mat[a][1]>=in[i][2]||mat[a][2]>=in[i][2])){
                                if(mat[a][3]==-1){
                                    //System.out.println(mat[a][0]+" "+mat[a][1]+" "+mat[a][2]);
                                    flags[k][1]=-1;
                                }
                                else{
                                    //System.out.println(mat[a][0]+" "+mat[a][1]+" "+mat[a][2]);
                                    flags[k][0]=-1;
                                }
                            }
                        }
                        //System.out.println(flags[k][0]+" "+flags[k][1]);
                    }
                    int finalCount=0;
                    int sup=in[i][1];
                    for(int r=0;r<in[i][0];r++){
                        if(flags[r][0]==-1&&flags[r][1]==-1)finalCount++;
                        else if(flags[r][0]==-1)finalCount++;
                        else if(flags[r][0]==0&&flags[r][1]==-1&&sup>0){
                            finalCount++;
                            sup--;
                        }
                    }
                    System.out.println("Case #"+(i+1)+": "+finalCount);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}