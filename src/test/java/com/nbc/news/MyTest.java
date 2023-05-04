package com.nbc.news;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyTest {
  @Test
  void test() {
    int[] inputs = { 1, 9, 8, 2, 4, 1, 9 };
    int[] outputs = IntStream.of(inputs).map(i -> i + i).map(i -> i / 2).toArray();
    Assertions.assertArrayEquals(inputs, outputs, "Hi hi");
  }
}
