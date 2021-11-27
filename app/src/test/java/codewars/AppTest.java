/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {
  @Test
  public void testExample() {
    int[] exampleTest1 = {2,6,8,-10,3};
    int[] exampleTest2 = {206847684,1056521,7,17,1901,21104421,7,1,35521,1,7781};
    int[] exampleTest3 = {Integer.MAX_VALUE, 0, 1};
    int[] exampleTest4 = {2, 4, 0, 100, 4, 11, 2602, 36};
    int[] exampleTest5 = {161, 3, 1719, 19, 11, 13, -20};
    assertEquals(3, App.find(exampleTest1));
    assertEquals(206847684, App.find(exampleTest2));
    assertEquals(0, App.find(exampleTest3));
    assertEquals(11, App.find(exampleTest4));
    assertEquals(-20, App.find(exampleTest5));
  }
}
