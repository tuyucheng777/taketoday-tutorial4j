package cn.tuyucheng.taketoday.concurrent.threadsafety.callables;

import cn.tuyucheng.taketoday.concurrent.threadsafety.services.ReentrantLockCounter;
import java.util.concurrent.Callable;

public class ReentrantLockCounterCallable implements Callable<Integer> {

    private final ReentrantLockCounter counter;

    public ReentrantLockCounterCallable(ReentrantLockCounter counter) {
        this.counter = counter;
    }

    @Override
    public Integer call() throws Exception {
        counter.incrementCounter();
        return counter.getCounter();
    }
}
