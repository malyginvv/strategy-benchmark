package ru.mvv.strategy.checker.interfaceimpl;

import ru.mvv.strategy.checker.CycleChecker;

public class BruteForcePrimeCheckerImpl implements PrimeChecker {

    @Override
    public boolean isPrime(int candidate) {
        return CycleChecker.cycleCheck(candidate, candidate - 1);
    }
}
