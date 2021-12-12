package ru.mvv.strategy.checker.abstractclass;

import ru.mvv.strategy.checker.CycleChecker;

public class BruteForcePrimeChecker extends AbstractPrimeChecker {

    @Override
    public boolean isPrime(int candidate) {
        return CycleChecker.cycleCheck(candidate, candidate - 1);
    }
}
