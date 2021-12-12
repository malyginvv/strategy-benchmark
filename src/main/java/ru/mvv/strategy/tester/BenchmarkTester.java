package ru.mvv.strategy.tester;

import org.openjdk.jmh.infra.Blackhole;

public class BenchmarkTester {

    private final int[] data;
    private final int switchingPoint;
    private final StrategyTester strategyTester;

    public BenchmarkTester(int[] data, StrategyTester strategyTester) {
        this.data = data;
        this.switchingPoint = data.length / 2;
        this.strategyTester = strategyTester;
    }

    public void runTest(Blackhole blackhole) {
        for (int i = 0; i < data.length; i++) {
            blackhole.consume(strategyTester.test(data[i]));
            if (i == switchingPoint)
                strategyTester.switchStrategy();
        }
    }
}
