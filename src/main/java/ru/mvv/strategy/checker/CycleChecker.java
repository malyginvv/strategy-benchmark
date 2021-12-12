package ru.mvv.strategy.checker;

public class CycleChecker {

    private CycleChecker() {}

    public static boolean cycleCheck(int candidate, int stop) {
        if (candidate < 1)
            return false;
        if (candidate == 1 || candidate == 2)
            return true;
        for (int i = 2; i <= stop; i++) {
            if (candidate % i == 0)
                return false;
        }
        return true;
    }
}
