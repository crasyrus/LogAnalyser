package de.siewarez.loganalyser.search.cases;

import de.siewarez.loganalyser.search.Case;

public abstract class NumberCase<E extends Number> extends Case<E> {

  public NumberCase(String name, String regEx, String valueLimiter) {
    super(name, regEx, valueLimiter);
  }

  @Override
  public abstract E convertStringToType(String s);

}
