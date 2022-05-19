package br.com.manipulacao;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.infra.Blackhole;

@BenchmarkMode(Mode.Throughput)
public class FreeCodeCamp1 {

	public static void main(String[] args) throws IOException {
		org.openjdk.jmh.Main.main(args);
	}
	
	@Benchmark
	public void testIntern(Blackhole bh) {
		for (int i = 0; i < 10000; i++) {
			String s = new String("String to intern " + i);
			String t = s.intern();
			bh.consume(t);
		}
	}

	private static ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

	@Benchmark
	public void testMap(Blackhole bh) {
		for (int i = 0; i < 10000; i++) {
			String s = new String("String to intern " + i);
			String t = map.putIfAbsent(s, s);
			bh.consume(t);
		}
	}
}
