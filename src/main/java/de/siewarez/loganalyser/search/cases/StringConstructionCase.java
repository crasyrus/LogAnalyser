/*
 *      |                    \                 |                       
 *      |      _ \   _` |   _ \     \    _` |  |  |  | (_-<   -_)   _| 
 *     ____| \___/ \__, | _/  _\ _| _| \__,_| _| \_, | ___/ \___| _|   
 *                 ____/                         ___/                  
 *
 * author: Klaus Sievers
 */
package de.siewarez.loganalyser.search.cases;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import de.siewarez.loganalyser.search.AbstractCase;

public class StringConstructionCase<E> extends AbstractCase<E> {

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

  @Override
  public Class<E> getType() {
    return type;
  }
}
