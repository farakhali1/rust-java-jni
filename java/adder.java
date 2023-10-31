import java.nio.file.Path;
import java.nio.file.Paths;

class adder {

  // load rust dynamic library with the name adder (libadder.so)
  static { System.loadLibrary("adder"); }

  // calling rust library adder function, native keyword means that this
  // function is implemented using JNI
  public static native int add_numbers_rust(int number_1, int number_2);

  public static void main(String... args) {
    int number_1 = 2;
    int number_2 = 4;

    // call java functions
    System.out.println("Sum of " + number_1 + " + " + number_2 + " = " +
                       adder.add_numbers_java(number_1, number_2));
    adder.callback("java");

    // call rust functions
    System.out.println("Sum of " + number_1 + " + " + number_2 + " = " +
                       adder.add_numbers_rust(number_1, number_2));
  }

  // both java and rust library can call this function
  public static void callback(String input_string) {
    System.out.println("Called 'callback' with argument: " + input_string);
  }

  public static int add_numbers_java(int number_1, int number_2) {
    return (number_1 + number_2);
  }
}
