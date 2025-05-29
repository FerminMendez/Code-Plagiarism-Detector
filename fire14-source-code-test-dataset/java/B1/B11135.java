package recyclednumbers.recycler;

import junit.framework.Assert;
import org.junit.Test;

public class RecyclerTest {

    @Test
    public void exampleTest() {

        Recycler recycler = new Recycler();

        Assert.assertTrue(recycler.isRecycledPair(12345, 34512));

        Assert.assertEquals(0, recycler.countPairs(1, 9));
        Assert.assertEquals(3, recycler.countPairs(10, 40));
        Assert.assertEquals(156, recycler.countPairs(100, 500));
        Assert.assertEquals(287, recycler.countPairs(1111, 2222));

    }
}
