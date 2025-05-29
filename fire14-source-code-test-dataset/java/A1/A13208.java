/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam;

public class CodeJam {

    public ReadWriteTextFile rw = new ReadWriteTextFile();
  public Triplet[] array = new Triplet[31];
      
  
  public void init()
  {
      for(int i=0;i<31;i++)
      {
      array[i] = new Triplet();
      }
      
      array[0].normal = 0;array[0].surprising = 0;
      array[1].normal = 1;array[1].surprising = 1;
      array[2].normal = 1;array[2].surprising = 2;
      array[3].normal = 1;array[3].surprising = 2;
      array[4].normal = 2;array[4].surprising = 2;
      array[5].normal = 2;array[5].surprising = 3;
      array[6].normal = 2;array[6].surprising = 3;
      array[7].normal = 3;array[7].surprising = 3;
      array[8].normal = 3;array[8].surprising = 4;
      array[9].normal = 3;array[9].surprising = 4;
      array[10].normal = 4;array[10].surprising = 4;
      array[11].normal = 4;array[11].surprising = 5;  
      array[12].normal = 4;array[12].surprising = 5;
      array[13].normal = 5;array[13].surprising = 5;
      array[14].normal = 5;array[14].surprising = 6;
      array[15].normal = 5;array[15].surprising = 6;
      array[16].normal = 6;array[16].surprising = 6;
    array[17].normal = 6;array[17].surprising = 7;
    array[18].normal = 6;array[18].surprising = 7;
    array[19].normal = 7;array[19].surprising = 7;
    array[20].normal = 7;array[20].surprising = 8;
    array[21].normal = 7;array[21].surprising = 8;
    array[22].normal = 8;array[22].surprising = 8;
    array[23].normal = 8;array[23].surprising = 9;
    array[24].normal = 8;array[24].surprising = 9;
    array[25].normal = 9;array[25].surprising = 9;
    array[26].normal = 9;array[26].surprising = 10;
    array[27].normal = 9;array[27].surprising = 10;
    array[28].normal = 10;array[28].surprising = 10;
    array[29].normal = 10;array[29].surprising = 10;
     array[30].normal = 10;array[30].surprising = 10;
   
      
      
  }
    public static void main(String[] args) {
        CodeJam codeJam = new CodeJam();
        
        codeJam.init();

        int sampleSize = codeJam.rw.readIntLine();


        for (int i = 0; i < sampleSize; i++) {
            
            int count=0;
            int N = codeJam.rw.readInt();
            int score;
            int S = codeJam.rw.readInt();
            int p = codeJam.rw.readInt();
            for(int k=0;k<N;k++)
            {
                score = codeJam.rw.readInt();
            if(codeJam.array[score].normal >= p)
            {
                count++;
            }
            else if(codeJam.array[score].surprising >= p && S>0)
            {
            count++;
            S--;
            }
            
            
            
            
            }
            
            
            codeJam.rw.writeNextLine(count);
        }
        codeJam.rw.close();
    }
}
