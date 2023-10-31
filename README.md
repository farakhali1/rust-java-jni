# rust-java-jni
IPC between rust and java using java JNI

# How to Build and Run
 - make sure all required packages install on system like `ructc`, `cargo`, `java jdk`.
```bash
# build rust library
cd rust/adder
cargo build

# build and run java part
cd ../../java
javac adder.java  
javac adder.java -h .
java  adder
```

# Output
```
Called 'callback' with argument: java
Sum of 2 + 4 = 6
Called 'callback' with argument: rust
Sum of 2 + 4 = 6
```