package ru.mvv.strategy.tester;

import ru.mvv.strategy.checker.interfaceimpl.BruteForcePrimeCheckerImpl;
import ru.mvv.strategy.checker.interfaceimpl.OptimizedPrimeCheckerImpl;
import ru.mvv.strategy.checker.interfaceimpl.PrimeChecker;

public class InterfaceTester implements StrategyTester {

    private PrimeChecker primeChecker = new BruteForcePrimeCheckerImpl();
    private PrimeChecker optimizedChecker = new OptimizedPrimeCheckerImpl();

    @Override
    public boolean test(int candidate) {
        return primeChecker.isPrime(candidate);
    }

    @Override
    public void switchStrategy() {
        primeChecker = optimizedChecker;
    }
}
