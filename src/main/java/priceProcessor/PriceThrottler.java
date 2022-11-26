package priceProcessor;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PriceThrottler implements PriceProcessor {

    private static final Map<String, Double> RATES = new ConcurrentHashMap<>();
    private final Map<PriceProcessor, ThreadPoolExecutor> processorToPool = new ConcurrentHashMap<>();
    private final Map<PriceProcessor, BlockingQueue<Runnable>> processorToQueues = new ConcurrentHashMap<>();

    @Override
    public void onPrice(String ccyPair, double rate) {
        RATES.put(ccyPair, rate);
        processorToPool.forEach((currentProcessor, value) -> {
            BlockingQueue<Runnable> currentProcessorsQueue = processorToQueues.get(currentProcessor);
            MyTask task = createTask(currentProcessor, ccyPair);
            if (!currentProcessorsQueue.contains(task)) {
                currentProcessorsQueue.add(task);
            }
        });
    }

    private MyTask createTask(PriceProcessor priceProcessor, String ccyPair) {
        return new MyTask(ccyPair, priceProcessor);
    }

    @Override
    public void subscribe(PriceProcessor priceProcessor) {
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 1, 10_000, TimeUnit.MINUTES, queue);
        pool.prestartCoreThread();
        processorToQueues.put(priceProcessor, queue);
        processorToPool.put(priceProcessor, pool);
    }

    @Override
    public void unsubscribe(PriceProcessor priceProcessor) {
        processorToQueues.remove(priceProcessor);
        ThreadPoolExecutor threadPoolExecutor = processorToPool.get(priceProcessor);
        threadPoolExecutor.shutdownNow();
        processorToPool.remove(priceProcessor);
    }

    private static class MyTask implements Runnable {

        private final String ccyPair;
        private final PriceProcessor priceProcessor;

        public MyTask(String ccyPair, PriceProcessor priceProcessor) {
            this.ccyPair = ccyPair;
            this.priceProcessor = priceProcessor;
        }

        @Override
        public void run() {
            priceProcessor.onPrice(ccyPair, RATES.get(ccyPair));
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MyTask myTask = (MyTask) o;
            return Objects.equals(ccyPair, myTask.ccyPair);
        }

        @Override
        public int hashCode() {
            return Objects.hash(ccyPair);
        }
    }

    public static void main(String[] args) throws Exception {
        PriceThrottler priceThrottler = new PriceThrottler();
        priceThrottler.subscribe(new EmailSubscriber());
        priceThrottler.subscribe(new ConsoleSubscriber());
        priceThrottler.onPrice("USDEUR", 1.25);
        Thread.sleep(100);
        priceThrottler.onPrice("USDEUR", 1.26);
        Thread.sleep(100);
        priceThrottler.onPrice("USDEUR", 1.27);
        Thread.sleep(100);
        priceThrottler.onPrice("USDEUR", 1.28);
        Thread.sleep(100);
        priceThrottler.onPrice("USDEUR", 1.29);
        Thread.sleep(100);
        priceThrottler.onPrice("USDRUB", 0.01);
    }
}