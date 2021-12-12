package ru.mvv.strategy.tester;

import ru.mvv.strategy.checker.interfaceimpl.BruteForcePrimeCheckerImpl;
import ru.mvv.strategy.checker.interfaceimpl.OptimizedPrimeCheckerImpl;
import ru.mvv.strategy.checker.interfaceimpl.PrimeChecker;

import java.lang.reflect.Method;

public class ReflectionTester implements StrategyTester {

    private BruteForcePrimeCheckerImpl bruteForceChecker = new BruteForcePrimeCheckerImpl();
    private OptimizedPrimeCheckerImpl optimizedChecker = new OptimizedPrimeCheckerImpl();
    private final Method bruteForceMethod = lookup(BruteForcePrimeCheckerImpl.class);
    private final Method optimizedForceMethod = lookup(OptimizedPrimeCheckerImpl.class);
    private Method method = bruteForceMethod;
    private PrimeChecker target = bruteForceChecker;

    @Override
    public boolean test(int candidate) {
        try {
            return (boolean) method.invoke(target, candidate);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void switchStrategy() {
        method = optimizedForceMethod;
        target = optimizedChecker;
    }

    private Method lookup(Class<?> clazz) {
        try {
            return clazz.getMethod("isPrime", int.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
