package com.google.codjam.utils;


import com.google.codjam.problems.ProblemInterface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.HashMap;

public class FileLoader {

        
    public static void processFile(FileDataAndSettings fileData,String fileName,int nlinesXCaseGlobal,ProblemInterface worker)
    {
        try  
        {
            PrintWriter p = new PrintWriter (new File( fileName.replace(".in",".out")));
            
            BufferedReader buf
                = new BufferedReader(new FileReader(new File (fileName)));
            
            String tmp = "";
            for(int i=0,nLinesXCase=0,nCase=1;true;i++) 
            { 
                tmp = buf.readLine();
                if (tmp == null) 
                    break;
                if(i==0)
                {
                    fileData.setNCases(Integer.parseInt(tmp)); 
                }else
                {
                    ArrayList<String> dataCase = null;
                    try  
                    {
                        dataCase =fileData.getInputCase().get(nCase  -1);
                    } catch (IndexOutOfBoundsException ex)  {
                        fileData.getInputCase().add(new ArrayList<String>(0));
                        dataCase =fileData.getInputCase().get(nCase - 1);
                    } 


                    dataCase.add(tmp);
                    nLinesXCase++;
                    
                    if(nlinesXCaseGlobal==nLinesXCase)
                    {
                        nCase++;
                        nLinesXCase = 0;
                        p.println("Case #"+(nCase - 1)+": "+worker.run(dataCase));
                    }
                    
                   
                }
    
            }
            
            p.flush();
            p.close();
        } catch (Exception ex)  {
            ex.printStackTrace();
        } finally  
        {
        
        }
        
    
    
    }
    

    

}
