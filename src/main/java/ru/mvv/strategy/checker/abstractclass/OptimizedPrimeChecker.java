package ru.mvv.strategy.checker.abstractclass;

import ru.mvv.strategy.checker.CycleChecker;

public class OptimizedPrimeChecker extends AbstractPrimeChecker {

    @Override
    public boolean isPrime(int candidate) {
        return CycleChecker.cycleCheck(candidate, (int) Math.sqrt(candidate));
    }
}
