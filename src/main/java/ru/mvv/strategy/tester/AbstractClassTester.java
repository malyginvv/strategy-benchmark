package ru.mvv.strategy.tester;

import ru.mvv.strategy.checker.abstractclass.AbstractPrimeChecker;
import ru.mvv.strategy.checker.abstractclass.BruteForcePrimeChecker;
import ru.mvv.strategy.checker.abstractclass.OptimizedPrimeChecker;

public class AbstractClassTester implements StrategyTester {

    private AbstractPrimeChecker primeChecker = new BruteForcePrimeChecker();
    private final AbstractPrimeChecker optimizedChecker = new OptimizedPrimeChecker();

    @Override
    public boolean test(int candidate) {
        return primeChecker.isPrime(candidate);
    }

    @Override
    public void switchStrategy() {
        primeChecker = optimizedChecker;
    }
}
