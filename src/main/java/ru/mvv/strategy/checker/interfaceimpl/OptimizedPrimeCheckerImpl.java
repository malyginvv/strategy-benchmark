package ru.mvv.strategy.checker.interfaceimpl;

import ru.mvv.strategy.checker.CycleChecker;

public class OptimizedPrimeCheckerImpl implements PrimeChecker {

    @Override
    public boolean isPrime(int candidate) {
        return CycleChecker.cycleCheck(candidate, (int) Math.sqrt(candidate));
    }
}
