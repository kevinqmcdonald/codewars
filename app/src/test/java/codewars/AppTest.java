/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class AppTest {
  @Test
  public void shouldWorkForSomeExamples() {
    assertFalse(App.isSquare(-1), "negative numbers aren't square numbers");
    assertTrue(App.isSquare(0), "0 is a square number (0 * 0)");
    assertFalse(App.isSquare(3), "3 isn't a square number");
    assertTrue(App.isSquare(4), "4 is a square number (2 * 2)");
    assertTrue(App.isSquare(25), "25 is a square number (5 * 5)");
    assertFalse(App.isSquare(26), "26 isn't a square number");
  }
}
