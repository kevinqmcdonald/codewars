/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package codewars;

public class App {

  static final int[] TO_ROMAN_STEPS = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
  static final String[] FROM_ROMAN_STEPS = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

  public static String toRoman(int n) throws Exception {
    StringBuilder roman = new StringBuilder();
    while(n > 0) {
      for(int i = TO_ROMAN_STEPS.length - 1; i >= 0; --i) {
        if(n - TO_ROMAN_STEPS[i] == 0) {
          return roman.append(FROM_ROMAN_STEPS[i]).toString();
        } else if(n - TO_ROMAN_STEPS[i] > 0) {
          roman.append(FROM_ROMAN_STEPS[i]);
          n -= TO_ROMAN_STEPS[i];
          break;
        }
      }
    }

    throw new Exception("Check algorithm");
  }

  public static int fromRoman(String romanNumeral) {
    int digit = 0;
    while(!romanNumeral.isEmpty()) {
      // Cascading if to check each of the significant steps
      if(romanNumeral.startsWith("M")) {
        digit += 1000;
        romanNumeral = safeSubstring(romanNumeral, 1);
      } else if(romanNumeral.startsWith("D")) {
        digit += 500;
        romanNumeral = safeSubstring(romanNumeral, 1);
      } else if(romanNumeral.startsWith("L")) {
        digit += 50;
        romanNumeral = safeSubstring(romanNumeral, 1);
      } else if(romanNumeral.startsWith("V")) {
        digit += 5;
        romanNumeral = safeSubstring(romanNumeral, 1);
      } else if(romanNumeral.startsWith("CM")) {
        digit += 900;
        romanNumeral = safeSubstring(romanNumeral, 2);
      }else if(romanNumeral.startsWith("CD")) {
        digit += 400;
        romanNumeral = safeSubstring(romanNumeral, 2);
      } else if(romanNumeral.startsWith("C")) {
        digit += 100;
        romanNumeral = safeSubstring(romanNumeral, 1);
      } else if(romanNumeral.startsWith("XC")) {
        digit += 90;
        romanNumeral = safeSubstring(romanNumeral, 2);
      } else if(romanNumeral.startsWith("XL")) {
        digit += 40;
        romanNumeral = safeSubstring(romanNumeral, 2);
      } else if(romanNumeral.startsWith("X")) {
        digit += 10;
        romanNumeral = safeSubstring(romanNumeral, 1);
      } else if(romanNumeral.startsWith("IX")) {
        digit += 9;
        romanNumeral = safeSubstring(romanNumeral, 2);
      } else if(romanNumeral.startsWith("IV")) {
        digit += 4;
        romanNumeral = safeSubstring(romanNumeral, 2);
      } else if(romanNumeral.startsWith("I")) {
        digit += 1;
        romanNumeral = safeSubstring(romanNumeral, 1);
      }
    }

    return digit;
  }

  private static String safeSubstring(String numeral, int length) {
    if(numeral.length() == length) {
      return "";
    } else {
      return numeral.substring(length);
    }
  }
}
