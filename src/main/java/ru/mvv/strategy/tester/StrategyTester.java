package ru.mvv.strategy.tester;

public interface StrategyTester {

    boolean test(int candidate);

    void switchStrategy();
}
