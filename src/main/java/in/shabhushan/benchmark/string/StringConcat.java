package in.shabhushan.benchmark.string;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.UUID;

@Fork(1)
@State(Scope.Thread)
public class StringConcat {
    private String s0, s1;

    @Setup
    public void setup() {
        s0 = UUID.randomUUID().toString();
        s1 = UUID.randomUUID().toString();
    }

    @Benchmark
    public void testStringFormat(Blackhole blackhole) {
        String result = String.format("%s%s", s0, s1);
        blackhole.consume(result);
    }

    @Benchmark
    public void testStringPlus(Blackhole blackhole) {
        String result = s0 + s1;
        blackhole.consume(result);
    }
}
