
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Observable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


/**
 *
 * @author dante
 */
public class dancers {
    
      
    public dancers(String filename)
    {
        
         base_size=0;
        
        init_database();
        contests = new int[100][6];
      
        
        parsing(filename);
        
    }
    
    
    public void init_database()
    {
        int min,max;
        
        database= new int[30*27+1][5];
        
        for(int num=30;num>2;num=num-1)
        {
           min= (int)Math.ceil(((double)num-3)/3);
           max= (int)Math.ceil(((double)num+3)/3);
           
           for(int i=max; i>=min; i--)
           {
               for(int j=max; j>=min; j--)
               {
                   for(int k=max; k>=min; k--)
                   {
                       if(((i+j+k)== num) && is_acceptable(i,j,k))
                       {
                           put_database(i,j,k);
                           
                       }
                   }
               }
           }
         
        //2   
        database[base_size][0]=2;
        database[base_size][1]=1;
        database[base_size][2]=1;
        database[base_size][3]=0;
        database[base_size][4]=is_surprising(1,1,0);  
         base_size++;
        //1   
        database[base_size][0]=1;
        database[base_size][1]=1;
        database[base_size][2]=0;
        database[base_size][3]=0;
        database[base_size][4]=is_surprising(1,0,0); 
         base_size++;
        //0   
        database[base_size][0]=0;
        database[base_size][1]=0;
        database[base_size][2]=0;
        database[base_size][3]=0;
        database[base_size][4]=is_surprising(0,0,0);
        base_size++;
            
            
        }
        
        
        
        
    }
    
    void put_database(int i, int j, int k)
    {
        database[base_size][0]=i+j+k;
        database[base_size][1]=i;
        database[base_size][2]=j;
        database[base_size][3]=k;
        database[base_size][4]=is_surprising(i,j,k);
        base_size++;
    }
    
    int is_surprising(int i, int j, int k)
    {
        if(Math.abs(i-j)== 2)
        {
            return 1;
        }
        else if(Math.abs(i-k)==2)
        {
            return 1;
        }      
        else if(Math.abs(j-k)==2)
        {
            return 1;
        }
        
        return 0;     
    }
    
    boolean is_acceptable(int i, int j, int k)
    {
        if(Math.abs(i-j) > 2)
        {
            return false;
        }
        else if( Math.abs(j-k) > 2)
        {
            return false;
        }      
        else if(Math.abs(i-k) > 2)
        {
            return false;
        }
        
        return true;
        
    }
    
    
    
