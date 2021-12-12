# strategy-benchmark

Benchmark of different implementations of Strategy pattern in Java 17.

Have you ever wondered how to efficiently implement dynamic behavior in Java code? Should you use `if` statement, extend from an abstract class or maybe implement an interface? What about lambdas and method handles? 

The benchmark tries to answer this question. 

# Usage

Install JDK 17 and Maven. Build the project by running the following command:
`mvn clean package`

Run tests `java -jar ./target/strategy-benchmark.jar`

# Results

Tested on JDK 17.0.1, OpenJDK 64-Bit Server VM, 17.0.1+12-39.

## Average time

|Benchmark        | Count | Score   | Error | Units |
|-----------------|-------|---------|-------|-------|
|Interface        | 10    | 23,159  | 0,092 | us/op |
|Abstract Class   | 10    | 23,346  | 0,258 | us/op |
|Lambda           | 10    | 23,562  | 0,045 | us/op |
|Switch Statement | 10    | 24,420  | 0,117 | us/op |
|Method Handle    | 10    | 27,808  | 0,100 | us/op |
|Reflection       | 10    | 31,555  | 0,360 | us/op |
|If Statement     | 10    | 307,211 | 0,183 | us/op |

## Throughput

|Benchmark        | Count | Score   | Error | Units  |
|-----------------|-------|---------|-------|--------|
|Abstract Class   | 10    | 43,246  | 0,114 | ops/ms |
|Interface        | 10    | 43,246  | 0,118 | ops/ms |
|Lambda           | 10    | 42,459  | 0,134 | ops/ms |
|Switch Statement | 10    | 41,030  | 0,039 | ops/ms |
|Method Handle    | 10    | 35,898  | 0,094 | ops/ms |
|Reflection       | 10    | 31,863  | 0,087 | ops/ms |
|If Statement     | 10    |  3,253  | 0,013 | ops/ms |
