package ru.mvv.strategy.tester;

import ru.mvv.strategy.checker.abstractclass.AbstractPrimeChecker;
import ru.mvv.strategy.checker.abstractclass.BruteForcePrimeChecker;
import ru.mvv.strategy.checker.abstractclass.OptimizedPrimeChecker;

public class SwitchTester implements StrategyTester {

    private AbstractPrimeChecker primeChecker = new BruteForcePrimeChecker();
    private AbstractPrimeChecker optimizedChecker = new OptimizedPrimeChecker();
    private Method method = Method.BRUTE_FORCE;

    @Override
    public boolean test(int candidate) {
        switch (method) {
            case BRUTE_FORCE -> {
                return primeChecker.isPrime(candidate);
            }
            case OPTIMIZED -> {
                return optimizedChecker.isPrime(candidate);
            }
        }
        return false;
    }

    @Override
    public void switchStrategy() {
        method = Method.OPTIMIZED;
    }

    private enum Method {
        BRUTE_FORCE,
        OPTIMIZED
    }
}
