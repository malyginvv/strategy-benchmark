package ru.mvv.strategy.tester;

import ru.mvv.strategy.checker.interfaceimpl.BruteForcePrimeCheckerImpl;
import ru.mvv.strategy.checker.interfaceimpl.OptimizedPrimeCheckerImpl;
import ru.mvv.strategy.checker.interfaceimpl.PrimeChecker;

import java.util.function.IntPredicate;

public class LambdaTester implements StrategyTester {

    private PrimeChecker primeChecker = new BruteForcePrimeCheckerImpl();
    private PrimeChecker optimizedChecker = new OptimizedPrimeCheckerImpl();
    private IntPredicate lambda = primeChecker::isPrime;

    @Override
    public boolean test(int candidate) {
        return lambda.test(candidate);
    }

    @Override
    public void switchStrategy() {
        lambda = optimizedChecker::isPrime;
    }
}
