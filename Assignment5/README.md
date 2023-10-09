# GMU_SWE437_PUBLIC
Assignment 5

The test code should run properly with JUnit 4. We used IntelliJ to run the tests, which automatically added JUnit 4 to an external library folder to use when running and compiling the tests. However, if running on the command line, you may need to specify the jar files for JUnit 4 and Hamcrest when compiling and running, and keep it in the same directory as the code if following the commands we provide below.
The test code for Assignment 5 is located in HW5Tests.java, so it would be:

javac -cp conversion.java

javac -cp junit-4.13.1.jar;. HW5Tests.java

java -cp junit-4.13.1.jar;hamcrest-core-1.3.jar;. org.junit.runner.JUnitCore  HW5Tests