      void parsing(String filename)
     {
         
     
        //String filename = args[1];
          String strLine = null;
          String [] temp= new String [150];
          String delimeter=" ";
          int num_contestants;
          int best,index,found_index=0;
        //  int i;
        // Open the file that is the first
        // command line parameter
        try{
            
        
        final FileInputStream stream = new FileInputStream(filename);
        // Get the object of DataInputStream
        final DataInputStream dataInputStream = new DataInputStream(stream);
        final BufferedReader reader = new BufferedReader(new InputStreamReader(dataInputStream));
        
        
        PrintWriter out = new PrintWriter(new FileWriter("Bsmall")); 
      //  out.print("Hello "); 
      //  out.println("world"); 
      //  out.close();
        //Read File Line By Line    
        int surp_events,my_surp_events;
        int diafora=0,ptr_change;
        
        if((strLine = reader.readLine()) != null)
        {
            System.out.println("Num_cases: "+ strLine);
        }
        
      
        //ena reader.readLine gia to prwto noumero 
         int my_case=0;
           while ((strLine = reader.readLine()) != null) {
               
               my_case++;
               
               temp=strLine.split(delimeter);
               
               num_contestants=Integer.parseInt(temp[0]);
               surp_events=Integer.parseInt(temp[1]);
               best=Integer.parseInt(temp[2]);
               
               for(int i=0;i<num_contestants;i++)
               {
                   contests[i][0]=Integer.parseInt(temp[3+i]);
                   contests[i][5]=-1;
               }
               
               
                    
                //search strline for pattern
               
               
               //contests new...
               
               //geimzw to contests[][0] me ta noumera kai ta [][5] me to -1
        
               for(int i=0;i<num_contestants;i++)
               {
                   //find first triplet
                   for(int ptr=0;ptr<base_size;ptr++)
                   {
                       if(database[ptr][0]== contests[i][0])
                       {
                           found_index=ptr;
                           break;
                       }
                       
                   }
                   //copy first triplet
                   for(int cell=1;cell<5;cell++)
                   {
                      contests[i][cell]=database[found_index][cell];
                   }
                   
                   contests[i][5]=find_best(i);
               }
               
               
               my_surp_events=count_surp(num_contestants);
               if(surp_events >= my_surp_events)
               {
                   count_best(best,num_contestants);//apo reading
                   out.println("Case #"+my_case+ ": " + count_best(best,num_contestants));
                   //print
               }
               else
               {
                   diafora=my_surp_events-surp_events;
                   index=0;
                   while(diafora>0 && index<num_contestants)
                   {
                       if(contests[index][4]==1) //if surprising
                       {
                           if(contests[index][5] >=best)
                           {
                               ptr_change=find_other(contests[index][0],best,1); //1 for want best
                           }
                           else
                           {
                               ptr_change=find_other(contests[index][0],best,0);
                           }
                           
                           if(ptr_change!=-1)
                           {
                               contests[index][1]=database[ptr_change][1];
                               contests[index][2]=database[ptr_change][2];
                               contests[index][3]=database[ptr_change][3];
                               contests[index][4]=database[ptr_change][4];
                               contests[index][5]=find_best(index);
                               
                               diafora--;                                   
                           }
                           
                           
                       }
                       index++;
                       
                   } //end while
                   
                   
                   
                   my_surp_events=count_surp(num_contestants);
                   if(surp_events >= my_surp_events)
                   {
                       count_best(best,num_contestants);//apo reading
                     
                        out.println("Case #"+my_case+ ": " + count_best(best,num_contestants));
                        //print
                   }
                   else //sencond parsing
                   {
                       index=0;
                       ptr_change=-1;
                       diafora=my_surp_events-surp_events;
                       while(diafora>0 && index<num_contestants)
                       {
                           if(contests[index][4]==1) //if surprising
                           {
                               ptr_change=find_other(contests[index][0],best,0);
                           }
                           
                           if(ptr_change!=-1)
                           {
                               contests[index][1]=database[ptr_change][1];
                               contests[index][2]=database[ptr_change][2];
                               contests[index][3]=database[ptr_change][3];
                               contests[index][4]=database[ptr_change][4];
                               contests[index][5]=find_best(index);
                               
                               diafora--;       
                           }
                           index++;
                       
                       }
                      
                       
                       
                       if(diafora!=0)
                       {
                           System.out.println("ERROR ME TI DIAFORA");
                       }
                       else
                       {
                        
                           out.println("Case #"+my_case+ ": " + count_best(best,num_contestants));
                       }
                       
                       
                       
                   }
               
               
               
               
            
        
        }
               
               
     
      }
        

        reader.close();
        out.close();
        } catch (Exception e) {//Catch exception if any
            System.out.println("Error: " + e.toString() + " line: " + strLine);
        }
        

         
     }
    
    
      int find_other(int total,int best,int choice)
      {
          for(int i=0;i<base_size;i++)
          {
              if(database[i][0]== total && database[i][4]==0) //not surspising
              {
                  if(choice==1)
                  {
                      if(has_best(best,database[i][1],database[i][2],database[i][3]))
                            return i;
                  }
                  else
                  {
                      return i;
                  }
                      
                  break;
              }
              
          }
          return -1;
          
      }
      
      boolean has_best(int best, int i, int j,int k)
      {
          if(i>=best || j>=best || k>=best)
              return true;
          
          return false;
      }
      
      int find_best(int ptr_change)
      {
          int total_max=-1;
          
          for(int i=1;i<4;i++)
          {
              if(total_max<contests[ptr_change][i])
                  total_max=contests[ptr_change][i];
          }
          return total_max;
          
      }
      
      int count_best(int best, int num_cont)
      {
          int count=0;
          
          for(int i=0;i<num_cont;i++)
          {
              if(contests[i][5] >=best)
              {
                  count++;
              }
          }
          return count;
      }
      
      int count_surp(int num_cont)
      {
          int count=0;
          
          for(int i=0;i<num_cont;i++)
          {
                  count+=contests[i][4];
          }
          return count;
      }
    
    
    
        public static void main(String[] args) {
        
        System.out.println(args[0]);
        
        new dancers(args[0]);
        
 
    }
        
        private int [][]database;
        private int [][]contests;
        private int base_size;
    
}
