package de.siewarez.loganalyser.search.cases;

import de.siewarez.loganalyser.search.Case;

public abstract class BooleanCase extends Case<Boolean> {

  public BooleanCase(String name, String regEx, String valueLimiter) {
    super(name, regEx, valueLimiter);
  }

  @Override
  public abstract Boolean convertStringToType(String s);
}
