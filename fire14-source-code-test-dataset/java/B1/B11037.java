import java.io.*;
import java.util.*;

class Recycling {
    static Scanner sc;

    static ArrayList<Integer> found;

    static void run()
    {
        int A = sc.nextInt();
        int B = sc.nextInt();

        found = new ArrayList<Integer>();

        int total = 0;
        
        for (int n = A; n < B; n++) {
            total += findPerms(n, A, B);
        }

        System.out.println(total + "");
    }

    static int findPerms(int n, int A, int B)
    {
        int perms = 0;

        // first generate the perm list
        ArrayList<Integer> a = toArrayList(n);

        // find all permutations of n
        // and check if n < m <= B
        
        for (int i = 0; i < a.size(); i++) {
            next_number(a);
            int m = toNumber(a);
            int ff = 1000000000 * n + m;
            //System.out.println(m);
            if (n < m && A <= m && m <= B && !found.contains(ff)) {
                perms++;
                found.add(ff);
                //System.out.println(m + " <<");
            }
        }
        
        return perms;
    }

    static ArrayList<Integer> toArrayList(int a)
    {
        ArrayList<Integer> b = new ArrayList<Integer>();
        for (int i = numdigits(a); i > 0; i--) {
            b.add(nthdigit(a, i - 1));
            //System.out.print(nthdigit(n, i - 1) + " ");
        }
        return b;
    }

    static int toNumber(ArrayList<Integer> a)
    {
        int n = 0;
        for (int i = 0; i < a.size(); i++) {
            n *= 10;
            n += a.get(i);
        }
        return n;
    }

    static int nthdigit(int x, int n)
    {
        while (n-- != 0) {
            x /= 10;
        }
        return (x % 10);
    }

    static int numdigits(int x)
    {
        int d = 0;
        while (x != 0) {
            x /= 10;
            d++;
        }
        return d;
    }

    static void next_number(ArrayList<Integer> a)
    {
        Collections.swap(a, 0, a.size() - 1);

        for (int i = 0; i < a.size() - 2; i++) {
            Collections.swap(a, a.size() - (2 + i), a.size() - (1 + i));
        }
    }

    public static void main(String args[])
    {
        sc = new Scanner(System.in);

        int cases = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < cases; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            run();
        }
    }
}
