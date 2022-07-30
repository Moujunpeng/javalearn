import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {

    @Test
    public void tesFixedThreadPool(){

        ExecutorService executorService = Executors.newFixedThreadPool(10);

    }

}
