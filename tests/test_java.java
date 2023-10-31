import java.io.*;
import java.lang.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

class test_java {

  static {
    Path p = Paths.get("./../rust/adder/target/debug/libadder.so");
    System.load(p.toAbsolutePath().toString());
  }
  public static native int add_numbers_rust(int number_1, int number_2);

  public static void main(String... args) {

    for (int i = 0; i < 1000; i++) {
      test_java.add_numbers_java(i, i); // warmup
    }

    int n = 1000000;
    Vector<Long> latencies = new Vector<Long>(n);

    for (int i = 0; i < 1000000; i++) {
      long start_time = System.nanoTime();
      test_java.add_numbers_java(i, i);
      long end_time = System.nanoTime();
      long latency = end_time - start_time;
      // System.out.println("Start Time: " + start_time +" End Time: " +
      // end_time + " latency: " + latency);
      latencies.add(latency);
    }

    for (int i = 0; i < latencies.size(); i++) {
      // Printing elements one by one
      System.out.print(latencies.get(i) + "\n");
    }
    //    test_java.callback("java");
    // System.out.println("Sum of " + number_1 + " + " + number_2 + " = " +
    //                    test_java.add_numbers_java(number_1, number_2));

    // // call rust functions
    // System.out.println("Sum of " + number_1 + " + " + number_2 + " = " +
    //                    test_java.add_numbers_rust(number_1, number_2));
  }

  // both java and rust library can call this function
  public static void callback(String input_string) {
    System.out.println("Called 'callback' with argument: " + input_string);
  }

  public static int add_numbers_java(int number_1, int number_2) {
    return (number_1 + number_2);
  }
}
