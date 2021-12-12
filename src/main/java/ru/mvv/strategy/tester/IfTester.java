package ru.mvv.strategy.tester;

import ru.mvv.strategy.checker.abstractclass.AbstractPrimeChecker;
import ru.mvv.strategy.checker.abstractclass.BruteForcePrimeChecker;
import ru.mvv.strategy.checker.abstractclass.OptimizedPrimeChecker;

public class IfTester implements StrategyTester {

    private AbstractPrimeChecker primeChecker = new BruteForcePrimeChecker();
    private AbstractPrimeChecker optimizedChecker = new OptimizedPrimeChecker();
    private boolean optimized;

    @Override
    public boolean test(int candidate) {
        if (optimized)
            return primeChecker.isPrime(candidate);
        else
            return optimizedChecker.isPrime(candidate);
    }

    @Override
    public void switchStrategy() {
        optimized = true;
    }
}
