package ru.mvv.strategy.tester;

import ru.mvv.strategy.checker.interfaceimpl.BruteForcePrimeCheckerImpl;
import ru.mvv.strategy.checker.interfaceimpl.OptimizedPrimeCheckerImpl;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MethodHandleTester implements StrategyTester {

    private BruteForcePrimeCheckerImpl bruteForceChecker = new BruteForcePrimeCheckerImpl();
    private OptimizedPrimeCheckerImpl optimizedChecker = new OptimizedPrimeCheckerImpl();
    private final MethodHandle bruteForceHandle = lookup(BruteForcePrimeCheckerImpl.class);
    private final MethodHandle optimizedHandle = lookup(OptimizedPrimeCheckerImpl.class);
    private MethodHandle handle = bruteForceHandle;
    private Object target = bruteForceChecker;

    @Override
    public boolean test(int candidate) {
        try {
            return (boolean) handle.invoke(target, candidate);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void switchStrategy() {
        handle = optimizedHandle;
        target = optimizedChecker;
    }

    private MethodHandle lookup(Class<?> clazz) {
        try {
            return MethodHandles.lookup().findVirtual(clazz, "isPrime", MethodType.methodType(boolean.class, int.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
