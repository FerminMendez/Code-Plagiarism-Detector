public class B
{
    public static void main(String []args)
    {
       int j,c,i,T, N, S, P,maior,menor,soma;
       java.util.Scanner sc = new java.util.Scanner(System.in);
       T = sc.nextInt();
       for (i = 0; i < T; i++)
       {
          c = 0;
          N = sc.nextInt();
          S = sc.nextInt();
          P = sc.nextInt();
          for (j = 0; j < N; j++)
          {
             soma = sc.nextInt();
             maior = (int)Math.ceil(soma/3.0);
             menor = (int)Math.floor(soma/3.0);
             if (maior>= P)
                 c++;
             else if (S>0 && (
                       (maior - menor == 0 && maior + 1 >= P && menor>0) ||
                       (maior - menor == 1 && maior + 1 >= P && 2*menor + maior + 1  <= soma))
                     )
             {
                        c++;
                        S--;
             }
          }
          System.out.println("Case #"+(i+1)+": "+c);
        }
    }
}
