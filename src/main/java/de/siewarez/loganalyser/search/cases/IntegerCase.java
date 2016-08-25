package de.siewarez.loganalyser.search.cases;

public class IntegerCase extends NumberCase<Integer> {

  public IntegerCase(String name, String regEx, String valueLimiter) {
    super(name, regEx, valueLimiter);
  }

  @Override
  public Integer convertStringToType(String s) {
    try {
      return Integer.parseInt(s);
    } catch (NumberFormatException ex) {
      return -1;
    }
  }
}
