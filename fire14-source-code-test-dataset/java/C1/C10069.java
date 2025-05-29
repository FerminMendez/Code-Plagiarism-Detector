import java.util.*;

public class d
{
    public static void main(String argv[])throws Exception
    {
	int ax[] = new int[10000];
	int ay[] = new int[10000];

	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t = 1; t <= T; t++)
	{
	    int H = sc.nextInt();
	    int W = sc.nextInt();
	    int D = sc.nextInt();
	    
	    int x = 0, y = 0;
	    for(int i = 0; i < H; i++)
	    {
		String in = sc.next();
		for(int j = 0; j < W; j++)
		    if(in.charAt(j) == 'X')
		    {
			x = i;
			y = j;	
		    }
	    }


	    int total = 0;
	    for(int dx = -50; dx <= 50; dx++)
		for(int dy = -50; dy <= 50; dy++)
		    if(dx != 0 || dy != 0)
		    {
			int xx = 0;
			int yy = 0;
			if(dx != 0)
			{
			    xx += Math.abs(dx / 2) * (H - 2) * 2;
			    if(dx % 2 != 0)
				if(dx > 0)
				    xx += 2 * (H - 2 - x) + 1;
				else
				    xx += 2 * (x - 1) + 1;
			}
			if(dy != 0)
			{
			    yy += Math.abs(dy / 2) * (W - 2) * 2;
			    if(dy % 2 != 0)
				if(dy > 0)
				    yy += 2 * (W - 2 - y) + 1;
				else
				    yy += 2 * (y - 1) + 1;
			}

			if(xx * xx + yy * yy <= D * D)
			{
			    ax[total] = xx * (dx >= 0? 1: -1);
			    ay[total] = yy * (dy >= 0? 1: -1);
			    total++;
			}

		    }

	    boolean el[] = new boolean[10000];
	    for(int i = 0; i < total; i++)
		for(int j = 0; j < total; j++)
		    if(i != j && (ax[i] * ay[j] - ay[i] * ax[j] == 0) && (ax[i] * ax[j] + ay[i] * ay[j] > 0))
			if(ax[i] * ax[i] + ay[i] * ay[i] > ax[j] * ax[j] + ay[j] * ay[j])
			    el[i] = true;
	    int ans = 0;
	    for(int i = 0; i < total; i++)
		if(!el[i])
		    ans++;

	    System.out.printf("Case #%d: %d\n", t, ans);
	}
    }

}
