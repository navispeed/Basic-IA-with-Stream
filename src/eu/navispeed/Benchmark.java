package eu.navispeed;

public class Benchmark {
    public static void benchmark(Runnable r) {
        long startTime = System.currentTimeMillis();
        r.run();
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime-startTime) + "ms");
    }
}
