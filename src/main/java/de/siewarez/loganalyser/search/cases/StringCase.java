package de.siewarez.loganalyser.search.cases;

import de.siewarez.loganalyser.search.Case;

public class StringCase extends Case<String> {

  public StringCase(String name, String regEx, String valueLimiter) {
    super(name, regEx, valueLimiter);
  }

  @Override
  public String convertStringToType(String s) {
    return s;
  }
}
