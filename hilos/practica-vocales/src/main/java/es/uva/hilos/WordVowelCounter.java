package es.uva.hilos;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class WordVowelCounter implements Runnable {
    private BlockingQueue<String> wordQueue;
    private BlockingQueue<Result> resultQueue;

    // Constructor
    public WordVowelCounter(BlockingQueue<String> wordQueue, BlockingQueue<Result> resultQueue) {
        this.wordQueue = wordQueue;
        this.resultQueue = resultQueue;
    }

    @Override
    public void run() {
        // TODO
    }

    private int countVowels(String word) {
        return -1;
    }
}

