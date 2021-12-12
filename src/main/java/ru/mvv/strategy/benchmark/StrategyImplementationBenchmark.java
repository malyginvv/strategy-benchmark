package ru.mvv.strategy.benchmark;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.mvv.strategy.tester.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Threads(1)
@Fork(3)
@Warmup(iterations = 3, time = 5)
@Measurement(iterations = 10, time = 10)
public class StrategyImplementationBenchmark {

    private BenchmarkTester ifTester;
    private BenchmarkTester switchTester;
    private BenchmarkTester abstractClassTester;
    private BenchmarkTester interfaceTester;
    private BenchmarkTester lambdaTester;
    private BenchmarkTester handleTester;
    private BenchmarkTester reflectionTester;

    @Setup
    public void setUp() {
        var random = new Random(12345L);
        int size = 1024;
        int[] data = new int[size];
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(3, 1000);
        }

        ifTester = new BenchmarkTester(data, new IfTester());
        switchTester = new BenchmarkTester(data, new SwitchTester());
        abstractClassTester = new BenchmarkTester(data, new AbstractClassTester());
        interfaceTester = new BenchmarkTester(data, new InterfaceTester());
        lambdaTester = new BenchmarkTester(data, new LambdaTester());
        handleTester = new BenchmarkTester(data, new MethodHandleTester());
        reflectionTester = new BenchmarkTester(data, new ReflectionTester());
    }

    @Benchmark
    public void testIf(Blackhole blackhole) {
        ifTester.runTest(blackhole);
    }

    @Benchmark
    public void testSwitch(Blackhole blackhole) {
        switchTester.runTest(blackhole);
    }

    @Benchmark
    public void testAbstract(Blackhole blackhole) {
        abstractClassTester.runTest(blackhole);
    }

    @Benchmark
    public void testInterface(Blackhole blackhole) {
        interfaceTester.runTest(blackhole);
    }

    @Benchmark
    public void testLambda(Blackhole blackhole) {
        lambdaTester.runTest(blackhole);
    }

    @Benchmark
    public void testMethodHandle(Blackhole blackhole) {
        handleTester.runTest(blackhole);
    }

    @Benchmark
    public void testReflection(Blackhole blackhole) {
        reflectionTester.runTest(blackhole);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(StrategyImplementationBenchmark.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }
}
