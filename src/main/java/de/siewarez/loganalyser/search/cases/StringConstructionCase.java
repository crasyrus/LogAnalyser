package de.siewarez.loganalyser.search.cases;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import de.siewarez.loganalyser.search.Case;

public class StringConstructionCase<E> extends Case<E> {

  private final Class<E> type;

  public StringConstructionCase(String name, String regEx, String valueLimiter, Class<E> type) {
    super(name, regEx, valueLimiter);
    this.type = type;
  }

  @Override
  @SuppressWarnings("unchecked")
  public E convertStringToType(String s) {
    try {
      Constructor<?> constructor = type.getConstructor(String.class);
      return (E) constructor.newInstance(s);
    } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
      Logger.getLogger(StringConstructionCase.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }

}
